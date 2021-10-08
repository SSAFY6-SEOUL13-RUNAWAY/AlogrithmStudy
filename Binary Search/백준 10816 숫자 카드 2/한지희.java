import java.util.Scanner;

public class bs_b10816_숫자카드2_1008 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = in.nextInt();
		int[] num = new int[20000001];
		for (int i = 0; i < N; i++) {
			num[in.nextInt() + 10000000]++;//-도 있으니깐~
		}
		int M = in.nextInt();
		for (int i = 0; i < M; i++) {
			sb.append((num[in.nextInt() + 10000000] + " "));
		}
		System.out.println(sb);
		in.close();
	}
}
