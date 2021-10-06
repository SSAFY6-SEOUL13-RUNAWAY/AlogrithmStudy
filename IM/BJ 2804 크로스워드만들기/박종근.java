package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2798블랙잭 {
	static int N, M;
	static int[] card;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		answer = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			;
		}
		comb(0, 0, 0);
		System.out.println(answer);
	}

	private static void comb(int cnt, int start, int sum) {
		if (cnt == 3) {
			if (sum <= M) {
				answer = Math.max(answer, sum);
			}
			return;
		}

		for (int i = start; i < N; i++) {
			comb(cnt + 1, i + 1, sum + card[i]);
		}
	}
}
