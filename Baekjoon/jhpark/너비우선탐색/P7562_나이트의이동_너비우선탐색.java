package 너비우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P7562_나이트의이동_너비우선탐색 {
    static int[] move1= {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] move2= {1,-1,1,-1,2,-2,2,-2};
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static int[][] visited;
    static Queue<int[]> queue;

    public static void main(String[]args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){

            int m= Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());

            startX= Integer.parseInt(st.nextToken());
            startY= Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            endX= Integer.parseInt(st.nextToken());
            endY= Integer.parseInt(st.nextToken());
            visited= new int[m][m];

            int[] goal={endX,endY};
            int[]starts={startX,startY};

            queue= new LinkedList<>();

            queue.add(new int[]{startX,startY});

            for(int p=0;p< visited.length;p++){
                for(int q=0;q<visited[p].length;q++){
                    visited[p][q]=9999;
                }
            }
            visited[startX][startY]=0;

            while(!queue.isEmpty()){

                int[] sample=queue.poll();
                if(sample[0]==endX && sample[1]==endY ){
                    break;
                }

                for(int k=0;k<move2.length;k++){
                    int newX= sample[0]+move1[k];
                    int newY= sample[1]+move2[k];
                    if(newX>=0 &&newX<=m-1 && newY>=0 && newY<=m-1 && visited[sample[0]][sample[1]]+1 < visited[newX][newY]){
                        visited[newX][newY]= visited[sample[0]][sample[1]]+1;
                        queue.add(new int[]{newX,newY});
                    }
                }
            }
            sb.append(visited[endX][endY]).append('\n');
        }
        System.out.println(sb);

    }
}
