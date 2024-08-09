import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class P10825_국영수 {
    public static void main(String[]args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());

        String[] str= new String[n];
        Integer[][] array= new Integer [n][3];

        for(int i=0;i<n;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            str[i]= st.nextToken();
            for(int j=0;j<3;j++){
                array[i][j]=Integer.parseInt(st.nextToken());
            }
            array[i][3]=i;
        }
        int[] a= new int[5];

        Arrays.sort(array, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {

                int result = o2[0].compareTo(o1[0]);
                if (result != 0) return result;

                result = o1[1].compareTo(o2[1]);
                if (result != 0) return result;

                result = o2[2].compareTo(o1[2]);
                if (result != 0) return result;

                return str[o1[3]].compareTo(str[o2[3]]);
            }
        });
        for(int i=0;i<n;i++){
            System.out.println(str[array[i][3]]);
        }
    }
}
