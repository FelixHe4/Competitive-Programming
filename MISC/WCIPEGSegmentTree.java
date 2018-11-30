package Unit2;
import java.io.*;
import java.util.*;
public class WCIPEGSegmentTree {
	static class node {
		long l, r, root, min;

		node(long l0, long r0, long root0, int min0) {
			l = l0;
			r = r0;
			root = root0;
			min = min0;
		}
	}

	static node[] seg;
	static int[] ori;

	static void Build(long l, long r, long root) {
		seg[(int) root] = new node(l, r, root, 0);
		if (l == r) {
			seg[(int) root].min = ori[(int) l];
		}
		else {
			long mid = (l + r) / 2;
			Build(l, mid, root * 2 + 1);
			Build(mid + 1, r, root * 2 + 2);
			seg[(int) root].min = Math.min(seg[(int) (root * 2 + 1)].min,
					seg[(int) root * 2 + 2].min);
		}
	}

	static void Update(long l, long r, long low, long high, long val, int root) {
		if (l > high || r < low) {
			return;
		}
		if (low == l && r == high) {
			seg[root].min = val;
		}
		else {
			long mid = (low + high) / 2;
			Update(l, r, low, mid, val, root * 2 + 1);
			Update(l, r, mid + 1, high, val, root * 2 + 2);
			seg[(int) root].min = Math.min(seg[(int) (root * 2 + 1)].min,
					seg[(int) root * 2 + 2].min);
		}
	}

	static long Minimum(long l, long r, long low, long high, int root) {
		if (l > high || r < low) {
			return Long.MAX_VALUE;
		}
		if (l <= low && r >= high) {
			return seg[(int) root].min;
		}
		long mid = (low + high) / 2;
		return Math.min(Minimum(l, r, low, mid, root * 2 + 1),
				Minimum(l, r, mid + 1, high, root * 2 + 2));
	}

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		seg = new node[(int) (n * 4 + 1)];
		ori = new int[n + 1];
		for (int i = 0; i < n; i++) {
			ori[i] = readInt();
		}
		Build(0, n - 1, 0);
		// for (int i = 0; i < seg.length; i++) {
		// if (seg[i] != null) {
		// System.out.print(seg[i].l + " ");
		// System.out.print(seg[i].r + " ");
		// System.out.println(seg[i].min);
		// }
		// }
		for (int i = 0; i < m; i++) {
			String s = read();
			if (s.equals("M")) {
				int x = readInt();
				Update(x, x, 0, n - 1, readInt(), 0);
			}
			if (s.equals("Q")) {
				System.out.println(Minimum(readInt(), readInt(), 0, n - 1, 0));
			}
		}
		// for (int i = 0; i < seg.length; i++) {
		// if (seg[i] != null) {
		// System.out.print(seg[i].l + " ");
		// System.out.print(seg[i].r + " ");
		// System.out.println(seg[i].min);
		// }
		// }
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