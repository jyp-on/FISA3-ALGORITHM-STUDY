import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class BaekJoon11728 {
    static int[] array1;
    static int[] array2;
    public static void main(String[]args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        array1= new int[n];
        array2= new int[m];
        for(int i =0;i<n;i++){
            array1[i]=Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(br.readLine());
        for(int i =0;i<m;i++){
            array2[i]=Integer.parseInt(st.nextToken());
        }
        int p=0,q=0;
        while(p<n && q<m){
            if( array1[p]<=array2[q]){
                sb.append(array1[p++]).append(" ");
            }
            else{
                sb.append(array2[q++]).append(" ");
            }
        }
        if(p==n){
            for(int i=q;i<m;i++){
                sb.append(array2[i]).append(" ");
            }
        }
        else {
            for(int i=p;i<n;i++){
                sb.append(array1[i]).append(" ");
            }
        }
        System.out.println(sb);

    }

}
