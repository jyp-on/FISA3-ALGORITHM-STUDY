import java.io.*;
import java.util.Arrays;

public class Main {
	static int K; // 가지고 있는 랜선의 개수
	static long N; // 만들어야 하는 랜선의 개수
	static int[] arr; // 랜선 배열
	
	// 현재 사이즈로 랜선의 개수를 만족하는지 확인
	static boolean check(long size) {
		int cnt = 0;
		for(int i=0; i<K; i++) {
			cnt += (arr[i] / size);
			if(cnt >= N) return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		K = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		
		arr = new int[K];
		for(int i=0; i<K; i++) arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		long min = 1; // 랜선 최소 길이
		long max = arr[K-1]; // 랜선 최대 길이
		long size = 0;
		
		// binary search
		while(min <= max) { // 둘이 같아질때까지 반복
            long tmp = (min + max) / 2; // 둘의 중간
            if(check(tmp)) {
                size = tmp;
                min = tmp + 1;
            } else {
            	max = tmp - 1;
            }
        }

        System.out.println(size);
	}

}
