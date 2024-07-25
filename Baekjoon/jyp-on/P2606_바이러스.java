import java.io.*;
import java.util.*;

public class P2606_바이러스 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        int t = Integer.parseInt(br.readLine());

        // 1번부터니까 n+1 개를 만들어야 함
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[1] = true;
        dfs(1);

        int ans = 0;
        for(int i=0; i<n+1; i++) {
            if(visited[i]) ans++;
        }
        System.out.println(ans-1);
    }

    static void dfs(int start) {
        for(int connected : graph.get(start)) {
            if(!visited[connected]) {
                visited[connected] = true;
                dfs(connected);
            }
        }
    }
}
