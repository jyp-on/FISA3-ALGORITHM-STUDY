import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] nums;
	static int N;
	static int M;
	static StringBuilder sb;
	
	private static void find(int idx) {
		if(idx == M) {
			for(int i:nums) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			nums[idx] = i;
			find(idx + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        br.close();
        
        nums = new int[M];
        
        find(0);
        bw.append(sb.toString());
        bw.close();
	}

}
