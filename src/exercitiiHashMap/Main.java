package exercitiiHashMap;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Login users = new Login();
        String user = key.nextLine();
        String pwd = key.nextLine();
        users.login(user,pwd);
    }
}
