import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wordCnt = Integer.parseInt(br.readLine());
        String[] words = new String[wordCnt];
        boolean[] contains = new boolean[wordCnt];

        for (int i = 0; i < wordCnt; i++) words[i] = br.readLine();

        Arrays.sort(words, (s1, s2) -> {
            if (s1.length() == s2.length()) return s1.compareTo(s2);
            else return s1.length() - s2.length();
        });

        for (int i = 0; i < wordCnt - 1; i++) {
            for (int j = i + 1; j < wordCnt; j++) {
                if(words[j].startsWith(words[i])) contains[i] = true;
            }
        }

        int result = 0;
        for(boolean value:contains) if(!value) result += 1;
        System.out.println(result);
    }
}
