import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        br.readLine();
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[st.countTokens()];
        
        for(int i=0; i<arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        
        int start = 0;
        int end = arr.length - 1;
        int cnt = 0;
        
        while(start < end) {
            int sum = arr[start] + arr[end];
            if(sum == n) {
            	cnt ++;
            	start ++;
            } else if(sum < n) start ++;
            else end --;
        }
        
        System.out.println(cnt);
	}

}
