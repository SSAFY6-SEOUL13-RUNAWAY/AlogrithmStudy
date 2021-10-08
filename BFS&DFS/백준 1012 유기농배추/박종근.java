package BFS와DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ1012유기농배추 {
	static int R,C,T,N;
	static int[][] map;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int Count;
	static StringBuilder answer;
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			Count = 0;
			map = new int[R][C];
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = 0;
				}
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());			
				map[r][c] = 1;		
			}
			
			// 로직

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 1) {
						Count++;
						dfs(i, j, Count + 1);
					}
				}
			}
			answer.append(Count).append("\n");
		}
		System.out.print(answer);
	}
	private static void dfs(int r, int c, int group) {
		map[r][c] = group;
		
		// 자기 기준으로 사방 탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 나가지 않았고 1이라면
			if (!check(nr, nc)) continue;
			
			if(map[nr][nc] == 1) {
				dfs(nr,nc,group);
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

}
