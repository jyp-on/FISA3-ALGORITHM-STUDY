import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/**
	 * 각 문자의 필요한 개수를 충족하는지 체크
	 * @param check 현재 문자 개수 체크 배열
	 * @param nums 각 문자의 필요한 개수 배열
	 * @return 충족하면 true, 아니면 false
	 */
    static boolean chkNums(int[] check, int[] nums) {
        for(int i=0; i<4; i++) if(check[i] < nums[i]) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int S = Integer.parseInt(input[0]); // 총 문자열 길이
        int P = Integer.parseInt(input[1]); // 부분 문자열 길이

        String dnaStr = br.readLine(); // dna 문자열
        String[] input2 = br.readLine().split(" ");
        
        int[] nums = new int[4]; // 각 문자의 필요한 개수 배열
        nums[0] = Integer.parseInt(input2[0]); // a
        nums[1] = Integer.parseInt(input2[1]); // c
        nums[2] = Integer.parseInt(input2[2]); // g
        nums[3] = Integer.parseInt(input2[3]); // t

        int cnt = 0; // 만족하는 부분 문자열 개수
        int[] check = new int[4]; // 현재 문자 개수 체크 배열

        for(int i=0; i<P; i++) { // 첫 번째 부분 문자열
            char c = dnaStr.charAt(i);          
            if(c == 'A') check[0]++;
            else if(c == 'C') check[1]++;
            else if(c == 'G') check[2]++;
            else if(c == 'T') check[3]++;
        }

        if(chkNums(check, nums)) cnt ++; // 만족하면 cnt +1

        for (int i = P; i < S; i++) {
        	// 이전에 있었던 문자가 필요한 문자인 경우 해당 문자 -1
            char before = dnaStr.charAt(i - P);
            if(before == 'A') check[0]--;
            else if(before == 'C') check[1]--;
            else if(before == 'G') check[2]--;
            else if(before == 'T') check[3]--;

            // 다음에 올 문자가 필요한 문자인 경우 해당 문자 +1
            char after = dnaStr.charAt(i);
            if (after == 'A') check[0]++;
            else if (after == 'C') check[1]++;
            else if (after == 'G') check[2]++;
            else if (after == 'T') check[3]++;

            if(chkNums(check, nums)) cnt ++; // 만족하면 cnt +1
        }

        System.out.println(cnt);
    }
}
