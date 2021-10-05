import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_서울_13반_박종근 {

	// 테스트케이스, 마을수, 경찰서 수, 둘레
	static int V, P;
	static long L, MinL;
	static StringTokenizer st;
	// 전체 마을 배열 , 경찰서만 있는 배열, 경찰서가 아닌 마을만 있는 배열
	static long[] VList, OnlyP, OnlyV, AnswerP;
	static boolean[] isV;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder Answer = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		
		VList = new long[V];
		isV = new boolean[V];
		OnlyV = new long[V - P];
		AnswerP = new long[P];
		OnlyP = new long[P];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < V; i++) {
			VList[i] = Integer.parseInt(st.nextToken());
		}
		
		// 전체 총 거리 저장 변수
		MinL = Long.MAX_VALUE;
		// 1. 조합으로 마을중 경찰서 5개를 뽑는다
		Comb(0, 0);

		Answer.append(MinL).append("\n");
		for (int i = 0; i < P; i++) {
			Answer.append(AnswerP[i]).append(" ");
		}
		Answer.setLength(Answer.length()-1);
		System.out.print(Answer);
	}

	private static void Comb(int start, int cnt) {
		// 뽑았으면
		if (cnt == P) {
			// 경찰서와 마을만을 분리해서 따로 담는다
			int PIdx = 0;
			int VIdx = 0;
			for (int i = 0; i < V; i++) {
				if (isV[i])
					OnlyP[PIdx++] = VList[i];
				else
					OnlyV[VIdx++] = VList[i];
			}

			// 마을만을 돌면서 총 거리 구하고 각 조합마다 저장된 거리보다작으면 갱신
			if(MinL > CalcL()) {
				MinL = CalcL();
				for (int i = 0; i < P; i++) {
					AnswerP[i] = OnlyP[i]; 
				}
			}
			return;
		}

		for (int i = start; i < V; i++) {
			isV[i] = true;
			Comb(i + 1, cnt + 1);
			isV[i] = false;
		}

	}

	// 모든 마을을 돌면서 가장 가까운 경찰서 거리합을 찾는다.
	private static Long CalcL() {
		Long L = 0L;
		// 모든 집을 돌면서
		for (int i = 0; i < OnlyV.length; i++) {
			// 왼쪽에 있는 경찰 거리와 오른쪽에 있는 경찰거리중 더 작은 값을 찾아 전부 더한다
			L += Math.min(findLP(OnlyV[i]), findRP(OnlyV[i]));
		}
		return L;
	}

	// 오른쪽 경찰서 찾기
	private static int findRP(long v) {
		// 이동 거리
		int round = 0;

		while (true) {
			++round;
			v = (v + 1) % L;
			for (int j = 0; j < OnlyP.length; j++) {
				// 오른쪽으로 이동 거리가 경찰서만 찾은겨
				if (OnlyP[j] == v) {
					return round;
				}
			}
		}
	}

	// 왼쪽 경찰서 찾기
	private static int findLP(long v) {
		int round = 0;

		while (true) {
			++round;
			v = (v + L - 1) % L;
			for (int j = 0; j < OnlyP.length; j++) {
				if (OnlyP[j] == v) {
					return round;
				}
			}
		}

	}

}
