import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] town;
    static boolean[][] check;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        town = new int[N][N];
        int height = 0;

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                town[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, town[i][j]);
            }
        }

        int result = 1;
        for(int h=1; h<=height; h++) {
            int cnt = 0;
            check = new boolean[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(town[i][j] > h && !check[i][j]) {
                        dfs(i, j, h);
                        cnt ++;
                    }
                }
            }
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }

    static void dfs(int r, int c, int h) {
        check[r][c] = true;

        for(int[] d : dir) {
            int newR = r + d[0];
            int newC = c + d[1];

            if(newR >= 0 && newC >= 0 && newR < N && newC < N) {
                if(town[newR][newC] > h && !check[newR][newC]) dfs(newR, newC, h);
            }
        }
    }
}
