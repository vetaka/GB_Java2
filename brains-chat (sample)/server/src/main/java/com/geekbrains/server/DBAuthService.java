package com.geekbrains.server;
//Задание 2
import java.sql.*;

public class DBAuthService implements AuthService{

    private static Connection connection;
    private static final String DB_CONNECTION= "jdbc:sqlite:WorkDB.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_CONNECTION);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public String getNicknameByLoginAndPassword(String login, String password){
        try (PreparedStatement stm = connection
                .prepareStatement("SELECT * FROM bd WHERE log='" + login + "' AND pass='" + password + "'");
                ResultSet resultSet = stm.executeQuery();) {

            if (resultSet.getString(3) != null) {
                return resultSet.getString(3);
                }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
