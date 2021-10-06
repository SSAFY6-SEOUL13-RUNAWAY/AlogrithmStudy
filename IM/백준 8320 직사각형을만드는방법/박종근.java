package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ8320직사각형을만드는방법 {
	static int N;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = 0;
		
		for (int i = 1; i <= 100; i++) {
			int I = i*i;
			if(I > N) {
				break;
			}
			int count = 0;
			while(true) {
				if(I+(count*i) > N) break;
				answer++;
				count++;
			}
		}
		System.out.println(answer);
	}

}
