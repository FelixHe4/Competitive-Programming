package Unit2;
import java.io.*;
import java.util.*;
public class SqrtDecomp {

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int[] vals = new int[n + 5];
		int root = (int) Math.sqrt(n);
		for (int i = 0; i < n; i++) {
			vals[i] = readInt();
		}
		int[] minimum = new int[root + 5];
		Arrays.fill(minimum, Integer.MAX_VALUE);
		int[] sum = new int[root + 5];
		for (int i = 0; i < root; i++) {
			for (int j = i * root; j < i * root + root; j++) {
				sum[i] += vals[j];
				minimum[i] = Math.min(vals[j], minimum[i]);
			}
		}
		// System.out.println(Arrays.toString(minimum));
		for (int i = 0; i < m; i++) {
			String s = read();
			if (s.equals("M")) {
				int pos = readInt();
				int block = pos / root;
				sum[block] -= vals[pos];
				int num = readInt();
				vals[pos] = num;
				minimum[block] = Integer.MAX_VALUE;
				for (int j = block * root; j < root + block * root && j < n; j++) {
					minimum[block] = Math.min(vals[j], minimum[block]);
				}
				sum[block] += vals[pos];
			} else {
				int l = readInt();
				int r = readInt();
				// System.out.println(l + " " + r);
				int sum11 = 0;
				int min = Integer.MAX_VALUE;
				for (int j = l; j <= r; j++) {
					if (j % root == 0 && j + root <= r) {
						sum11 += sum[j / root];
						min = Math.min(min, minimum[j / root]);
						j += root;
						j--;
					} else {
						min = Math.min(min, vals[j]);
						sum11 += vals[j];
					}
				}
				System.out.println(min);
			}
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
