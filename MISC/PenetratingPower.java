package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PenetratingPower {
	static class Node {
		int l, r;
		long val, lazy;

		public Node(int l, int r, long val, long lazy) {
			this.l = l;
			this.r = r;
			this.val = val;
			this.lazy = lazy;
		}
	}

	static void Build(int l, int r, int root) {
		seg[root] = new Node(l, r, 0, 0);
		if (l == r) {
			return;
		}
		int mid = (l + r) / 2;
		Build(l, mid, root * 2);
		Build(mid + 1, r, root * 2 + 1);
	}

	static void Update(int l, int r, int root, long val) {
		if (seg[root].l == l && seg[root].r == r) {
			seg[root].lazy += val;
			seg[root].val += val;
			return;
		}
		if (seg[root].lazy != 0) {
			seg[root << 1].lazy += seg[root].lazy;
			seg[root << 1 | 1].lazy += seg[root].lazy;
			seg[root << 1].val += seg[root].lazy;
			seg[root << 1 | 1].val += seg[root].lazy;
			seg[root].lazy = 0;
		}
		int mid = (seg[root].l + seg[root].r) / 2;
		if (r <= mid) {
			Update(l, r, root << 1, val);
		} else if (l > mid) {
			Update(l, r, root << 1 | 1, val);
		} else {
			Update(l, mid, root << 1, val);
			Update(mid + 1, r, root << 1 | 1, val);
		}
		seg[root].val = Math.max(seg[root << 1].val, seg[root << 1 | 1].val);
	}

	static long Query(int l, int r, int root) {
		if (seg[root].l > r || seg[root].r < l) {
			return Long.MIN_VALUE;
		}
		if (seg[root].l == l && seg[root].r == r) {
			return seg[root].val;
		}
		if (seg[root].lazy != 0) {
			seg[root << 1].lazy += seg[root].lazy;
			seg[root << 1 | 1].lazy += seg[root].lazy;
			seg[root << 1].val += seg[root].lazy;
			seg[root << 1 | 1].val += seg[root].lazy;
			seg[root].lazy = 0;
		}
		int mid = (seg[root].l + seg[root].r) / 2;
		if (r <= mid) {
			return Query(l, r, root << 1);
		} else if (l > mid) {
			return Query(l, r, root << 1 | 1);
		} else {
			return Math.min(Query(l, mid, root << 1), Query(mid + 1, r, root << 1 | 1));
		}
	}

	static Node[] seg;

	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt(), q = readInt();
		seg = new Node[n * 4 + 1];
		Build(1, n, 1);
		while (q-- > 0) {
			int op = readInt();
			if (op == 0) {
				int i = readInt();
				long val = readLong();
				Update(Math.max(1, i - k + 1) + 1, i + 1, 1, val);
//				for (int j = 0; j < seg.length; j++) {
//					System.out.print(seg[i].val + " ");
//				}
//				System.out.println();
			} else {
				int l = readInt(), r = readInt();
				System.out.println(Query(l + 1, r + 1, 1));
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
