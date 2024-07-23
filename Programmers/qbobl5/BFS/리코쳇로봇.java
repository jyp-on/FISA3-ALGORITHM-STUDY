import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int rowLength; // game 의 행 길이
	static int colLength; // game 의 열 길이
	static int[][] game; // 보드게임판
	static int[] startNode; // 시작점
	static int[] endNode; // 끝점
	
	/* bfs 알고리즘 */
	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startNode[0], startNode[1], 0});
        boolean[][] check = new boolean[rowLength][colLength];
        check[startNode[0]][startNode[1]] = true;
		
		int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];

            if(r == endNode[0] && c == endNode[1]) return current[2];

            for(int[] dir : directions) {
                int newRow = r;
                int newCol = c;

                while(newRow >= 0 && newRow < rowLength && newCol >= 0 && newCol < colLength && game[newRow][newCol] == 0) {
                    newRow += dir[0];
                    newCol += dir[1];
                }

                newRow -= dir[0];
                newCol -= dir[1];

                if(!check[newRow][newCol]) {
                    q.add(new int[]{newRow, newCol, current[2] + 1});
                    check[newRow][newCol] = true;
                }
            }
        }
		
		return -1;
	}

	public int solution(String[] board) {
		rowLength = board.length;
		colLength = board[0].length();
        
		startNode = new int[2];
		endNode = new int[2];
        game = new int[rowLength][colLength];
		
		for (int i=0; i <rowLength; i++) {
			for (int j=0; j <colLength; j++) {
				if (board[i].charAt(j) == 'D') game[i][j] = 1;
				else {
					if (board[i].charAt(j) == 'R') {
						startNode[0] = i;
						startNode[1] = j;
					} else if (board[i].charAt(j) == 'G') {
						endNode[0] = i;
						endNode[1] = j;
					}
				}
			}
		}
		
		return bfs();
	}
}
