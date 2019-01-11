package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class cco14p2 {
	public static class Edge implements Comparable<Edge> {
		int ev, cost, scost;
		boolean type;

		public Edge(int ev, int cost, int scost, boolean type) {
			this.ev = ev;
			this.cost = cost;
			this.scost = scost;
			this.type = type;
		}

		public int compareTo(Edge o) {
			return cost - o.cost;
		}
	}

	static class Pair implements Comparable<Pair> {
		int a, b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int compareTo(Pair o) {
			if (b == o.b) {
				return a - o.a;
			}
			return b - o.b;
		}
	}

	static class Edges {
		int bv, ev, cost, scost;

		public Edges(int bv, int ev, int cost, int scost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
			this.scost = scost;
		}
	}

	static int n;
	static int[] startStep, endStep;
	static ArrayList<Edge>[] a;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		n = readInt();
		int m = readInt(), start = readInt(), end = readInt();
		startStep = new int[n + 1];
		endStep = new int[n + 1];
		a = new ArrayList[n + 1];
		Edges[] Edge = new Edges[m];
		for (int i = 0; i < n + 1; i++) {
			a[i] = new ArrayList<Edge>();
		}
		int count = 0;
		for (int i = 0; i < m; i++) {
			int c1 = readInt(), c2 = readInt(), cost = readInt(), scost = readInt();
			a[c1].add(new Edge(c2, cost, scost, true));
			a[c2].add(new Edge(c1, cost, scost, false));
			Edge[count++] = new Edges(c1, c2, cost, scost);
		}
		Pair[] Pair = new Pair[m];
		dijkstras(start, startStep, true);
		dijkstras(end, endStep, false);
		count = 0;
		for (Edges e : Edge) {
			if (startStep[e.bv] != 1 << 30 && endStep[e.ev] != 1 << 30) {
				Pair[count++] = new Pair(e.scost, startStep[e.bv] + endStep[e.ev] + e.cost);
			} else {
				Pair[count++] = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
			}
		}
		Arrays.sort(Pair);
		int[] psa = new int[m];
		for (int i = 0; i < m; i++) {
			if (i == 0) {
				psa[i] = Pair[i].a;
			} else {
				psa[i] += psa[i - 1] + Pair[i].a;
			}
		}
		int q = readInt();
		while (q-- > 0) {
			int a = readInt();
			int ans = -1;
			int low = 0, mid = 0, high = m - 1;
			while (low <= high) {
				mid = (low + high) / 2;
				if (Pair[mid].b <= a) {
					ans = mid;
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			System.out.println(ans == -1 ? 0 : psa[ans]);
		}
	}

	static void dijkstras(int start, int step[], boolean type) {
		boolean[] vis = new boolean[n + 1];
		Arrays.fill(step, 1 << 30);
		step[start] = 0;
		vis[start] = true;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(start, 0, 0, type));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.cost > step[cur.ev]) {
				continue;
			}
			for (Edge e : a[cur.ev]) {
				if (type == e.type) {
					if (step[e.ev] > step[cur.ev] + e.cost) {
						step[e.ev] = step[cur.ev] + e.cost;
						pq.add(new Edge(e.ev, step[e.ev], 0, type));
					}
				}
			}
		}
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
