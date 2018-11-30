package Unit2;
import java.io.*;
import java.util.*;
public class Knapsack01 {

	public static void main(String[] args) throws IOException {
		int N = readInt(); // Weight
		int M = readInt(); // Items
		int[][] dp = new int[N + 1][M + 1];
		int[] v = new int[N + 1]; // Value of each item
		int[] w = new int[N + 1]; // Weight of each item
		for (int i = 0; i <= N; i++) {
			v[i] = readInt();
			w[i] = readInt();
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= w[i]) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
				}
			}
		}
		System.out.println(dp[N][M]);
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static float readFloat() throws IOException {
		return Float.parseFloat(next());
	}

	static boolean readBool() throws IOException {
		return Boolean.parseBoolean(next());
	}

	static short readShort() throws IOException {
		return Short.parseShort(next());
	}

	static byte readByte() throws IOException {
		return Byte.parseByte(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine();
	}

	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static void print(Object o) {
		pr.print(o);
	}

	static void println(Object o) {
		pr.println(o);
	}

	static void flush() {
		pr.flush();
	}

	static void println() {
		pr.println();
	}

	static void exit() throws IOException {
		br.close();
		pr.close();
		System.exit(0);
	}
}
