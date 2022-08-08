package temaFunctii;

public class FunctieUnireSiSortare {
    public static void main(String[] args) {
        int list1[] = new int[]{2, 5, 6, 9, 12};
        int list2[] = new int[]{3, 4, 10, 11, 15};
        int coList[] = new int[list1.length + list2.length];
        System.out.print("Prima lista: ");
        for (int i = 0; i < list1.length; i++) {
            coList[i] = list1[i];
            System.out.print(list1[i] + " ");
        }
        System.out.println();
        System.out.print("A doua lista: ");
        int a = list1.length;
        for (int i = 0; i < list2.length; i++) {
            coList[a] = list2[i];
            System.out.print(list2[i] + " ");
            a++;
        }
        System.out.println();
        System.out.print("Lista finala: ");
        for (int i = 0; i < coList.length; i++) {
            for (int j = i + 1; j < coList.length; j++) {
                if (coList[i] > coList[j]) {
                    int temp = 0;
                    temp = coList[i];
                    coList[i] = coList[j];
                    coList[j] = temp;
                }
            }
            System.out.print(coList[i] + " ");
        }

    }
}

