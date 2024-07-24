import java.util.Arrays;
import java.util.Scanner;
//import java.util.Arrays;

public class seven_Dwarfs{
	public static void main(String[] args) {
		//1.난쟁이 키 입력
		Scanner sc = new Scanner(System.in);
		int num=9; int sum=0;
		int height[] = new int[num];
		for(int i=0; i<9; i++) {
			height[i] = sc.nextInt();
			sum+=height[i];
		}
		//System.out.println(Arrays.toString(height));
		
		//2.가짜 난쟁이 두 명 찾기
		int j=0;
		int fakeIndex_1=0, fakeIndex_2=0;
		for(int i=0; i<num-1; i++) {
			for(j=i+1; j<num; j++){
				if(sum - (height[i] + height[j])==100){
					fakeIndex_1 = i;
					fakeIndex_2 = j;
					break;
				}
			} break;
		}
		
		//3.가짜 난쟁이 인덱스 continue
		Arrays.sort(height);

		for(int i=0; i<num; i++){
			if(i==fakeIndex_1 || i==fakeIndex_2){
				continue;
			}
			System.out.println(height[i]);
		}
	}
}

//다른 아이디어 가짜 난쟁이 제거(arryList.remove) 후 정렬