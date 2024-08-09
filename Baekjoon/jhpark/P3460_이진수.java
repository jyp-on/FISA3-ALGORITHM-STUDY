import java.util.Scanner;

class P3460_이진수 {
    static int[] ints;
    static StringBuilder sb;
    public static void main(String[]arg){
        Scanner scan = new Scanner(System.in);
        int n= scan.nextInt();;
        for (int i=0;i<n;i++){
            int t= scan.nextInt();
            sb= new StringBuilder();
            ints= new int[5];
            re(t);
            char[] ch=sb.toString().toCharArray();
            sb.delete(0,sb.length());
            for (int j=0;j<ch.length;j++){
                if(ch[j]=='1'){
                    sb.append(j).append(" ");
                }
            }
            System.out.println(sb);
        }
    }
    static void re(int t){
        if(t==1){
            sb.append(1);
            return;
        }
        else {
            int k=t%2;

            re(t/2);
            sb.append(k);
        }
    }
}


