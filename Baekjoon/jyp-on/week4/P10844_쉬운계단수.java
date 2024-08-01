package week4;

import java.util.Arrays;
import java.util.Scanner;

public class P10844_쉬운계단수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] dp = new long[N + 1][10]; // dp 테이블 초기화
        final int MOD = 1000000000; // 나머지 연산을 위한 상수 선언

        // 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1임 (0 제외)
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 두 번째 자릿수부터 N까지 탐색
        for (int i = 2; i <= N; i++) {
            // i번째 자릿수의 값 탐색 (0~9)
            for (int j = 0; j < 10; j++) {
                // 0인 경우 이전 자릿수가 1인 경우의 수와 같음
                if (j == 0) {
                    dp[i][0] = dp[i-1][1] % MOD;
                }
                // 9인 경우 이전 자릿수가 8인 경우의 수와 같음
                else if (j == 9) {
                    dp[i][9] = dp[i-1][8] % MOD;
                }
                // 그 외의 경우 이전 자릿수의 (j-1)과 (j+1)의 경우의 수의 합
                else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
                }
            }
        }

        long sum = 0;
        // 마지막 자릿수의 경우의 수를 모두 합산
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i]) % MOD;
        }

        // 결과 출력
        System.out.println(sum);
    }
}
