package 문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1932_정수삼각형 {
    static int n;
    static int[][] arr;
    static int max;
    static int[] vs;
    static int abc=0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        arr= new int[n+1][n+1];
        vs= new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()) {
                arr[i][j++] = Integer.parseInt(st.nextToken());
            }
            //자기자신과 자기자신+1인 곳 갈 수 있음
        }
        for (int i = 0; i < n; i++) {
            max=Math.max(max,func(n-1,i));
        }
        System.out.println(max);
        System.out.println(abc);
    }

    static int func(int level,int index){
        abc++;
        if(level==0){
            return arr[0][0];
        }
        else if(index==0){
            return func(level-1,index)+arr[level][index];
        }
        else if(index==level-1){
            return func(level-1,index-1)+arr[level][index];
        }
        return Math.max(func(level-1,index-1)
                ,func(level-1,index))+arr[level][index];
    }
}
