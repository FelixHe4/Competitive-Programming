package Unit2;
import java.io.*;
public class cco13p2 {

	static class Pair {
		int val, index;

		public Pair(int a0, int b0) {
			val = a0;
			index = b0;
		}
	}

	public static void main(String[] args) throws IOException {
		Pair[] p = new Pair[1 << 21];
		int n = readInt(), m = readInt();
		int k = (1 << n) - 1;
		n = 1 << n;
		for (int i = 0; i <= n; i++) {
			p[i] = new Pair(0, 0);
		}
		for (int i = 1; i <= n; i++) {
			p[k + i] = new Pair(readInt(), i);
		}
		for (int i = k; i >= 1; i--) {
			if (p[i * 2].val > p[i * 2 + 1].val) {
				p[i].val = p[i * 2].val;
				p[i].index = p[i * 2].index;
			} else {
				p[i].val = p[i * 2 + 1].val;
				p[i].index = p[i * 2 + 1].index;
			}
		}
		for (int i = 0; i < m; i++) {
			String s = read();
			if (s.equals("W")) {
				System.out.println(p[1].index);
			} else if (s.equals("S")) {
				int x = readInt();
				int count = 0;
				x += k;
				for (int j = x / 2; j >= 1; j /= 2) {
					if (p[j].index == p[x].index) {
						count++;
					} else {
						break;
					}
				}
				System.out.println(count);
			} else {
				int x = readInt(), y = readInt();
				x += k;
				p[x].val = y;
				for (x /= 2; x > 0; x /= 2) {
					if (p[x * 2].val > p[x * 2 + 1].val) {
						p[x].val = p[x * 2].val;
						p[x].index = p[x * 2].index;
					} else {
						p[x].val = p[x * 2 + 1].val;
						p[x].index = p[x * 2 + 1].index;
					}
				}
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
