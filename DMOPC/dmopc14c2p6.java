package Unit2;
import java.io.*;
import java.util.*;
public class dmopc14c2p6 {
	static long freqTo(int idx) {
		long sum = 0;
		while (idx > 0) {
			sum += tree[idx];
			idx -= (idx & -idx);
		}
		return sum;
	}

	static void update(int idx, long val) {
		while (idx <= n) {
			tree[idx] += val;
			idx += (idx & -idx);
		}
	}

	static class query {
		int a, b, q, pos;
		long val;

		public query(int a0, int b0, int q0, int pos0, long val0) {
			a = a0;
			b = b0;
			q = q0;
			pos = pos0;
			val = val0;
		}

	}

	static class QueryComparator implements Comparator<query> {
		boolean byPos = false;

		public int compare(query q1, query q2) {
			if (byPos) {
				return Integer.compare(q1.pos, q2.pos);
			} else {
				return Integer.compare(q2.q, q1.q);
			}
		}

	}

	static class Tree implements Comparable<Tree> {
		int val, pos;

		public Tree(int val0, int pos0) {
			val = val0;
			pos = pos0;
		}

		public int compareTo(Tree o) {
			return o.val - val;
		}
	}

	static int n;
	static long[] tree;
	static Tree[] a;
	static query[] q;

	public static void main(String[] args) throws IOException {
		n = readInt();
		tree = new long[100005];
		a = new Tree[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Tree(readInt(), i + 1);
		}
		int m = readInt();
		q = new query[m];
		for (int i = 0; i < m; i++) {
			q[i] = new query(readInt() + 1, readInt() + 1, readInt(), i, 0);
		}
		QueryComparator qc = new QueryComparator();
		Arrays.sort(q, qc);
		Arrays.sort(a);
		int aPos = 0;
		long[] ans = new long[m + 5];
		for (int i = 0; i < m; i++) {
			long queryVal = q[i].q;
			for (int j = aPos; j < a.length; j++) {
				if (queryVal <= a[j].val) {
					update(a[j].pos, a[j].val);
					aPos++;
				} else {
					break;
				}
			}
			ans[q[i].pos] = freqTo(q[i].b) - freqTo(q[i].a - 1);
		}
		for (int i = 0; i < m; i++) {
			System.out.println(ans[i]);
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