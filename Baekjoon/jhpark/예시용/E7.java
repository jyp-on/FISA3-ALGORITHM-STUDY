package 예시용;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class E7 {
    static int find=6;
    static int[][] arr= new int[7][7];
    public static void main(String[] args) {

        /*         0
         *     1    2    3
         *   4     5  6
         */
        arr[0][1]=1; arr[0][2]=1; arr[0][3]=1;


        arr[1][4]=1;

        arr[2][5]=1; arr[2][6]=1;

        Stack<Integer> stack= new Stack<>();
        stack.add(0);
        List<Integer> list= new ArrayList<>();
        list.add(0);
        dfs(0);
        dfsShow(0,list);
    }
    static void dfsShow(int n, List<Integer> list){
        if(n==find){
            System.out.println("찾았다"+ list);
        }
        else {
            for (int i = 0; i < 7; i++) {
                if (arr[n][i]==1){
                    list.add(i);

                    dfsShow(i,list);

                    list.remove(list.size()-1);
                }
            }
        }
    }
    static void dfs(int n){
        if(n==find){
            System.out.println("찾았다");
        }
        else {
            for (int i = 0; i < 7; i++) {
                if (arr[n][i]==1){
                    dfs(i);
                }
            }
        }
    }
}
