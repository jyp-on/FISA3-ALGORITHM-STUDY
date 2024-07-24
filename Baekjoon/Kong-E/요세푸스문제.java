import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            dq.add(i + 1);
        }

        sb.append("<");
        int count = 1;
        while (!dq.isEmpty()) {
            if (count % K == 0) {
                int pop = dq.removeFirst();
                sb.append(pop);
                if (dq.isEmpty())  {
                    sb.append(">");
                } else {
                    sb.append(", ");
                }
            } else {
                int pop = dq.removeFirst();
                dq.addLast(pop);
            }
            count++;
        }

        System.out.println(sb);
    }
}
