package AlgoStudy1012;

import java.io.*;
import java.util.*;

public class Main_1654_랜선자르기 {


	static int K, N;
	static int[] lan;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		lan = new int[N];
		
		for(int i=0; i<N; i++) {
			lan[i] = Integer.parseInt(br.readLine());
		}
		
		// 전체 평균
		int tot = 0;
		for(int i=0; i<N; i++) {
			tot = Math.max(tot, lan[i]);
		}
		//// 입력 끝
		// 로직
//		tot = tot/2;
		
		int start = 1;
		int cnt = 0;
		int next = 0;
		int result = 0;
		while(true) {
			next = (tot-start)/2 + start;
			if(start == tot) next = start;
			cnt = calc(next);
			if(cnt >= K) {
				start = next+1;
				result = Math.max(next, result);
			} else if (cnt < K) {
				tot = next-1;
			}
			if(start > tot) break;
		}
		sb.append(result);
		System.out.println(sb.toString());
	}
	private static int calc(int next) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(cnt > K) return K+1;
			cnt += lan[i] / next;
		}
		return cnt;
	}

}

