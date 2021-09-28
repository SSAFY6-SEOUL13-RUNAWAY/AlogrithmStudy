package java35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9184 {
	
	static int[][][] bd = new int[101][101][101];
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] order = bf.readLine().split(" ");
			
			int a = Integer.parseInt(order[0]);
			int b = Integer.parseInt(order[1]);
			int c = Integer.parseInt(order[2]);
			
			if(a == -1 && b == -1 && c == -1)
				break;
			
			System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
		}
	}
	
	public static int w(int a, int b, int c) {
		if(bd[50 + a][50 + b][50 + c] != 0)
			return bd[50 + a][50 + b][50 + c];
		
		int temp;
		
		if(a <= 0 || b <= 0 || c <= 0)
			temp = 1;
		else if(a > 20 || b > 20 || c > 20)
			temp = w(20, 20, 20);
		else if(a < b && b < c)
			temp = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		else
			temp = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	
		bd[50 + a][50 + b][50 + c] = temp;
		return temp;
	}

}
