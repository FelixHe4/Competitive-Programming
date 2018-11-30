package Unit2;
import java.io.*;
import java.util.*;
public class Djikstras {
	public static class Edge {
		int ev;
		int cost;

		public Edge(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
		}
	}

	public static class Node implements Comparable<Node> {
		int v;
		int step;

		public Node(int v, int step) {
			this.v = v;
			this.step = step;
		}

		public int compareTo(Node o) {
			return this.step - o.step;
		}
	}

	static ArrayList<Edge>[] a;
	static int v;
	static int e;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		v = readInt();
		e = readInt();
		a = new ArrayList[v + 1];
		for (int i = 0; i < v + 1; i++) {
			a[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < e; i++) {
			int c1 = readInt();
			int c2 = readInt();
			int cost = readInt();
			a[c1].add(new Edge(c2, cost));
			a[c2].add(new Edge(c1, cost));
		}
		Djikstra(1, 3);
	}

	public static void Djikstra(int start, int end) {
		int[] step = new int[v + 1];
		boolean[] vis = new boolean[v + 1];
		Arrays.fill(step, Integer.MAX_VALUE);
		step[start] = 0;
		vis[start] = true;
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(1, step[1]));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			ArrayList<Edge> neighbour = a[cur.v];
			for (int i = 0; i < neighbour.size(); i++) {
				Edge e = neighbour.get(i);
				if (step[e.ev] > step[cur.v] + e.cost) {
					step[e.ev] = step[cur.v] + e.cost;
					q.add(new Node(e.ev, step[e.ev]));
				}
			}
		}
		System.out.println(step[end]);
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
