package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2346_풍선터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        boolean[] visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start_idx = 0;
        visit[start_idx] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(start_idx+1).append(" ");
        boolean dir = true;

        for (int i = 0; i < N-1; i++) {
            if(!visit[start_idx + arr[start_idx]]) {
                visit[start_idx + arr[start_idx]] = true;
                start_idx += arr[start_idx];
                sb.append(start_idx+1).append(" ");
                continue;
            }

            while(!visit[start_idx + arr[start_idx]]) {
                
            }
        }

        System.out.println(sb.toString());
    }
}
