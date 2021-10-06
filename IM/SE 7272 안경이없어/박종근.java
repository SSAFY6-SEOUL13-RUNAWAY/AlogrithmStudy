package IM;

import java.util.Scanner;

public class SE7272안경이없어 {
	static String S1;
	static String S2;
	static int T;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		StringBuilder answer = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			S1 = sc.next();
			S2 = sc.next();
			
			S1 = S1.replaceAll("[ADOPQR]", "1").replaceAll("[CEFGHIJKLMNSTUVWXYZ]", "0");
			
			S2 = S2.replaceAll("[ADOPQR]", "1").replaceAll("[CEFGHIJKLMNSTUVWXYZ]", "0");;

			String result = S1.equals(S2) ? "SAME" : "DIFF";
			answer.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(answer);
		

	}

}
