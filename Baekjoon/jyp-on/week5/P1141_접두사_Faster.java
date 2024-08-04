package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1141_접두사_Faster {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        Arrays.sort(words);
        int cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            if (!isPrefix(words[i], words[i + 1])) {
                cnt++;
            }
        }
        System.out.println(cnt + 1);
    }

    public static boolean isPrefix(String prefix, String word) {
        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
