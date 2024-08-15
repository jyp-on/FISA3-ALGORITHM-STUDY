package codingtest;
import java.util.*;

public class P29813_최애의팀원 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		Queue<String> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			queue.add(sc.nextLine());
		};
		
		while(queue.size() > 1) {
			String arr[] = queue.peek().split(" ");
			// arr[0] : 이름, Integer.parseInt(arr[1]) : 학번
			int id = Integer.parseInt(arr[1]);
			queue.poll();
			for (int i = 0; i <id-1; i++) {
				queue.add(queue.poll());
			}
			queue.poll();
		}
		
		String arr[] = queue.peek().split(" ");
		System.out.println(arr[0]);
	}
};
