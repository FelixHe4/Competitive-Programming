package Unit2;
import java.io.*;
import java.util.*;
public class dmopc16c4p6 {

	// public static class Node {
	// long h;
	// int i;
	//
	// public Node(long h0, int i0) {
	// h = h0;
	// i = i0;
	// }
	// }

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int q = readInt();
		long[] count = new long[1000002];
		long[] st = new long[1000002];
		long[] h = new long[1000002];
		int tp = -1;
		h[0] = -1;
		st[++tp] = 0;
		int h0 = 0;
		for (int i = 1; i <= n; i++) {
			h[i] = readInt();
			while (h[(int) st[tp]] > h[i]) {
				int p0 = (int) st[tp];
				h0 = (int) h[p0];
				tp--;
				int l = (int) (p0 - st[tp]);
				int r = i - p0;
				count[h0] += l * r * 1L;
			}
			st[++tp] = i;
		}
		while (tp > 0) {
			int p0 = (int) st[tp];
			h0 = (int) h[p0];
			tp--;
			int l = (int) (p0 - st[tp]);
			int r = n + 1 - p0;
			count[h0] += l * r * 1L;
		}
		for (int i = 1; i <= 1000000; i++) {
			count[i] += count[i - 1];
		}
		for (int i = 1; i <= q; i++) {
			int x = readInt();
			int y = readInt();
			pr.println(count[y] - count[x - 1]);
		}
		exit();
		// st.push(new Node(-1, 0));
		// count[0] = -1;
		// for (int i = 1; i <= n + 1; i++) {
		// if (i <= n) {
		// h = readInt();
		// }
		// else {
		// h = -1;
		// while (st.peek().h > h) {
		// long h0 = st.peek().h;
		// long p0 = st.peek().i;
		// st.pop();
		// long r = i - p0;
		// long l = p0 - st.peek().i;
		// count[(int) h0] += l * r;
		// }
		// st.push(new Node(h, i));
		// }
		// }
		// for (int i = 1; i < count.length; i++) {
		// count[i] += count[i - 1];
		// }
		// for (int i = 0; i < q; i++) {
		// int low = readInt();
		// int high = readInt();
		// System.out.println(count[high] - count[low - 1]);
		// }
	}

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
