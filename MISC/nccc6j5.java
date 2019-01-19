package Unit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class nccc6j5 {
	static long count;
	static int[] arr;
	static long[][] dp;
	static int n;
	static ArrayList<Integer> a;
	private static final long MOD = 998244353;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		a = new ArrayList<Integer>();
		count = 1;
		arr = new int[1005];
		dp = new long[1005][1005];
		if (k == 1) {
			System.out.println(n);
			System.exit(0);
		}
		for (int i = 0; i < n; i++) {
			int z = Integer.parseInt(s[i]);
			arr[z]++;
		}
		dp[n + 1][0] = 1;
		dp(1);
//		for (int i = 0; i <= n; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		System.out.println(dp[1][k]);
	}

	public static void dp(int cur) {
		if (cur > n) {
			return;
		}
		dp(cur + 1);
		// with first cur fish, how much is your max value
		for (int i = 0; i <= n - cur; i++) {
			dp[cur][i] = dp[cur][i] + dp[cur + 1][i];
			// essentially, don't take the fish
			dp[cur][i] %= MOD;
			dp[cur][i + 1] = dp[cur][i + 1] + (arr[cur] * dp[cur + 1][i]) % MOD;
			// take the fish, what's your max value
			dp[cur + 1][i] %= MOD;
		}
		return;
	}

}
