import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 표의 크기
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

        int[][] table = new int[N][N]; // 표
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) table[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][N+1];
        for(int i=1; i<=N; i++) for(int j=1; j<=N; j++) dp[i][j] = table[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int sum = dp[endX][endY] - dp[startX-1][endY] - dp[endX][startY-1] + dp[startX-1][startY-1];
            sb.append(sum).append("\n");
        }

        System.out.print(sb.toString());
    }
}
