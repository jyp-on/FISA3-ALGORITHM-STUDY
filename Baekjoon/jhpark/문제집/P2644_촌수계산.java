package 문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P2644_촌수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        int[] visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            visited[i] = 9999;
        }

        deque.add(a);
        visited[a]=0;
        while (!deque.isEmpty()) {
            int tem = deque.pop();
//            System.out.println(tem);
            for (int i = 1; i <= n; i++) {

                if (arr[tem][i] == 1 && visited[tem] + 1 < visited[i]) {
                    deque.add(i);
                    visited[i] = visited[tem] + 1;
//                    System.out.println(i);
                }
            }
        }
        System.out.println(visited[b]==9999?-1:visited[b]);
    }
}
