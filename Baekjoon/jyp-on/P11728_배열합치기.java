import java.util.*;
import java.io.*;

public class P11728_배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size1 = Integer.parseInt(st.nextToken());
        int size2 = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        int[] ans = new int[size1 + size2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size1; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < size1 && p2 < size2) {
            if (arr1[p1] <= arr2[p2]) {
                ans[p3++] = arr1[p1++];
            } else {
                ans[p3++] = arr2[p2++];
            }
        }

        while (p1 < size1) {
            ans[p3++] = arr1[p1++];
        }

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
