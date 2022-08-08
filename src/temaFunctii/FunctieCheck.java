package temaFunctii;

public class FunctieCheck {
    public static void main(String[] args) {
        int[] listSort = new int[]{1, 5, 2, 6};
        boolean test = false;
        for (int i = 0; i < listSort.length - 1; i++) {
            if (listSort[i] > listSort[i + 1]) {
                test = true;
                break;
            }
        }
        if (test) {
            System.out.println("Vectorul nu este sortat");
        } else {
            System.out.println("Vectorul este sortat");
        }
    }
}
