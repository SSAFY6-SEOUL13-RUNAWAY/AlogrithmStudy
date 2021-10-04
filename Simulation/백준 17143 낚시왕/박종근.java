package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ17143낚시왕 {
	static int Answer, R, C, S;
	static Shark[][] Map;
	static LinkedList<Shark> SharksList;
	static StringTokenizer st;

	static public class Shark {
		int r;
		int c;
		int s; // 속도
		int d; // 방향
		int z; // 크기

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SharksList = new LinkedList<Shark>();
		Answer = 0;
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		Map = new Shark[R + 1][C + 1];

		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			Shark shark = new Shark(r, c, s, d, z);
			// 상어리스트에 상어 넣어
			SharksList.add(shark);
			// 맵에 반영
			Map[r][c] = shark;
		}

		// 이동
		for (int i = 1; i < R + 1; i++) {
			// 다잡아도 끝
			if (SharksList.isEmpty())
				break;

			// 잡아
			fish(i);

			// 상어 움직여
			Move();

		}

		System.out.println(Answer);
	}

	private static void Move() {
		// 하나씩 돌면서
		for (int i = 0; i < SharksList.size(); i++) {

			Shark shark = SharksList.get(i);
			int r = shark.r;
			int c = shark.c;
			int s = shark.s;
			int d = shark.d;
			int z = shark.z;

			if (s == 0)
				continue;

			Map[r][c] = null;
			// 상하
			if (d < 3) {
				while (s-- > 0) {
					if (d == 1) {
						r -= 1;
						if (r < 1) {
							r++;
							d = 2;
							s++;
						}
					}

					if (d == 2) {
						r += 1;
						if (r > R) {
							r--;
							d = 1;
							s++;
						}
					}
				}
			}

			// 좌우
			else {
				while (s-- > 0) {
					if (d == 3) {
						c += 1;
						if (c > C) {
							c--;
							d = 4;
							s++;
						}
					}

					if (d == 4) {
						c -= 1;
						if (c < 1) {
							c++;
							d = 3;
							s++;
						}
					}
				}
			}

			// 맵에 크기가 이미 나보다 크다면
			if (Map[r][c] != null && Map[r][c].z > z) {
				// 못들어가 잡아먹힘
				// 상어 리스트에서 나 지워 끝
				SharksList.remove(i);
				continue;
			}

			shark.r = r;
			shark.c = c;
			shark.s = s;
			shark.d = d;
			shark.z = z;
			
			Map[r][c] = shark;
		}

	}

	private static void fish(int c) {
		for (int i = 1; i < R + 1; i++) {
			if (Map[i][c] != null) {
				Answer += Map[i][c].z;
				SharksList.remove(Map[i][c]);
				break;
			}
		}

	}

	private static void printMap() {
		for (int i = 0; i < R + 1; i++) {
			for (int j = 0; j < C + 1; j++) {
				if (Map[i][j] == null)
					System.out.print("0 ");
				else
					System.out.print(Map[i][j].z + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
