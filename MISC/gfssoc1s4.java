package Unit2;
import java.io.*;
public class gfssoc1s4 {
	static void update(int x, int y, int z, long val) {
		for (int i = x; i < n + 1; i += (i & -i)) {
			for (int j = y; j < n + 1; j += (j & -j)) {
				for (int k = z; k < n + 1; k += (k & -k)) {
					tree[i][j][k] += val;
				}
			}
		}
	}

	static long query(int x, int y, int z) {
		long sum = 0;
		for (int i = x; i > 0; i -= (i & -i)) {
			for (int j = y; j > 0; j -= (j & -j)) {
				for (int k = z; k > 0; k -= (k & -k)) {
					sum += tree[i][j][k];
				}
			}
		}
		return sum;
	}

	static int n;
	static long[][][] tree;

	public static void main(String[] args) throws IOException {
		n = readInt();
		tree = new long[n + 1][n + 1][n + 1];
		int q = readInt();
		long summ = 0;
		for (int i = 0; i < q; i++) {
			String s = read();
			if (s.equals("C")) {
				int x = readInt(), y = readInt(), z = readInt();
				long val = readInt();
				val = val - (1L * (query(x, y, z) - query(x - 1, y, z) - query(x, y - 1, z) - query(x, y, z - 1)
						+ query(x - 1, y - 1, z) + query(x - 1, y, z - 1) + query(x, y - 1, z - 1)
						- query(x - 1, y - 1, z - 1)));
				update(x, y, z, val);
			} else {
				int x1 = readInt(), y1 = readInt(), z1 = readInt(), x2 = readInt(), y2 = readInt(), z2 = readInt();
				summ += 1L * (query(x2, y2, z2) - query(x1 - 1, y2, z2) - query(x2, y1 - 1, z2) - query(x2, y2, z1 - 1)
						+ query(x1 - 1, y1 - 1, z2) + query(x1 - 1, y2, z1 - 1) + query(x2, y1 - 1, z1 - 1)
						- query(x1 - 1, y1 - 1, z1 - 1));
			}
		}
		println(summ);
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
