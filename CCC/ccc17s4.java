package Unit1;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class ccc17s4 {
	public static class Edge implements Comparable<Edge> {
		int bv, ev, cost, active;

		public Edge(int bv, int ev, int cost, int active) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
			this.active = active;
		}

		public int compareTo(Edge o) {
			return cost - o.cost == 0 ? active - o.active : cost - o.cost;
		}
	}

	static int find(int n) {
		if (dsu[n] == n) {
			return n;
		} else {
			return dsu[n] = find(dsu[n]);
		}
	}

	static Edge[] Edge;
	static int[] dsu, rank;

	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), d = readInt();
		Edge = new Edge[m];
		dsu = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 0; i < dsu.length; i++) {
			dsu[i] = i;
		}
		for (int i = 0; i < m; i++) {
			int c1 = readInt(), c2 = readInt(), cost = readInt();
			if (i < n - 1) {
				Edge[i] = new Edge(c1, c2, cost, 0);
			} else {
				Edge[i] = new Edge(c1, c2, cost, 1);
			}
		}
		Arrays.sort(Edge);
		int days = 0;
		int curM = 0;
		int curA = 0;
		int maxC = Integer.MIN_VALUE;
		for (Edge e : Edge) {
			if (curM == n - 1) {
				break;
			}
			int bv = e.bv, ev = e.ev, c = e.cost, active = e.active;
			int fa = find(bv);
			int fb = find(ev);
			if (fa != fb) {
				if (rank[fa] > rank[fb]) {
					dsu[fb] = fa;
				} else {
					dsu[fa] = fb;
					if (rank[fa] == rank[fb]) {
						rank[fb]++;
					}
				}
				maxC = c;
				curM++;
				days += active;
				curA = active;
			}
		}
		if (curA == 1) {
			// if the biggest weight tube is currently not being used
			for (int i = 0; i < dsu.length; i++) {
				dsu[i] = i;
			}
			rank = new int[n + 1];
			for (Edge e : Edge) {
				int bv = e.bv;
				int ev = e.ev;
				int cost = e.cost;
				int fa = find(bv);
				int fb = find(ev);
				if (fa != fb) {
					if (cost < maxC || cost == maxC && e.active == 0) {
						// cost is less than the largest tube's cost or
						// cost is the max tube and the max tube is being used
						// add it to the disjoint set
						if (rank[fa] > rank[fb]) {
							dsu[fb] = fa;
						} else {
							dsu[fa] = fb;
							if (rank[fa] == rank[fb]) {
								rank[fb]++;
							}
						}
					} else if (e.active == 0 && cost - d <= 0) {
						// if the tube is being used and if the cost of the tube subtract the super tube is less than 0, that means use the
						// super tube. this means we use the tube and reduce days by 1.
						days--;
						break;
					}
				}
			}

		}
		System.out.println(days);
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
