package java35;

import java.util.Scanner;

public class BJ1904 {
	
	static int[] b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		b = new int[n + 2];
		b[1] = 1;
		b[2] = 2;
		
		System.out.println(calu(n));
	}
	
	public static int calu(int n) {
		if(b[n] != 0)
			return b[n];
				
		int temp = (calu(n - 1) + calu(n - 2)) % 15746;
		b[n] = temp;
		return b[n];
	}
}