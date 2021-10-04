package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1904_01타일 {

	static int N;
	static int[] Memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		// 배열 [N+1]로 만들면 왜 런타임에러나는지 아시는분? 
		Memo = new int[N+2];
		
		Memo[1] = 1;
		Memo[2] = 2;

		for (int i = 3; i <= N; i++) {
			Memo[i] = Memo[i - 2] + Memo[i - 1];
			
			if (Memo[i] >= 15746) {
				Memo[i] %= 15746;
			}
			
		}
		answer.append(Memo[N]);
		System.out.print(answer);
	}

}
