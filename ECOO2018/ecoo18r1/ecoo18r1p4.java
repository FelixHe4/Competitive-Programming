package ecoo18r1;
import java.util.*;
import java.io.*;
public class ecoo18r1p4 {
	static long[] fib_nums = new long[100];

	public static void main(String[] args) throws IOException {
		try {
			fib_nums[0] = 1;
			fib_nums[1] = 1;
			fib_nums[2] = 1;
			for (int j = 0; j < 10; j++) {// change to # test cases\
				String in[] = br.readLine().split(" ");
				long targetX = Integer.parseInt(in[0]);
				long targetY = Integer.parseInt(in[1]);
				long x = 0;
				long y = 0;
				long ix = 0;
				long iy = 0;
				if (targetX == 0 || targetX == 1)
					ix = 1;
				if (targetY == 0)
					iy = 1;
				if (targetX < 0) {
					targetX = Math.abs(targetX);
					for (int i = 2; x < targetX; i += 4) {
						x += fib(i);
						ix = i;
					}
				}
				if (targetX > 1) {
					for (int i = 0; x < targetX; i += 4) {
						x += fib(i);
						ix = i;
					}
				}
				if (targetY < 0) {
					targetY = Math.abs(targetY);
					for (int i = 1; y < targetY; i += 4) {
						y += fib(i);
						iy = i;
					}
				}
				if (targetY > 0) {
					for (int i = 3; y < targetY; i += 4) {
						y += fib(i);
						iy = i;

					}
				}
				System.out.println(Math.max(ix, iy));
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found...");
		}
	}

	public static long fib(int n) {
		if (fib_nums[n] > 0)
			return fib_nums[n];
		else {
			fib_nums[n] = fib(n - 1) + fib(n - 2);
			return fib_nums[n];
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
