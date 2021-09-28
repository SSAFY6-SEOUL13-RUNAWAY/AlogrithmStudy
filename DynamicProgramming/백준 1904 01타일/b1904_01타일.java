
import java.util.Scanner;

public class b1904_01타일 {
	static int[] dp = new int[1000001];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
		}
		System.out.println(dp[N]);
		in.close();
	}
}
