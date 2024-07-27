import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        br.close();
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) queue.add(i);
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while(queue.size() > 1) {
            for(int i=1; i<cnt; i++) queue.add(queue.poll());
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");
        
        bw.write(sb.toString());
        bw.close();
	}

}
