package temaFunctii;

import java.io.*;
import java.util.*;

public class Palindrom {
        public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            String A=sc.next();
            char[] a = A.toCharArray();
            boolean test = false;
            int j = a.length-1;
            for(int i= 0; i<a.length/2; i++){
                if(a[i] != a[j]){
                    test = true;
                    break;
                }
                j--;
            }
            if(test){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }

