package Unit2;
import java.io.*;
import java.util.*;
public class cco12p4 {

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[][] grid = new int[n + 1][81];
		int[][] step = new int[n + 1][81];
		int[] ender = new int[n + 1];
		for (int i = 0; i < n; i++) {
			int end = readInt();
			ender[i] = end;
			Arrays.fill(grid[i], 0, end, 1);
		}
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(step[i], Integer.MAX_VALUE);
		}
		System.out.println();
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < 81; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		int startX = readInt();
		int startY = readInt();
		int endX = readInt();
		int endY = readInt();
		Queue<Integer> rowQ = new LinkedList<Integer>();
		Queue<Integer> colQ = new LinkedList<Integer>();
		rowQ.add(startX);
		colQ.add(startY);
		while (!rowQ.isEmpty()) {
			int curY = rowQ.poll();
			int curX = colQ.poll();
			if (curX - 1 < 0 && step[ender[curY - 1]][curY - 1] > step[curX][curY] + 1 && grid[ender[curY - 1]][curY - 1] != 1) {
				step[ender[curY - 1]][curY - 1] = step[curX][curY] + 1;
				rowQ.add(ender[curY - 1] - 1);
				colQ.add(curY - 1);
			}
			if (curY + 1 < n && curX + 1 > ender[curY] && step[0][curY + 1] > step[curX][curY] + 1 && grid[0][curY + 1] != 1) {
				step[0][curY + 1] = step[curX][curY] + 1;
				rowQ.add(0);
				colQ.add(curY + 1);
			}
			if (curX - 1 >= 0 && step[curX - 1][curY] > step[curX][curY] + 1 && step[curX - 1][curY] == 1) {
				step[curX - 1][curY] = step[curX][curY] + 1;
				rowQ.add(curX - 1);
				colQ.add(curY);
			}
			if (curX + 1 < n && step[curX + 1][curY] > step[curX][curY] + 1 && step[curX + 1][curY] == 1) {
				step[curX + 1][curY] = step[curX][curY] + 1;
				rowQ.add(curX + 1);
				colQ.add(curY);
			}
			if (curY - 1 >= 0 && step[curX][curY - 1] > step[curX][curY] + 1 && step[curX][curY + 1] == 1) {
				step[curX][curY - 1] = step[curX][curY] + 1;
				rowQ.add(curX);
				colQ.add(curY - 1);
			}
			if (curY + 1 < n && step[curX][curY + 1] > step[curX][curY] + 1 && step[curX][curY - 1] == 1) {
				step[curX][curY + 1] = step[curX][curY] + 1;
				rowQ.add(curX);
				colQ.add(curY + 1);
			}
		}
		System.out.println();
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < 81; j++) {
				System.out.print(step[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(step[endX][endY]);
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
		return readLine().charAt(0);
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
