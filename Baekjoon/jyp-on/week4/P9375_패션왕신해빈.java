package week4;

import java.util.*;
import java.io.*;

public class P9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String value = st.nextToken();  // 의상 이름
                String key = st.nextToken();    // 의상 종류

                // 의상 종류별 카운트를 증가시킴
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int result = 1;

            // 각 의상 종류별로 (입지 않는 경우 포함하여) 경우의 수를 곱함
            for (int count : map.values()) {
                result *= (count + 1);
            }

            // 아무것도 입지 않는 경우는 제외
            result -= 1;

            System.out.println(result);
        }
    }
}
