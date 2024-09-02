package week6;

import java.util.*;
import java.io.*;

class Child {
    char lt, rt;
    public Child(char lt, char rt) {
        this.lt = lt;
        this.rt = rt;
    }
}

public class P1991_트리순회 {
    static Map<Character, Child> tree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    static void preOrder(char root) {
        if(root == '.') return;
        Child child = tree.get(root);

        System.out.print(root);
        preOrder(child.lt);
        preOrder(child.rt);
    }

    static void inOrder(char root) {
        if(root == '.') return;
        Child child = tree.get(root);

        inOrder(child.lt);
        sb.append(root);
        inOrder(child.rt);
    }

    static void postOrder(char root) {
        if(root == '.') return;
        Child child = tree.get(root);

        postOrder(child.lt);
        postOrder(child.rt);
        sb.append(root);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char lt = st.nextToken().charAt(0);
            char rt = st.nextToken().charAt(0);
            tree.put(root, new Child(lt, rt));
        }

        preOrder('A');
        sb.append("\n");

        inOrder('A');
        sb.append("\n");

        postOrder('A');
        System.out.println(sb.toString());
    }
}
