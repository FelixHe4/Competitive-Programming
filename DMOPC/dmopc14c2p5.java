package Unit2;
import java.io.*;
import java.util.*;
public class dmopc14c2p5 {
	static int n;
	static int m;
	static ArrayList<Integer>[] grid;
	// static int[] paths;
	// static boolean[] vis;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		grid = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			grid[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int a = readInt();
			int b = readInt();
			grid[a].add(b);
		}
		// System.out.println(Arrays.toString(grid));
		// System.out.println(Arrays.toString(rows));
		// paths = new int[n + 1];
		// vis = new boolean[n + 1];
		// int start = 1;
		// vis[start] = true;
		// dfs(start, 1);
		double[] ppn = new double[n + 1];
		ppn[0] = 1;
		ppn[1] = 1;
		for (int i = 1; i < n + 1; i++) {
			double tp = 0.0;
			if (grid[i].size() == 1 && ppn[i] == 0) {
				ppn[i] = ppn[i - 1];
			}
			else {
				tp += grid[i].size();
				for (int j = 0; j < grid[i].size(); j++) {
					if (ppn[grid[i].get(j)] == 0) {
						ppn[grid[i].get(j)] = (double) ppn[i] / tp;
					}
					else {
						ppn[grid[i].get(j)] += (double) ppn[i] / tp;
					}
				}
			}
		}
		// System.out.println(Arrays.toString(ppn));
		// System.out.println(Arrays.toString(paths));
		// System.out.println(Arrays.toString(connected));
		for (int i = 1; i < n + 1; i++) {
			if (grid[i].isEmpty()) {
				System.out.println(ppn[i]);
			}
		}
	}

	// public static void dfs(int x, int mul) {
	// for (int i : grid[x]) {
	// if (!vis[i]) {
	// vis[i] = true;
	// dfs(i, doublepaths[x][i]);
	// }
	// if (grid[i].isEmpty()) {
	// paths[i] = mul;
	// }
	// }
	// }

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
