package Unit2;
import java.io.*;
import java.util.*;
public class ccoprep3p2 {
	// use https://www.desmos.com/calculator/d3hilksf8y as a guideline.
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long l = readLong();
		int start = 0, end = 0;
		long[] p = new long[n + 1];
		long[] a = new long[n + 1];
		long[] b = new long[n + 1];
		long[] dp = new long[n + 1];
		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				dp[i] = 0;
			}
			else {
				while (start + 1 < end && eval(a[start], b[start], p[i] - 1) >= eval(a[start + 1], b[start + 1], p[i] - 1)) {
					start++;
					// skip this one (It's the purple function.
				}
				dp[i] = eval(a[start], b[start], p[i] - 1);
			}
			if (i == n) {
				break;
			}
			long F = p[i] + l;
			long F2 = dp[i];
			while (end > 1 && crossP(a[end - 2], b[end - 2], a[end - 1], b[end - 1], F, F2)) {
				end--;
			}
			a[end] = F;
			b[end] = F2;
			end++;
			start = Math.min(start, end);
			long val = readLong();
			p[i + 1] = p[i] + 1 + val;
		}
		System.out.println(dp[n]);
	}

	static long eval(long a, long b, long x) {
		return (long) Math.pow((x - a), 2) + b;
	}

	static long intersect(long a1, long b1, long a2, long b2) {
		return (long) (Math.pow(a2, 2) + b2 - Math.pow(a1, 2) - b1) / (2 * (a2 - a1));
	}

	static boolean crossP(double a1, double b1, double a2, double b2, double a3, double b3) {
		if ((double) (Math.pow(a2, 2) + b2 - Math.pow(a1, 2) - b1) / (a2 - a1) >= (double) (Math.pow(a3, 2) + b3 - Math.pow(a2, 2) - b2)
				/ (a3 - a2)) {
			return true;
		}
		else {
			return false;
		}
	}

	final private static int BufferS = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BufferS];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	public static String readLine() throws IOException {
		byte[] buf = new byte[64];
		int cnt = 0, c;
		while ((c = Read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}

	public static String read() throws IOException {
		byte[] ret = new byte[1024];
		int idx = 0;
		byte c = Read();
		while (c <= ' ') {
			c = Read();
		}
		do {
			ret[idx++] = c;
			c = Read();
		}
		while (c != -1 && c != ' ' && c != '\n' && c != '\r');
		return new String(ret, 0, idx);
	}

	public static int readInt() throws IOException {
		int ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		}
		while ((c = Read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}

	public static long readLong() throws IOException {
		long ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		}
		while ((c = Read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public static double readDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();

		do {
			ret = ret * 10 + c - '0';
		}
		while ((c = Read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = Read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	static char readChar() throws IOException {
		return next().charAt(0);
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

	private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BufferS);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private static byte Read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}

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
		din.close();
		pr.close();
		System.exit(0);
	}
}
