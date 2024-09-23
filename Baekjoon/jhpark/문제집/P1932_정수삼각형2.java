package 문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1932_정수삼각형2 {
    static int n;
    static int[][] arr;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        memo = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                arr[i][j++] = Integer.parseInt(st.nextToken());
            }
            //자기자신과 자기자신+1인 곳 갈 수 있음
        }
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        System.out.println(func(0, 0));
    }

    static int func(int level, int index) {

        if (level == n) {
            return 0;
        }
        if (memo[level][index] != -1) {
            return memo[level][index]; // 이미 계산한 값이 있으면 반환
        } else if (index > level) {
            return 0;
        }
        int left = func(level + 1, index) + arr[level][index];
        int right = func(level + 1, index + 1) + arr[level][index];
        memo[level][index] = Math.max(left, right);

        return memo[level][index];
    }
}
