import java.util.Scanner;

public class greedy_b11047_동전_1001 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int count = 0;
		int[] m = new int[N];
		for (int i = 0; i < N; i++) {
			m[i] = in.nextInt();
		}
		for (int i = N - 1; i >= 0; i--) {
			if (K / m[i] >= 1) {
				count += K / m[i];
				K = K % m[i];
			}
		}
		System.out.println(count);
		in.close();
	}
}
