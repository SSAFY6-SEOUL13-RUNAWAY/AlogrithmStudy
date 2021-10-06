package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2941크로아티아알파벳 {
	static String[] word = { "c=", "c-", "d-", "s=", "z=", "lj", "nj" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		int count = 0;

		for (int i = 0; i < line.length(); i++) {
			count++;
			System.out.println("i:"+i);
			if (i <= line.length() - 3 && line.substring(i, i + 3).equals("dz=")) {
				i += 2;
				continue;
			}
			
			if (i <= line.length() - 2 && findWord(line.substring(i, i + 2))) {
				i += 1;
				continue;
			}
		}
		System.out.println(count);
	}

	private static boolean findWord(String s) {
		for (int i = 0; i < word.length; i++) {
			if (s.equals(word[i])) {
				return true;
			}
		}
		return false;
	}
}