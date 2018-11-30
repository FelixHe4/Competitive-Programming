package Unit2;
import java.io.*;
import java.util.*;
public class cco11p2 {
	public static class Edge implements Comparable<Edge> {
		int ev;
		int cost;
		int stat;

		public Edge(int ev, int cost, int stat) {
			this.ev = ev;
			this.cost = cost;
			this.stat = stat;
		}

		public int compareTo(Edge o) {
			return cost - o.cost;
		}
	}

	static int s;
	static int n;
	static int edges;
	static ArrayList<Edge>[] a;
	static int[][] sto;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		s = readInt();
		n = readInt();
		edges = readInt();
		sto = new int[n + 1][s + 1];
		a = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < sto.length; i++) {
			Arrays.fill(sto[i], 1 << 30);
		}
		for (int i = 0; i < edges; i++) {
			int c1 = readInt();
			int c2 = readInt();
			int cost = readInt();
			int stat = readInt();
			if (stat == 1) {
				a[c1].add(new Edge(c2, cost, cost));
				a[c2].add(new Edge(c1, cost, cost));
			}
			else {
				a[c1].add(new Edge(c2, cost, 0));
				a[c2].add(new Edge(c1, cost, 0));
			}
		}
		Djikstras();
		Arrays.sort(sto[n - 1]);
		if (sto[n - 1][0] == 1 << 30) {
			System.out.println(-1);
		}
		else {
			System.out.println(sto[n - 1][0]);
		}
	}

	public static void Djikstras() {
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		q.add(new Edge(0, 0, 0));
		sto[0][0] = 0;
		while (!q.isEmpty()) {
			Edge now = q.poll();
			for (Edge Do : a[now.ev]) {
				if (now.stat + Do.stat <= s && sto[now.ev][now.stat] + Do.cost < sto[Do.ev][now.stat + Do.stat]) {
					sto[Do.ev][now.stat + Do.stat] = sto[now.ev][now.stat] + Do.cost;
					q.add(new Edge(Do.ev, sto[Do.ev][now.stat + Do.stat], now.stat + Do.stat));
				}
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
