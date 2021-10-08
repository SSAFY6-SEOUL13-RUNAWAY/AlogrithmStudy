package BFS와DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1707이분그래프 {

	static int K, V, E;
	static int[] Visited;
	static Node[] NodeList;
	static String Result;
	
	static class Node {
		// 연결된 노드
		ArrayList<Integer> linked;

		public Node() {
			linked = new ArrayList<Integer>();
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		K = Integer.parseInt(br.readLine());

		// 전체 테케
		for (int i = 0; i < K; i++) {
			Result = "YES";

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 노드의 개수
			V = Integer.parseInt(st.nextToken());
			// 간선의 개수
			E = Integer.parseInt(st.nextToken());

			// 노드 배열 생성
			NodeList = new Node[V + 1];

			// 초기화 주의
			for (int j = 0; j < NodeList.length; j++) {
				NodeList[j] = new Node();
			}

			// 1번 부터라서 N+1
			Visited = new int[V + 1];

			// 간선 수만큼 돌면서 연결 리스트 채우기
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				NodeList[start].linked.add(end);
				NodeList[end].linked.add(start);
			}

			// 노드 전체를 돌면서 확인
			for (int j = 1; j < V + 1; j++) {
				// 해당 노드를 방문한 적이 없다면
				if (Visited[j] == 0) {
					Visited[j] = 1;
					dfs(j);
					}
				}
			
			System.out.println(Arrays.toString(Visited));
			answer.append(Result).append("\n");
		}
		System.out.println(answer);
	}

	private static void dfs(int check) {
		// 내 자식을 돌면서 확인
		for (int i = 0; i < NodeList[check].linked.size(); i++) {
			int child = NodeList[check].linked.get(i);
			// 방문했으면
			if (Visited[child] != 0) {
//				// 색 확인 나랑 같으면 실패
				if (Visited[child] == Visited[check]) {
					Result = "NO";
					return; 
				}
			}
			// 안했으면 나랑 다른색으로 칠해
			else {
				if (Visited[check] == 1) {
					Visited[child] = 2;

				} else {
					Visited[child] = 1;
				}
				dfs(child);
			}
		}
	}

	private static boolean bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		// 제일 처음 노드는 1로 색칠
		Visited[start] = 1;

		while (!que.isEmpty()) {
			int check = que.poll();
			// 내 자식을 돌면서 확인
			for (int i = 0; i < NodeList[check].linked.size(); i++) {
				int child = NodeList[check].linked.get(i);
				// 방문했으면
				if (Visited[child] != 0) {
					// 색 확인 나랑 같으면 실패
					if (Visited[child] == Visited[check]) {
//						System.out.println("색이 같아서 실패");
						return true;
					}
				}
				// 안했으면 나랑 다른색으로 칠해
				else {
					if (Visited[check] == 1) {
						Visited[child] = 2;

					} else {
						Visited[child] = 1;

					}
					que.offer(child);
				}

			}
		}
		// 다 돌면 성공
		return false;
	}

}
