package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15650_N과M2 {
    static int[] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        int[] out = new int[M];
        combination(out, 0, 0);

    }

    public static void combination(int[] out, int start, int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int a : out) {
                sb.append(a).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            out[depth] = arr[i];
            combination(out, i + 1, depth + 1);

        }
    }
}