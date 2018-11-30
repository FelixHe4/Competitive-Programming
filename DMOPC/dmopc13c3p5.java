package Unit2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class dmopc13c3p5 {
	static int[][][] dp;
	static int maxM;
	static int maxF;
	static int R;

	public static void main(String[] args) throws IOException {
		maxM = readInt();
		maxF = readInt();
		R = readInt();
		dp = new int[R + 1][maxM + 1][maxF + 1];
		for (int i = 1; i <= R; i++) {
			int v1 = readInt();
			int t1 = readInt();
			int f1 = readInt();
			dynamic(dp, v1, t1, f1, i);
		}
		System.out.println(dp[R][maxM][maxF]);
	}

	public static void dynamic(int[][][] dp, int v, int t, int f, int r) {
		for (int i = 1; i <= maxM; i++) {
			for (int j = 1; j <= maxF; j++) {
				dp[r][i][j] = dp[r - 1][i][j];
				if (i >= t && j >= f) {
					dp[r][i][j] = Math.max(dp[r][i][j], v + dp[r - 1][i - t][j - f]);
				}
			}
		}
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