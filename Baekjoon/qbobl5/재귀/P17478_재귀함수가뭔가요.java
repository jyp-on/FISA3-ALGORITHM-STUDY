import java.io.*;

public class Main {
    static final String[] str = {"\"재귀함수가 뭔가요?\"", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.", "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",};
    static final String[] last = {"\"재귀함수가 뭔가요?\"", "\"재귀함수는 자기 자신을 호출하는 함수라네\"", "라고 답변하였지."};
    static final String end = "라고 답변하였지.";
    static String repeat = "_";
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursion(0);

        bw.append(sb.toString());
        bw.close();
        br.close();
    }

    static void recursion(int cnt) {
        String r = repeat.repeat(cnt * 4);

        if(cnt == N) {
            for(String s:last) sb.append(r).append(s).append("\n");
            return;
        }

        for(String s:str) sb.append(r).append(s).append("\n");
        recursion(cnt + 1);
        sb.append(r).append(end).append("\n");
    }
}
