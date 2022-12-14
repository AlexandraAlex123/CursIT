package exercitiiHashMap;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class MainPractice {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Scanner key = new Scanner(System.in);
        LoginPractice log = new LoginPractice();

        System.out.println(" ");
        System.out.println("Welcome to your platform!");
        while (true) {
            System.out.println(" ");
            System.out.println("1 Login");
            System.out.println("2 Register");
            System.out.println("3 Exit");
            String command = controlCommand(log, key);
            if ("1".equals(command)) {
                System.out.print("Username: ");
                String userName = controlUsername(log, key);
                System.out.print("Password: ");
                String password = controlPassword(log, key);
                System.out.println("Connecting database...");
                System.out.println("Database connected.");
                while (log.login(userName, password)) {
                    System.out.println("Do you want to try again?");
                    System.out.println("1. Yes");
                    System.out.println("2. NO");
                    command = controlCommand(log, key);
                    if (command.equals("2")) {
                        break;
                    }
                    System.out.print("Username: ");
                    userName = controlUsername(log, key);
                    System.out.print("Password: ");
                    password = controlPassword(log, key);
                    System.out.println("Connecting database...");
                    System.out.println("Database connected.");
                }
                if (!log.login(userName, password)) {
                    System.out.println("Connecting...");
                    System.out.println("Login successful.");
                    while (true) {
                        System.out.println(" ");
                        System.out.println("Welcome to you account!");
                        System.out.println(" ");
                        System.out.println("Choose from menu:");
                        System.out.println("1. Movie");
                        System.out.println("2. Game");
                        System.out.println("3. Book");
                        System.out.println("4. Change password");
                        System.out.println("5. Exit your account");
                        command = controlCommand(log, key);
                        if (command.equals("1")) {
                            while (true) {
                                System.out.println(" ");
                                menu("movie");
                                command = controlCommand(log, key);
                                if (command.equals("1")) {
                                    System.out.print("Movie's name: ");
                                    String name = controlNoName(log, key, "movie", "Movie's name: ");
                                    log.searchMovie(name);
                                } else if (command.equals("2")) {
                                    command = "1";
                                    while (command.equals("1")) {
                                        int idMovie = log.getIdForMovie() + 1;
                                        System.out.print("ID movie:  ");
                                        System.out.println(idMovie);
                                        System.out.print("Movie's name: ");
                                        String movieName = controlDuplicateName(log, key, "movie", "Movie's name: ");
                                        System.out.print("Price: ");
                                        double price = Double.parseDouble(controlDouble(log, key, "Price: "));
                                        System.out.print("Gender: ");
                                        String gender = controlName(log, key, "Gender: ");
                                        System.out.print("Release date(dd-mm-yyy): ");
                                        String date = controlName(log, key, "Date(dd-mm-yyyy): ");
                                        System.out.print("Duration: ");
                                        double duration = Double.parseDouble(controlDouble(log, key, "Duration: "));
                                        String sqlQuery = "insert into movie values (" + idMovie + ",'" + movieName + "'," + price + ",STR_TO_DATE('" + date + "', '%d-%m-%Y'),'" + gender + "'," + duration + ");";
                                        log.addProduct(sqlQuery, "Movie updated");
                                        command = "1";
                                        while (command.equals("1")) {
                                            System.out.print("Actor name: ");
                                            String nameActor = controlName(log, key, "Actor name: ");
                                            System.out.print("Last name: ");
                                            String lastName = controlName(log, key, "Last name: ");
                                            System.out.print("ID: ");
                                            String id = controlName(log, key, "ID: ");
                                            System.out.print("Age: ");
                                            int age = Integer.parseInt(controlInt(log, key, "Age: "));
                                            sqlQuery = "insert into actor values(" + idMovie + ",'" + nameActor + "','" + lastName + "','" + id + "'," + age + ");";
                                            log.addProduct(sqlQuery, "Actor add.");
                                            System.out.println("Add another actor?");
                                            System.out.println("1. Yes");
                                            System.out.println("2. No");
                                            command = controlCommand(log, key);
                                        }
                                        System.out.println("Movie completely add.");
                                        System.out.println("Add another movie?");
                                        System.out.println("1. Yes");
                                        System.out.println("2. No");
                                        command = controlCommand(log, key);
                                    }
                                } else if (command.equals("3")) {
                                    String table = "movie";
                                    System.out.print("Delete movie: ");
                                    String delete = controlName(log, key, "Delete movie");
                                    int idMovie = log.getIdForDelete(delete);
                                    while (log.deleteProduct(delete, table)) {
                                        System.out.print("Delete movie: ");
                                        delete = controlName(log, key, "Delete movie: ");
                                    }
                                    log.deleteActor(idMovie);
                                } else if (command.equals("4")) {
                                    break;
                                } else {
                                    System.out.println("Command not found. Try again..");
                                }
                            }
                        } else if (command.equals("2")) {
                            while (true) {
                                menu("game");
                                command = controlCommand(log, key);
                                if (command.equals("1")) {
                                    System.out.print("Game's name: ");
                                    String name = controlNoName(log, key, "game", "Game's name: ");
                                    log.searchGame(name);
                                } else if (command.equals("2")) {
                                    command = "1";
                                    while (command.equals("1")) {
                                        System.out.print("Game's name:  ");
                                        String gameName = controlDuplicateName(log, key, "game", "Game's name: ");
                                        System.out.print("Price: ");
                                        double price = Double.parseDouble(controlDouble(log, key, "Price: "));
                                        System.out.print("Release date(dd-mm-yyy): ");
                                        String date = controlName(log, key, "Date(dd-mm-yyyy): ");
                                        System.out.print("Type og game: ");
                                        String tpo = controlName(log, key, "Type of game: ");
                                        System.out.print("Multiplayer(true/false): ");
                                        boolean mp = Boolean.parseBoolean(key.nextLine());
                                        String sqlQuery = "insert into game values ('" + gameName + "'," + price + ",STR_TO_DATE('" + date + "', '%d-%m-%Y'),'" + tpo + "'," + mp + ");";
                                        log.addProduct(sqlQuery, "Game add");
                                        System.out.println("Add another game?");
                                        System.out.println("1. Yes");
                                        System.out.println("2. No");
                                        command = controlCommand(log, key);
                                    }
                                } else if (command.equals("3")) {
                                    System.out.print("Delete game: ");
                                    controlDelete(log, key, "game", "Delete game: ");
                                } else if (command.equals("4")) {
                                    break;
                                } else {
                                    System.out.println("Command not found. Try again..");
                                }
                            }
                        } else if (command.equals("3")) {
                            while (true) {
                                menu("book");
                                command = controlCommand(log, key);
                                if (command.equals("1")) {
                                    System.out.print("Book's name: ");
                                    String name = controlNoName(log, key, "book", "Book's name: ");
                                    log.searchBook(name);
                                } else if (command.equals("2")) {
                                    command = "1";
                                    while (command.equals("1")) {
                                        System.out.print("Book's name:  ");
                                        String bookName = controlDuplicateName(log, key, "book", "Book's name: ");
                                        System.out.print("Price: ");
                                        double price = Double.parseDouble(controlDouble(log, key, "Price: "));
                                        System.out.print("Release date(dd-mm-yyy): ");
                                        String date = controlName(log, key, "Date(dd-mm-yyyy): ");
                                        System.out.print("Number of book's: ");
                                        int nob = Integer.parseInt(controlInt(log, key, "Number of book's: "));
                                        String sqlQuery = "insert into book values ('" + bookName + "'," + price + ",STR_TO_DATE('" + date + "', '%d-%m-%Y')," + nob + ");";
                                        log.addProduct(sqlQuery, "Book add");
                                        System.out.println("Add another book?");
                                        System.out.println("1. Yes");
                                        System.out.println("2. No");
                                        command = controlCommand(log, key);
                                    }
                                } else if (command.equals("3")) {
                                    System.out.print("Delete book: ");
                                    controlDelete(log, key, "book", "Delete book: ");
                                } else if (command.equals("4")) {
                                    break;
                                } else {
                                    System.out.println("Command not found. Try again..");
                                }
                            }
                        } else if (command.equals("4")) {
                            System.out.print("Enter new password: ");
                            String newPassword = controlPassword(log, key);
                            System.out.print("Enter old password: ");
                            password = controlPassword(log, key);
                            log.changePassword(userName, newPassword, password);
                        } else if (command.equals("5")) {
                            break;
                        } else {
                            System.out.println("Command not found. Try again..");
                        }
                    }
                }
            } else if ("2".equals(command)) {
                System.out.print("Username: ");
                String userName = controlDuplicateUsername(log, key);
                System.out.print("Password: ");
                String pwd = controlPassword(log, key);
                log.register(userName, pwd);
            } else if ("3".equals(command)) {
                break;
            } else {
                System.out.println("Command not found. Try again..");
            }
        }
    }


    static void menu(String message) {
        System.out.println(" ");
        System.out.println("Choose your action:");
        System.out.println("1. Search " + message);
        System.out.println("2. Add " + message);
        System.out.println("3. Delete " + message);
        System.out.println("4. Back");
    }


    static String controlDuplicateUsername(LoginPractice log, Scanner key) {
        String userName = controlUsername(log, key);
        while (log.userExist(userName)) {
            System.out.print("Username: ");
            userName = controlUsername(log, key);
        }
        return userName;
    }


    static void controlDelete(LoginPractice log, Scanner key, String table, String message) {
        String delete = controlName(log, key, message);
        while (log.deleteProduct(delete, table)) {
            System.out.print(message);
            delete = controlName(log, key, message);
        }
    }


    static String controlCommand(LoginPractice log, Scanner key) {
        String command = key.nextLine();
        while (log.controlStringCommand(command)) {
            System.out.println("Error. Please try again..");
            command = key.nextLine();
        }
        return command;
    }


    static String controlUsername(LoginPractice log, Scanner key) {
        String userName = key.nextLine();
        while (log.controlStringUser(userName)) {
            System.out.println("Error. Please try again..");
            System.out.print("Username: ");
            userName = key.nextLine();
        }
        return userName;
    }


    static String controlPassword(LoginPractice log, Scanner key) {
        String pwd = key.nextLine();
        while (log.controlStringPassword(pwd)) {
            System.out.println("Please try again. The password must contain first letter uppercase, 1 figure and a special character.");
            System.out.print("Password: ");
            pwd = key.nextLine();
        }
        return pwd;
    }


    static String controlDuplicateName(LoginPractice log, Scanner key, String table, String message) {
        String name = controlName(log, key, message);
        while (log.nameExist(name, table)) {
            System.out.print(message);
            name = controlName(log, key, message);
        }
        return name;
    }

    static String controlNoName(LoginPractice log, Scanner key, String table, String message) {
        String name = controlName(log, key, message);
        while (!log.nameExist(name, table)) {
            System.out.print(message);
            name = controlName(log, key, message);
        }
        return name;
    }


    static String controlName(LoginPractice log, Scanner key, String message) {
        String name = key.nextLine();
        while (log.controlStringName(name)) {
            System.out.println("Error. Please try again..");
            System.out.print(message);
            name = key.nextLine();
        }
        return name;
    }


    static String controlDouble(LoginPractice log, Scanner key, String message) {
        String check = key.nextLine();
        while (log.controlStringDouble(check)) {
            System.out.println("Error. Please try again..");
            System.out.print(message);
            check = key.nextLine();
        }
        return check;
    }


    static String controlInt(LoginPractice log, Scanner key, String message) {
        String check = key.nextLine();
        while (log.controlStringInt(check)) {
            System.out.println("Error. Please try again..");
            System.out.print(message);
            check = key.nextLine();
        }
        return check;
    }
}
