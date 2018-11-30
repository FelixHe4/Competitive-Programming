package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class mcco17p2 {

	static int n, k, q;
	static long[] seg;
	static long[] lazy;

	static void Update(int l, int r, int low, int high, int root, long value) {
		if (lazy[root] != 0) {
			seg[root] += lazy[root];
			if (high != low) {
				lazy[root << 1] += lazy[root];
				lazy[root << 1 | 1] += lazy[root];
			}
			lazy[root] = 0;
		}
		if (low > high || low > r || high < l) {
			return;
		}
		if (low >= l && high <= r) {
			seg[root] += value;
			if (high != low) {
				lazy[root << 1] += value;
				lazy[root << 1 | 1] += value;
			}
			return;
		}
		int mid = (low + high) / 2;
		Update(l, r, low, mid, root << 1, value);
		Update(l, r, mid + 1, high, root << 1 | 1, value);
		seg[root] = Math.max(seg[root << 1], seg[root << 1 | 1]);
	}

	static long Query(int l, int r, int low, int high, int root) {
		if (low > r || high < l || low > high) {
			return Long.MIN_VALUE;
		}
		if (lazy[root] != 0) {
			seg[root] += lazy[root];
			if (low != high) {
				lazy[root << 1] += lazy[root];
				lazy[root << 1 | 1] += lazy[root];
			}
			lazy[root] = 0;
		}
		if (low >= l && high <= r) {
			return seg[root];
		}
		int mid = (low + high) / 2;
		return Math.max(Query(l, r, low, mid, root << 1), Query(l, r, mid + 1, high, root << 1 | 1));
	}

	public static void main(String[] args) throws IOException {
		n = readInt();
		k = readInt();
		q = readInt();
		seg = new long[4 * n + 1];
		lazy = new long[4 * n + 1];
		while (q-- > 0) {
			int op = readInt();
			if (op == 0) {
				int x = readInt() + 1;
				long v = readLong();
				if (x - k <= 0) {
					Update(1, x, 1, n, 1, v);
				} else {
					Update(x - k + 1, x, 1, n, 1, v);
				}
				System.out.println(Arrays.toString(seg));
				System.out.println(Arrays.toString(lazy));
			} else {
				int l = readInt() + 1, r = readInt() + 1;
				System.out.println(Query(l, r, 1, n, 1));
			}
		}
	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static String readLine() throws IOException {
		byte[] buf = new byte[64]; // line length
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
		din.close();
		pr.close();
		System.exit(0);
	}
}
