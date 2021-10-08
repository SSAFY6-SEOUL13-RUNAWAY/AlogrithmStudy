package BFS와DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17144미세먼지안녕 {

	static int R, C, T, P;
	static int[][] Room, Temp;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	// 공기 청정기 위, 아래 좌표값 저장
	static L MT, MB;

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
		T = Integer.parseInt(st.nextToken());
		P = 0;
		
		Room = new int[R][C];
		Temp = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				int t = Integer.parseInt(st.nextToken());
				Room[i][j] = t;
				if (t == -1) {
					MB = new L(i, 0);
					MT = new L(i - 1, 0);
				}
			}
		}

		// T초 진행
		for (int i = 0; i < T; i++) {
			// 미세먼지 확산
			diffusion();

			// 공기 회전
			airCleaningT();
			airCleaningB();
		}
		
		// 먼지 총합
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(Room[i][j] > 0) P += Room[i][j];
			}
		}
		System.out.println(P);

	}

	// 공기 청정기 아랫부분 순환
	private static void airCleaningB() {
		// 하 우 상 좌
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		// 방향
		int d = 0;

		// 시작은 항상 공기 청정기 아랫부분에서 1칸 아래(바뀌는 위치)
		int r = MB.r + 1;
		int c = MB.c;

		// 4 방향을 다 돌때까지 무한루프
		while (d < 4) {
			// 맵 밖으로 나갔니?
			int nr = r + dr[d];
			int nc = c + dc[d];

			// 나갔으면 방향 바꿔 
			if (!checkMB(nr, nc)) {
				d++;
				continue;
			}

			// 안나갔으면 나를 해당 진행 방향에 있는 애를 가져와서 내자리에 덮어씌운다.
			Room[r][c] = Room[nr][nc];
			r = nr;
			c = nc;
		}
		// 공기청정기 바로 우측에 새공기 0으로 채움
		Room[r][c] = 0;

	}

	// 공기 청정기 윗부분 순환
	private static void airCleaningT() {
		// 상 우 하 좌
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		// 방향
		int d = 0;

		// 시작은 항상 공기 청정기 윗부분에서 1칸 위(바뀌는 위치)
		int r = MT.r - 1;
		int c = MT.c;

		// 4 방향을 다 돌때까지 무한루프
		while (d < 4) {
			// 맵 밖으로 나갔니?
			int nr = r + dr[d];
			int nc = c + dc[d];

			// 나갔으면 방향 바꿔
			if (!checkMT(nr, nc)) {
				d++;
				continue;
			}

			// 안나갔으면 나를 해당 진행 방향에 있는 애를 가져와서 내자리에 덮어씌운다.
			Room[r][c] = Room[nr][nc];
			r = nr;
			c = nc;
		}
		// 공기청정기 바로 우측에 새공기 0으로 채움
		Room[r][c] = 0;

	}

	private static void diffusion() {
		// 탬프맵에 공기 확산 연산 저장
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 먼지가 있다면
				int m = Room[r][c];

				// 먼지가 5보다 작을 경우 0이 확산되기 때문에 의미가 없음
				if (m >= 5) {

					// 확산되는 먼지 양
					int dm = m / 5;
					// 사방탐색 후 사방에 뿌린다
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];

						// 범위 확인
						if (!check(nr, nc))
							continue;
						// 사방에 확산된 양만큼 증가
						Temp[nr][nc] += dm;
						// 나에게세 확산된 양만큼 감소
						Temp[r][c] -= dm;
					}
				}
			}
		}

		// 방에 먼지 변화 업데이트
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 먼지의 변화가 있다면
				if (Temp[r][c] != 0) {
					Room[r][c] += Temp[r][c];
					// 초기화
					Temp[r][c] = 0;
				}
			}
		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && Room[r][c] != -1;
	}

	private static boolean checkMT(int r, int c) {
		// r <= MT.r 같을 때가 왜 들어가야하는지 모르겠음
		return r >= 0 && r <= MT.r && c >= 0 && c < C && Room[r][c] != -1;
	}

	private static boolean checkMB(int r, int c) {
		return r >= MB.r && r < R && c >= 0 && c < C && Room[r][c] != -1;
	}
}
