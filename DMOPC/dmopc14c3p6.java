package Unit2;
import java.io.*;
import java.util.*;
public class dmopc14c3p6 {
	static int[] dp1;
	static int[] dp2;

	public static void main(String[] args) throws IOException {
		int N = readInt();
		int T = readInt();
		dp1 = new int[T + 1];
		dp2 = new int[T + 1];
		for (int i = 0; i < N; i++) {
			int p1 = readInt();
			int v1 = readInt();
			int p2 = readInt();
			int v2 = readInt();
			int p3 = readInt();
			int v3 = readInt();
			for (int j = 1; j <= T; j++) {
				dp2[j] = dp1[j];
				if (j >= p1) {
					dp2[j] = Math.max(dp2[j], v1 + dp1[j - p1]);
				}
				if (j >= p2) {
					dp2[j] = Math.max(dp2[j], v2 + dp1[j - p2]);
				}
				if (j >= p3) {
					dp2[j] = Math.max(dp2[j], v3 + dp1[j - p3]);
				}
			}
			for (int j = 0; j <= T; j++) {
				dp1[j] = dp2[j];
			}
		}
		System.out.println(dp2[T]);
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
