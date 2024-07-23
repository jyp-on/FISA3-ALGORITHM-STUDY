import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int rowLength; // game 의 행 길이
	static int colLength; // game 의 열 길이
	static int[][] game; // 보드게임판
	static int[] startNode; // 시작점
	static int[] endNode; // 끝점
	
	/* board 에 맞게 game 을 생성 */
	public static void madeGame(String[] board) {
		for (int i=0; i <rowLength; i++) {
			String[] sTmp = board[i].split("");
			for (int j=0; j <sTmp.length; j++) {
				if (sTmp[j].equals("D")) game[i][j] = 1;
				else {
					if (sTmp[j].equals("R")) {
						startNode[0] = i;
						startNode[1] = j;
					} else if (sTmp[j].equals("G")) {
						endNode[0] = i;
						endNode[1] = j;
					}
				}
			}
		}
	}
	
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
            int depth = current[2];

            if(r == endNode[0] && c == endNode[1]) return depth;

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
                    q.add(new int[]{newRow, newCol, depth + 1});
                    check[newRow][newCol] = true;
                }
            }
        }
		
		return -1;
	}

	public int solution(String[] board) {
		rowLength = board.length;
		colLength = board[0].length();
		
		game = new int[rowLength][colLength];
		startNode = new int[2];
		endNode = new int[2];
		
		madeGame(board);
		
		return bfs();
	}
}
