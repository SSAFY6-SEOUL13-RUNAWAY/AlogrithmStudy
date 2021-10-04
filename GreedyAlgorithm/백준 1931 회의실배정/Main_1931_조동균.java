package algoStudy1001;

import java.util.*;

public class Main_1931_조동균 {

	static int N;
	static int[][] rooms;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		rooms = new int[N][2];
		
		for(int i=0; i<N; i++) {
			rooms[i] = new int[] {sc.nextInt(), sc.nextInt()};
		}
		// 끝나는 시간을 기준으로 정렬
		Arrays.sort(rooms, new Comparator<int[]>() {

			// 끝나는 시간이 같으면 시작시간을 기준으로 정렬시키기.
			// ex) 1 3, 5 5, 3 5
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] - o2[1] == 0) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		

		Queue<int[]> que = new LinkedList<int[]>();

		// 정렬된거 que에 넣기
		for(int i=0; i<N; i++) {
			que.add(rooms[i]);
		}

		
		int cnt = 1;
		int[] cur = que.poll();
		// 첫번째꺼 꺼내두고 que에서 다음꺼랑 비교하기
		while(!que.isEmpty()) {
			int[] next = que.poll();
			if(next[0] < cur[1]) continue;
			else {
				cur = next;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}
