package Unit2;
import java.io.*;
import java.util.*;
import Unit2.cco12p2.E;
public class cco15p2 {
	public static class Edge {
		int ev;
		int cost;

		public Edge(int ev0, int cost0) {
			ev = ev0;
			cost = cost0;
		}
	}

	static int n;
	static ArrayList<Edge>[] grid;
	static int[][] dp;
	static int vis;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		n = readInt();
		int m = readInt();
		dp = new int[20][1 << 18];
		grid = new ArrayList[n];
		vis = 1;
		for (int i = 0; i < grid.length; i++) {
			grid[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < m; i++) {
			int c1 = readInt();
			int c2 = readInt();
			int cost = readInt();
			grid[c1].add(new Edge(c2, cost));
		}
		System.out.println(dfs(0, vis));
	}

	public static int dfs(int x, int vis) {
		if (dp[x][vis] != -1) {
			return dp[x][vis];
		}
		if (x == n - 1) {
			return 0;
		}
		int b = -(1 << 30);
		for (int i = 0; i < grid[x].size(); i++) {
			if ((vis & (1 << grid[x].get(i).ev)) > 0) {
				continue;
			}
			b = Math.max(b, grid[x].get(i).cost + dfs(grid[x].get(i).ev, vis | 1 << grid[x].get(i).ev));
		}
		return dp[x][vis] = b;
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
