package matrice;

public class TemaMatrice {
    public static void main(String[] args) {
        int[][] v = {{3, 4, 7, 8}, {10, 12, 14, 20}, {2, 3, 3, 4}, {12, 3, 34, 4}};
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();//Pentru a separa grupurile

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                if (i == j) {
                    System.out.print(v[i][j] + " ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println();// sa separam grupurile

        int i = 0;
        int y = v[i].length - 1;
        for (; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                if (j == y) {
                    System.out.print(v[i][j] + " ");
                    y--;
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }

        System.out.println();

        for (i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                if (i < j) {
                    System.out.print(v[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
