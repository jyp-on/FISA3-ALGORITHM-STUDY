import java.util.*;
import java.io.*;

public class P2156_포도주시식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        // n이 3개 이하면 에러를 방지하고자 따로 처리하고 강제종료.
        if(n <= 3) {
            if(n == 1) System.out.println(arr[0]);
            if(n == 2) System.out.println(arr[0] + arr[1]);
            if(n == 3) System.out.println(Math.max(arr[0] + arr[1], Math.max(arr[0] + arr[2], arr[1] + arr[2])));
            System.exit(0);
        }

        // dp[i]는 i번째 까지 최대한 먹을 수 있는 포도주의 량
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0] + arr[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));

        /*
        * 1. 현재 포도주를 안먹는 경우 (dp[i-1])
        * 2. 직전 포도주를 안먹는 경우 (dp[i-2] + arr[i])
        * 3. 현재와 직전 포도주를 먹는 경우, 즉 i-2번을 안먹는 경우 (arr[i] + arr[i-1] + dp[i-3])
        * */
        for(int i=3; i<n; i++) {
            dp[i] = Math.max(dp[i-1],
                    Math.max(dp[i-2] + arr[i],
                             dp[i-3] + arr[i-1] + arr[i]));
        }

        System.out.println(dp[n-1]);
    }
}
