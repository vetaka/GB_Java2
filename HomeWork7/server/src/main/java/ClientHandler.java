import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private String nickname;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Server server;
// конструктор класса
    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> { // поток для клиента
                boolean continueChat = true;
                String msg = "";
                boolean isAuthorized = false;
                final long TIMEOUT = 120000;  // Время таймаута
                long startTime = System.currentTimeMillis();// начало отсчета времени таймаута:
                try {
                   while (!isAuthorized && continueChat) { // цикл авторизации
                        // проверяем время таймаута
                       if ( (System.currentTimeMillis()-startTime)> TIMEOUT){  // если время превысило таймаут
                            System.out.println("server = " + server + ", socket = " + socket + " -> timeout");
                            continueChat = false;
                            sendMessage("/error timeout");
                            disconnect();
                        } else
                            if (in.available()>0) {
                        /*
                         * Последнее ДЗ (8) один из возможных вариантов если не понятно пишите мне
                         * в телеграм if((System.currentTimeMillis() - start) > 120000){ continueChat =
                         * false; // Тут можно еще и отправить и сообщение об ошибке
                         * sendMessage("/error timeout"); и там как то это обрабатывать } else
                         * if(in.available()>0) {
                         */
                        msg = in.readUTF(); // читаем сообщение от клиента
                        if (msg.startsWith("/auth")) { // если начинается с /auth, то пытаемся его авторизировать
                            String[] tokens = msg.split("\\s", 3); // разделяем на части (разделитель пробел)
                            nickname = server.getAuthService().getNicknameByLoginAndPassword(tokens[1], tokens[2]);

                            if (nickname != null) { // если авторизация, то шлем клиенту authok и выходим из цикла
                                // авторизации
                                isAuthorized = true;
                                sendMessage("/authok");
                                server.subscribe(this);
                            } else {
                                sendMessage("/error Ошибка_авторизации");
                                // иначе пишем клиенту об ошибке (по хорошему тут можно еще
                                // текст ошибки писать, а на клиенте его ловить и печатать.
                                // Если кто то хочет, то может добавить это в чат,
                                // не будет получаться -> пишите в телеграм
                                //continueChat = false; // чтобы не заходить в чат- неправильно -убрала, чтобы не выскочить из цикла
                            }
                        }
                        if (msg.equalsIgnoreCase("/end")) {// клиент решил выйти без авторизации
                            continueChat = false;
                        }
                        } // это скобка от ДЗ 8
                        //
                    }

                    while (continueChat) { // цикл чтения сообщений клиента
                        msg = in.readUTF();
                        if (msg.startsWith("/")) {// специальное сообщение
                            if (msg.equalsIgnoreCase("/end")) { // клиент вышел
                                continueChat = false;
                            } else if (msg.startsWith("/w")) { //приватное сообщение ДЗ7
                                String[] tokens = msg.split("\\s", 3);
                                System.out.println(tokens);
                                if (tokens.length == 3) {
                                    System.out.println(tokens);
                                    server.privateMsg(this, tokens[1], tokens[2]);
                                }
                            }
                        } else {// обычное сообщение
                            server.broadcastMessage(nickname + " : " + msg);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Отключаем клиента");
                    disconnect();

                    }

            }).start();
        } catch (IOException e) {
            e.printStackTrace();
       }
//        finally {    //**
//          disconnect();   //**
    }


    public void sendMessage(String message) {
        try {
            out.writeUTF(message);// пишем сообщение клиенту
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

        }
    }

    public String getNickname() {
        return nickname;
    }

    public void disconnect() { // отключаемся
        sendMessage("/end");
        System.out.println("disconnected client " + nickname);
        server.unsubscribe(this);
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
}