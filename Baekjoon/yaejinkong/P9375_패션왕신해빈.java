import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P9375_패션왕신해빈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < test; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String [] arr = sc.nextLine().split(" ");
                // getOrDefault(key, defaultvalue) : 찾는 키가 있으면 값을 반환, 없으면 기본값을 반환
                // 의상 종류(arr[1])의 개수를 세는 것! "의상종류" : 개수
                map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
            }

            int cnt = 1;
            for (Integer value : map.values()) {
                cnt *= (value + 1);
            }
            cnt--;
            System.out.println(cnt);
        }
    }
}
