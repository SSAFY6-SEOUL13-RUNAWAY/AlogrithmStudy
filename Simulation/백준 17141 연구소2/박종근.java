package BFS와DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ17141연구소2 {
	static int R, C, M;
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

	// 벽 배열
	static L[] Walls;

	static class L {
		int r;
		int c;

		public L(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = 0;
		Map = new int[R][C];
		TestMap = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				int temp = Integer.parseInt(st.nextToken());
				Map[i][j] = temp;
				if (temp == 0)
					ZeroList.offer(new L(i, j));
				else if (temp == 2)
					VirusList.offer(new L(i, j));

			}
		}
		
		ZeroCount = ZeroList.size();
		Walls = new L[3];
		Comb(0, 0);
		System.out.println(M);
	}

	private static void Comb(int start, int cnt) {
		if (cnt == 3) {
			// TestMap 초기화 및 벽세우기 , TestVirus 초기화
			setTestMap();
			// 크기 구하기
			M = Math.max(M, countSafeZone());
			return;
		}

		for (int i = start; i < ZeroList.size(); i++) {
			Walls[cnt] = ZeroList.get(i);
			Comb(i + 1, cnt + 1);
		}
	}

	private static int countSafeZone() {
		int testZero = ZeroCount-3;
		while (!TestVirusList.isEmpty()) {
			L virus = TestVirusList.poll();
			for (int i = 0; i < 4; i++) {
				int nr = virus.r + dr[i];
				int nc = virus.c + dc[i];

				// 나가지않고 0(벽이 아니고) 이고 2(가본곳이 아닌지)이 아닌지 확인
				if (!check(nr, nc))
					continue;

				TestVirusList.offer(new L(nr, nc));
				TestMap[nr][nc] = 2;
				if(--testZero < M) break;
			}
		}

		return testZero;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && TestMap[r][c] == 0 && TestMap[r][c] != 2;
	}

	private static void setTestMap() {
		// 테스트 맵 초기화
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				TestMap[i][j] = Map[i][j];
			}
		}

		// 벽세우기
		for (int i = 0; i < 3; i++) {
			L wall = Walls[i];
			TestMap[wall.r][wall.c] = 1;
		}
		
		// 테스트 바이러스 초기화
		for (int i = 0; i < VirusList.size(); i++) {
			TestVirusList.offer(VirusList.get(i));
		}
	}
}