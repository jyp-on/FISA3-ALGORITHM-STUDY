import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P1932_정수삼각형 {
    static int n;
    static StringTokenizer st;
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static int max;
    public static void main(String[] args) throws IOException {

        n= Integer.parseInt(br.readLine());


        func(1,0);
    }
    static void func(int k,int sum) throws IOException {
        if(k==n){
            max = (max < sum) ? sum : max;
        }
        else {
            st = new StringTokenizer(br.readLine());
            for (int i=0;i<k;i++){
                func(k+1,sum+Integer.parseInt(st.nextToken()));
            }
        }

    }
}
