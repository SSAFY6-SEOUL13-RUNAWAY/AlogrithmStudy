package IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2567색종이2 {
	static int N;
	static int R;
	static int C;
	static int Length;
	static boolean[][] checked;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Length = 0;
		checked = new boolean[100][100];

		for (int t = 0; t < N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = 90 - Integer.parseInt(st.nextToken());

			// 오른쪽으로 10칸 가면서 체크
			for (int i = 0; i < 10; i++) {
				if (!checked[R][C + i]) {
					Length++;
					checked[R][C + i] = true;
				}
			}
			C += 10;
			
			// 아래 9칸 가면서 체크
			for (int i = 0; i < 10; i++) {
				if (!checked[R + i][C]) {
					checked[R + i][C] = true;
					Length++;
				}
			}
			R += 10;

			// 왼쪽 8칸 가면서 체크
			for (int i = 0; i < 10; i++) {
				if (!checked[R][C - i]) {
					Length++;
					checked[R][C - i] = true;
				}
			}
			C -= 10;

			// 내 위치부터 위로 10칸 가면서 체크
			for (int i = 0; i < 10; i++) {
				if (!checked[R - i][C]) {
					Length++;
					checked[R - i][C] = true;
				}
			}
			R -= 10;

			// 가운데 공간 전부 채워주기
			for (int i = R; i < R + 10; i++) {
				for (int j = C; j < C + 10; j++) {
					checked[i][j] = true;
				}
			}
		}

		System.out.println(Length);
	}

}
