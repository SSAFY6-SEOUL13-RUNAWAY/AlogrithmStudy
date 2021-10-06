package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2447별찍기10 {
	/*
	 * 분할정복 색종이가 떠올라서 그대로 풀어보면 될것같다.
	 */
	static int N;
	static char[][] Map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		Map = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Map[i][j] = '*';
			}
		}
		punch(0, 0, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer.append(Map[i][j]);
			}
			answer.append("\n");
		}
		System.out.print(answer);
	}

	private static void punch(int r, int c, int n) {
		
		// 망... 왜 제일 첫번째 재귀까지만 가지고 나머지는 안먹히는지모르곘다...
		if(n==1) return;
		
		// 내꺼중에 정가운데를 뚫는다.
		for (int i = r+ n/3; i < r+(n/3) * 2; i++) {
			for (int j = c+n/3; j < c+(n/3) * 2; j++) {
				Map[i][j] = ' ';
			}
		}
		
		
		int ThirdN = n / 3;
		// 가운데를 제외한 8군데의 영역에 재귀로 보낸다.
		
		punch(r, c, ThirdN);
		punch(r, c + ThirdN, ThirdN);
		punch(r, c + (ThirdN * 2), ThirdN);

		punch(r + ThirdN, c, ThirdN);
		punch(r + ThirdN, c + (ThirdN * 2), ThirdN);

		punch(r + (ThirdN * 2), c, ThirdN);
		punch(r + (ThirdN * 2), c + ThirdN, ThirdN);
		punch(r + (ThirdN * 2), c + (ThirdN * 2), ThirdN);
		
	}

}
