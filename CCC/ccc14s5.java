package Unit1;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class ccc14s5 {

	public static void main(String[] args) throws IOException {
		short n = (short) readInt();
		short[] x = new short[n + 1];
		short[] y = new short[n + 1];
		x[0] = 0;
		y[0] = 0;
		// ArrayList<Node> a = new ArrayList<Node>();
		for (short i = 1; i <= n; i++) {
			x[i] = (short) readInt();
			y[i] = (short) readInt();
		}
		int count = 0;
		long modX = (long) 1 << 30, modY = (long) 1 << 15;
		long[] hecc = new long[2001000];
		Arrays.fill(hecc, Long.MAX_VALUE);
		for (short i = 0; i <= n; i++) {
			for (short j = (short) (i + 1); j <= n; j++) {
				hecc[count++] = 1L * (1L * (pow(x[i] - x[j], 2) + pow(y[i] - y[j], 2)) * modX) + 1L * i * modY + 1L * j;
				// a.add(new Node((int) (pow(x[i] - x[j], 2) + pow(y[i] - y[j], 2)), (short) i, (short) j));
				// System.out.println(hecc[count - 1]);
			}
		}
		Arrays.sort(hecc);
		// System.out.println(Arrays.toString(hecc));
		// Some kind of sort needs to go here.........
		// System.out.println(count);
		// System.out.println(a.size());
		// double[][] dp = new double[2001][3];
		int[] dp = new int[n + 1];
		int[] dist = new int[n + 1];
		int[] step = new int[n + 1];
		for (int i = 0; i < count; i++) {
			int c = (int) (hecc[i] / modX), a = (int) ((hecc[i] % modX) / modY), b = (int) (hecc[i] % modY);
			// System.out.println(a + " " + b + " " + c);
			if (dist[a] != c) {
				dist[a] = c;
				step[a] = dp[a];
			}
			if (dist[b] != c) {
				dist[b] = c;
				step[b] = dp[b];
			}
			if (a == 0) {
				dp[a] = Math.max(dp[a], step[b]);
			} else {
				dp[a] = Math.max(dp[a], step[b] + 1);
				dp[b] = Math.max(dp[b], step[a] + 1);
				// increase the amount of steps taken
			}
		}

		// System.out.println(Arrays.toString(dist));
		System.out.println(dp[0] + 1);
		// System.out.println(Runtime.getRuntime().totalMemory());
		exit();
	}

	public static long pow(int base, int exp) {
		long x = 1;
		for (int i = 0; i < exp; i++) {
			x = (x * base);
		}
		return x;
	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static String readLine() throws IOException {
		byte[] buf = new byte[1000000]; // line length
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
		} while (c != -1 && c != ' ' && c != '\n' && c != '\r');
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
		} while ((c = Read()) >= '0' && c <= '9');

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
		} while ((c = Read()) >= '0' && c <= '9');
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
		} while ((c = Read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = Read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
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
		pr.flush();
		din.close();
		pr.close();
		System.exit(0);
	}
}