package Unit2;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
public class dmpg17g2 {
	static class Node {
		int l, r, root;
		long sum, prefixsum, suffixsum, maxsum;

		public Node(int l0, int r0, int root0, long sum0, long prefixsum0, long suffixsum0, long maxsum0) {
			l = l0;
			r = r0;
			root = root0;
			sum = sum0;
			prefixsum = prefixsum0;
			suffixsum = suffixsum0;
			maxsum = maxsum0;
		}
	}

	static void Build(int l, int r, int root) {
		st[root] = new Node(l, r, root, 0, 0, 0, 0);
		if (l == r) {
			st[root].sum = ori[l];
			st[root].prefixsum = ori[l];
			st[root].suffixsum = ori[l];
			st[root].maxsum = ori[l];
		} else {
			int mid = (l + r) / 2;
			Build(l, mid, root * 2);
			Build(mid + 1, r, root * 2 + 1);
			st[root].sum = st[root * 2].sum + st[root * 2 + 1].sum;
			st[root].prefixsum = Math.max(st[root * 2].prefixsum, st[root * 2].sum + st[root * 2 + 1].prefixsum);
			st[root].suffixsum = Math.max(st[root * 2 + 1].suffixsum, st[root * 2 + 1].sum + st[root * 2].suffixsum);
			st[root].maxsum = Math.max(st[root * 2].maxsum,
					Math.max(st[root * 2 + 1].maxsum, st[root * 2].suffixsum + st[root * 2 + 1].prefixsum));
		}
	}

	static void Update(int x, int v, int low, int high, int root) {
		if (low == high) {
			st[root].sum = v;
			st[root].prefixsum = v;
			st[root].suffixsum = v;
			st[root].maxsum = v;
		} else {
			int mid = (st[root].l + st[root].r) / 2;
			if (x <= mid) {
				Update(x, v, low, mid, root * 2);
			} else {
				Update(x, v, mid + 1, high, root * 2 + 1);
			}
			st[root].sum = st[root * 2].sum + st[root * 2 + 1].sum;
			st[root].prefixsum = Math.max(st[root * 2].prefixsum, st[root * 2].sum + st[root * 2 + 1].prefixsum);
			st[root].suffixsum = Math.max(st[root * 2 + 1].suffixsum, st[root * 2 + 1].sum + st[root * 2].suffixsum);
			st[root].maxsum = Math.max(st[root * 2].maxsum,
					Math.max(st[root * 2 + 1].maxsum, st[root * 2].suffixsum + st[root * 2 + 1].prefixsum));
		}
	}

	static Node Query(int l, int r, int low, int high, int root) {
		if (low > r || l > high) {
			Node a = new Node(-1, -1, -1, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
			return a;
		}
		if (l <= low && r >= high) {
			return st[root];
		} else {
			int mid = (low + high) / 2;
			if (r <= mid) {
				return Query(l, r, low, mid, root * 2);
			}
			if (l > mid) {
				return Query(l, r, mid + 1, high, root * 2 + 1);
			}
			Node left = Query(l, r, low, mid, root * 2);
			Node right = Query(l, r, mid + 1, high, root * 2 + 1);

			Sum = new Node(-1, -1, -1, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
			Sum.sum = left.sum + right.sum;
			Sum.prefixsum = Math.max(left.prefixsum, left.sum + right.prefixsum);
			Sum.suffixsum = Math.max(right.suffixsum, right.sum + left.suffixsum);
			Sum.maxsum = Math.max(left.maxsum, Math.max(right.maxsum, left.suffixsum + right.prefixsum));
			return Sum;
		}
	}

	static int[] ori;
	static Node[] st;
	static Node Sum;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int q = readInt();
		ori = new int[n + 1];
		st = new Node[n * 4 + 1];
		for (int i = 1; i <= n; i++) {
			ori[i] = readInt();
		}
		Build(1, n, 1);
//		System.out.println();
//		for (int j = 0; j < st.length; j++) {
//			if (st[j] != null) {
//				System.out.println(st[j].sum + " " + st[j].prefixsum + " " + st[j].suffixsum + " " + st[j].maxsum);
//			}
//		}
//		System.out.println();
		while (q-- > 0) {
			String s = read();
			switch (s) {
			case "S":
				int i = readInt(), v = readInt();
				Update(i, v, 1, n, 1);
				ori[i] = v;
//				for (int j = 0; j < st.length; j++) {
//					if (st[j] != null) {
//						System.out.println(st[j].sum + " " + st[j].prefixsum + " " + st[j].suffixsum + " " + st[j].maxsum);
//					}
//				}
				break;
			case "Q":
				System.out.println(Query(readInt(), readInt(), 1, n, 1).maxsum);
				break;
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