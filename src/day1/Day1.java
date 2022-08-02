package day1;

import java.util.Scanner;

public class Day1{

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int varsta = keyboard.nextInt();
        if (varsta > 0 && varsta < 100) {
            System.out.println("Varsta este corecta");
        } else {
            System.out.println("Varsta nu este corecta");
        }
    }
}
