package exercitiiHashMap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Login log = new Login();

        System.out.println(" ");
        System.out.println("Welcome to your platform!");
        while (true) {
            System.out.println(" ");
            System.out.println("1 Login");
            System.out.println("2 Register");
            System.out.println("3 Exit");
            String command = log.controlCommand(key);
            if (command.equals("1")) {
                System.out.print("Username:");
                String userName = log.controlUsername(key);
                System.out.print("Password: ");
                String password = log.controlPassword(key);
                while (log.login(userName, password)) {
                    System.out.println("Do you want to try again?");
                    System.out.println("1. Yes");
                    System.out.println("2. NO");
                    command = log.controlCommand(key);
                    if (command.equals("2")) {
                        break;
                    }
                    System.out.print("Username: ");
                    userName = log.controlUsername(key);
                    System.out.print("Password: ");
                    password = log.controlPassword(key);
                    System.out.println("Login successful.");
                }
            } else if ("2".equals(command)) {
                System.out.print("Username: ");
                String userName = log.controlDuplicateUsername(key);
                System.out.print("Password: ");
                String pwd = log.controlPassword(key);
                log.register(userName, pwd);
            } else if ("3".equals(command)) {
                break;
            } else {
                System.out.println("Command not found. Try again..");
            }
        }
    }
}
