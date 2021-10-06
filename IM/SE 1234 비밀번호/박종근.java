package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SE1234비밀번호 {
	static int N;
	static StringBuilder answer = new StringBuilder();;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {

			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			StringBuilder Password = new StringBuilder(input[1]);
			int i = 0;
			while (i < N - 1) {
				if (Password.charAt(i) == Password.charAt(i + 1)) {
					Password.delete(i, i + 2);
					if(i > 0) i--;
					N -= 2;
					continue;
				}
				i++;
			}		
			
			answer.append("#").append(t).append(" ").append(Password).append("\n");
		}
		
		System.out.println(answer);
	}
}
