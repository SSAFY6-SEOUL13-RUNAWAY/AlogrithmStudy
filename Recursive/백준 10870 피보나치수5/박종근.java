package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10870피보나치수5 {
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N==0) System.out.print(0);
		else if(N==1) System.out.print(1);
		else System.out.print(fibo(0,1,2));
		
	}

	private static int fibo(int f1, int f2 ,int n) {
		int f3 = f1+f2;
		if(n==N) return f3;
		return fibo(f2,f3,n+1);
	}

}
