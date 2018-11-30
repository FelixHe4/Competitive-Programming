package Unit2;
import java.io.*;
import java.util.*;
import java.math.*;
public class fib {
	public static void main(String[] args) throws IOException, NumberFormatException {
		Scanner scan = new Scanner(System.in);
		BigInteger b = scan.nextBigInteger();
		System.out.println(getNthfibo(b));
		// for (int i = 0; i <= 100000000; i++) {
		// System.out.println(i + ": i " + getNthfibo(BigInteger.valueOf(i)));
		// }
		scan.close();
	}

	public static long getNthfibo(BigInteger n) throws NumberFormatException {
		if (n.compareTo(BigInteger.valueOf(1)) == 0 || n.compareTo(BigInteger.valueOf(1)) == -1) {
			return n.longValue();
		}
		long[][] result = { { 1, 0 }, { 0, 1 } };
		long[][] fiboM = { { 1, 1 }, { 1, 0 } };
		while (n.compareTo(BigInteger.valueOf(0)) == 1) {
			if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(1))) {
				multMatrix(result, fiboM);
			}
			n = n.divide(BigInteger.valueOf(2));
			multMatrix(fiboM, fiboM);
		}

		return result[1][0] % 1_000_000_007;
	}

	public static void multMatrix(long[][] m, long[][] n) throws NumberFormatException {
		long a = m[0][0] * n[0][0] + m[0][1] * n[1][0];
		long b = m[0][0] * n[0][1] + m[0][1] * n[1][1];
		long c = m[1][0] * n[0][0] + m[1][1] * n[0][1];
		long d = m[1][0] * n[0][1] + m[1][1] * n[1][1];

		m[0][0] = a % 1_000_000_007;
		m[0][1] = b % 1_000_000_007;
		m[1][0] = c % 1_000_000_007;
		m[1][1] = d % 1_000_000_007;
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
