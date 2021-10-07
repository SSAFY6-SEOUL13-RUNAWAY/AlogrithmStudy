package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13305주유소 {
	static int N, End;
	static long[] Gap;
	static int[] Memo;
	static Town[] TownList;
	static long Cost;
	
	static class Town {
		int index;
		long oilPrice;

		public Town(int index, long oilPrice) {
			this.index = index;
			this.oilPrice = oilPrice;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Cost = 0L;
		N = Integer.parseInt(br.readLine());
		Gap = new long[N - 1];
		Memo = new int[N - 1];
		TownList = new Town[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N - 1; i++) {
			Gap[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		
		// 마지막 마을은 의미가 없기 때문에 N-1 까지만 한다
		for (int i = 0; i < N-1; i++) {
			long oilPrice = Long.parseLong(st.nextToken());
			// 타운에 넣고
			TownList[i] = new Town(i, oilPrice);
			if(i > 0) {
				if(TownList[Memo[i-1]].oilPrice > oilPrice) {
					Memo[i] = i;
				}
				else Memo[i] = Memo[i-1];
			}
		}
		
		End = N-2;
		while (true) {
			// 마지막인덱스가 0이면 끝
			if(End < 0) break;
			// 2. 최저가 오일값 * 거리를 정답에 더한다
			Cost += TownList[Memo[End]].oilPrice*getDistance(Memo[End]);
			// 마지막인덱스를 나머지 마을 값으로 바꿔준다.
			End = Memo[End]-1;
		}
		
		System.out.println(Cost);
	}

	private static long getDistance(int start) {
		long d = 0;
		for (int i = start; i <= End; i++) {
			d += Gap[i];
		}
		return d;
	}

}
