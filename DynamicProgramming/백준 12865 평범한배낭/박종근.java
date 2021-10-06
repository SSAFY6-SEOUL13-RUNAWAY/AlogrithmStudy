package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 담는 것의 수
		int N = Integer.parseInt(st.nextToken());
		// 최대 무게
		int W = Integer.parseInt(st.nextToken());
		
		// 무게 저장 배열 편의상 1부터 쓰기위해 N+1로 생성
		int[] weights = new int[N+1];
		// 가치 저장 배열 편의상 1부터 쓰기위해 N+1로 생성
		int[] profits = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산 표를 1 차원 배열로 변경
		int[] D = new int[W+1];
		
		
		for (int i = 1; i <= N; i++) {
			// 최대 무게부터 자신의 무게까지 거꾸로 확인
			// 즉 자기가 담길 수있는 상황만 본다
			for (int w = W; w >= weights[i]; w--) {
				// 해당 물건을 가방에 넣을 수 있다.
					D[w] = Math.max(D[w], profits[i]+D[w-weights[i]]);
			}
			// 나머지는  자신을 못담는 상황인데
			// 그대로 두면 자신을 담지않은 이전 상태에서 해당 무게의 최대 가치이기 때문에 변경하지않음.
		}
		
		System.out.println(D[W]);
	}

}
