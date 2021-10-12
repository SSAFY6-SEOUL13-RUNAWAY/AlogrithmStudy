import java.util.Arrays;
import java.util.Scanner;

public class s3_b1654_랜선자르기 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		int N = in.nextInt();
		int[] Lan = new int[K];
		for (int i = 0; i < K; i++) {
			Lan[i] = in.nextInt();
		}
		Arrays.sort(Lan);
		long left = 1;
		long right = Lan[K - 1];
		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for (int i = 0; i < K; i++) {
				sum += Lan[i] / mid;
			}
			if (sum >= N) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(right);

	}
}
