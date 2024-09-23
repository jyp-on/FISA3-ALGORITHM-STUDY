package 예시용;


import java.lang.reflect.Array;
import java.util.Arrays;

class E5 {
    public static void main(String[] args) {
//        List<List<Integer>> lists= new ArrayList<>();

        int[][] arr= new int[7][7];
        /*         0
         *     1    2    3
         *   4     5  6
         */
        arr[0][1]=1; arr[0][2]=1; arr[0][3]=1;

        arr[1][4]=1;

        arr[2][5]=1; arr[2][6]=1;


        for (int i=0;i<7;i++){

            System.out.print(i + "의 노드의 자식은: ");

            for (int j = 0; j <arr[i].length ; j++) {
                if (arr[i][j]==1)
                    System.out.print(j+" ");
            }
            System.out.println();
        }
        for (int i=0;i<7;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
