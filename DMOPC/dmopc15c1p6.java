package Unit2;
import java.io.*;
import java.util.*;
public class dmopc15c1p6 {

	static class node {
		long l, r, sum;

		node(long l0, long r0, long sum0) {
			l = l0;
			r = r0;
			sum = sum0;
		}
	}

	static long[] ori;
	static node[] seg;
	static long[] lazy;

	static void Build(int l, int r, int root) {
		seg[(int) root] = new node(l, r, 0);
		if (l == r) {
			seg[root].sum = ori[l];
			return;
		}
		int mid = (l + r) / 2;
		Build(l, mid, root * 2);
		Build(mid + 1, r, root * 2 + 1);
		seg[root].sum = (seg[2 * root].sum % M + seg[2 * root + 1].sum % M) % M;
	}

	static void Update(long l, long r, int root, long val) {
		if (seg[root].l == l && seg[root].r == r) {
			seg[root].sum += val * (r - l + 1);
			seg[root].sum %= M;
			lazy[root] += val;
			return;
		}
		if (lazy[root] != 0) {
			lazy[root * 2] += lazy[root];
			lazy[root * 2 + 1] += lazy[root];
			seg[root * 2].sum += lazy[root] * (seg[root * 2].r - seg[root * 2].l + 1);
			seg[root * 2 + 1].sum += lazy[root]
					* (seg[root * 2 + 1].r - seg[root * 2 + 1].l + 1);
			lazy[root] = 0;
			lazy[root * 2] %= M;
			lazy[root * 2 + 1] %= M;
			seg[root * 2].sum %= M;
			seg[root * 2 + 1].sum %= M;
		}
		long mid = (seg[root].l + seg[root].r) / 2;
		if (r <= mid) {
			Update(l, r, root * 2, val);
		}
		else if (l > mid) {
			Update(l, r, root * 2 + 1, val);
		}
		else {
			Update(l, mid, root * 2, val);
			Update(mid + 1, r, root * 2 + 1, val);
		}
		seg[root].sum = (seg[root * 2].sum + seg[root * 2 + 1].sum) % M;
	}

	static int Sum(long l, long r, int root) {
		if (seg[root].l > r || seg[root].r < l) {
			return 0;
		}
		if (seg[root].l == l && seg[root].r == r) {
			return (int) seg[root].sum % M;
		}
		if (lazy[root] != 0) {
			lazy[root * 2] += lazy[root];
			lazy[root * 2 + 1] += lazy[root];
			seg[root * 2].sum += lazy[root] * (seg[root * 2].r - seg[root * 2].l + 1);
			seg[root * 2 + 1].sum += lazy[root]
					* (seg[root * 2 + 1].r - seg[root * 2 + 1].l + 1);
			lazy[root] = 0;
			lazy[root * 2] %= M;
			lazy[root * 2 + 1] %= M;
			seg[root * 2].sum %= M;
			seg[root * 2 + 1].sum %= M;
		}
		long mid = (seg[root].l + seg[root].r) / 2;
		if (r <= mid) {
			return Sum(l, r, root * 2);
		}
		else if (l > mid) {
			return Sum(l, r, root * 2 + 1);
		}
		else {
			return Sum(l, mid, root * 2) + Sum(mid + 1, r, root * 2 + 1) % M;
		}
	}

	public static void main(String[] args) throws IOException {
		M = readInt();
		int N = readInt();
		seg = new node[N * 4 + 1];
		lazy = new long[N * 4 + 1];
		ori = new long[N + 1];
		int Q = readInt();
		for (int i = 1; i <= N; i++) {
			ori[i] = readInt();
		}
		Build(1, N, 1);

		for (int i = 0; i < Q; i++) {
			int op = readInt();
			if (op == 1) {
				int l = readInt();
				int r = readInt();
				long val = readInt();
				Update(l, r, 1, val);
			}
			else if (op == 2) {
				int l = readInt();
				int r = readInt();
				System.out.println((Sum(l, r, 1)) % M);
			}
			// for (int j = 0; j < seg.length; j++) {
			// if (seg[j] != null) {
			// System.out.print(seg[j].l + " ");
			// System.out.print(seg[j].r + " ");
			// System.out.print(seg[j].sum + " ");
			// System.out.println(lazy[i]);
			// }
			// }
		}
	}

	static int M;
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
