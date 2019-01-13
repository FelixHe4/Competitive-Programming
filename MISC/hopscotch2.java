package Unit2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;
public class hopscotch2 {
	static class Pair {
		long pos, val;

		public Pair(long pos0, long val0) {
			pos = pos0;
			val = val0;
		}
	}

	public static void main(String[] args) throws IOException {
		long n = readLong();
		long k = readLong();
		long[] vals = new long[(int) n + 5];
		long[] prev = new long[(int) n + 5];
		Stack<Long> st = new Stack<Long>();
		ArrayDeque<Pair> ad = new ArrayDeque<Pair>();
		ad.push(new Pair(0, 0));
		for (int i = 1; i <= n; i++) {
			long x = readLong();
			// vals[i] = x;
			while (ad.peekFirst().pos < i - k) {
				// System.out.println(ad.peekFirst().pos);
				ad.pollFirst();
			}
			prev[i] = ad.peekFirst().pos;
			long val = ad.peekFirst().val + x;
			vals[i] = val;
			while (!ad.isEmpty() && val <= ad.peekLast().val) {
				ad.pollLast();
			}
			ad.add(new Pair(i, val));
			// System.out.println(ad.peekLast().pos + " " + ad.peekLast().val);
		}
		// System.out.println(Arrays.toString(prev));
		long min = Long.MAX_VALUE;
		long index = -1;
		for (int i = (int) (n - k + 1) + 1; i <= n; i++) {
			if (vals[i] <= min) {
				min = vals[i];
				index = i;
			}
		}
		while (index != 0 && index != -1) {
			st.push(index);
			index = prev[(int) index];
		}
		System.out.println(min);
		for (int i = st.size() - 1; i >= 0; i--) {
			System.out.print(st.pop() + " ");
		}
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
