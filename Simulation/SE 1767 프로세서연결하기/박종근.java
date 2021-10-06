package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWTEST1767프로세서연결하기 {
	static int T, N, Answer, L, C;
	static int[][] Map;
	static ArrayList<Core> CoreList;
	static boolean[] isChecked;
	// 상 하 좌 우
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Core {
		int r;
		int c;

		public Core(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine().trim());

		// 전체 테스트 케이스 반복
		for (int t = 1; t <= T; t++) {
			Answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine().trim());
			Map = new int[N][N];

			// 코어 전체가 저장될 리스트
			CoreList = new ArrayList<>();
			C = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int c = Integer.parseInt(st.nextToken());
					Map[i][j] = c;
					// 가장자리에 있지않으면서 코어(1)라면 리스트에 넣는다.
					if (c == 1 && i < N - 1 && j < N - 1 && i > 0 && j > 0) {
						CoreList.add(new Core(i, j));
					}
				}
			}

			isChecked = new boolean[CoreList.size()];
			// 코어 부분집합 전부 돌아가면서 테스트 해보기
			SubSet(0, CoreList.size());
			System.out.println("#"+t+" "+Answer);

		}

	}

	private static void SubSet(int cnt, int N) {
		if (cnt == N) {
			// 테스트 할 코어 리스트
			ArrayList<Core> TestCoreList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (isChecked[i])
					TestCoreList.add(CoreList.get(i));
			}
			L = 0;
			go(0, TestCoreList);
			return;
		}

		isChecked[cnt] = true;
		SubSet(cnt + 1, N);
		isChecked[cnt] = false;
		SubSet(cnt + 1, N);
	}

	private static void go(int index, ArrayList<Core> TestCoreList) {
		// 끝까지 성공
		if (index == TestCoreList.size()) {
			if (C < TestCoreList.size()) {
				Answer = L;
				C = index;
			}

			// 코어 테스트 수가 같다면 더 적은 경우를 정답으로 바꾼다.
			else if (C == index) {
				Answer = Math.min(Answer, L);
			}
			return;
		}

		Core c = TestCoreList.get(index);
		// 4방 탐색
		for (int i = 0; i < 4; i++) {
			if (isAvailable(c.r, c.c, i)) {
				setPath(c.r, c.c, i, 2);
				go(index + 1, TestCoreList);
				setPath(c.r, c.c, i, 0);
			}
		}
		// 해당 그룹에 있는 코어중  한번이라도 안되서 반복문을 나왔다면 실패
		return;
	}

	private static void setPath(int r, int c, int d, int fill) {

		int nr = r + dr[d];
		int nc = c + dc[d];

		if (!check(nr, nc))
			return;
		Map[nr][nc] = fill;
		if (fill == 2)
			L++;
	
		else if (fill == 0)
			L--;
		setPath(nr, nc, d, fill);
	}

	private static boolean isAvailable(int r, int c, int d) {

		int nr = r + dr[d];
		int nc = c + dc[d];
		// 계속 쭉 가서 맵을 나갔으면 연결성공
		if (!check(nr, nc))
			return true;

		// 1(코어가 막고있는경우)이거나 2(이미 전선의 경로)인경우 실패
		if (Map[nr][nc] == 1 || Map[nr][nc] == 2)
			return false;

		return isAvailable(nr, nc, d);

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}