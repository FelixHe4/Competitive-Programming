package Unit1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class ccc14s4 {
	static long[][] grid;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int k = readInt();
		int[][] arr = new int[n][5];
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		TreeSet<Integer> xx = new TreeSet<Integer>();
		TreeSet<Integer> yy = new TreeSet<Integer>();
		HashMap<Integer, Integer> compressX = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> compressY = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int xL = readInt(), yT = readInt(), xR = readInt(), yB = readInt(), t = readInt();
			arr[i][0] = xL;
			arr[i][1] = yT;
			arr[i][2] = xR;
			arr[i][3] = yB;
			arr[i][4] = t;
			xx.add(xL);
			compressX.put(xL, 0);
			xx.add(xR);
			compressX.put(xR, 0);
			yy.add(yT);
			compressY.put(yT, 0);
			yy.add(yB);
			compressY.put(yB, 0);
		}
		x.addAll(xx);
		y.addAll(yy);
		Collections.sort(x);
		Collections.sort(y);
		grid = new long[2005][2005];
		for (int i = 1; i < compressX.size() + 1; i++) {
			compressX.put(x.get(i - 1), i);
		}
		for (int i = 1; i < compressY.size() + 1; i++) {
			compressY.put(y.get(i - 1), i);
		}
//		System.out.println(compressX);
//		System.out.println(compressY);
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		for (int i = 0; i < n; i++) {
			compute(compressX.get(arr[i][0]), compressY.get(arr[i][1]), compressX.get(arr[i][2]), compressY.get(arr[i][3]), arr[i][4]);
		}
		long t = 0;
		for (int i = 1; i < x.size(); i++) {
			for (int j = 1; j < y.size(); j++) {
				grid[i][j] += grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1];
				if (grid[i][j] >= k) {
					t += ((long) x.get(i) - x.get(i - 1)) * ((long) y.get(j) - y.get(j - 1));
				}
			}
		}
//		for (int i = 0; i < x.size(); i++) {
//			for (int j = 0; j < y.size(); j++) {
//				System.out.print(grid[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(t);
//		for (int i = 0; i < a.size() + 2; i++) {
//			System.out.println(Arrays.toString(psa[i]));
//		}
	}

	public static void compute(int x, int y, int w, int h, int v) {
		grid[x][y] += v;
		grid[x][h] -= v;
		grid[w][y] -= v;
		grid[w][h] += v;
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
