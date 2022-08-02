package day3;

public class Day3 {
    public static void main(String[] args) {
        String d = "alex";
        String e = "mama";
        String c = concatenareString(d, e);
        System.out.println(c);
        String t = "vreau sa plec";
        String v = "de la veo";
        System.out.println(concatenareString(t, v).toUpperCase());

    }

    static String concatenareString(String aa, String bb) {
        String asib = aa + " " + bb;
        return asib;

    }
}