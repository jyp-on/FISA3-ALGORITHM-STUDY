package 백트래킹;
import java.util.*;
import java.io.*;

public class P10974_모든순열 {
    static int[] arr, ans;
    static boolean[] visit;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        ans = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        dfs(0);
        System.out.println(sb.toString());
    }

    static void dfs(int depth) {
        if(depth == N) {
            for(int i=0; i<N; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                ans[depth] = arr[i];
                dfs(depth+1);
                visit[i] = false;
            }

        }

    }
}
