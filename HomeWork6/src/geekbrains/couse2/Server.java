package geekbrains.couse2;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String... args) {
        startTextServer();

    }

    private static void startTextServer() {
        try (ServerSocket serverSocket = new ServerSocket(8180)) {
            System.out.println("Server is listening");
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream());
                 Scanner sc = new Scanner(System.in)){
                 System.out.println("Client is connected");
                out.println("Hello client");
                out.flush();
                String message = "";

                Thread clientReader = new Thread(() -> {
                    String clientMessage = "";
                    try {
                        while (!socket.isClosed() ) {
                            if (clientMessage.equalsIgnoreCase("stop")) {
                                break;}

                                clientMessage = in.readLine();
                            System.out.println(clientMessage);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                });
                clientReader.start();
                do {
                    message = sc.nextLine();
                    out.println(message);
                    out.flush();

                } while (!message.equalsIgnoreCase("stop") );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
