import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine()); // test case 개수
        StringBuilder sb = new StringBuilder();
        
        for(int t=0; t<test; t++) {
        	int N = Integer.parseInt(br.readLine()); // cloth 개수
        	Map<String, Integer> map = new HashMap<>(); // map
        	
        	for(int i=0; i<N; i++) {
        		String[] str = br.readLine().split(" ");
            	map.put(str[1], map.getOrDefault(str[1], 0) + 1); // key, value 삽입 (if key exist -> +1)
        	}
        	
        	int cnt = 1;
        	for(Integer value : map.values()) cnt *= (value + 1); // 조합 계산: 종류 별로 각 개수에 +1 을 해준 값을 모두 곱함
        	cnt --; // 아무것도 입지 않는 경우 제외
        	
        	sb.append(cnt).append("\n");
        }
        
        bw.append(sb.toString());
        bw.close();
        br.close();
	}

}
