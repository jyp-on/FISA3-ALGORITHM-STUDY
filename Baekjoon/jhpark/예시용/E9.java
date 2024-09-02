
package 예시용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E9 {
    static int[][] arr;
    static int find=4;
    static boolean[]visited;
    static  int s ;
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]strs= br.readLine().split(" ");
        s = Integer.parseInt(strs[0])+1;
        t = Integer.parseInt(strs[1]);
        visited = new boolean[s];
         arr= new int[s][s];
        for (int i = 0; i <t; i++) {
            String[] str= br.readLine().split(" ");
            arr[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
        }
        for (int i = 0; i < s; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        dfs(1);

    }
    static void dfs(int n){
        if(n==find){
            System.out.println("찾았다");
            return;
        }
        visited[n] = true;
            for (int i = 1; i < s; i++) {
                if (arr[n][i]==1&& !visited[i]){
                    dfs(i);
                }
            }

    }
}
//5 13
//1 2
//1 3
//1 4
//2 1
//2 3
//2 5
//3 1
//3 2
//3 4
//4 1
//4 5
//5 2
//5 4



