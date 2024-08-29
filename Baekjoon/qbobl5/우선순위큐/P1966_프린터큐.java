import java.util.*;
import java.io.*;

class Node {
    int idx;
    int priority;

    public Node(int i, int p) {
        idx = i;
        priority = p;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        for(int t=0; t<test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Node> q = new LinkedList<>();

            for(int i=0; i<size; i++) {
                int priority = Integer.parseInt(st.nextToken());
                q.add(new Node(i, priority));
                pq.add(priority);
            }

            int order = 1;
            while(!q.isEmpty()) {
                int priority = pq.peek();
                if(q.peek().priority < priority) q.add(q.poll());
                else {
                    if(q.peek().idx == idx) {
                        sb.append(order).append("\n");
                        break;
                    } else {
                        pq.poll();
                        q.poll();
                        order ++;
                    }
                }
            }
        }

        bw.append(sb.toString());
        bw.close();
        br.close();
    }
}
