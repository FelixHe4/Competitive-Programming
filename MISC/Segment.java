package Unit2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class Segment {

	static class node {
		int l, r, min;

		node(int l0, int r0, int m0) {
			l = l0;
			r = r0;
			min = m0;
		}
	}

	static node[] seg;
	static int[] ori;

	static void Build(int l, int r, int root) {
		seg[root] = new node(l, r, 0);
		if (l == r) {
			seg[root].min = ori[root];
		} else {
			int mid = (l + r) / 2;
			Build(l, mid, 2 * root);
			Build(mid + 1, r, 2 * root + 1);
			seg[root].min = Math.min(seg[2 * root].min, seg[2 * root + 1].min);
		}
	}

	static void update(int pos, int val, int root) {
		if (seg[root].l == seg[root].r)
			seg[root].min = val;
		else {
			int mid = (seg[root].l + seg[root].r) / 2;
			if (pos <= mid) {
				update(pos, val, 2 * root);
			} else {
				update(pos, val, 2 * root + 1);
			}
		}
	}

	static int query(int l, int r, int root) {
		if (seg[root].l == l && seg[root].r == r) {
			return seg[root].min;
		} else {
			int mid = (seg[root].l + seg[root].r) / 2;
			if (r <= mid) {
				return query(l, r, 2 * root);
			} else if (l > mid) {
				return query(l, r, 2 * root + 1);
			} else {
				return Math.min(query(l, mid, 2 * root), query(mid + 1, r, 2 * root + 1));
			}
		}

	}

	public static void main(String[] args) throws IOException {
		int N = readInt();
		int M = readInt();
		seg = new node[N * 4 + 1];
		ori = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			ori[i] = readInt();
		}
		Build(1, N, 1);
		for (int i = 0; i < M; i++) {
			int ope = readInt();
			// 0 update 1 query
			if (ope == 0) {
				int pos = readInt();
				int val = readInt();
				update(pos, val, 1);
			} else {
				int l = readInt();
				int r = readInt();
				System.out.println(query(l, r, 1));
			}
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