package temaFunctii;

public class FunctieSortare {
    public static void main(String[] args) {
        int abc[] = new int[]{12, 5, 3, 10, 9};
        System.out.print("Vector Initial: ");
        for (int i = 0; i < abc.length; i++) {
            System.out.print(abc[i] + " ");
        }
        System.out.println();
        System.out.print("Vector sortat: ");
        for (int i = 0; i < abc.length; i++) {
            for (int j = i + 1; j < abc.length; j++) {
                if (abc[i] > abc[j]) {
                    int temp = 0;
                    temp = abc[i];
                    abc[i] = abc[j];
                    abc[j] = temp;
                }
            }
            System.out.print(abc[i] + " ");
        }


    }
}
