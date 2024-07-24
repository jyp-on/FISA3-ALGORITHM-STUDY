import java.io.*;
import java.util.Arrays;

public class Main {
	final static int hbgCnt = 3; // 햄버거의 개수
	final static int drinkCnt = 2; // 음료의 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] hambugers = new int[hbgCnt];
        int[] drinks = new int[drinkCnt];
        
        for(int i=0; i<hbgCnt; i++) hambugers[i] = Integer.parseInt(br.readLine());
        for(int i=0; i<drinkCnt; i++) drinks[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(hambugers);
        Arrays.sort(drinks);
        
        /* 정렬된 배열에서 각각 가장 앞의 원소 덧셈 */
        System.out.println(hambugers[0] + drinks[0] - 50);
	}

}
