package exercitiiHashMap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Login log = new Login();
        while (true) {
            System.out.println("Welcome to your platform!");
            System.out.println("Choose your action:");
            System.out.println("1 Login");
            System.out.println("2 Register");
            System.out.println("3 Exit");
            String comanda = controlComanda(log, key);
            if ("1".equals(comanda)) {
                System.out.print("Username: ");
                String userName = controlUsername(log, key);
                System.out.print("Password: ");
                String pwd = controlPassword(log, key);
                while (log.login(userName, pwd)) {
                    System.out.println("Username and password dosen't match. Try again.");
                    System.out.print("Username: ");
                    userName = controlUsername(log, key);
                    System.out.print("Password: ");
                    pwd = controlPassword(log, key);
                }
            } else if ("2".equals(comanda)) {
                System.out.print("Username: ");
                String userName = controlDubluraUsername(log, key);
                System.out.print("Password: ");
                String pwd = controlPassword(log, key);
                log.register(userName, pwd);
            } else if ("3".equals(comanda)) {
                break;
            } else {
                System.out.println("This command dosen't exit. Try again..");
            }
        }
    }



    static String controlDubluraUsername(Login log, Scanner key) {
        String userName = controlUsername(log, key);
        while (log.userExist(userName)) {
            System.out.print("Username: ");
            userName = controlUsername(log, key);
        }
        return userName;
    }
    static String controlComanda(Login log, Scanner key) {
        String comanda = key.nextLine();
        while (log.controlStringComanda(comanda)) {
            System.out.println("Error. Please try again..");
            comanda = key.nextLine();
        }
        return comanda;
    }

    static String controlUsername(Login log, Scanner key) {
        String userName = key.nextLine();
        while (log.controlStringUser(userName)) {
            System.out.println("Error. Please try again..");
            System.out.print("Username: ");
            userName = key.nextLine();
        }
        return userName;
    }

    static String controlPassword(Login log, Scanner key) {
        String pwd = key.nextLine();
        while (log.controlStringPassword(pwd)) {
            System.out.println("Error. Please try again..");
            System.out.print("Password: ");
            pwd = key.nextLine();
        }
        return pwd;
    }
}
