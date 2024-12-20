package 문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
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
        //촌을 입력받아 관계 설정
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        //bfs용 큐생성
        Deque<Integer> deque = new ArrayDeque<>();
        //각 인원마다 큰 값을 설정
        int[] visited = new int[n + 1];
        Arrays.fill(visited, 9999);
        //큐에 시작점을 추가하고 시작점의 촌수를 0으로 설정
        deque.add(a);
        visited[a] = 0;

        while (!deque.isEmpty()) {

            int tem = deque.pop();

            for (int i = 1; i <= n; i++) {
                //tem과 i가 관계가 맺어져 있고, 해당 값의 크기가 촌수+1보다 작을 때만 교체해줌(이는 visited 개념도 포함됨)
                if (arr[tem][i] == 1 && visited[tem] + 1 < visited[i]) {
                    deque.add(i);
                    
                    visited[i] = visited[tem] + 1;
                }
            }
        }
        System.out.println(visited[b] == 9999 ? -1 : visited[b]);
    }
}
