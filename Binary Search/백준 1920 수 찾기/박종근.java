package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920수찾기 {
	static int N, M;
	static long[] Search, From;
	static StringBuilder Answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Answer = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		From = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			From[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(From);

		M = Integer.parseInt(br.readLine());
		Search = new long[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			Search[i] = Long.parseLong(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int startIdx = 0;
			int endIdx = N - 1;
			long target = Search[i];
			int result = 0;
			while (startIdx <= endIdx) {
				// 중간위치
				int mid = (startIdx + endIdx) / 2;
				if (From[mid] == target) {
					// 찾았음.
					result = 1;
					break;
				} else if (From[mid] > target) {
					endIdx = mid-1;
				} else {
					startIdx = mid+1;
				}
			}
			Answer.append(result).append("\n");
		}
		System.out.println(Answer);
	}

//	private static boolean find(long target, int start, int end) {
//		if (end - start < 2) {
//			if (From[start] == target) {
//				return true;
//			}
//			return false;
//		}	
//		if(find(target, start, start + (end - start) / 2)) return true;
//		if(find(target, start + (end - start) / 2, end)) return true;
//		return false;
//	}

//	private static boolean find(long target, int start, int end) {
//		System.out.println("s:" + start + " e:" + end);
//		if (end - start == 1) {
//			if (From[start] != target) {
//				return false;
//			}
//		}
//
//		// 1.반절로 나누고 왼쪽을 찾아본다.
//		for (int i = start; i < start + (end - start) / 2; i++) {
//			if (From[i] == target) {
//				System.out.println(target);
//				return true;
//			}
//		}
//		if (find(target, start + (end - start) / 2, end))
//			return true;
//		else
//			return false;
//	}
}
