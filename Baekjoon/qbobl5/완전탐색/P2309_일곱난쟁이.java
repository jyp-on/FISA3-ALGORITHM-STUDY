import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		/* 입력 변수 선언 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/* 9명 난쟁이들의 키 입력 */
		int size = 9;
		int[] dwarf = new int[size];
		int target = 0; // 난쟁이 9명 키의 전체 합
		
		for(int i=0; i<size; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			target += dwarf[i];
		}
		
		/* 가짜 난쟁이 2명의 키의 합 계산 */
		target -= 100;
		
		/* 가짜 난쟁이 2명 찾기 */
		int d1 = 0;
		int d2 = 0;
		
		Arrays.sort(dwarf); // 오름차순 정렬 (나중에 가짜 난쟁이의 인덱스를 받기 때문에 미리 정렬)
		
		for(int i=0; i<size-1; i++) {
			for(int j=i+1; j<size; j++) {
				if(dwarf[i] + dwarf[j] == target) {
					d1 = i;
					d2 = j;
					break;
				}
			}
		}
		
		/* 진짜 난쟁이 출력 */		
		for(int i=0; i<size; i++) {
			if(i == d1 || i == d2) continue;
			System.out.println(dwarf[i]);
		}
		
		br.close();
	}

}
