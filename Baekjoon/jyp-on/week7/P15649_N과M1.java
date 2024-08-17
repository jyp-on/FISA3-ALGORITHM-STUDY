package week7;

import java.util.*;
public class P15649_N과M1 {
    static int N, M;
    static boolean[] visited;
    static int[] output;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N + 1];
        output = new int[M];
        DFS(0);
        System.out.println(sb.toString());
    }

    static void DFS(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                DFS(depth + 1);
                visited[i] = false;
            }
        }
    }
}
