package Unit1;
import java.util.*;
import java.io.*;
public class ccc16s4 {

	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[] ai = new int[N];
		for (int i = 0; i < N; i++) {
			ai[i] = readInt();
		}
		int[][] dp = new int[N][N];
		int out = Integer.MIN_VALUE;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = i; j < N; j++) {
				if (i == j)
					dp[i][j] = ai[i];
				else {
					for (int i1 = i, i2 = j; i1 < i2;) {
						if (dp[i][i1] > dp[i2][j])
							i2--;
						else if (dp[i][i1] < dp[i2][j])
							i1++;
						else if (dp[i][i1] == dp[i2][j]) {
							if (dp[i][i1] == 0) {
								i2--;
								i1++;
							}
							else {
								if (i1 + 1 == i2)
									dp[i][j] = 2 * dp[i][i1];
								else if (dp[i1 + 1][i2 - 1] != 0)
									dp[i][j] = 2 * dp[i][i1] + dp[i1 + 1][i2 - 1];
								else {
									i2--;
									i1++;
								}
							}
						}
						else {
							i2--;
							i1++;
						}
						if (dp[i][j] != 0)
							break;
					}
				}
				out = Math.max(out, dp[i][j]);
			}
		}
		System.out.println(out);
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