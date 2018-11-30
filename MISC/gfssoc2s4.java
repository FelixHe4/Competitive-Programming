package Unit2;
import java.io.*;
import java.util.*;
public class gfssoc2s4 {
	static class Edge implements Comparable<Edge> {
		int ev, cost;

		public Edge(int ev0, int cost0) {
			ev = ev0;
			cost = cost0;
		}

		public int compareTo(Edge o) {
			return cost - o.cost;
		}
	}

	static class CEdge {
		int bv, ev, cost;

		public CEdge(int bv0, int ev0, int cost0) {
			bv = bv0;
			ev = ev0;
			cost = cost0;
		}
	}

	static ArrayList<Edge>[] a;
	static ArrayList<Edge>[] b;
	static ArrayList<CEdge> c;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		a = new ArrayList[n + 1];
		b = new ArrayList[n + 1];
		c = new ArrayList<CEdge>();
		for (int i = 0; i < a.length; i++) {
			a[i] = new ArrayList<Edge>();
			b[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < m; i++) {
			int bv = readInt(), ev = readInt(), cost = readInt();
			Edge x = new Edge(ev, cost);
			Edge y = new Edge(bv, cost);
			a[bv].add(x);
			b[ev].add(y);
		}
		int d = readInt();
		for (int i = 0; i < d; i++) {
			int bv = readInt(), ev = readInt(), cost = readInt();
			CEdge x = new CEdge(bv, ev, cost);
			c.add(x);
		}
		int[] step1 = new int[n + 1];
		int[] step2 = new int[n + 1];
		Arrays.fill(step1, Integer.MAX_VALUE);
		Arrays.fill(step2, Integer.MAX_VALUE);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(1, 0));
		step1[1] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (int i = 0; i < a[cur.ev].size(); i++) {
				if (a[cur.ev].get(i).cost != 0 && step1[a[cur.ev].get(i).ev] > step1[cur.ev] + a[cur.ev].get(i).cost) {
					step1[a[cur.ev].get(i).ev] = step1[cur.ev] + a[cur.ev].get(i).cost;
					pq.add(new Edge(a[cur.ev].get(i).ev, step1[a[cur.ev].get(i).ev]));
				}
			}
		}

		pq.add(new Edge(n, 0));
		step2[n] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (int i = 0; i < b[cur.ev].size(); i++) {
				if (b[cur.ev].get(i).cost != 0 && step2[b[cur.ev].get(i).ev] > step2[cur.ev] + b[cur.ev].get(i).cost) {
					step2[b[cur.ev].get(i).ev] = step2[cur.ev] + b[cur.ev].get(i).cost;
					pq.add(new Edge(b[cur.ev].get(i).ev, step2[b[cur.ev].get(i).ev]));
				}
			}
		}
		int ans = step1[n];
		for (CEdge cindy : c) {
			int x = cindy.bv;
			int y = cindy.ev;
			int cost = cindy.cost;
			if (step1[x] != Integer.MAX_VALUE && step2[y] != Integer.MAX_VALUE) {
				ans = Math.min(ans, step1[x] + step2[y] + cost);
			}
		}
		if (ans == Integer.MAX_VALUE) {
			println(-1);
			exit();
		}
		println(ans);
		exit();
	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static String readLine() throws IOException {
		byte[] buf = new byte[64]; // line length
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
