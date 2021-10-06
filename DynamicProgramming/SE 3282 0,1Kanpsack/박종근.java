package DP;

import java.util.Scanner;

public class KnapsakcTest_2차원배열 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		for (int i = 1; i <=N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int[][] D = new int[N+1][W+1];
		
		for (int i = 1; i <=N; i++) {
			for (int w = 1; w <= W; w++) {
				// 해당 물건을 가방에 넣을 수 있다.
				if(weights[i] <= w) {
					
					D[i][w] = Math.max(D[i-1][w], profits[i] + D[i-1][w-weights[i]]);
				}
				// 해당 물건을 가방에 넣을 수 없다.
				else {
					// 최대가치는 해당 물건을 넣기 전 최대 가치 그대로 진행 
					D[i][w] = D[i-1][w];
				}
			}
		}
		
		System.out.println(D[N][W]);
	}

}
