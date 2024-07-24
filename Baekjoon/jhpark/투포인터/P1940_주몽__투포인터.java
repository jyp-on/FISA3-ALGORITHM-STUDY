package 투포인터;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class P1940_주몽__투포인터 {
    public static void main(String[]args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int[] nList= new int[n];
        int count=0;
        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            nList[i]= Integer.parseInt(st.nextToken());
        }
        int end=nList.length-1;
        int start=0;
        Arrays.sort(nList);
        while(end>start){
            if((nList[start]+nList[end])==m){
                count++;
                end--;
                start++;
            }
            else if((nList[start]+nList[end])<m){
                start++;
            }
            else {
                end--;
            }
        }
        System.out.println(count);
    }
}
