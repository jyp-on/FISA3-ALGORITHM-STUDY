import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P10025_백곰 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = 1000002;
        int maxSize = 0;
        int[] list = new int[max];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            list[x] = g;
        }
        if(k>=500000){
            for (int i = 0; i < max; i++) {
                maxSize += list[i];
            }
        }else{
            int start = 0;
            int end = 2 * k;
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += list[i];
            }
            maxSize = sum;
            while (end < (max - k)) {
                sum -= list[start++];
                sum += list[++end];

                if (sum > maxSize) {
                    maxSize = sum;
                }
            }
        }

        System.out.println(maxSize);
    }
}
