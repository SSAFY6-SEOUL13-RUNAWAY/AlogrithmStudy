package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SE4615재미있는오셀로게임 {

	static int T, N, M, W, B;
	static int[][] map;
	static StringTokenizer st;
	static StringBuilder answer = new StringBuilder();
	// 상 하 좌 우 11시 1시 5시 7시
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, 1, -1 };
	static Queue<int[]> queue = new LinkedList<>();
	static Queue<int[]> TempQueue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			map[N / 2][N / 2] = 2;
			map[N / 2 - 1][N / 2 - 1] = 2;
			map[N / 2 - 1][N / 2] = 1;
			map[N / 2][N / 2 - 1] = 1;
			W = 2;
			B = 2;

			for (int i = 0; i < M; i++) {

				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int s = Integer.parseInt(st.nextToken());

				map[r][c] = s;
				if(s== 1) B++;
				else W++;

				// 8방 탐색
				for (int j = 0; j < 8; j++) {
					int size = 1;

					while (true) {
						int nr = r + dr[j] * size;
						int nc = c + dc[j] * size;
						// 맵밖으로 나갔다
						if (!check(nr, nc) || map[nr][nc] == 0) {
							// 맵을 나가면 나를 안만났기때문에 여태까지 이동한 큐는 날린다.안바꿈
							TempQueue.clear();
							break;
						}

						// 나를 찾았다
						if (map[nr][nc] == s) {
							// 여태까지 저장된 바뀌어야 하는 위치 전부 메인큐에 넣는다.
							while (!TempQueue.isEmpty()) {
								queue.offer(TempQueue.poll());
							}
							break;
						}

						TempQueue.offer(new int[] { nr, nc });
						size++;
					}
				}

				// 여기서 모든 큐 다 색바꿔
				while (!queue.isEmpty()) {
					int[] L = queue.poll();
					map[L[0]][L[1]] = s;
					// 내 카운트 늘려
					if (s == 1) {
						B += 1;
						W -= 1;
						continue;
					}
					else if(s == 2) {
						W += 1;
						B -= 1;
					}
				}
			}
			 answer.append("#").append(t).append(" ").append(B).append(" ").append(W).append("\n");

		}
		System.out.print(answer);
	}
	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
