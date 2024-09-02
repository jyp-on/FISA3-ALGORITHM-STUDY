package week7;

import java.util.Scanner;

public class P15651_N과M3 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[] out = new int[M];
        combination(out, 0);
        System.out.println(sb.toString());
    }

    static void combination(int[] out, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(out[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            out[depth] = i;
            combination(out, depth + 1);
        }
    }
}
