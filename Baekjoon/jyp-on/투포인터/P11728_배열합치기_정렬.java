package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11728_배열합치기_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size1 = Integer.parseInt(st.nextToken());
        int size2 = Integer.parseInt(st.nextToken());
        // 정답을 저장할 배열 선언
        int[] ans = new int[size1 + size2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size1; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = size1; i < size1 + size2; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        // 2개의 배열을 합치고 정렬
        Arrays.sort(ans);

        StringBuilder sb = new StringBuilder();
        for (int x : ans) {
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString());
    }
}
