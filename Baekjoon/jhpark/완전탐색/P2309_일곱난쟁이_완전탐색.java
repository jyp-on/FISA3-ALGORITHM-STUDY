import java.util.Arrays;
import java.util.Scanner;

class P2309_일곱난쟁이_완전탐색 {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int[] arr=new int[9];
        int sum=0;
        for(int i=0;i<9;i++){
            int n= scan.nextInt();
            arr[i]=n;
            sum+=n;

        }
        Arrays.sort(arr);
        for(int i=0;i<8;i++){
            int num=sum;
            for(int j=i+1;j<9;j++){
                if((num-(arr[i]+arr[j]))==100){
                    for(int k=0;k<9;k++){
                        if(k!=i && k!=j)
                            System.out.println(arr[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
