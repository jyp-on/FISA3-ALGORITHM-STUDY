package 문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P1182_부분수열의합 {
    static int n;
    static int s;
    static int[]arr;
    static boolean[] visited;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        arr= new int[n];
        visited= new boolean[n];
        for(int i=0;i<n;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        func(0,0);
        System.out.println(count);
    }
    public static void func(int c,int sum){
        if(c==n){
            if(s==sum){
                int a=0;
                for(int i=0;i<n;i++){
                    if(!visited[i]){
                        a++;
                    }
                }
                if(a!=n){
                    count++;
                }
            }

        }
        else {
                func(c+1,sum);
                visited[c]=true;
                func(c+1,sum+arr[c]);

        }
    }
}
