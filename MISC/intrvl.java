package Unit2;
import java.io.*;
import java.util.*;
public class intrvl {
	static class Point implements Comparable<Point> {
		long type;
		int pos;

		public Point(long type0, int pos0) {
			type = type0;
			pos = pos0;
		}

		public int compareTo(Point A) {
			if (pos < A.pos || pos == A.pos &&
					(type == (1 << 30) || type != -(1 << 30) && A.type == -(1 << 30)))
				return -1;
			if (A.pos < pos || pos == A.pos &&
					(A.type == (1 << 30) || A.type != -(1 << 30) && type == -(1 << 30)))
				return 1;
			return 0;
		}
	}

	final static long max = +(1 << 30);
	final static long min = -(1 << 30);

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int q = readInt();
		Point[] p = new Point[2 * n + q];
		int[] answer = new int[q];
		for (int i = 0; i < n; i++) {
			int a = readInt();
			int b = readInt();
			p[i * 2] = new Point(max, a);
			p[i * 2 + 1] = new Point(min, b);
		}
		for (int i = 0; i < q; i++) {
			int a = readInt();
			p[i + 2 * n] = new Point(i, a);
		}
		Arrays.sort(p, 0, 2 * n + q);
		int c = 0;
		for (int i = 0; i < 2 * n + q; i++) {
			if (p[i].type == min) {
				c--;
			}
			else if (p[i].type == max) {
				c++;
			}
			else {
				answer[(int) p[i].type] = c;
			}
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
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
