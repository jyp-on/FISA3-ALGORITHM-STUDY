package 예시용;


import java.util.ArrayList;
import java.util.List;

class E4 {
    public static void main(String[] args) {
//        List<List<Integer>> lists= new ArrayList<>();

        int[][] arr= new int[7][];
        /*         0
         *     1    2    3
         *   4     5  6
         */
        arr[0] = new int[3];
        arr[0][0]=1; arr[0][1]=2; arr[0][2]=3;

        arr[1] = new int[1];
        arr[1][0]=4;

        arr[2] = new int[2];
        arr[2][0]=5; arr[2][1]=6;

        arr[3] = new int[0];
        arr[4] = new int[0];
        arr[5] = new int[0];
        arr[6] = new int[0];

        for (int i=0;i<7;i++){
            System.out.print(i + "의 노드의 자식은: ");
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

//        for (int i=0;i<6;i++){
//            System.out.print(i + "의 노드들은: ");
//            for (Integer j : lists.get(i))
//                System.out.print(j+" ");
//            System.out.println();
//        }
    }
}
