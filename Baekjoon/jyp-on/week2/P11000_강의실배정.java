package week2;

import java.util.*;
import java.io.*;

public class P11000_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            // 시작시간 오름차순 정렬, 시작시간 같다면 종료시간 오름차순 정렬
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new int[]{start, end});
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(pq.poll()[1]); // 끝나는 시간

        for (int i = 1; i < N; i++) {
            if(room.peek() <= pq.peek()[0]) {
                room.poll();
            }
            room.add(pq.poll()[1]);
        }

        System.out.println(room.size());
    }
}
