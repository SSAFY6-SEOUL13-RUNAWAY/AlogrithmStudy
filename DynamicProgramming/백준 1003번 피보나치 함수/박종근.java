package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1003_피보나치함수 {
	
	static int N, T, Z, O;
	static int[][] Memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T  = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			
			Memo = new int[41][2];
			
			// 0 만드는 횟수 초기화
			Memo[0][0] = 1;
			Memo[0][1] = 0;
			
			// 1 만드는 횟수 초기화
			Memo[1][0] = 0;
			Memo[1][1] = 1;
			
			
					
			// 채우면서 표 완성
			for (int j = 2; j <= N; j++) {
				Memo[j][0] = Memo[j-2][0]+ Memo[j-1][0];
				Memo[j][1] = Memo[j-2][1]+ Memo[j-1][1];
				
			}

			System.out.println(Memo[N][0]+" "+Memo[N][1]);
			
		}

	}

}
