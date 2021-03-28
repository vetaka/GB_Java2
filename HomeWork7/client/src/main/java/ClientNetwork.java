import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ClientNetwork {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Callback<String> callOnMsgRecieved;
    private Callback<String> callOnChangeClientList;
    private Callback<String> callOnAuth;
    private Callback<String> callOnError;

    public void connect() {
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> { // создаем поток для чтения
                boolean goOn = true;
                boolean isAuthorized = false;
                try {
                    while (!isAuthorized && goOn) { // цикл авторизации
                        String message = in.readUTF(); // читаем сообщения сервера
                        if (message.startsWith("/authok")) { // если от сервера пришло сообщение,
                            // что авторизация прошла успешно то
                            callOnAuth.callback("/authok"); // вызываем метод Callback-a авторизации который
                            /* имплиментирован ClientGUI */
                            isAuthorized = true; //можно выйти из цикла
                        } else if (message.equalsIgnoreCase("/end")) { //если сервер написал end, выходим из обоих
                            //циклов и отключаемся
                            goOn = false;
                        } else
                            if (message.startsWith("/error")) {
                                callOnError.callback(message.substring(7));
                            } else {
                            // сюда мы попадаем если сервер нам написал что то иное, чем authok и end
                            // можно было бы тут написать if startsWith(error)
                            callOnError.callback("Something is wrong"); // отправляем
                        }
                    }
                    // цикл авторизации завершается
                    //
                    while (goOn) {//цикл общения с cервером
                        String msg = in.readUTF(); // читаем сообщение сервера
                        if (msg.equalsIgnoreCase("/end")) {
                            goOn = false; // выходим
                        } else if (msg.startsWith("/clients ")) { // сервер прислал список клиентов
                            callOnChangeClientList.callback(msg.substring(9)); // отправляем список клиентов, отсекая
                            // /clients
                        } else if (msg.startsWith("/error")) { // при получении сообщения об ошибке
                            callOnError.callback(msg.substring(7));
                        } else {
                            callOnMsgRecieved.callback(msg); // при получении обычного сообщения без префиксов
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String msg) {
        try {
            // return true;
            out.writeUTF(msg); // отправляем серверу сообщение
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Отослать сообщение невозможно");
            callOnError.callback("Подключение к серверу, видимо, отсутствует");
            /* return false; */
        }
        finally {

        }

    }

    public void closeConnection() {
        // закончили работать, все выключаем и сокеты и потоки ввода-вывода
        try {
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // сеттеры с помощью которых мы в ClientGUI можем задать желаемое поведение

    public void setCallOnAuth(Callback<String> callOnAuth) {
        this.callOnAuth = callOnAuth;
    }

    public void setCallOnMsgRecieved(Callback<String> callOnMsgRecieved) {
        this.callOnMsgRecieved = callOnMsgRecieved;
    }

    public void setCallOnChangeClientList(Callback<String> callOnChangeClientList) {
        this.callOnChangeClientList = callOnChangeClientList;
    }

    public void setCallOnError(Callback<String> callOnError) {
        this.callOnError = callOnError;
    }
}