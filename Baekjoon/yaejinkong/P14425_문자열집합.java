package codingtest;
import java.io.*;
import java.util.*;

public class P14425_문자열집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 0);
		}
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			}
		}
				
		int answer = 0;
		for (Integer value : map.values()) {
			answer += value;
		}
		
		System.out.println(answer);
	}
}
