package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11399ATM {
	static int N;
	static int[] times;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		times = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(times);
		System.out.println(sum(0,0,0));
		

	}
	private static int sum(int i, int sum, int answer) {
		if(i == N) {
			return answer;
		}
		return sum(i+1, sum+times[i], answer+sum+times[i]);
	}

}
