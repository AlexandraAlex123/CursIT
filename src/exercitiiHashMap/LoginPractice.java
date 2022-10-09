package exercitiiHashMap;

import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPractice {

    MyConnection c = new MyConnection();


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


    public void searchMovie(String name) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from movie where name = '" + name + "';");
            int idFilm = 0;
            while (rs.next()) {
                System.out.print("ID film: ");
                System.out.println(rs.getInt(1));
                idFilm = rs.getInt(1);
                System.out.print("Price: ");
                System.out.println(rs.getDouble(3));
                System.out.print("Release date: ");
                System.out.println(rs.getDate(4));
                System.out.print("Gender: ");
                System.out.println(rs.getString(5));
                System.out.print("Duration: ");
                System.out.println(rs.getDouble(6));
            }
            rs = statement.executeQuery("select * from actor where id_movie = '" + idFilm + "';");
            System.out.println("Actor:");
            while (rs.next()) {
                System.out.println("- Name:" + rs.getString(2) + " " + rs.getString(3) + " ID:" + rs.getString(4) + " Age:" + rs.getInt(5));
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }


    public void searchGame(String name) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from game where name = '" + name + "';");
            while (rs.next()) {
                System.out.print("Price: ");
                System.out.println(rs.getDouble(2));
                System.out.print("Release date: ");
                System.out.println(rs.getDate(3));
                System.out.print("Gender: ");
                System.out.println(rs.getString(4));
                System.out.print("Multiplayer: ");
                System.out.println(rs.getBoolean(5));
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }


    public void searchBook(String name) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from book where name = '" + name + "';");
            while (rs.next()) {
                System.out.print("Price: ");
                System.out.println(rs.getDouble(2));
                System.out.print("Release date: ");
                System.out.println(rs.getDate(3));
                System.out.print("Number of books: ");
                System.out.println(rs.getInt(4));
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public boolean nameExist(String name, String table) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from " + table + " where name = '" + name + "';");
            if (rs.next()) {
                System.out.println("This " + table + " exist. ");
                return true;
            } else {
                System.out.println("Not found. Try again..");
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return false;
    }


    public Integer getIdForMovie() {
        int idMovie = 0;
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from movie where id_movie = (select max(id_movie) from movie);");
            if (rs.next()) {
                idMovie = rs.getInt(1);
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return idMovie;
    }


    public Integer getIdForDelete(String delete) {
        int idMovie = 0;
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select id_movie from movie where name = '" + delete + "';");
            if (rs.next()) {
                idMovie = rs.getInt(1);
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return idMovie;
    }

    public void addProduct(String sqlQuery, String message) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            Statement statement = connection.createStatement();
            int rs = statement.executeUpdate(sqlQuery);
            if (rs != 0) {
                System.out.println(message);
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }


    public boolean deleteProduct(String delete, String table) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            Statement statement = connection.createStatement();
            int rs = statement.executeUpdate("delete from " + table + " where name = '" + delete + "';");
            if (rs != 0) {
                System.out.println("Item deleted.");
                return false;
            } else {
                System.out.println("Not found. Try again");
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return true;
    }


    public void deleteActor(int idMovie) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            Statement statement = connection.createStatement();
            int rs = statement.executeUpdate("delete from actor where id_movie = " + idMovie + ";");
            if (rs != 0) {
                System.out.println("Actor deleted.");
            } else {
                System.out.println("Not found. Try again");
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }


    public boolean login(String userName, String pwd) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            String passwordHash = getHash(pwd);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from login where username = '" + userName + "' and password = '" + passwordHash + "';");
            if (rs.next()) {
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


    public void changePassword(String userName, String newPwd, String pwd) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            String passwordHash = getHash(pwd);
            String newPasswordHash = getHash(newPwd);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from login where username = '" + userName + "' and password = '" + passwordHash + "';");
            if (rs.next()) {
                int rs2 = statement.executeUpdate("update login set password = '" + newPasswordHash + "' where username = '" + userName + "';");
                if (rs2 != 0) {
                    System.out.println("Password changed");
                }
            } else {
                System.out.println("Wrong old password. The change didn't apply.");
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }


    public boolean userExist(String userName) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select username from login;");
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


    public void register(String userName, String pwd) {
        try {
            Connection connection = DriverManager.getConnection(c.getUrl(), c.getUsername(), c.getPassword());
            String passwordHash = getHash(pwd);
            Statement statement = connection.createStatement();
            int rs = statement.executeUpdate("insert into login values ('" + userName + "','" + passwordHash + "');");
            if (rs != 0) {
                System.out.println("Your account has been created.");
            }
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }


    public boolean controlStringName(@NotNull String name) {
        char[] c = name.toCharArray();
        if (!name.equals("")) {
            return c.length < 2;
        }
        return true;
    }


    public boolean controlStringUser(@NotNull String userName) {
        char[] c = userName.toCharArray();
        if (!userName.contains(" ")) {
            return c.length < 6;
        }
        return true;
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


    public boolean controlStringCommand(@NotNull String command) {
        char[] c = command.toCharArray();
        if (!command.equals(" ")) {
            return c.length != 1;
        }
        return true;
    }


    public boolean controlStringDouble(String stringToCheck) {
        return Objects.equals(stringToCheck, "") || !stringToCheck.matches("\\d{0,2}\\.\\d{1,2}");
    }


    public boolean controlStringInt(String stringToCheck) {
        return Objects.equals(stringToCheck, "") || !stringToCheck.matches("[\\d.]+");
    }
}

