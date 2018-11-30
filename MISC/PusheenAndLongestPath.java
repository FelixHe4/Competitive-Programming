package Unit2;
import java.io.*;
import java.util.*;
public class PusheenAndLongestPath {

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int[][] grid = new int[n][m];
		int[][] step = new int[n][m];
		int rowA = 0, colA = 0;
		int rowP = 0, colP = 0;
		int rowJ = 0, colJ = 0;
		for (int i = 0; i < n; i++) {
			Arrays.fill(step[i], 1 << 30);
		}
		readLine();
		for (int i = 0; i < n; i++) {
			String s = readLine();
			for (int j = 0; j < m; j++) {
				if (s.charAt(j) == 'A') {
					rowA = i;
					colA = j;
				}
				if (s.charAt(j) == 'X') {
					grid[i][j] = -1;
					continue;
				}
				if (s.charAt(j) == 'P') {
					rowP = i;
					colP = j;
				}
				if (s.charAt(j) == 'J') {
					rowJ = i;
					colJ = j;
				}
				grid[i][j] = 1;
			}
		}
		Queue<Integer> rowQ = new LinkedList<Integer>();
		Queue<Integer> colQ = new LinkedList<Integer>();
		rowQ.add(rowP);
		colQ.add(colP);
		step[rowP][colP] = 0;
		while (!rowQ.isEmpty()) {
			int curR = rowQ.poll();
			int curC = colQ.poll();
			if (curR - 1 >= 0 && step[curR - 1][curC] > step[curR][curC] + 1 && grid[curR - 1][curC] > 0) {
				step[curR - 1][curC] = step[curR][curC] + 1;
				rowQ.add(curR - 1);
				colQ.add(curC);
			}
			if (curR + 1 < n && step[curR + 1][curC] > step[curR][curC] + 1 && grid[curR + 1][curC] > 0) {
				step[curR + 1][curC] = step[curR][curC] + 1;
				rowQ.add(curR + 1);
				colQ.add(curC);
			}
			if (curC - 1 >= 0 && step[curR][curC - 1] > step[curR][curC] + 1 && grid[curR][curC - 1] > 0) {
				step[curR][curC - 1] = step[curR][curC] + 1;
				rowQ.add(curR);
				colQ.add(curC - 1);
			}
			if (curC + 1 < m && step[curR][curC + 1] > step[curR][curC] + 1 && grid[curR][curC + 1] > 0) {
				step[curR][curC + 1] = step[curR][curC] + 1;
				rowQ.add(curR);
				colQ.add(curC + 1);
			}
		}
		int d1 = step[rowA][colA];
		for (int i = 0; i < step.length; i++) {
			Arrays.fill(step[i], 1 << 30);
		}
		rowQ = new LinkedList<Integer>();
		colQ = new LinkedList<Integer>();
		rowQ.add(rowA);
		colQ.add(colA);
		step[rowA][colA] = 0;
		while (!rowQ.isEmpty()) {
			int curR = rowQ.poll();
			int curC = colQ.poll();
			if (curR - 1 >= 0 && step[curR - 1][curC] > step[curR][curC] + 1 && grid[curR - 1][curC] > 0) {
				step[curR - 1][curC] = step[curR][curC] + 1;
				rowQ.add(curR - 1);
				colQ.add(curC);
			}
			if (curR + 1 < n && step[curR + 1][curC] > step[curR][curC] + 1 && grid[curR + 1][curC] > 0) {
				step[curR + 1][curC] = step[curR][curC] + 1;
				rowQ.add(curR + 1);
				colQ.add(curC);
			}
			if (curC - 1 >= 0 && step[curR][curC - 1] > step[curR][curC] + 1 && grid[curR][curC - 1] > 0) {
				step[curR][curC - 1] = step[curR][curC] + 1;
				rowQ.add(curR);
				colQ.add(curC - 1);
			}
			if (curC + 1 < m && step[curR][curC + 1] > step[curR][curC] + 1 && grid[curR][curC + 1] > 0) {
				step[curR][curC + 1] = step[curR][curC] + 1;
				rowQ.add(curR);
				colQ.add(curC + 1);
			}
		}
		int d2 = step[rowJ][colJ];
		if (d2 == 1 << 30 || d1 == 1 << 30) {
			System.out.println(-1);
		}
		else {
			System.out.println(d1 + d2);
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