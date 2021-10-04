package algoStudy1001;

import java.util.*;

public class Main_11047_조동균 {

	
	static int N, K;
	static int[] coins;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		coins = new int[N];
		
		for(int i=0; i<N; i++) {
			coins[i] = sc.nextInt();
		}
		int num = K;
		int cnt = 0;
		for(int i=N-1; i>=0; i--) {
			if(num/coins[i] > 0) {
				cnt += num/coins[i];
				num %= coins[i]; 
			}
		}
		System.out.println(cnt);
	}

}
