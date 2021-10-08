package BFS와DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ14502연구소 {
	static int R, C, V, T;
	// 시뮬레이션 시 사용될 맵
	static int[][] TestMap;
	// 표본 맵
	static int[][] Map;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	// 0 좌표값 리스트
	static LinkedList<L> ZeroList = new LinkedList<L>();
	static int ZeroCount;
	// 2 좌표값 리스트
	static LinkedList<L> VirusList = new LinkedList<L>();
	// 테스트시 사용될 바이러스 리스트
	static LinkedList<L> TestVirusList = new LinkedList<L>();
	static L[] Virus;

	static class L {
		int r;
		int c;
		int t;

		public L(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = R;
		V = Integer.parseInt(st.nextToken());
		T = Integer.MAX_VALUE;
		Map = new int[R][C];
		TestMap = new int[R][C];
		ZeroCount = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				int temp = Integer.parseInt(st.nextToken());
				Map[i][j] = temp;
				if (temp == 0)
					ZeroCount++;
				else if (temp == 2)
					VirusList.offer(new L(i, j, 1));
			}
		}
		Virus = new L[V];
		Comb(0, 0);
		System.out.println(T);
	}

	private static void Comb(int start, int cnt) {
		if (cnt == V) {
			// TestMap 초기화 및 벽세우기 , TestVirus 초기화
			setTestMap();
			// 크기 구하기
			T = Math.min(T, countSafeZone());
			return;
		}

		for (int i = start; i < VirusList.size(); i++) {
			Virus[cnt] = VirusList.get(i);
			Comb(i + 1, cnt + 1);
		}
	}

	private static int countSafeZone() {
		int testZero = ZeroCount + VirusList.size() - V;
		while (!TestVirusList.isEmpty()) {
			L virus = TestVirusList.poll();
			System.out.println("시간:" + virus.t + "남은 양" + testZero);

			if (testZero < 1) {
				for (int x = 0; x < R; x++) {
					for (int j = 0; j < C; j++) {
						System.out.print(TestMap[x][j]);
					}
					System.out.println();
				}
				System.out.println();
				System.out.println(virus.t);
				return virus.t;
			}

			for (int i = 0; i < 4; i++) {
				int nr = virus.r + dr[i];
				int nc = virus.c + dc[i];

				// 나가지않고 0(벽이 아니고) 이고 2(가본곳이 아닌지)이 아닌지 확인
				if (!check(nr, nc))
					continue;

				TestVirusList.offer(new L(nr, nc, virus.t + 1));
				TestMap[nr][nc] = 2;
				testZero--;
			}
		}
		return -1;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && TestMap[r][c] == 0 && TestMap[r][c] != 2;
	}

	private static void setTestMap() {
		// 테스트 맵 초기화
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (Map[i][j] == 2) {
					TestMap[i][j] = 0;
					continue;
				}
				TestMap[i][j] = Map[i][j];
			}
		}

		// 바이러스 넣기
		for (int i = 0; i < 3; i++) {
			L virus = Virus[i];
			TestMap[virus.r][virus.c] = 2;
		}
		
		TestVirusList.clear();
		// 테스트 바이러스 초기화
		for (int i = 0; i < V; i++) {
			TestVirusList.offer(Virus[i]);
		}

//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(TestMap[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
	}
}