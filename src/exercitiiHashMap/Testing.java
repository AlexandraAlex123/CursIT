package exercitiiHashMap;


import java.util.Scanner;
import login.Login;

public class Testing {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Welcome to your platform!");
        while (true) {
            System.out.println(" ");
            System.out.println("1 Login");
            System.out.println("2 Register");
            System.out.println("3 Exit");
            String command = key.next();
            if (command.equals("1")) {
                 Login.login();
            } else if ("2".equals(command)) {
                Login.register();
            } else if ("3".equals(command)) {
                break;
            } else {
                System.out.println("Command not found. Try again..");
            }
        }
    }
}
