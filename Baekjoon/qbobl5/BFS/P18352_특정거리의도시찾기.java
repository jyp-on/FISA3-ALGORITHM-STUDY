import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> map = new ArrayList<>();
        for(int i=0; i<=N; i++) map.add(new ArrayList<>());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.get(start).add(end);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(X);

        int[] cnt = new int[N + 1];
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int i : map.get(current)) {
                if(cnt[i] == 0 && i != X) {
                    cnt[i] = cnt[current] + 1;
                    queue.add(i);
                }
            }
        }

        for(int i=0; i<=N; i++) if(cnt[i] == K) sb.append(i).append("\n");
        if(sb.length() == 0) sb.append("-1");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
