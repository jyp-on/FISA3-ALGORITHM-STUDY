import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class P1074_Z {
    static int n;
    static int r;
    static int c;
    static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        z(size, 0, 0);
    }

    static void z(int size, int x, int y) {
        if (size == 1) {

            System.out.println(num);
            return;
        }

        int newSize = size / 2;


        if (r < x + newSize && c < y + newSize) {
            z(newSize, x, y);
        }

        else if (r < x + newSize && c >= y + newSize) {
            num += newSize * newSize;
            z(newSize, x, y + newSize);
        }

        else if (r >= x + newSize && c < y + newSize) {
            num += 2 * newSize * newSize;
            z(newSize, x + newSize, y);
        }

        else {
            num += 3 * newSize * newSize;  // Skip cells in top-left, top-right, and bottom-left quadrants
            z(newSize, x + newSize, y + newSize);
        }
    }
}
