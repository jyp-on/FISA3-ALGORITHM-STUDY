import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder save = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder result = new StringBuilder();
            
            while(st.hasMoreTokens()) {
                StringBuilder word = new StringBuilder(st.nextToken());
                result.append(word.reverse().toString()).append(" ");
            }
            
            save.append(result).append("\n");
        }
        
        bw.write(save.toString());
        bw.close();
        br.close();
    }
}
