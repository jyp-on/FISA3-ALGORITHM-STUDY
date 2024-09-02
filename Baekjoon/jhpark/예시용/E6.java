package 예시용;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class E6 {
    public static void main(String[] args) {
        int[][] arr= new int[7][7];
        /*         0
         *     1    2    3
         *   4     5  6
         */
        arr[0][1]=1; arr[0][2]=1; arr[0][3]=1;


        arr[1][4]=1;

        arr[2][5]=1; arr[2][6]=1;
        int find=6;
        Stack<Integer> stack= new Stack<>();
        stack.add(0);
        while (!stack.isEmpty()){
            int in = stack.pop();
            System.out.print(in+" ");
            for (int i = 6; i >= 0; i--) {
                if(arr[in][i]==1){
                    stack.add(i);
                }
            }
        }
    }
}
