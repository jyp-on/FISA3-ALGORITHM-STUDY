
import java.util.*;

public class Twopointer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[M];
        Boolean checkA = false,checkB = false;
        for (int i = 0; i < N; i++) {
            A[i]=sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            B[i]=sc.nextInt();
        }
        int pointA = 0;
        int pointB = 0;
        while(true){
            if(A[pointA]>=B[pointB]){
                System.out.print(B[pointB]+" ");
                pointB++;
            }
            else{
                System.out.print(A[pointA]+" ");
                pointA++;
            }
            if(pointA==N){
                checkA=true;
                break;
            }
            if(pointB==M){
                checkB=true;
                break;
            }
        }
        if(checkA){
            for(int i = pointB;i<M;i++){
                System.out.print(B[i]+" ");
            }
        }
        if(checkB){
            for(int i = pointA;i<N;i++){
                System.out.print(A[i]+" ");
            }
        }
    }
}