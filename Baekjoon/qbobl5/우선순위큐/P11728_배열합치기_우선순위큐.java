import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> pq = new PriorityQueue<>();
        
        br.readLine();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) pq.add(Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) pq.add(Integer.parseInt(st.nextToken()));
        br.close();
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll()+" ");
        }
        bw.write(sb.toString());
        bw.close();
	}

}
