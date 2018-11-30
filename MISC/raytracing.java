package Unit2;
import java.io.*;
public class raytracing {
	static void update(int x, int y, int val) {
		int y1;
		while (x <= n) {
			y1 = y;
			while (y1 <= n) {
				tree[x][y1] += val;
				y1 += (y1 & -y1);
			}
			x += (x & -x);
		}
	}

	static long query(int x, int y) {
		long sum = 0;
		while (x != 0) {
			int y1 = y;
			while (y1 != 0) {
				sum += tree[x][y1];
				y1 -= (y1 & -y1);
			}
			x -= (x & -x);
		}
		return sum;
	}

	static int n;
	static int[][] tree;
	static int[] a;

	public static void main(String[] args) throws IOException {
		n = readInt();
		tree = new int[n + 1][n + 1];
		a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int b = readInt() + 1;
			a[i] = b;
			update(a[i], i, 1);
		}
		int q = readInt();
		for (int i = 0; i < q; i++) {
			int op = readInt();
			if (op == 1) {
				int l = readInt();
				int r = readInt() + 1;
				int min = readInt();
				int max = readInt() + 1;
				System.out.println(query(max, r) - query(min, r) - query(max, l) + query(min, l));
			} else {
				int idx = readInt() + 1;
				int val = readInt() + 1;
				// must subtract at current pos before adding
				update(a[idx], idx, -1);
				a[idx] = val;
				update(a[idx], idx, 1);
			}
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
