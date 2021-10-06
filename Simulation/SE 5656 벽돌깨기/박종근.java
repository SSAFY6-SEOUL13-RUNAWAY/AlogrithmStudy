package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5656_벽돌깨기 {
	static int T, N, R, C, MaxBreak, BreakCnt, WallCnt;
	static StringTokenizer st;
	static int[][] OriginMap, TestMap;
	static int[] DropBall;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class L {
		int r;
		int c;
		int d;

		public L(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder Answer = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			DropBall = new int[N];
			MaxBreak = Integer.MIN_VALUE;
			OriginMap = new int[R][C];
			TestMap = new int[R][C];
			WallCnt = 0;
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					OriginMap[i][j] = Integer.parseInt(st.nextToken());
					if(OriginMap[i][j] > 0) WallCnt++;
				}
			}

			// 중복순열
			Perm(0);
			Answer.append("#").append(t).append(" ").append(WallCnt - MaxBreak).append("\n");
		}
		System.out.println(Answer);
	}

	private static void Perm(int cnt) {
		if (cnt == N) {
			MaxBreak = Math.max(MaxBreak, Game());
			return;
		}

		for (int i = 0; i < C; i++) {
			DropBall[cnt] = i;
			Perm(cnt + 1);
		}
	}

	private static int Game() {
		setTestMap();
		BreakCnt = 0;

		for (int i = 0; i < N; i++) {
			drop(DropBall[i]);
			sortWall();
		}
		return BreakCnt;
	}


	private static void sortWall() {
		LinkedList<Integer> temp;
		// 한줄씩 확인
		for (int i = 0; i < C; i++) {
			temp = new LinkedList<>();
			
			for (int j = R-1; j >= 0; j--) {
				if(TestMap[j][i] > 0) {
					temp.offer(TestMap[j][i]);
				}
			}
			
			for (int j = R-1; j >= 0; j--) {
				TestMap[j][i] = 0;
			}
			
			for (int j = 0; j < temp.size(); j++) {
				TestMap[R-1-j][i] = temp.get(j);
			}
		}

	}

	private static void drop(int c) {
		for (int i = 0; i < R; i++) {
			if (TestMap[i][c] != 0) {
				breakBall(i, c);
				break;
			}
		}
	}

	private static void breakBall(int r, int c) {
		Queue<L> que = new LinkedList<L>();
		que.offer(new L(r, c, TestMap[r][c]));

		while (!que.isEmpty()) {
			L l = que.poll();
			TestMap[l.r][l.c] = -1;
			BreakCnt++;

			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < l.d; j++) {
					
					int nr = l.r + dr[i] * j;
					int nc = l.c + dc[i] * j;
					if (!check(nr, nc) || TestMap[nr][nc] <= 0)
						continue;

					que.offer(new L(nr, nc, TestMap[nr][nc]));
					TestMap[nr][nc] = -1;
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	private static void setTestMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				TestMap[i][j] = OriginMap[i][j];
			}
		}
	}
}
