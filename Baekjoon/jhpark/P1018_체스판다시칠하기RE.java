import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P1018_체스판다시칠하기RE {
    static int n;
    static int m;
    static boolean[][] arr;
    static int W;
    static int B;
    static int WMax=0;
    static int BMax=0;

    // b=0 w=1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = ch[j] == 'W';
            }
        }
        boolean bool=true;
        for (int i = 0; i < n-7; i++) {
            for (int j = 0; j < m-7; j++) {
                W=0;
                B=0;

                for (int k = i; k < i+8; k++) {
                    for (int l = j; l < j+8; l++) {
                        if (arr[k][l]==bool){
                            W++;

                        }
                        else {
                            B++;
                        }
                        bool=!bool;
                    }
                    bool=!bool;
                }
                WMax=Math.max(W,WMax);
                BMax=Math.max(B,BMax);
            }
        }
        System.out.println(64-Math.max(BMax,WMax));
    }
}


