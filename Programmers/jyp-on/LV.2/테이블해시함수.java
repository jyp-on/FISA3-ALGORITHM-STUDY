import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int col_length = data[0].length;
        int answer = 0;
    
        // col 기준으로 오름차순 정렬 (col 값 같으면 first col 내림차순)
        Arrays.sort(data, (a, b) -> a[col-1] == b[col-1] ? b[0] - a[0] : a[col-1] - b[col-1]);
        
        for(int k=row_begin-1; k<row_end; k++) {
            int sum = 0;
            for(int i=0; i<col_length; i++) {
                // System.out.println(data[k][i] + " % " + (k+1));
                sum += (data[k][i] % (k+1));
            }
            answer = (answer ^ sum);
        }
        
        return answer;
    }
}
