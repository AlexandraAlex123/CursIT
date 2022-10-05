package exercitiiHashMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyConnection {

    public String getUrl() throws RuntimeException {
        String url = null;
        try {
            File citire = new File("MyConnection.txt");
            Scanner myReader = new Scanner(citire);
            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                String[] s = word.split(" ");
                if ("url".equals(s[0])) {
                    url = s[1];
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    public String getUsername() {
        String username = null;
        try {
            File citire = new File("MyConnection.txt");
            Scanner myReader = new Scanner(citire);
            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                String[] s = word.split(" ");
                if ("username".equals(s[0])) {
                    username = s[1];
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return username;
    }

    public String getPassword() {
        String password = null;
        try {
            File citire = new File("MyConnection.txt");
            Scanner myReader = new Scanner(citire);
            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                String[] s = word.split(" ");
                if ("password".equals(s[0])) {
                    password = s[1];
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return password;
    }


//    public String conection() {
//        String url;
//        String username;
//        String password = null;
//        try {
//            File citire = new File("C:\\Users\\Lenovo\\IdeaProjects\\untitled\\src\\exercitiiHashMap\\ConexiuneaMea");
//            Scanner myReader = new Scanner(citire);
//            while (myReader.hasNextLine()) {
//                String word = myReader.nextLine();
//                String[] s = word.split(" ");
//                if ("url".equals(s[0])) {
//                    url = s[1];
//                    return url;
//                } else if ("user".equals(s[0])) {
//                    username = s[1];
//                    return username;
//                } else if ("password".equals(s[0])) {
//                    password = s[1];
//                }
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Connecting database...");
//        return password;
//    }

}
