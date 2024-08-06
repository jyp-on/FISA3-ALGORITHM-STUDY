import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class P4779_칸토어집합_배열 {
    static int n;
    static StringBuilder sb;
    static boolean[] booleans;
    public static void main(String[] args) throws  IOException,NumberFormatException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        String str;

//        while ((str = br.readLine()) != null || str.isEmpty()) {
        while (scanner.hasNextLine()){

            str=scanner.nextLine();
            if (str.isEmpty()) {

                break;
            }
            int n= Integer.parseInt(str);
            sb =new StringBuilder();
            int length = (int) Math.pow(3, n);
            booleans= new boolean[length];
            func(0, length);

            for (int i = 0; i < length; i++) {
                if(!booleans[i]){
                    sb.append("-");
                }
                else {
                    sb.append(" ");
                }
            }
            System.out.println(sb);

        }
    }

    public static void func(int start,int size) {
        if(size==1) {
            return;
        }
        int newSize=size/3;

        for(int i=start+newSize; i<start+2*newSize; i++) {
            booleans[i]=true;
        }
        func(start, newSize);
        func(start+2*newSize, newSize);
    }

}