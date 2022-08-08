package temaFunctii;

public class FunctieNumerePare {
    public static void main(String[] args) {
        int list[] = new int[]{2, 4, 5, 8, 11, 13, 14, 17, 21, 22};
        int listPare[] = new int[list.length];
        functieNrPare(list, listPare);
    }
    static int[] functieNrPare(int[] list, int[] listPare){
        int j = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] % 2 == 0) {
                listPare[j] = list[i];
                System.out.print(listPare[j] + " ");
                j++;
            }

        }
        return listPare;
    }
}
