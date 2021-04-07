package com.geekbrains.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
<<<<<<< Updated upstream


public class ClientHandler {
=======
import java.time.LocalDateTime;
import java.util.logging.*;


public class ClientHandler {

>>>>>>> Stashed changes
    private String nickname;
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
<<<<<<< Updated upstream
=======
    final Logger logger = Logger.getLogger(ClientHandler.class.getName());

>>>>>>> Stashed changes

    public String getNickname() {
        return nickname;
    }

<<<<<<< Updated upstream
    public ClientHandler(Server server, Socket socket, ExecutorService executorService){
=======
    public ClientHandler(Server server, Socket socket, ExecutorService executorService) throws IOException {
        logger.setLevel(Level.ALL);

        logger.setUseParentHandlers(false);
        Handler handler;
        handler = new FileHandler("file_%g.txt", 1024, 10, true);
        handler.setFormatter(new Formatter(){
            @Override
            public String format(LogRecord record){
                return record.getLevel() + " " + record.getLoggerName() + "->" + record.getMessage();

            }
        });
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);

        logger.log(Level.FINE, "\n Server is started.");

>>>>>>> Stashed changes
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
//            new Thread(() -> {
            executorService.submit(() -> {
                try {
                    while (true) {
                        String msg = in.readUTF();
                        // /auth LOG1 PASS1, LOG2 PASS2
                        if (msg.startsWith("/auth ")) {
                            String[] tokens = msg.split("\\s");
                            String nick = server.AuthService.getNicknameByLoginAndPassword(tokens[1], tokens[2]);
                            System.out.println("nick = " + nick);//
                            if (nick != null && !server.isNickBusy(nick)) {
                                sendMsg("/authok " + nick);
                                nickname = nick;
                                server.subscribe(this);
<<<<<<< Updated upstream
=======
//
                                logger.log(Level.FINE, "\n Client " + nick + " is coming to chat.");
>>>>>>> Stashed changes
                                break;
                            }
                        }
                    }
                    while (true) {
                        String msg = in.readUTF();
                        if(msg.startsWith("/")) {
<<<<<<< Updated upstream
=======

                            logger.log(Level.FINE, "\n Client send message.");

>>>>>>> Stashed changes
                            if (msg.equals("/end")) {
                                sendMsg("/end");
                                break;
                            }
                            if(msg.startsWith("/w ")) {
                                String[] tokens = msg.split("\\s", 3);
                                server.privateMsg(this, tokens[1], tokens[2]);
                            }
                        } else {
                            server.broadcastMsg(nickname + ": " + msg);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    ClientHandler.this.disconnect();
                }
            });
            //}).start();
        } catch (IOException e) {
            e.printStackTrace();
<<<<<<< Updated upstream
=======
            logger.log(Level.FINE, "\n" + e);
>>>>>>> Stashed changes
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
<<<<<<< Updated upstream
=======
            logger.log(Level.FINE, "\n" + e);
>>>>>>> Stashed changes
        }
    }

    public void disconnect() {
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
<<<<<<< Updated upstream
=======
            logger.log(Level.FINE, "\n" + e);
>>>>>>> Stashed changes
        }
    }
}
