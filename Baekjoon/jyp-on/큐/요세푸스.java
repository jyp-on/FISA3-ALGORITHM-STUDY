import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(!q.isEmpty()) {
            int polledItem = q.poll();
            cnt++;

            if(cnt == K) {
                sb.append(polledItem).append(", ");
                cnt = 0;
            }
            else q.offer(polledItem);
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());
    }
}
