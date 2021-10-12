package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14719빗물 {

	static int R, C, Answer;
	static StringTokenizer st;
	static int[][] Map;
	static int[] Rain;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Answer = 0;

		Map = new int[R][C];
		Rain = new int[C];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			int n = Integer.parseInt(st.nextToken());
			Rain[i] = n;
			for (int j = R - 1; j > R - 1 - n; j--) {
				Map[j][i] = 1;
			}
		}

		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R - Rain[i]; j++) {
				down(0, i);
			}
		}
		System.out.println(Answer);
	}

	private static void down(int r, int c) {
		
		// 내려오다가 1이거나 밑에가 마지막 칸이면
		if (r == R-1 || Map[r+1][c] == 1) {
			// 양 옆을 확인한다 뚫혀있으면 true
			if (checkLeft(r, c) && checkRight(r, c)) {
				Answer++;
				Map[r][c] = 1;
			}
			return;
		}
		// 1. 내려갈수있으면 내려간다
		if (r < R && Map[r][c] == 0) {
			down(r + 1, c);
		}

	}

	private static boolean checkRight(int r, int c) {
		// 오른쪽
		for (int i = c + 1; i < C; i++) {
			// 하나라도 발견하면 종료
			if (Map[r][i] == 1) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkLeft(int r, int c) {
		// 왼쪽
		for (int i = c - 1; i >= 0; i--) {
			// 하나라도 발견하면 false;
			if (Map[r][i] == 1) {
				return true;
			}
		}
		// 다 갔으면 벽이없다 
		return false;
	}

}
