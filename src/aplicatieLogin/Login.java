package aplicatieLogin;

import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    MyConnection c = new MyConnection();

    public String controlCommand(Scanner key) {
        String command = key.nextLine();
        while (controlStringInt(command)) {
            System.out.println("Error. Please try again..");
            command = key.nextLine();
        }
        return command;
    }


    public boolean controlStringInt(String stringToCheck) {
        return Objects.equals(stringToCheck, "") || !stringToCheck.matches("[\\d.]+");
    }


    static public String getHash(@NotNull String password) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }


    public boolean login(String userName, String password) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            String passwordHash = getHash(password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from conturi where nume = '" + userName + "' and parola = '" + passwordHash + "';");
            if (rs.next()) {
                System.out.println("Login successful.");
                return false;
            } else {
                System.out.println("Username and password don't match. Try again.");
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return true;
    }


    public void register(String userName, String password) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            String passwordHash = getHash(password);
            Statement statement = connection.createStatement();
            int rs = statement.executeUpdate("insert into conturi values ('" + userName + "','" + passwordHash + "');");
            if (rs != 0) {
                System.out.println("Your account has been created.");
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }


    public String controlUsername(Scanner key) {
        String userName = key.nextLine();
        while (controlStringUser(userName)) {
            System.out.println("Error. Please try again..");
            System.out.print("Username: ");
            userName = key.nextLine();
        }
        return userName;
    }


    public void tryAgain(String userName, String password, Scanner key) {
        while (login(userName, password)) {
            System.out.println("Do you want to try again?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            String command = controlCommand(key);
            if (command.equals("2")) {
                break;
            }
            System.out.print("Username: ");
            userName = controlUsername(key);
            System.out.print("Password: ");
            password = controlPassword(key);
        }
    }


    public boolean controlStringUser(@NotNull String userName) {
        char[] c = userName.toCharArray();
        if (!userName.contains(" ")) {
            return c.length < 6;
        }
        return true;
    }


    public String controlDuplicateUsername(Scanner key) {
        String userName = controlUsername(key);
        while (userExist(userName)) {
            System.out.print("Username: ");
            userName = controlUsername(key);
        }
        return userName;
    }

    public boolean userExist(String userName) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select nume from conturi;");
            while (rs.next()) {
                if (userName.equals(rs.getString(1))) {
                    System.out.println("This user exist.");
                    return true;
                }
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return false;
    }


    public String controlPassword(Scanner key) {
        String pwd = key.nextLine();
        while (controlStringPassword(pwd)) {
            System.out.println("Please try again. The password must contain first letter uppercase, 1 figure and a special character.");
            System.out.print("Password: ");
            pwd = key.nextLine();
        }
        return pwd;
    }

    public boolean controlStringPassword(@NotNull String password) {
        char[] c = password.toCharArray();
        if (!password.contains(" ")) {
            if (c.length > 6) {
                Pattern p = Pattern.compile("[^a-zA-Z\\d]");
                Matcher m = p.matcher(password);
                boolean result = m.find();
                if (result) {
                    if (password.matches(".*\\d.*")) {
                        char firstLetter = password.charAt(0);
                        if (Character.isUpperCase(firstLetter)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
