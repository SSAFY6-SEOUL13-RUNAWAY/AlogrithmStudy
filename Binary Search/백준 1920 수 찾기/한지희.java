import java.util.Arrays;
import java.util.Scanner;

public class bs_b1920_수찾기_1008 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		int M = in.nextInt();
		for (int i = 0; i < M; i++) {
			int result = 0, low = 0, high = N - 1;
			int target = in.nextInt();
			while (low <= high) {
				int mid = (low + high) / 2;
				if (a[mid] == target) {
					result = 1;
					break;
				}
				if (a[mid] > target)
					high = mid - 1;
				else
					low = mid + 1;
			}
			System.out.println(result);
		}

		in.close();
	}
}
