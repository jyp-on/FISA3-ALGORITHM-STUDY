
import java.util.LinkedList;
import java.util.Queue;

class P리코챗로봇 {
    static String[] board= {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
    static int[] x= {1,-1,0,0};
    static int[] y= {0,0,1,-1};
    static int endX;
    static int endY;
    static int startX;
    static int startY;
    static int[][] arr;

    public static void main(String[]args){
        arr= new int[board.length][board[1].length()];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                char a= board[i].charAt(j);
                if(a=='G'){
                    endX= i; endY=j;
                }
                else if(a=='R'){
                    startX= i; startY=j;
                }
                arr[i][j]=500;

            }
        }
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{startX,startY});
        arr[startX][startY]=0;
        boolean flag=false;
        while (!queue.isEmpty()&& !flag){
            int[] now=queue.poll();

            for(int k=0;k<x.length;k++){
                int newX= now[0];
                int newY= now[1];
                while (true) {
                    int nextX = newX + x[k];
                    int nextY = newY + y[k];

                    if (nextX < 0 || nextY < 0 || nextX >= board.length || nextY >= board[0].length() || board[nextX].charAt(nextY) == 'D') {
                        break;
                    }
                    newX = nextX;
                    newY = nextY;
                }

                if(board[newX].charAt(newY) =='G'){
                    arr[newX][newY]=arr[now[0]][now[1]]+1;
                    flag=true;
                    break;
                }
                else  {
                    if(arr[newX][newY] > arr[now[0]][now[1]]+1){
                        arr[newX][newY]=arr[now[0]][now[1]]+1;
                        if(arr[newX][newY]!=500){
                            queue.add(new int[]{newX,newY});
                        }
                    }
                }
            }
        }
        System.out.println( arr[endX][endY]==500 ? -1 : arr[endX][endY] );
    }
}