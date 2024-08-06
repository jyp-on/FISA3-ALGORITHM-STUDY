import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    
    static void binary(int num, int idx) {
        if(num == 0) return;
        if(num % 2 == 1) sb.append(idx).append(" ");
        binary(num / 2, idx + 1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            binary(n, 0);
            sb.append("\n");
        }

        bw.append(sb.toString());
        bw.close();
        br.close();
    }
}
