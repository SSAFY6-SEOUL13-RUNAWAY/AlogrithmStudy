package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11047_동전0 {
	static int N,K;
	static int[] Coin;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Coin = new int[N];
		
		for (int i = 0; i < N; i++) {
			Coin[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		
		while(true) {
			if(K == 0) break;
			
			// 코인 종류를 탐색하면서
			int MaxCoin = -1;
			for (int i = 0; i < N; i++) {
				// 현재 거스름돈을 넘지 않으면서 가장 큰 값인 코인을 찾는다
				if(Coin[i] > K) break; 
				MaxCoin = Math.max(MaxCoin, Coin[i]); 
			}
			
			K -= MaxCoin;
			ans++;
		}
		
		System.out.println(ans);
	}

}
