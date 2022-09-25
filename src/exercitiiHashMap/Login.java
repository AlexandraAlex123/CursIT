package exercitiiHashMap;

import java.sql.*;

public class Login {

    public boolean login(String user, String pwd) {
        String url = "jdbc:mysql://localhost:3306/exercitii";
        String username = "java";
        String password = "password";

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users where userName = " + user + " and password = " + pwd);
            while (rs.next()) {
                System.out.println("User name: " + user);
                System.out.println("Password: " + pwd);
                System.out.println("Conecting...");
                System.out.println("Login successful.");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return true;
    }

    public boolean register(String userName, String pwd) {
        String url = "jdbc:mysql://localhost:3306/exercitii";
        String username = "java";
        String password = "password";

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select userName from users");
            while (rs.next()) {
                if (userName.equals(rs.getString(1))) {
                    System.out.println("This user exist.");
                    return false;
                }
            }
            rs = statement.executeQuery("insert into user values('" + userName + "', '" + pwd + "')");
            System.out.println("The account has been created.");
            return true;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}

