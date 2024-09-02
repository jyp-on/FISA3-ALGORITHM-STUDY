import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] chk;
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
			if(chk[i]) continue;
			chk[i] = true;
			nums[idx] = i;
			find(idx + 1);
			chk[i] = false;
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
        
        chk = new boolean[N + 1];
        nums = new int[M];
        
        find(0);
        bw.append(sb.toString());
        bw.close();
	}
}
