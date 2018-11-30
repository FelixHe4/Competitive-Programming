package Unit2;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
public class BinaryIndexedTree {
	static long freqTo(int idx) {
		long sum = 0;
		while (idx > 0) {
			sum += tree[idx];
			idx -= (idx & -idx);
		}
		return sum;
	}
	// to query for 5 - 13
	// print freqTo(13) - freqTo(4);

	static void update(int idx, long val) {
		while (idx <= n) {
			tree[idx] += val;
			idx += (idx & -idx);
		}
	}

	static void update2(long idx, long val) {
		while (idx <= 100005) {
			tree2[(int) idx] += val;
			idx += (idx & -idx);
		}
	}

	static long freqTo2(int idx) {
		long sum = 0;
		while (idx > 0) {
			sum += tree2[idx];
			idx -= (idx & -idx);
		}
		return sum;
	}

	static long[] tree, tree2;
	static int[] a;
	static int n;

	public static void main(String[] args) throws IOException {
		// Fenwick Tree
		// Add N marbles into ith box
		// We can say that box#i has frequency N
		// Total number of marbles in box #1 to #j
		// Add/Update (log N)
		// Sum + Query (log N)
		// int array of size N;
		// a1
		// a1+a2
		// a3
		// a1+a2+a3+a4
		// a5
		// a5+a6
		// a7
		// a1+a2+a3+a4+a5+a6+a7+a8
		// a9
		// a9+a10
		// a11
		// a9+a10+a11+a12
		// a13
		// a13+a14
		// a15
		// a1+a2+a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15+a16
		// A node at the index X will store freq of boxes in the range
		// X - 2^r + 1 to X
		// where r is the position of the last digit of 1
		// to query 13
		// flip the last bit
		// 1101 (13)
		// 1100 (12)
		// 1000 (8)
		// 0000 end
		// so the sum is 13+12+8
		// to update 5
		// take the last bit and then add it to the current one
		// repeat until the index is greater than N
		// 00101 (5)
		// 00110 (6)
		// 01000 (8)
		// 10000 (16)
		n = readInt();
		int m = readInt();
		a = new int[n + 1];
		tree = new long[n + 1];
		tree2 = new long[100005];
		// Method 1 to Build
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
			update2(a[i], 1);
			update(i, a[i]);
		}
		// Method 2 to Build
//		for (int i = 1; i <= n; i++) {
//			tree[i] += a[i];
//			int j = i + (i & -i);
//			if (j <= n) {
//				tree[j] += tree[i];
//			}
//		}
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < m; i++) {
			String s = read();
			if (s.equals("C")) {
				int x = readInt(), y = readInt();
				update2(a[x], -1);
				update2(y, 1);
				update(x, -a[x] + y);
				a[x] = y;
			} else if (s.equals("S")) {
				int l = readInt(), r = readInt();
				System.out.println(freqTo(r) - freqTo(l - 1));
			} else {
				int v = readInt();
				System.out.println(freqTo2(v));
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
