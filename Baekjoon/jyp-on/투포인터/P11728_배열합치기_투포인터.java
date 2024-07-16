package 투포인터;

import java.util.*;
import java.io.*;

public class P11728_배열합치기_투포인터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size1 = Integer.parseInt(st.nextToken());
        int size2 = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        // 정답을 저장할 배열 선언
        int[] ans = new int[size1 + size2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size1; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        // arr1의 원소를 순회할 포인터 p1, arr2를 순회할 포인터 p2, 정답 배열을 순회할 포인터 p3
        int p1 = 0, p2 = 0, p3 = 0;
        // 두개의 포인터 중 하나라도 범위를 초과하면 종료
        while (p1 < size1 && p2 < size2) {
            // 더 작은 값을 ans에 더해감
            if (arr1[p1] <= arr2[p2]) {
                ans[p3++] = arr1[p1++];
            } else {
                ans[p3++] = arr2[p2++];
            }
        }

        // 만약 p1이 다 안채워졌으면 ans 뒤에 추가
        while (p1 < size1) {
            ans[p3++] = arr1[p1++];
        }

        // 만약 p2이 다 안채워졌으면 ans 뒤에 추가
        while (p2 < size2) {
            ans[p3++] = arr2[p2++];
        }

        StringBuilder sb = new StringBuilder();
        for (int x : ans) {
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString());
    }
}
