package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P12891_DNA비밀번호_B {

    static int[] count = new int[26];

    // 하나라도 1 이상이면 false
    static boolean check() {
        return !(count[0] > 0 || count[2] > 0 || count[6] > 0 || count[19] > 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] str = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        count[0] = Integer.parseInt(st.nextToken());
        count[2] = Integer.parseInt(st.nextToken());
        count[6] = Integer.parseInt(st.nextToken());
        count[19] = Integer.parseInt(st.nextToken());

        int ans = 0;
        for(int i=0; i<P; i++) {
            count[str[i]-'A']--;
        }

        if(check()) ans++;

        for(int i=0; i<S-P; i++) {
            count[str[i]-'A']++;
            count[str[i+P]-'A']--;

            if(check()) ans++;
        }

        System.out.println(ans);
    }
}
