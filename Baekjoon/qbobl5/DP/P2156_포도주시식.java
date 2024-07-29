import java.io.*;

public class Main {
	
	static int dp(int n, int[] arr) {
		if(n == 1) return arr[0];
		else if(n == 2) return arr[0] + arr[1];
		
		int[] dp = new int[n];
		dp[0] = arr[0];
		dp[1] = arr[0] + arr[1];
		dp[2] = Math.max(arr[0] + arr[1], Math.max(arr[1] + arr[2], arr[0] + arr[2]));
		
		for(int i=3; i<n; i++) dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
		return dp[n-1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 포도주 개수
		int[] arr = new int[n]; // 각 포도주 양
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
		
		System.out.println(dp(n, arr));
	}

}
