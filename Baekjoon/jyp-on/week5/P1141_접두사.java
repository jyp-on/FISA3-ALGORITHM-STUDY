package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1141_접두사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        // 길이 내림차순 정렬
        Arrays.sort(arr, (s1, s2) -> s2.length() - s1.length());
        List<String> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i = 1; i < n; i++) {
            boolean flag = true;
            for(String s : list) {
                if(s.startsWith(arr[i])) {
                    flag = false;
                    break;
                }
            }
            if(flag) list.add(arr[i]);
        }

        System.out.println(list.size());
    }
}
