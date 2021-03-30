package com.geekbrains.server;
import java.sql.SQLException;

public class MainServer {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       Class.forName("org.sqlite.JDBC");
        final Server server = new Server();
    }
}
