package 문제집;

import java.util.Scanner;

class P15650 {
    static int n;
    static int m;
    static boolean[]visited;
//    static int[]arr;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n= scan.nextInt();;
        m= scan.nextInt();
//        visited = new boolean[n+1];
        int[] arr= new int[m+1];
        re(arr,0);
        System.out.println(sb);
    }
    static void re(int[]arr ,int level){
        if(level== m){
            for (int i=0;i<m;i++){
                sb.append(arr[i]).append(" ");

            }
            sb.append('\n');
        }
        else {
            for (int i=1;i<=n;i++){
                if(level==0){
                    arr[level]=i;
                    re(arr,level+1);
                }
                else if (arr[level-1]<i){

                    arr[level]=i;
                    re(arr,level+1);
                }
            }
        }
    }

}
