package 문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P2606_바이러스 {
    static int[][]net;
    static int computer;
    static  int number;
    static boolean[] visited;
    static int count;
    public static void main(String[]args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        computer= Integer.parseInt(br.readLine());
        number= Integer.parseInt(br.readLine());
        net= new int[computer+1][computer+1];
        visited= new boolean[computer+1];
        count=0;
        for(int i=0;i<number;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            net[a][b]=1;
            net[b][a]=1;
        }
        visited[1]=true;
        dfs(1);
        System.out.println(count);
    }
    static void dfs(int input){
        for(int i=1;i<=computer;i++){
            if(net[input][i]==1 && !visited[i]){
                visited[i]=true;
                count++;
                dfs(i);
            }
        }
    }
}
