package AlgoStudy1019;

import java.util.*;

public class Programmers_카카오프렌즈_컬러링북 {
	
	static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public static void main(String[] args) {
		int[][] picture = {
				{1, 1, 1, 0},
				{1, 1, 1, 0},
				{0, 0, 0, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 1}
		};
		int[] answer = solution(picture.length, picture[0].length, picture);
		System.out.println(Arrays.toString(answer));
	}
    
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        // visited 초기화
        visited = new boolean[m][n];
        
        // picture에 0 이상 값 찾기
        for(int i=0; i<picture.length; i++) {
            for(int j=0; j<picture[i].length; j++) {
                // 값이 0이상 visited == false이면 bfs 돌기
                if(picture[i][j] > 0 && visited[i][j] == false) {
                    numberOfArea++;
                    visited[i][j] = true;
                    int cnt = calArea(i, j, picture[i][j], picture);
                    System.out.println(cnt);
                    maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public static int calArea(int r, int c, int number, int[][] map) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {r, c});
        int cnt = 0;
        
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            // 한번에 몇개가 영역으로 구성되어있는지 확인하는 cnt;
            cnt++;
            int x = cur[0];
            int y = cur[1];
            
            for(int d=0; d<4; d++) {
                int nr = x + dr[d];
                int nc = y + dc[d];
                if(!(nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length)) continue;
                if(map[nr][nc] == number && visited[nr][nc] == false) {
                    que.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return cnt;
    }
}
