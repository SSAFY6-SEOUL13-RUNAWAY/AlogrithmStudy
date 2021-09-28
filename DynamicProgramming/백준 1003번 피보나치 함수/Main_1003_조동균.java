package AlgoStudy0928;

import java.io.*;
import java.util.*;

public class Main_boj_1003_피보나치함수 {

	static int T;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		dp = new int[2][41];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int i=2; i<41; i++) {
			fibonacci(i);
		}
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(dp[0][N]).append(" ").append(dp[1][N]).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void fibonacci(int n) {
		dp[0][n] = dp[0][n-1] + dp[0][n-2];
		dp[1][n] = dp[1][n-1] + dp[1][n-2];
	}
}
