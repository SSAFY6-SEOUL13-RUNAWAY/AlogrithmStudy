package algoStudy1007;

import java.io.*;
import java.util.*;

public class Main_10816_숫자카드2 {

	static int N, M;
	static int[] map;
	static int[] search;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		String[] s = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(s[i]);
		}
		
		M = Integer.parseInt(br.readLine());
		search = new int[M];
		String[] c = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			search[i] = Integer.parseInt(c[i]);
		}
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			hm.put(map[i], hm.getOrDefault(map[i], 0)+1);
		}
		
		int[] answer = new int[M];
		for(int j=0; j<M; j++) {
			answer[j] = hm.getOrDefault(search[j], 0);
		}
		
		for(int num : answer) {
			sb.append(num).append(" ");
		}
		System.out.println(sb.toString());
	}
//	private static int binarySearch(int n) {
//		int index = map.length/2;
//		int half = map[index];
//		int front = 0;
//		int back = N-1;
//		
//		while(true) {
//			if(n >= half) {
//				front = index;
//				index = (back+front)/2;
//				half = map[index];
//			} else if(n < half) {
//				back = index-1;
//				index = (back+front)/2;
//				half = map[index];
//			} else if(half == n) {
//				map[index] = Integer.MAX_VALUE;
//				return 1;
//			}
//		}
//	}

}
