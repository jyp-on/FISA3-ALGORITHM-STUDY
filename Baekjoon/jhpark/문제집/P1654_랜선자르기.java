package 문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

class P1654_랜선자르기 {
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        long sum =0;
        int all=0;
        for(int i=0;i<list.size();i++){
            sum+= list.get(i);
        }

        long fin= sum / n;

        System.out.println(fin);
        List<Integer> list2= new ArrayList<>();
        if(n==k){
            System.out.println(list.get(list.size())-1);
        }
        else {
            for(int i=0;i<list.size();i++){

                long a= (long)Math.ceil(list.get(i)/(fin));
                System.out.println(a);
                if( a==0){
                    list2.add(list.get(i));
                }
                else {
                    long b= list.get(i)/a;
                    list2.add((int)b);
                }

                all+=a;
            }
            Collections.sort(list2,Collections.reverseOrder());
            System.out.println(list2.get(all-n-1));

        }


//
//
//       System.out.println(list.get(list.size() - 1));

    }
}

