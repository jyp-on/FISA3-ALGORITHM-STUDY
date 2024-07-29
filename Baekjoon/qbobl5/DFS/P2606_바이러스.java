import java.io.*;

public class Main {
	static int comCnt; // 컴퓨터 개수
	static int netCnt; // 네트워크 개수
	static boolean[][] networks; // 네트워크 배열
	static boolean[] check; // 체크용 배열
	
	static int dfs(int idx, int cnt) {
		for(int i=1; i<=comCnt; i++) {
			if(networks[idx][i] && !check[i]) {
				check[i] = true;
				cnt = dfs(i, cnt + 1);
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		comCnt = Integer.parseInt(br.readLine());
		netCnt = Integer.parseInt(br.readLine());
		networks = new boolean[comCnt + 1][comCnt + 1];
		check = new boolean[comCnt + 1];
		
		for(int i=0; i<netCnt; i++) {
			String[] num = br.readLine().split(" ");
			int x = Integer.parseInt(num[0]);
			int y = Integer.parseInt(num[1]);
			networks[x][y] = true;
			networks[y][x] = true;
		}
		
		check[1] = true;
		System.out.println(dfs(1, 0));
	}

}
