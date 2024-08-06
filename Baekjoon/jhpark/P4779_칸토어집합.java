import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class P4779_칸토어집합 {
    static int n;
    static StringBuilder sb;
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            n = Integer.parseInt(str);
            sb =new StringBuilder();
            int len = (int) Math.pow(3, n);

            for (int i = 0; i < len; i++) {
                sb.append("-");
            }

            func(0, len);
            System.out.println(sb);

        }
    }

    public static void func(int start,int size) {
        if(size==1) {
            return;
        }
        int newSize=size/3;

        for(int i=start+newSize; i<start+2*newSize; i++) {
            sb.setCharAt(i, ' ');
        }

        func(start, newSize);
        func(start+2*newSize, newSize);
    }

}