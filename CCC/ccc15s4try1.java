package Unit1;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
public class ccc15s4try1 {
	public static class Edge implements Comparable<Edge> {
		int ev, cost, hull;

		public Edge(int ev, int cost, int hull) {
			this.ev = ev;
			this.cost = cost;
			this.hull = hull;
		}

		public int compareTo(Edge o) {
			if (this.cost > o.cost) {
				return 1;
			}
			if (this.cost < o.cost) {
				return -1;
			}
			return 0;
		}
	}

	static int n, m, k;
	static int edges;
	static ArrayList<Edge>[] a;
	static int[][] dis;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		k = readInt();
		n = readInt();
		m = readInt();
		dis = new int[n + 1][k + 1];
		a = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			a[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < dis.length; i++) {
			Arrays.fill(dis[i], 1 << 30);
		}
		for (int i = 0; i < m; i++) {
			int c1 = readInt();
			int c2 = readInt();
			int cost = readInt();
			int hull = readInt();
			a[c1].add(new Edge(c2, cost, hull));
			a[c2].add(new Edge(c1, cost, hull));
		}
		int start = readInt(), end = readInt();
		Djikstras(start, end);
	}

	public static void Djikstras(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(start, 0, k));
		dis[start][0] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.ev == end) {
				System.out.println(cur.cost);
				return;
			}
			if (dis[cur.ev][cur.hull] < cur.cost) {
				continue;
			}
			for (Edge e : a[cur.ev]) {
				int hull = cur.hull - e.hull;
				if (hull > 0 && dis[e.ev][hull] > cur.cost + e.cost) {
					dis[e.ev][hull] = cur.cost + e.cost;
					pq.add(new Edge(e.ev, dis[e.ev][hull], hull));
				}
			}
		}
		System.out.println(-1);
	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static String readLine() throws IOException {
		byte[] buf = new byte[1000000]; // line length
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

	private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
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