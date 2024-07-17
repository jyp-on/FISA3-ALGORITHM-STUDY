import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        int[] arr = new int[9];
        
        for (int i = 0; i < 9; i++) {
            int a = sc.nextInt();
            sum += a;
            arr[i] = a;
        }
        
        int target = sum - 100;

        int num1 = 0;
        int num2 = 0;

        Arrays.sort(arr);
        
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (arr[i] + arr[j] == target) {
                    num1 = i;
                    num2 = j;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != num1 && i != num2) {
                System.out.println(arr[i]);
            }
        }
        
    }
}