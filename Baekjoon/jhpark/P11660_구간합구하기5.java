import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class P11660_구간합구하기5 {
    public static void main(String[]args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int[][] arr= new int[n+1][n+1];
        int[][] prefixSum = new int[n+1][n+1];
        for (int i=1;i<=n;i++){
            st= new StringTokenizer(br.readLine());
            for (int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                prefixSum[i][j] = arr[i][j]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

            }
        }
        for(int i=0;i<m;i++){
            st= new StringTokenizer(br.readLine());
            int x1= Integer.parseInt(st.nextToken());
            int y1= Integer.parseInt(st.nextToken());
            int x2= Integer.parseInt(st.nextToken());
            int y2= Integer.parseInt(st.nextToken());


            int result = prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
            System.out.println(result);
//            int sx=x2-x1;
//            int sy=y2-y1;
//            int sum=0;
//            for(int y=0;y<sy+1;y++){
//                for(int x=0;x<sx+1;x++){
//                    sum+=arr[x1+x][y1+y];
//                };
//            }
//            System.out.println(sum);
        }
    }
}
