import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) triangle[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for(int i=1; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(j == 0) dp[i][0] = dp[i - 1][0] + triangle[i][0];
                else if(j == i) dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        int max = dp[n - 1][0];
        for(int i=1; i<n; i++) max = Math.max(max, dp[n - 1][i]);
        System.out.println(max);
    }
}
