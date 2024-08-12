import java.io.*;
import java.util.StringTokenizer;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static char[][] tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        
        tree = new char[26][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[node - 'A'][0] = left;
            tree[node - 'A'][1] = right;
        }
        
        preOrder('A');
        sb.append("\n");
        inOrder('A');
        sb.append("\n");
        postOrder('A');
        sb.append("\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void preOrder(char node) {
        if (node == '.') return;
        sb.append(node);
        preOrder(tree[node - 'A'][0]);
        preOrder(tree[node - 'A'][1]);
    }

    private static void inOrder(char node) {
        if (node == '.') return;
        inOrder(tree[node - 'A'][0]);
        sb.append(node);
        inOrder(tree[node - 'A'][1]);
    }

    private static void postOrder(char node) {
        if (node == '.') return;
        postOrder(tree[node - 'A'][0]);
        postOrder(tree[node - 'A'][1]);
        sb.append(node);
    }
}
