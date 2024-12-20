package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1495_기타리스트 {
    static int n;
    static int startVolume;
    static int[][] dp;
    static int max;
    static int[] v;
    static int[] answer;
    static int a = 0;
    static boolean flag=false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        startVolume = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            v[i] = temp;
        }

        dp(startVolume,1);
        if (flag){
            System.out.println(-1);
        }
        else
            System.out.println(a==0?-1:a);
    }

    public static void dp(int now, int index) {
//        System.out.println(now);
        if (index == n+1) {
            a = a < now ? now : a;
            return;
        }
        int num = v[index];
//        System.out.println(num);
        if(now + num > max && now - num < 0){
            flag=true;
        }else {
            if (now + num <= max) {
                dp(now + num, index + 1);

            }
            if (now - num >= 0) {
                dp(now - num, index + 1);
            }
        }

    }
}
