package algoStudy1007;

import java.io.*;
import java.util.*;

public class Main_13305_주유소 {

	static int N;
	static long[] oil;
	static long[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		oil = new long[N];
		dist = new long[N - 1];
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int j = 0; j < dist.length; j++) {
			dist[j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			oil[i] = Integer.parseInt(st.nextToken());
		}
	
		long cost = 0;
		for (int i = 0; i < N - 1; i++) {
			if (visited[i])
				continue;
			else {
				int num = i;
				cost += oil[i] * dist[i];
				while (oil[++num] > oil[i]) {
					if(num >= N-1) break;
					cost += oil[i] * dist[num];
					visited[num] = true;
				}
				visited[i] = true;
			}
		}
		System.out.println(cost);
	}

}
