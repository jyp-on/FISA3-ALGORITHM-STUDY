package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int K = sc.nextInt(); // 랜선의 개수
        int N = sc.nextInt(); // 필요한 랜선의 개수

        int[] lanLengths = new int[K];
        long maxLength = 0;

        for (int i = 0; i < K; i++) {
            lanLengths[i] = sc.nextInt();
            if (lanLengths[i] > maxLength) {
                maxLength = lanLengths[i]; // 최대 랜선 길이 초기화
            }
        }

        // 이진 탐색을 통해 최대 랜선 길이 찾기
        long result = binarySearch(lanLengths, N, maxLength);

        // 결과 출력
        System.out.println(result);
    }

    private static long binarySearch(int[] lanLengths, int N, long maxLength) {
        long start = 1;
        long end = maxLength;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (canMakeLans(lanLengths, N, mid)) {
                result = mid; // 가능한 최대 길이 저장
                start = mid + 1; // 더 긴 길이 탐색
            } else {
                end = mid - 1; // 더 짧은 길이 탐색
            }
        }

        return result;
    }

    // 주어진 길이로 N개의 랜선을 만들 수 있는지 체크
    private static boolean canMakeLans(int[] lanLengths, int N, long length) {
        long count = 0;

        for (int lan : lanLengths) {
            count += lan / length; // 각 랜선을 잘라 만들 수 있는 개수 누적
        }

        return count >= N; // N개 이상 만들 수 있으면 true
    }
}
