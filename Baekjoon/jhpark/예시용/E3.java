package 예시용;


import java.util.ArrayList;
import java.util.List;

class E3 {
    public static void main(String[] args) {
        List<List<Integer>> lists= new ArrayList<>();

        /*         0
         *     1    2    3
         *   4     5  6
         */
        for (int i=0;i<7;i++){
            lists.add(new ArrayList<>());
        }
        lists.get(0).add(1);
        lists.get(0).add(2);
        lists.get(0).add(3);

        lists.get(1).add(4);

        lists.get(2).add(5);
        lists.get(2).add(6);

        for (int i=0;i<7;i++){
            System.out.print(i + "의 노드의 자식은: ");
            for (int j=0;j<lists.get(i).size();j++){
                System.out.print(lists.get(i).get(j)+" ");
            }
            System.out.println();
        }
        int first=0;
        System.out.println("첫번째: "+ first);
        int second=lists.get(first).get(1);
        System.out.println("두번째: "+second);
        int third= lists.get(second).get(1);
        System.out.println("세번쨰: "+third);
    }
}
