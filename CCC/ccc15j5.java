package Unit1;
import java.util.*;
public class ccc15j5 {
	static int[][] dp;

	// dynamic programming uses global array to store values
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		dp = new int[n + 1][k + 1];
		System.out.println(pie(n, k));
		scan.close();
	}

	public static int pie(int n, int k) {
		if (dp[n][k] != 0) {
			return dp[n][k];
		}
		if (n < k) {
			return 0;
		}
		else if (n == k || k == 1) {
			return 1;
		}
		else {
			dp[n][k] = (pie(n - k, k) + pie((n - 1), (k - 1)));
			return dp[n][k];
		}

	}
}
