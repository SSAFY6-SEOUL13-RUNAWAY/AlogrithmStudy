import java.util.Scanner;

public class greedy_b13305_주유소_1008 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		
		long[] dist = new long[N-1];
		long[] cost = new long[N];
		for (int i = 0; i < N-1; i++) {
			dist[i] = in.nextLong();
		}
		for (int i = 0; i < N; i++) {
			cost[i] = in.nextLong();
		}
		long total = 0;
		long min = cost[0];
		for (int i = 0; i < N-1; i++) {
			min = Math.min(min, cost[i]);
			total += (dist[i] * min);
		}
		System.out.println(total);
		
		in.close();
	}
}
