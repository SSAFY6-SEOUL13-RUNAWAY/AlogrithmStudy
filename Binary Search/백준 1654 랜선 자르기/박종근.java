package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654랜선자르기 {

	static int K,N;
	static long[] KList;
	static long L,Aver,Max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = 0;
		Aver = 0;
		Max = Long.MIN_VALUE;
		KList = new long[K];
		
		for (int i = 0; i < K; i++) {
			long input = Long.parseLong(br.readLine());
			KList[i] = input;
			L += input;
			if(Max < input) Max = input;
		}
		
		Aver = Max/N;
		
		// 1번쨰로 든 풀이법은 각 수를 모두 더한 후 N개로 나눠서 해당 수마다 나눈 값으로 몫을 구해서 N개 이상이면 스탑 당연히 시간초과~ 컷~ ㅋㅋㅋㅋ
		
		while(true) {
			if(!cut(++Aver,KList.clone())) break;
		}
		
		System.out.println(--Aver);
	}

	private static boolean cut(long average,long[] KList) {
		int m = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				if(KList[j] < average) continue;
				KList[j] -= average;
				m++;
			}
			if(m >= N) return true;
		}
		return false;
		
	}

}
