package week6;

import java.util.*;
import java.io.*;

public class P14888_연산자끼워넣기 {
    static int N;
    static int[] arr;
    static int[] op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        DFS(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void DFS(int depth, int sum) {
        if (depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            if (op[k] > 0) {
                op[k]--;
                switch (k) {
                    case 0: DFS(depth + 1, sum + arr[depth]);
                        break;
                    case 1: DFS(depth + 1, sum - arr[depth]);
                        break;
                    case 2: DFS(depth + 1, sum * arr[depth]);
                        break;
                    case 3: DFS(depth + 1, sum / arr[depth]);
                        break;
                }
                op[k]++;
            }
        }
    }
}
