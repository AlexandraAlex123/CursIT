package day3;

public class Exemplu {
    public static void main(String[] args) {
        int[] valori = new int[]{1, 2, 3, 45, 78, 96};
        int target = 78;
        int i;
        boolean test = true;
        for (i = 0; i < valori.length; i++) {
            if (valori[i] == target) {
                System.out.println(i);
                test = false;
                break;
            }
        }
        if (test) {
            System.out.println("Not found");
        }
    }
}
