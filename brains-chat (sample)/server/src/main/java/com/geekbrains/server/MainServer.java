package com.geekbrains.server;
<<<<<<< Updated upstream
import java.sql.SQLException;

public class MainServer {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
     //  Class.forName("org.sqlite.JDBC");
        final Server server = new Server();
=======
import com.sun.javafx.binding.StringFormatter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.*;
import java.time.LocalDateTime;

public class MainServer {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

       Class.forName("org.sqlite.JDBC");
        final Server server = new Server();

>>>>>>> Stashed changes
    }
}
