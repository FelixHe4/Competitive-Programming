package Unit2;
import java.io.*;
import java.util.*;
public class cf336A {

	public static void main(String[] args) throws IOException {
		int m = readInt();
		int R = readInt();
		double totalD = 0;
		if (m == 2) {
			for (long i = 0; i < m; i++) {
				double v = (Math.floor(i / m)) + 1;
				double u = m + 1 + (i % m);
				double lT = u - m;
				if (v != u) {
					totalD += 2 * R;
				}
				if (lT - v >= 1 || v - lT >= 1) {
					totalD += Math.sqrt((Math.pow(R, 2) * 2));
				}
				if (lT - v >= 2 || v - lT >= 2) {
					totalD += lT - (v + 1) * R;
				}
				if (i == m - 1) {
					totalD *= 2;
				}
			}
			System.out.println(totalD / Math.pow(m, 2));
		}
		else if (m == 1) {
			System.out.println((double) R * 2);
		}
		else if (m % 2 == 0) {
			for (long i = 0; i < m * 2; i++) {
				double v = (Math.floor(i / m)) + 1;
				double u = m + 1 + (i % m);
				double lT = u - m;
				if (v != u) {
					totalD += 2 * R;
				}
				if (lT - v >= 1 || v - lT >= 1) {
					totalD += Math.sqrt((Math.pow(R, 2) * 2));
				}
				if (lT - v >= 2) {
					totalD += ((lT - (v + 1)) * 2) * R;
				}
				if (v - lT >= 2) {
					totalD += (((v + 1) - lT) * 2) * R;
				}
				if (i == m * 2 - 1 && m > 2) {
					totalD *= 2;
				}
			}
			System.out.println(totalD / Math.pow(m, 2));
		}
		else if (m % 2 == 1 && m != 1) {
			for (long i = 0; i < m * 2; i++) {
				double v = (Math.floor(i / m)) + 1;
				double u = m + 1 + (i % m);
				double lT = u - m;
				if (v != u) {
					totalD += 2 * R;
				}
				if (lT - v >= 1 || v - lT >= 1) {
					totalD += Math.sqrt((Math.pow(R, 2) * 2));
				}
				if (lT - v >= 2) {
					totalD += ((lT - (v + 1)) * 2) * R;
				}
				if (v - lT >= 2) {
					totalD += (((v + 1) - lT) * 2) * R;
				}
				if (i == m * 2 - 1 && m > 2) {
					totalD *= 2;
				}
			}
			System.out.println(totalD / Math.pow(m, 2));
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
