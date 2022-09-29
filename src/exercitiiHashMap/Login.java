package exercitiiHashMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Login {

    public String conection() {
        String url;
        String username;
        String password = null;
        try {
            File citire = new File("C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\exercitiiHashMap\\ConexiuneaMea");
            Scanner myReader = new Scanner(citire);
            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                String[] s = word.split(" ");
                if ("url".equals(s[0])) {
                    url = s[1];
                    return url;
                } else if ("user".equals(s[0])) {
                    username = s[1];
                    return username;
                } else if ("password".equals(s[0])) {
                    password = s[1];
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connecting database...");
        return password;
    }


    public boolean login(String userName, String pwd) {
        String url = null;
        String username = null;
        String password = null;
        try {
            File citire = new File("C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\exercitiiHashMap\\ConexiuneaMea");
            Scanner myReader = new Scanner(citire);
            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                String[] s = word.split(" ");
                if ("url".equals(s[0])) {
                    url = s[1];
                } else if ("user".equals(s[0])) {
                    username = s[1];
                } else if ("password".equals(s[0])) {
                    password = s[1];
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connecting database...");
        try {
            assert url != null;
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Database connected!");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from login where username = " + userName + " and password = " + pwd);
                if (rs.next()) {
                    System.out.println("Conecting...");
                    System.out.println("Login successful.");
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public boolean userExist(String userName) {
        String url = null;
        String username = null;
        String password = null;
        try {
            File citire = new File("C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\exercitiiHashMap\\ConexiuneaMea");
            Scanner myReader = new Scanner(citire);
            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                String[] s = word.split(" ");
                if ("url".equals(s[0])) {
                    url = s[1];
                } else if ("user".equals(s[0])) {
                    username = s[1];
                } else if ("password".equals(s[0])) {
                    password = s[1];
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connecting database...");
        try {
            assert url != null;
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Database connected!");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select username from login");
                while (rs.next()) {
                    if (userName.equals(rs.getString(1))) {
                        System.out.println("This user exist.");
                        return false;
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }


    public void register(String userName, String pwd) {
        String url = null;
        String username = null;
        String password = null;
        try {
            File citire = new File("C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\exercitiiHashMap\\ConexiuneaMea");
            Scanner myReader = new Scanner(citire);
            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                String[] s = word.split(" ");
                if ("url".equals(s[0])) {
                    url = s[1];
                } else if ("user".equals(s[0])) {
                    username = s[1];
                } else if ("password".equals(s[0])) {
                    password = s[1];
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connecting database...");
        try {
            assert url != null;
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Database connected!");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("insert into login values('" + userName + "','" + pwd + "');");
                if (rs.next()) {
                    System.out.println("Your account has been created.");
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }


    public boolean controlStringUser(String userName) {
        char[] c = userName.toCharArray();
        if (!userName.contains(" ")) {
            return c.length < 6;
        }
        return true;
    }

    public boolean controlStringPassword(String password) {
        char[] c = password.toCharArray();
        if (!password.contains(" ")) {
            return c.length < 6;
        }
        return true;
    }

    public boolean controlStringComanda(String comanda) {
        char[] c = comanda.toCharArray();
        if (!comanda.equals(" ")) {
            return c.length != 1;
        }
        return true;
    }
}

