import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] counts = br.readLine().split(" ");
        int N = Integer.parseInt(counts[0]);
        int M = Integer.parseInt(counts[1]);
        
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	map.put(st.nextToken(), st.nextToken());
        }

        for(int i=0; i<M; i++) bw.append(map.get(br.readLine())).append("\n");
        bw.close();
	}

}
