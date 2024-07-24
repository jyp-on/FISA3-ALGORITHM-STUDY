class Solution
{
    public int solution(int [][]board)
    {
        int row_size = board.length;
        int col_size = board[0].length;
        int maxSquareSize = 0;
        
        // DP 배열 선언 및 초기화
        int[][] dp = new int[row_size][col_size];
        
        for(int i=0; i<row_size; i++) {
            for(int j=0; j<col_size; j++) {
                if(board[i][j] == 1) {
                    // 첫 행과 첫 열은 이전과 비교할 수 없으니 1로 초기화
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 위, 옆, 대각선 뒤 중 최솟값에 + 1
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                }
                maxSquareSize = Math.max(maxSquareSize, dp[i][j]);
            }
        }
        
        // 최대 정사각형의 크기 반환
        return maxSquareSize * maxSquareSize;
    }
}
