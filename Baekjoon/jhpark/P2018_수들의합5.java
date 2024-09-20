import java.util.Scanner;

class P2018_수들의합5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int start=0;
        int end=0;
        int sum=0;
        int count=0;
        while (end<=n){
            if(sum<n){
                sum+=++end;
            }
            else if(sum==n){
                count++;
                sum-=start++;
                sum+=++end;
            }
            else{
                sum-=start++;
            }
        }
        System.out.println(count);
    }
}
