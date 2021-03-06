package Unit2;
import java.io.*;
import java.util.*;
public class wc161s2 {
	public static class Edge {
		int ev;
		int cost;

		public Edge(int ev0, int cost0) {
			ev = ev0;
			cost = cost0;
		}
	}

	static ArrayList<Edge>[] grid;
	static boolean[] vis;
	static boolean[] pho;
	static int n, x, k, max;
	static int[] parents;
	static int dis;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		n = readInt();
		x = n - 1;
		int k = readInt();
		grid = new ArrayList[n + 1];
		vis = new boolean[n + 1];
		pho = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			grid[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < x; i++) {
			int c1 = readInt();
			int c2 = readInt();
			int cost = readInt();
			grid[c1].add(new Edge(c2, cost));
			grid[c2].add(new Edge(c1, cost));
		}
		for (int i = 0; i < k; i++) {
			pho[readInt()] = true;
		}
		dfs(1, 0);
		System.out.println(dis);
	}

	public static boolean dfs(int node, int prev) {
		int cur = 0;
		if (pho[node] == false) {
			cur = 0;
		}
		else {
			cur = 1;
		}
		for (Edge i : grid[node]) {
			if (i.ev == prev) {
				continue;
			}
			if (dfs(i.ev, node)) {
				cur = 1;
			}
		}
		for (Edge i : grid[node]) {
			if (i.ev == prev) {
				continue;
			}
			if (pho[i.ev] && cur > 0) {
				dis += i.cost;
			}
		}
		if (cur > 0) {
			return pho[node] = true;
		}
		else {
			return pho[node] = false;
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
