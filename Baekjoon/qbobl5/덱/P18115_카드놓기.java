import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] card = br.readLine().split(" ");

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1, j=N-1; i<=N; i++, j--) {
            int num = Integer.parseInt(card[j]);

            if(num == 1) deque.addFirst(i);
            else if(num == 3) deque.addLast(i);
            else {
                if(deque.isEmpty()) deque.addFirst(i);
                else {
                    int first = deque.pollFirst();
                    deque.addFirst(i);
                    deque.addFirst(first);
                }
            }
        }

        while(!deque.isEmpty()) sb.append(deque.pollFirst()).append(" ");
        bw.append(sb.toString());
        bw.close();
        br.close();
    }
}
