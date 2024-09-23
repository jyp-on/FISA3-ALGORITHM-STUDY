import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] tops = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) tops[i] = Integer.parseInt(st.nextToken());

        Stack<int[]> stack = new Stack<int[]>();
        int[] result = new int[N + 1];

        for(int i=N; i>0; i--) {
            int height = tops[i];
            while(!stack.isEmpty() && stack.peek()[1] <= height) {
                result[stack.peek()[0]] = i;
                stack.pop();
            }
            stack.add(new int[] {i, height});
        }

        for(int i=1; i<=N; i++) sb.append(result[i]).append(" ");
        bw.append(sb.toString());
        bw.close();
    }
}
