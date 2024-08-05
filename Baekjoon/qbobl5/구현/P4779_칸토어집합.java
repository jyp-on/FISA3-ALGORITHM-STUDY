import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] arr = new String[13];
        arr[0] = "-";
        for(int i=1; i<13; i++) {
            arr[i] = "";
            arr[i] += arr[i-1];
            arr[i] += " ".repeat(arr[i-1].length());
            arr[i] += arr[i-1];
        }

        StringBuilder sb = new StringBuilder();
        while(true) {
            String s = br.readLine();
            if(s == null || s.isEmpty()) break;
            int n = Integer.parseInt(s);
            sb.append(arr[n]).append("\n");
        }
        bw.append(sb.toString());
        bw.close();
        br.close();
    }
}
