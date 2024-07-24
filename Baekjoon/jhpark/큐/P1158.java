package 큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P1158 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k= scan.nextInt();

        StringBuilder sb= new StringBuilder();
        sb.append('<');

        Queue<Integer> queue= new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.add(i);
        }
        while (queue.size()!=0){

            for(int j=0;j<k-1;j++){
                queue.add(queue.poll());
            }
            int a=queue.poll();
            if( queue.size()!=0){
                sb.append(a+", ");
            }
            else {
                sb.append(a+">");
            }
        }
        System.out.println(sb);
    }
}
