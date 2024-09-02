
import java.util.*;
import java.io.*;

class Ex1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int k = 1; k <= 10; k++) {
                sb.append("#"+k+" ").append('\n');
        }
        System.out.println(sb);
    }

}

//public class Study_DFS_Recursion {
//
//    // 방문처리에 사용 할 배열선언
//    static boolean[] vistied = new boolean[9];
//
//    // 그림예시 그래프의 연결상태를 2차원 배열로 표현
//    // 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태라고 생각하시면됩니다.
//    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
//
//    public static void main(String[] args) {
//        dfs(1);
//    }
//
//    static void dfs(int nodeIndex) {
//        // 방문 처리
//        vistied[nodeIndex] = true;
//
//        // 방문 노드 출력
//        System.out.print(nodeIndex + " -> ");
//
//        // 방문한 노드에 인접한 노드 찾기
//        for (int node : graph[nodeIndex]) {
//            // 인접한 노드가 방문한 적이 없다면 DFS 수행
//            if(!vistied[node]) {
//                dfs(node);
//            }
//        }
//    }
//}


//public class Study_DFS_stack {
//
//    // 방문처리에 사용 할 배열선언
//    static boolean[] vistied = new boolean[9];
//
//    // 그림예시 그래프의 연결상태를 2차원 배열로 표현
//    // 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태라고 생각하시면됩니다.
//    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
//
//    // DFS 사용 할 스택
//    static Stack<Integer> stack = new Stack<>();
//
//    public static void main(String[] args) {
//
//        // 시작 노드를 스택에 넣어줍니다.
//        stack.push(1);
//        // 시작 노드 방문처리
//        vistied[1] = true;
//
//        // 스택이 비어있지 않으면 계속 반복
//        while(!stack.isEmpty()) {
//
//            // 스택에서 하나를 꺼냅니다.
//            int nodeIndex = stack.pop();
//
//            // 방문 노드 출력
//            System.out.print(nodeIndex + " -> ");
//
//            // 꺼낸 노드와 인접한 노드 찾기
//            for (int LinkedNode : graph[nodeIndex]) {
//                // 인접한 노드를 방문하지 않았을 경우에 스택에 넣고 방문처리
//                if(!vistied[LinkedNode]) {
//                    stack.push(LinkedNode);
//                    vistied[LinkedNode] = true;
//                }
//            }
//        }
//    }
//}
//https://heytech.tistory.com/55
//https://sunho-doing.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%83%90%EC%83%89-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-DFS-BFS
//https://sunho-doing.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%ED%83%90%EC%83%89-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-DFS-BFS

//import java.util.*;
//        import java.io.*;
//
//class Solution {
//    static int[][] list;
//    static boolean[] visit;
//    static boolean flag;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        for (int k = 1; k <= 10; k++) {
//            flag=false;
//            StringTokenizer st= new StringTokenizer(br.readLine());
//            int num= Integer.parseInt(st.nextToken());
//            int n= Integer.parseInt(st.nextToken());
//            list= new int[100][100];
//            visit= new boolean[100];
//            st= new StringTokenizer(br.readLine());
//            for(int i=0;i<n;i++){
//                list[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
//            }
//            dfs(0);
//            if (flag){
//                sb.append("#"+k+" 1").append('\n');
//            }
//            else
//                sb.append("#"+k+" 0").append('\n');
//        }
//        System.out.println(sb);
//    }
//    public static void dfs(int n){
//        if(!flag){
//            visit[n]=true;
//            for (int next=0;next<100;next++){
//                if (list[n][next] ==1 && !visit[next]) {
//                    dfs(next);
//                }
//            }
//            if(n==99){
//                flag=true;
//            }
//        }
//    }
//}