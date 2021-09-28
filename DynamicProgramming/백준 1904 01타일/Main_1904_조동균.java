package AlgoStudy0928;

import java.io.*;

public class Main_boj_1904_01타일 {

	
	static int N;
	static int[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[1000001];
		map[0] = 0;
		map[1] = 1;
		map[2] = 2;
		
		for(int i=3; i<=N; i++) {
			
			map[i] = map[i-1]%15746 + map[i-2]%15746;
			
		}
		
		System.out.println(map[N]%15746);
	}

}
