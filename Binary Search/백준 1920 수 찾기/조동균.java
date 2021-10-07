package algoStudy1007;

import java.io.*;
import java.util.*;

public class Main_1920_수찾기 {

	static int N, M;
	static int nmap[];
	static int mmap[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nmap = new int[N];
		String[] s = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			nmap[i] = Integer.parseInt(s[i]);
		}
		
		M = Integer.parseInt(br.readLine());
		mmap = new int[M];
		String[] c = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			mmap[i] = Integer.parseInt(c[i]);
		}
		
		Arrays.sort(nmap);
				
		for(int j=0; j<mmap.length; j++) {
			System.out.println(Arrays.binarySearch(nmap, mmap[j]) >= 0 ? 1 : 0);
		}
	}

}
