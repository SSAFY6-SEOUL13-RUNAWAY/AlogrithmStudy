package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ18442_우체국2 {
	// 테이블을 이용해서 풀어봅니다.

	// 전체 마을 수
	static int N;
	// 우체국 수
	static int M;
	// 마을 둘레
	static long D;
	// 최소 거리(답)
	static long MinD;
	// 최소 거리를 저장하는 맵
	static long[][] Map;
	// 마을 저장 배열
	static long[] VList;
	// 우체국 인덱스 저장 배열
	static int[] AnswerMailIdxArr;

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder Answer = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Long.parseLong(st.nextToken());

		Map = new long[N][N];
		VList = new long[N];
		AnswerMailIdxArr = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			VList[i] = Long.parseLong(st.nextToken());
		}

		// 맵을 채운다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j || Map[i][j] != 0)
					continue;
				// 시계방향으로 가는 값하고 반시계방향으로 가는 값중 작은 값
				Map[i][j] = Math.min(Math.abs(VList[i] - VList[j]), D - Math.abs(VList[i] - VList[j]));

			}
		}
		
		MinD = Long.MAX_VALUE;
		Comb(0, 0, new int[M]);
		
		Answer.append(MinD).append("\n");
		for (int i = 0; i < M; i++) {
			Answer.append(VList[AnswerMailIdxArr[i]]).append(" ");
		}
		Answer.setLength(Answer.length()-1);
		System.out.print(Answer);
	}

	private static void Comb(int start, int cnt, int[] MailIdxArr) {
		if (cnt == M) {
			if (MinD > checkDistance(MailIdxArr)) {
				MinD = checkDistance(MailIdxArr);
				for (int i = 0; i < M; i++) {
					AnswerMailIdxArr[i] = MailIdxArr[i];
				}
			}
			return;
		}

		for (int i = start; i < N; i++) {
			MailIdxArr[cnt] = i;
			Comb(i + 1, cnt + 1, MailIdxArr);
		}

	}

	private static long checkDistance(int[] isMail) {
		long d = 0L;
		// 우체국이 아닌 집들의 인덱스 쭉 확인하면서
		// 우체국인 칸들중 가장 최소값을 더한다
		for (int r = 0; r < N; r++) {
			// 우체국이면 안본다 집만 보기 때문에
			if (checkHome(isMail, r)) continue;
			long min = Long.MAX_VALUE;
			for (int c = 0; c < M; c++) {
				min = Math.min(min, Map[r][isMail[c]]);
			}
			d += min;
		}
		return d;
	}

	private static boolean checkHome(int[] isMail, int r) {
		for (int i = 0; i < M; i++) {
			if (isMail[i] == r)
				return true;
		}
		return false;
	}

}
