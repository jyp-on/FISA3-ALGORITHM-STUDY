import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr1[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) arr2[i] = Integer.parseInt(st.nextToken());
        br.close();
        
        int idx1 = 0;
        int idx2 = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n+m; i++) {
            if(idx1 < n && idx2 < m) {
                int x = arr1[idx1];
                int y = arr2[idx2];
                if(x > y) {
                    sb.append(y + " ");
                    idx2 ++;
                } else {
                    sb.append(x + " ");
                    idx1 ++;
                }
            } else {
                if(idx1 >= n) {
                    sb.append(arr2[idx2]+" ");
                    idx2 ++;
                } else {
                    sb.append(arr1[idx1]+" ");
                    idx1 ++;
                }
            }
        }
        
        bw.write(sb.toString());
        bw.close();
	}

}
