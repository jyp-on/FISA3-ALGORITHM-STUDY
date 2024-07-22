import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        
        br.close();

        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) list.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = 0;

        while (list.size() > 0) {
        	idx = (idx + cnt - 1) % list.size();
            sb.append(list.remove(idx)).append(", ");
        }

        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        bw.append(sb.toString());
        bw.close();
    }
}
