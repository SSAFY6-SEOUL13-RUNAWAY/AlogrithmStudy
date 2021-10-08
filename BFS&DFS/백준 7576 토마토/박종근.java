package BFS와DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576토마토 {
	static int N, M, D;
	static int[][] Box;
	static Queue<Tomato> CompleteTomatoQue; // 1
	// 우 하 상 좌
	static int[] dr = { 0, 1, -1, 0 };
	static int[] dc = { 1, 0, 0, -1 };
	static int cnt;
	
	static class Tomato {
		int r;
		int c;
		int d;

		public Tomato(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Box = new int[N][M];
		D = 0;
		cnt = 0;
		
		// 다익은 토마토 1
		CompleteTomatoQue = new LinkedList<>();
		
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				Box[i][j] = value;

				if (value == 1)
					CompleteTomatoQue.offer(new Tomato(i, j, 0));

				else if (value == 0)
					cnt++;
			}
		}

		// 익은 토마토를 전부 확인
		while (!CompleteTomatoQue.isEmpty()) {
			// 하나 뽑고
			Tomato t = CompleteTomatoQue.poll();
			// Day 변경
			D = t.d;
			
			// 사방에 안익은토마토(0)이 있는지 확인한다
			for (int i = 0; i < 4; i++) {
				int nr = t.r + dr[i];
				int nc = t.c + dc[i];
				if (!check(nr, nc))
					continue;
				// 있다면 그곳을 1로 바꾸고 익은 토마토 리스트에 해당 토마토를 넣는다
				Box[nr][nc] = 1;
				CompleteTomatoQue.offer(new Tomato(nr, nc, t.d + 1));
				// 그리고 안익은 토마토 큐에서 삭제
				cnt--;

			}

		}
			
		// 익은 토마토를 다 살펴보고 나왔는데  안 익은 토마토가 있다면 -1
		if (cnt != 0) D = -1;
		System.out.println(D);
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M && Box[r][c] == 0;
	}

}
