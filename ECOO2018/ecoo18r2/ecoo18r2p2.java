package ecoo18r2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.text.*;
public class ecoo18r2p2 {

	static Queue<double[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\Users\\Dingding\\eclipse-workspace\\ecoo2018\\src\\ecoo18r2\\DATA2.txt"));
			DecimalFormat df = new DecimalFormat(".####");
			while (br.ready()) {// change to # test cases\
				int n = Integer.parseInt(br.readLine());
				int last = 0;
				for (int i = 0; i < n; i++) {
					String[] str = br.readLine().split(" ");
					last = Math.max(Integer.valueOf(str[0]), last);
					q.add(new double[] { Integer.parseInt(str[0]), Double.parseDouble(str[1]) });
				}
				double[] W = new double[n + 1000900];

				while (!q.isEmpty()) {
					double[] arr = q.poll();
					add(W, (int) arr[0], arr[1]);
				}
				double t = 0.0000;
				for (double d : W) {
					t += d;
				}
				String str = df.format(t);
				int zeros = str.length() - str.substring(0, str.indexOf(".")).length();
				System.out.print(str);
				if (zeros < 4) {
					for (int i = 0; i <= zeros; i++) {
						System.out.print("0");
					}
				}
				System.out.println();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found...");
		}
	}

	public static void add(double[] W, int d, double w) {
		if (W[d] != 0) {
			if (W[d] > w) {
				for (int i = d; i > 0; i--) {
					if (W[i] < w) {
						q.add(new double[] { i, W[i] });
						W[i] = w;
						break;
					}
				}
			}
			else {
				q.add(new double[] { d, W[d] });
				W[d] = w;
			}
		}
		else {
			W[d] = w;
		}
	}

	/*
	 * int N = readInt(); // Weight
	 * int M = readInt(); // Items
	 * int[][] dp = new int[N + 1][M + 1];
	 * int[] v = new int[N + 1]; // Value of each item
	 * int[] w = new int[N + 1]; // Weight of each item
	 * for (int i = 0; i <= N; i++) {
	 * v[i] = readInt();
	 * w[i] = readInt();
	 * }
	 * for (int i = 1; i <= N; i++) {
	 * for (int j = 0; j <= M; j++) {
	 * dp[i][j] = dp[i - 1][j];
	 * if (j >= w[i]) {
	 * dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
	 * }
	 * }
	 * }
	 * System.out.println(dp[N][M]);
	 */
}
