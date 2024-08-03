package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1074_Z {
    static int n, r, c, ans=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        conquer(0, 0, (int) Math.pow(2, n));
    }
    static void conquer(int row, int col, int size) {
        if(r == row && c == col) {
            System.out.println(ans);
            return;
        } else if(r < row + size && c < col + size &&
                  r >= row && c >= col) {
            // 찾으려는 열과 행이 4분면안에 있을 경우 각각 분할정복

            conquer(row, col, size / 2); // 왼쪽 위
            conquer(row, col + size / 2, size / 2); // 오른쪽 위
            conquer(row + size / 2, col, size / 2); // 왼쪽 아래
            conquer(row + size / 2, col + size / 2, size / 2); // 오른쪽 아래
        } else {
            // 해당 분면에 없는 경우 바로 넓이만큼 건너뜀
            ans += (size * size);
        }
    }
}
