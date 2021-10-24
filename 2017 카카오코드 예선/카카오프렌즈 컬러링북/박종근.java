import java.util.*;

class Solution {
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int[][] Map;
    static int R, C;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static class L {
        int r;
        int c;
        public L(int r,int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) { 
        Map = new int[m][n];
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                Map[r][c] = picture[r][c];
            }
        }
        
        R = m;
        C = n;
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(Map[r][c] > 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(bfs(r,c,Map[r][c]),maxSizeOfOneArea);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
        
    public int bfs(int r, int c, int start) {
        int size = 0;
        Queue<L> que = new LinkedList<L>();
        que.offer(new L(r,c));
        Map[r][c] = -1;
        while(!que.isEmpty()) {
            L l = que.poll();
            
            size++;
            for(int i = 0; i<4; i++) {
                int nr = l.r+dr[i];
                int nc = l.c+dc[i];
                
                if(!check(nr,nc,start)) continue;
                
                que.offer(new L(nr,nc));
                Map[nr][nc] = -1;
            }
        }
        return size;
    }
    
    public boolean check(int r, int c, int start) {
        return r >=0 && c>=0 && r<R && c<C && Map[r][c] != 0 && Map[r][c] == start;
    }
}