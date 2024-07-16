package 완전탐색;

import java.util.*;

public class P2309_일곱난쟁이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        for(int i=0; i<9; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int sum = 0;
        for(int x : arr) {
            sum += x;
        }

        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                if(sum - (arr[i] + arr[j]) == 100) {
                    for(int k=0; k<9; k++) {
                        if(k != i && k != j) {
                            System.out.println(arr[k]);
                        }
                    }
                    System.exit(0);
                }
            }
        }
    }
}
