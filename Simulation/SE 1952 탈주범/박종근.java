package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SW1952탈주범 {
	static int N, M, R, C, L;
	static int[][] map;
	static int[][] visited; // int -> 거리나 시간을 저장할 때 사용
	static int T;
	static int cnt;
	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int[][] dd = { { 0 }, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 3 } };

	// bfs 인데 방향을 파이프 상황(dd)에 맞추어 델타(dr, dc)
	// 를 찾는 것이 관건

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder answer = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt = 0;
			bfs();
			counting();
			answer.append("#").append(t).append(" ").append(cnt).append("\n");

		}
		System.out.print(answer);
	}

	private static void counting() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] != 0 && visited[i][j] <= L)
					cnt++;
			}
		}

	}

	private static void bfs() {
		// r, c, d의 방향, 시간 que에 저장
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { R, C, map[R][C], 1 });
		visited[R][C] = 1;

		while (!que.isEmpty()) {
			int[] hole = que.poll();
			int r = hole[0];
			int c = hole[1];
			int h = hole[2];
			for (int i = 0; i < dd[h].length; i++) {
				int nr = r + dr[dd[h][i]];
				int nc = c + dc[dd[h][i]];

				if (!check(nr, nc))
					continue;

				for (int j = 0; j < dd[map[nr][nc]].length; j++) {
					int availableD;
					if (dd[h][i] > 1)
						availableD = dd[h][i] - 2;
					else
						availableD = dd[h][i] + 2;

					if (dd[map[nr][nc]][j] == availableD) {
						que.offer(new int[] { nr, nc, map[nr][nc], hole[3] + 1 });
						visited[nr][nc] = hole[3] + 1;
						break;
					}
				}

			}

		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M && visited[r][c] == 0 && map[r][c] != 0;
	}

}