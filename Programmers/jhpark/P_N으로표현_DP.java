public class P_N으로표현_DP {
    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        int answer = solution(N, number);
        System.out.println(answer);
    }

    public static int solution(int N, int number) {
        String[] operation = new String[]{"+", "-", "*", "/", " "};

        int answer = 0;
        // 1,5,55
        int[][] dp = new int[number + 1][number + 1];


        return answer;
    }
}
