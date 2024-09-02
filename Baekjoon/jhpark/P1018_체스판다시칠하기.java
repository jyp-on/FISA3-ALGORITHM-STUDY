import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P1018_체스판다시칠하기 {
    static int n;
    static int m;
    static boolean[][]arr;
    static int one;
    static int one2;
    static int two;
    static int two2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m=  Integer.parseInt(st.nextToken());
        System.out.println(n+ " "+m);
        arr= new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = ch[j]== 'W';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        func();
        func2();
        System.out.println(Math.min(Math.abs(one - one2), Math.abs(two - two2)));
    }
    static void func() {
        boolean b=true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b=!b;
                if (arr[i][j]== b) {
                    if (b){
                        one++;
                    }
                    else{
                        one2++;
                    }
                }
            }
            if(m%2==0){
                b=!b;
            }
        }
    }
    static void func2() {
        boolean b=false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b=!b;
                if (arr[i][j]== b) {
                    if (b){
                        two++;
                    }
                    else{
                        two2++;
                    }
                }
            }
            if(m%2==0){
                b=!b;
            }
        }
    }
}
