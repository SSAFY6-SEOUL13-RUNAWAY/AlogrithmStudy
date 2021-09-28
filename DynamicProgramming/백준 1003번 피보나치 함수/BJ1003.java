package java35;

import java.util.Scanner;

public class BJ1003 {
	
	static int Zero_n = 0;
	static int One_n = 0;
	static int[][] b;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			b = new int[n + 1][3];
			Zero_n = 0;
			One_n = 0;
			
			
			fib(n);
			System.out.println(b[n][1] + " " + b[n][2]);
		}
		
	}
	
	public static int[] fib(int n) {
		if(b[n][0] != 0)
			return b[n];
		
		if(n == 0) {
			b[n][0] = 0;
			b[n][1] = 1;
			b[n][2] = 0;
			return new int[] {0, 1, 0};
		}
		else if(n == 1) {
			b[n][0] = 1;
			b[n][1] = 0;
			b[n][2] = 1;
			return new int[] {1, 0, 1};
		}
		
		int[] temp1 = fib(n - 1);
		int[] temp2 = fib(n - 2);

		b[n][0] = temp1[0] + temp2[0];
		b[n][1] = temp1[1] + temp2[1];
		b[n][2] = temp1[2] + temp2[2];
		
		return b[n];
	}

}
