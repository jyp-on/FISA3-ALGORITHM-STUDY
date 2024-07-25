package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P12891_DNA비밀번호_A {
    static Map<Character, Integer> input = new HashMap<>();
    static Map<Character, Integer> target = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] str = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        int answer = 0;

        target.put('A', Integer.parseInt(st.nextToken()));
        target.put('C', Integer.parseInt(st.nextToken()));
        target.put('G', Integer.parseInt(st.nextToken()));
        target.put('T', Integer.parseInt(st.nextToken()));

        for(int i=0; i<P; i++) {
            input.put(str[i], input.getOrDefault(str[i], 0) + 1);
        }

        int p1 = 0, p2 = P;
        if(check()) answer++;

        while(p2 < S) {
            input.put(str[p1], input.get(str[p1])-1);
            if(input.get(str[p1]) == 0) input.remove(str[p1]);
            p1++;

            input.put(str[p2], input.getOrDefault(str[p2], 0) + 1);
            p2++;

            if(check()) answer++;
        }

        System.out.println(answer);
    }

    static boolean check() {
        for(char c : target.keySet()) {
            if(input.getOrDefault(c, 0) < target.get(c)) return false;
        }
        return true;
    }
}
