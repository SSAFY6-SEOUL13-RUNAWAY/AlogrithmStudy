package BFS와DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class BJ2667단지번호붙이기 {
	static int N;
	static int[][] map;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int Count;
	static int APTCount;
	static TreeSet<Integer> APTList;
	static StringBuilder answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = new StringBuilder();

//		N = Integer.parseInt(br.readLine());
		Count = 0;
		map = new int[N][N];
		APTList = new TreeSet<>();

//		for (int i = 0; i < N; i++) {
//			String line = br.readLine();
//			for (int j = 0; j < N; j++) {
//				map[i][j] = line.charAt(j) - '0';
//			}
//		}

		// 로직
		// 주변을 다 탐색하기때문에 BFS를 사용해야한다.
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (map[i][j] == 1) {
//					APTCount = 0;
//					Count++;
//					dfs(i, j, Count + 1);
//					
//				}
//			}
//		}

		APTList.add(7);
		APTList.add(7);
		APTList.add(7);
		
//		answer.append(Count).append("\n");
		for (int i = 0; i < 3; i++) {
			System.out.println(APTList.pollFirst());
		}
	
//		int[] list = new int[Count];
//		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//					if(map[i][j] != 0) list[map[i][j]-2]++;
//			}
//		}
//		
//		Arrays.sort(list);
//		
//		for (int i = 0; i < list.length; i++) {
//			answer.append(list[i]).append("\n");
//		}
		
		System.out.println(answer);
	}

	private static void dfs(int r, int c, int group) {
		map[r][c] = group;
		APTCount++;
		// 자기 기준으로 사방 탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 나가지 않았고 1이라면
			if (!check(nr, nc))
				continue;

			if (map[nr][nc] == 1) {
				dfs(nr, nc, group);
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
