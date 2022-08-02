package day2;

import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int[] nums = new int[]{1, 5, 10, 14, 20, 23};
        int[] nums2 = new int[]{1, 5, 10, 14, 20, 23};
        int i = 0;
        if (nums.length == nums2.length) {
            for (i = 0; i < nums.length; i++) {
                if (nums[i] == nums2[i]) {
                    if (i == nums.length - 1) {
                        System.out.println("Matricile sunt egale");
                    }
                } else {
                    System.out.println("Maricile nu sunt egale");
                    break;
                }
            }

        } else {
            System.out.println("Matricile nu sunt egale");
        }
    }
}



