package 문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P1991_트리순회 {
    static int[][] arr;
    static int n;
    static  StringBuilder sb;
    public static void main(String[]args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        sb= new StringBuilder();
        n= Integer.parseInt(br.readLine());
        arr= new int[n+1][n+1];
        for(int i=0;i<n;i++){
            int k = 0;
            StringTokenizer st= new StringTokenizer(br.readLine());
            for (int j=0;j<3;j++){
                int c=st.nextToken().charAt(0)-'A'+1;
                if (j==0){
                    k=c;
                }
                if(c >0){
                    arr[k][j]=c;
                }

            }
        }
        prefix(1);
        System.out.println(sb);
        sb.setLength(0);
        infix(1);
        System.out.println(sb);
        sb.setLength(0);
        postfix(1);
        System.out.println(sb);

    }

    static void prefix(int i){
        if(arr[i][0]==0){
            return;
        }
        sb.append( (char)(arr[i][0]+'A'-1));

        prefix(arr[i][1]);
        prefix(arr[i][2]);
    }
    static void infix(int i){
        if(arr[i][0]==0){
            return;
        }
        infix(arr[i][1]);
        sb.append( (char)(arr[i][0]+'A'-1));
        infix(arr[i][2]);
    }
    static void postfix(int i){
        if(arr[i][0]==0){
            return;
        }
        postfix(arr[i][1]);
        postfix(arr[i][2]);
        sb.append( (char)(arr[i][0]+'A'-1));

    }

}
