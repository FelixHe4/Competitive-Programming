package Unit2;
import java.io.*;
import java.util.*;
public class utso15p3 {
	static long[] dp;
	static long[][] dp1;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		dp = new long[100005];
		dp1 = new long[100005][5];
		if (m == 1) {
			print(1 % 1000000007);
		}
		if (m == 2) {
			print(recurse(n));
		}
		if (m == 3) {
			print(A(n));
		}
		exit();

	}

	static long recurse(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (dp[n] != 0) {
			return dp[n];
		}
		return dp[n] = (recurse(n - 1) + recurse(n - 3)) % 1000000007;
	}

	static long A(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (dp1[n][0] != 0) {
			return dp1[n][0];
		}
		return dp1[n][0] = (A(n - 1) % 1000000007 + B(n - 2) % 1000000007 + C(n - 3)) % 1000000007;
	}

	static long B(int n) {
		if (n <= 0) {
			return 0;
		}
		if (dp1[n][1] != 0) {
			return dp1[n][1];
		}
		return dp1[n][1] = (A(n - 2) % 1000000007 + D(n - 3) % 1000000007 + E(n - 1) % 1000000007 + E(n - 3) % 1000000007) % 1000000007;
	}

	static long C(int n) {
		if (n <= 0) {
			return 0;
		}
		if (dp1[n][2] != 0) {
			return dp1[n][2];
		}
		return dp1[n][2] = (A(n - 2) % 1000000007 + D(n)) % 1000000007;
	}

	static long D(int n) {
		if (n <= 0) {
			return 0;
		}
		if (dp1[n][3] != 0) {
			return dp1[n][3];
		}
		return dp1[n][3] = (A(n - 1) % 1000000007 + A(n - 2) % 1000000007 + D(n - 3) % 1000000007 + E(n - 1) % 1000000007
				+ E(n - 3) % 1000000007) % 1000000007;
	}

	static long E(int n) {
		if (n <= 0) {
			return 0;
		}
		if (dp1[n][4] != 0) {
			return dp1[n][4];
		}
		return dp1[n][4] = (A(n) % 1000000007 + B(n - 1) % 1000000007) % 1000000007;
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
		return readLine().charAt(0);
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
