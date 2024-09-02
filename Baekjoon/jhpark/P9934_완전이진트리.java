import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class P9934_완전이진트리 {
    static  StringBuilder sb;
    static int k;
    static int[] arr;
    static int k2;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        sb= new StringBuilder();
        k2=(int)Math.pow(2,k)-1;
        arr= new int[k2+1];
//        System.out.println(k2);
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=1;i<=k2;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        func(1);
        System.out.println(sb);

    }
    static void func(int b){
        int a=k2;
        if(b==k){
            return;
        }
        else {
            for (int i=0;i<b;i++){
                a=a/2;
//                System.out.println(a);
            }

//            System.out.println(a);
            int c=a+1;
//            System.out.println(c);
            for (int i=0;i<b;i++){
//                System.out.println(c);
                sb.append(arr[c]);
//                System.out.println(arr[c]);
                c=c+a;
            }
            sb.append('\n');
            func(b+1);
        }

    }
}

//7
// 왼쪽가고

//164357

//