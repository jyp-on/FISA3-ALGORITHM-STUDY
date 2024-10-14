package 문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1012_유기농배추 {
    static int[] xArr = {0, 0, 1, -1};
    static int[] yArr = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];
            int[][] visited = new int[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[b][a] = 1;
            }

            int answer = 0;

            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {

                    if (arr[y][x] == 1) {
                        answer++;
                        arr[y][x] = 0;
                        Deque<int[]> deque = new LinkedList<>();
                        deque.push(new int[]{x, y});
                        while (!deque.isEmpty()) {
                            int[] tem = deque.pop();
                            int l = tem[0];
                            int r = tem[1];

                            for (int j = 0; j < xArr.length; j++) {
                                int newY = r + yArr[j];
                                int newX = l + xArr[j];
                                if (newX >= 0 && newY >= 0 && newY < n && newX < m && arr[newY][newX] == 1) {
                                    deque.add(new int[]{newX,newY });
                                    arr[newY][newX] = 0;
                                }
                            }
                        }

                    }
                }
            }
            System.out.println(answer);
        }
    }
}
