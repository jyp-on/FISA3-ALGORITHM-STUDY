package 문제집;

import java.util.Scanner;

class P10844_쉬운계단수 {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int n= scanner.nextInt();
        int x=1;
        int v=10;
        long count=9;
        long[] arr= new long[10];
        long ans=0;
        for (int i=0;i<9;i++){
            arr[i+1]=1;
        }
        while (n-x>0){
            long[] newArr= new long[10];
            for (int i=0;i<10;i++){
                if(i==0){
                    newArr[i]=arr[i+1];
                }
                else if(i ==9){
                    newArr[i]=arr[i-1];
                }
                else {
                    newArr[i]=arr[i-1]+arr[i+1];
                }
            }
            if(newArr[0]>1000000000){
                for (int j=0;j<10;j++){
                    newArr[j] %= 1000000000;
                }
            }
            arr=newArr;
            x++;
        }
        for (int i=0;i<10;i++){
            ans+=arr[i];
//            System.out.println(arr[i]);
            ans %= 1000000000;
        }
        System.out.println(ans);
    }
}
//0~9 10 *2 근데 0이랑 9는 1개만 있고 또 앞이 0일땐 불가
//  1~9  *2 but  9 때문에 -1 9    1
// 123456789
//  두 번째 0 ~ 8  *2 0때문에 -1 하고 *2 +1 17
// 0 11 22 33 44 55 66 77 88 9
// 10 12  21 23  32 34            76 78  87  89 98    17개 9, 0 1개씩  2
//  세 번째 1 ~ 9  여기서 9 한개만 존재
// 00 111 2222 3333 4444      7777 888 99
//네번째
// 000 1*6 2*7 3*8
// 101 121 123 210 212      789       898  989      61       16*2 +1  9 2개
// 3 6 7 8
//