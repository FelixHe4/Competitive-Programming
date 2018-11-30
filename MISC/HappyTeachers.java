package Unit2;
import java.io.*;
import java.util.*;
public class HappyTeachers {

	public static void main(String[] args) throws IOException {
		int n = readInt();
		System.out.println(n);
		int[] H = new int[n];
		int[] E = new int[n];
		int[] P = new int[n];
		for (int i = 0; i < n; i++) {
			H[i] = readInt();
			E[i] = readInt();
			P[i] = readInt();
		}
		int s = readInt();
		int[] dp = new int[s + 1];
		int[] dp2 = new int[s + 1];
		int[] time = new int[s + 1];
		int[] time2 = new int[s + 1];
		Arrays.fill(time, Integer.MAX_VALUE);
		Arrays.fill(time2, Integer.MAX_VALUE);
		int count = 0;
		int j = 1;
		System.out.println(s);
		boolean flag = true;
		for (int i = 0; i < H.length; i++) {
			int h = 0;
			int e = E[i];
			int p = P[i];
			while (true) {
				if (P[i] * j <= s && H[i] > 0) {
					h += H[i];
					p = P[i] * j;
					H[i] -= e;
					j++;
					for (int k = s; k >= 1; k--) {
						dp[k] = dp2[k];
						if (k >= p) {
							dp2[k] = Math.max(dp2[k], Math.max(dp[k - p] + h, dp2[k]));
							if (flag) {
								count += j;
								flag = false;
							}
							System.out.println(Arrays.toString(dp2));
						}
					}
				}
				else {
					break;
				}
			}
			flag = true;
			j = 1;
		}
		System.out.println(dp2[s]);
		System.out.println(count);
		exit();
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
