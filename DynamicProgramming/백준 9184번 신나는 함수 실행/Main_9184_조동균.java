package AlgoStudy0928;

import java.io.*;
import java.util.*;

public class Main_boj_9184_신나는_함수_실행 {

	
	static int[][][] map;
	static int a,b,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		map = new int[21][21][21];
		for(int i=0; i<21; i++) {
			for(int j=0; j<21; j++) {
				for(int k=0; k<21; k++) {
					if(i<= 0 || j <= 0 || k <= 0) map[i][j][k] = 1;
					else if(i > 20 || j > 20 || k > 20) map[i][j][k] = map[20][20][20];
					else if(i<j && j<k) {
						map[i][j][k] = map[i][j][k-1] + map[i][j-1][k-1] - map[i][j-1][k]; 
					} else {
						map[i][j][k] = map[i-1][j][k] + map[i-1][j-1][k] + map[i-1][j][k-1] - map[i-1][j-1][k-1]; 
					}
					
				}
			}
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1) break;
			sb.append("w("+a+", " +b+", "+c+") = ");
			if(a <= 0 || b <= 0 || c <= 0) sb.append(1);
			else if(a > 20 || b > 20 || c > 20 ) sb.append(map[20][20][20]);
			else sb.append(map[a][b][c]);
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
