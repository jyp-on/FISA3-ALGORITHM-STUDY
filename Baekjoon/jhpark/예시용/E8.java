package 예시용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class E8 {
    static int find=18;
    static int[][] arr;
    static int a;
    static int b;
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] s= br.readLine().split(" ");
        a=Integer.parseInt(s[0])+1;
        b=Integer.parseInt(s[1]);
        arr= new int[a][a];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i=0;i<b;i++){

            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
        }

        List<Integer> list= new ArrayList<>();
        list.add(1);

        dfs(1);
        dfsShow(1,list);
    }
    static void dfsShow(int n, List<Integer> list){
        if(n==find){
            System.out.println("찾았다"+ list);
            return;
        }
        else {
            for (int i = 0; i < a; i++) {
                if (arr[n][i]==1){
                    list.add(i);
                    dfsShow(i,list);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    static void dfs(int n){
        if(n==find){
            System.out.println("찾았다");
            return;
        }
        else {
            for (int i = 0; i < a; i++) {
                if (arr[n][i]==1){
                    dfs(i);
                }
            }
        }
    }
}


//20 19
//1 2 1 3 1 4 2 5 2 6 3 7 3 8 4 9 4 10 5 11 5 12 6 13 7 14 7 15 8 16 9 17 9 18 10 19 10 20


//        1
//        ├── 2
//        │   ├── 5
//        │   │   ├── 11
//        │   │   └── 12
//        │   └── 6
//        │       └── 13
//        ├── 3
//        │   ├── 7
//        │   │   ├── 14
//        │   │   └── 15
//        │   └── 8
//        │       └── 16
//        └── 4
//        ├── 9
//        │   ├── 17
//        │   └── 18
//        └── 10
//        ├── 19
//        └── 20
