import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//16004	164
public class b1003_피보나치함수_dp1 {
	static int[] dp = new int[41];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp[0] = 0;
		dp[1] = 1;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			fibo(N);
			if (N == 0)
				System.out.println(1 + " " + 0);
			else if (N == 1)
				System.out.println(0 + " " + 1);
			else
				System.out.println(dp[N - 1] + " " + dp[N]);
		}
		br.close();
	}

	public static int fibo(int N) {
		if (N <= 1 || dp[N] != 0)
			return dp[N];
		else
			return dp[N] = fibo(N - 1) + fibo(N - 2);
	}
}
