package codingtest;
import java.util.*;
import java.io.*;

public class P11478_서로다른부분문자열의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
				
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			for (int j = i + 1; j < S.length() + 1; j++) {
				map.put(S.substring(i, j), 1);
			}
		}
		System.out.println(map.size());
	}
}