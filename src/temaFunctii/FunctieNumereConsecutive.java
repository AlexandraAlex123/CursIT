package temaFunctii;

public class FunctieNumereConsecutive {
    public static void main(String[] args) {
        int listInitial[] = new int[]{1, 4, 4, 5, 7, 8, 7, 2, 2, 9, 9};
        int listFinal[] = new int[listInitial.length];
        functieNrCon(listInitial, listFinal);
    }
    static int[] functieNrCon(int[] listInitial, int[] listFinal){
        int j = 0;
        for (int i = 0; i < listInitial.length - 1; i++) {
            if (listInitial[i] == listInitial[i + 1]) {
                listFinal[j] = listInitial[i];
                System.out.print(listFinal[j] + " ");
                j++;
            }
        }
        return listFinal;
    }
}
