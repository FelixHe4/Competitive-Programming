package ecoo18r1;
import java.util.*;
import java.io.*;
public class ecoo18r1p3 {

	public static void main(String[] args) throws IOException {
		try {

			for (int test = 0; test < 10; test++) {// change to # test cases
				int n, x, y, z;
				String[] initNums = br.readLine().split(" ");
				n = Integer.parseInt(initNums[0]);
				x = Integer.parseInt(initNums[1]);
				y = Integer.parseInt(initNums[2]);
				z = Integer.parseInt(initNums[3]);
				String[] output = new String[n];
				ArrayList<Integer> fail = new ArrayList<>();
				boolean anyFalse = false;
				for (int c = 0; c < n; c++) {
					String in = br.readLine(), out = "";
					for (int i = 0; i < in.length(); i++) {
						int num = Integer.valueOf(in.charAt(i) + "");
						if (num == 0) {
							num = z;
						}
						else {
							if (num % 2 == 0) {
								num += x;
							}
							else {
								num -= y;
							}
							if (num < 0) {
								num = 0;
							}
						}
						out += num + "";
					}
					output[c] = out;
				}
				br.readLine();
				for (int c = 0; c < n; c++) {
					String an = br.readLine();
					if (output[c].equals(an))
						continue;
					anyFalse = true;
					fail.add(c + 1);
				}
				if (anyFalse) {
					System.out.print("FAIL: ");
					for (Integer s : fail) {
						System.out.print(s + "");
						if (fail.indexOf(s) != fail.size() - 1) {
							System.out.print(",");
						}
					}
					System.out.println();
				}
				else {
					System.out.println("MATCH");
				}
				br.readLine();
				fail.clear();
				anyFalse = false;
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found...");
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
