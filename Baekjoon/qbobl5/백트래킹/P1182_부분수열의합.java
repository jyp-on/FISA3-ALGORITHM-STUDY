import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int SUM;
    private static int[] arr;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        SUM = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        backTracking(0, 0, false);
        System.out.println(cnt);
    }

    private static void backTracking(int idx, int sum, boolean flag) {
        if(idx == N) {
            if(sum == SUM & flag) cnt ++;
            return;
        }

        backTracking(idx + 1, sum, flag);
        backTracking(idx + 1, sum + arr[idx], true);
    }
}
