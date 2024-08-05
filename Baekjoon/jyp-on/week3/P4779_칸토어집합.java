package week3;
import java.io.*;
public class P4779_칸토어집합 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if(input == null || input.isEmpty()) break;
            int N = Integer.parseInt(input);
            char[] arr = "-".repeat((int) Math.pow(3, N)).toCharArray();
            dfs(arr, 0, arr.length);
            sb.append(arr);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(char[] arr, int start, int length) {
        if (length == 1) {
            return;
        }

        int partLength = length / 3;
        for (int i = start + partLength; i < start + (partLength * 2); i++) {
            arr[i] = ' ';
        }

        dfs(arr, start, partLength);
        dfs(arr, start + (partLength * 2), partLength);
    }
}
