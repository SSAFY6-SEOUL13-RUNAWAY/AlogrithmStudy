package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9184_신나는함수실행 {

	static int[][][] Memo;
	static int A, B, C;
	static StringBuilder answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = new StringBuilder();

		Memo = new int[101][101][101];
		// 0 이하 먼저 다 1 로 채우고
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				for (int k = 0; k <= 100; k++) {
					if (i <= 50 || j <= 50 || k <= 50)
						Memo[i][j][k] = 1;
					else if (i > 70 || j > 70 || k > 70)
						Memo[i][j][k] = Memo[70][70][70];
					else {
						if (i < j && j < k) {
							Memo[i][j][k] = Memo[i][j][k - 1] + Memo[i][j - 1][k - 1] - Memo[i][j - 1][k];
						}

						else {
							Memo[i][j][k] = Memo[i - 1][j][k] + Memo[i - 1][j - 1][k] + Memo[i - 1][j][k - 1]
									- Memo[i - 1][j - 1][k - 1];
						}
					}
				}
			}
		}

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			A = Integer.parseInt(st.nextToken()) + 50;
			B = Integer.parseInt(st.nextToken()) + 50;
			C = Integer.parseInt(st.nextToken()) + 50;
			
			if (A == 49 && B == 49 && C == 49)
				break;
			answer.append("w(").append(A-50).append(", ").append(B-50).append(", ").append(C-50).append(") = ").append(Memo[A][B][C]).append("\n");

		}
		System.out.println(answer);
	}
}
