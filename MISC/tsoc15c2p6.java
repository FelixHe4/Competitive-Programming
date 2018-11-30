package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class tsoc15c2p6 {
	static class Node {
		int root;
		long val;

		public Node(int root, long val) {
			this.root = root;
			this.val = val;
		}
	}

	static void Build(int l, int r, int root) {
		seg[root] = new Node(root, 0);
		if (l == r) {
			seg[root].val = ori[l];
		} else {
			int mid = (l + r) / 2;
			Build(l, mid, root * 2);
			Build(mid + 1, r, root * 2 + 1);
			seg[root].val = Math.min(seg[root * 2].val, seg[root * 2 + 1].val);
		}
	}

	static void Update(int l, int r, int low, int high, int root, int value) {
		if (lazy[root] != 0) {
			seg[root].val -= lazy[root];
			// SUM MULTIPLY BY INTERVAL.
			if (seg[root].val < 0) {
				seg[root].val = 0;
			}
			if (high != low) {
				lazy[root * 2] += lazy[root];
				lazy[root * 2 + 1] += lazy[root];
			}
			lazy[root] = 0;
		}
		if (low > high || low > r || high < l) {
			return;
		}
		if (low >= l && high <= r) {
			seg[root].val -= value;
			// SUM MULTIPLY BY INTERVAL.
			if (seg[root].val < 0) {
				seg[root].val = 0;
			}
			if (high != low) {
				lazy[root * 2] += value;
				lazy[root * 2 + 1] += value;
			}
			return;
		}
		int mid = (low + high) / 2;
		Update(l, r, low, mid, root * 2, value);
		Update(l, r, mid + 1, high, root * 2 + 1, value);
		seg[root].val = Math.min(seg[root * 2].val, seg[root * 2 + 1].val);
	}

	static long Query(int l, int r, int low, int high, int root) {
		if (low > r || high < l || low > high) {
			return Integer.MAX_VALUE;
		}
		if (lazy[root] != 0) {
			seg[root].val -= lazy[root];
			// SUM MULTIPLY BY INTERVAL.
			if (seg[root].val < 0) {
				seg[root].val = 0;
			}
			if (low != high) {
				lazy[root * 2] += lazy[root];
				lazy[root * 2 + 1] += lazy[root];
			}
			lazy[root] = 0;
		}
		if (low >= l && high <= r) {
			return seg[root].val;
		}
		int mid = (low + high) / 2;
		return Math.min(Query(l, r, low, mid, root * 2), Query(l, r, mid + 1, high, root * 2 + 1));
	}

	static Node[] seg;
	static long[] ori, lazy;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int q = readInt();
		seg = new Node[n * 4 + 1];
		ori = new long[n + 1];
		lazy = new long[n * 4 + 1];
		for (int i = 1; i < ori.length; i++) {
			ori[i] = readInt();
		}
		Build(1, n, 1);
//		System.out.println();
//		for (int i = 0; i < seg.length; i++) {
//			if (seg[i] != null) {
//				println(seg[i].l + " " + seg[i].r + " " + seg[i].root + " " + seg[i].val);
//			}
//		}
		while (q-- > 0) {
			int a = readInt(), b = readInt(), c = readInt();
			Update(a, b, 1, n, 1, c);
//			for (int i = 0; i < seg.length; i++) {
//				if (seg[i] != null) {
//					println(seg[i].l + " " + seg[i].r + " " + seg[i].root + " " + seg[i].val);
//				}
//			}
//			exit();
			print(Query(a, b, 1, n, 1) + " ");
			println(Query(1, n, 1, n, 1));
		}
		exit();
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
