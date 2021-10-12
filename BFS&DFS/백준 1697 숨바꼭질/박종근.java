package BFS와DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1697숨바꼭질 {
	static int B = 100000;
	static boolean[] visited = new boolean[B+1];
	// 동생
	static int D;
	
	static class S {
		int m; // 수민 거리
		int s; // 걸린 초
		public S(int m, int s) {
			
			this.m = m;
			this.s = s;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		S firstS = new S(sc.nextInt(),0);
		D = sc.nextInt();
		
		Queue<S> q = new LinkedList<S>();
		
		q.offer(firstS);
		visited[firstS.m] = true;
		
		while(!q.isEmpty()) {
			// 하나 뽑고
			S s = q.poll();
			System.out.println("목표:"+D+" 나:"+s.m);
			// 동생과 같은지 확인
			if(s.m == D) {
				System.out.println(s.s);
				break;
			}
			
			// 아니면
			// 1. 앞으로 한칸
			if(s.m < B && !visited[s.m+1])  {
				q.offer(new S(s.m+1,s.s+1));
				visited[s.m+1] = true;
			}
			
			// 2. 뒤로한칸
			if(s.m > 0 && !visited[s.m-1]) {
				q.offer(new S(s.m-1,s.s+1));
				visited[s.m-1] = true;
			}
			
			// 3. 두배 이동
			if(s.m*2 <= B && !visited[s.m*2]) {
				q.offer(new S(s.m*2,s.s+1));
				visited[s.m*2] = true;
			}
		}
	}

}
