package Unit2;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
public class tle16c4p4 {
	static class Edge {
		int ev, cost;

		public Edge(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
		}
	}

	static int n, m, q;
	static ArrayList<Edge>[] a;
	static boolean[] vis;
	static long[] step1, step2, recDown, diameter, radius;
	static long max, start, radius1, radius2;
	static int sets;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		q = readInt();
		max = 0;
		radius1 = 0;
		radius2 = 0;
		a = new ArrayList[n + 1];
		vis = new boolean[n + 1];
		step1 = new long[n + 1];
		step2 = new long[n + 1];
		recDown = new long[n + 1];
		diameter = new long[n + 1];
		radius = new long[n + 1];
		Arrays.fill(radius, Long.MAX_VALUE);
		for (int i = 0; i < a.length; i++) {
			a[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < m; i++) {
			int bv = readInt(), ev = readInt(), cost = readInt();
			a[bv].add(new Edge(ev, cost));
			a[ev].add(new Edge(bv, cost));
		}
		sets = 0;
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				// not necessarily a connected graph.
				dfs(i, -1);
				diameter(i, -1, 0);
				sets++;
			}
		}
		long disjoint = sets - 1;
		for (int i = 0; i < sets; i++) {
			if (radius[i] == radius1) {
				radius2++;
			} else if (radius[i] > radius1) {
				radius1 = radius[i];
				radius2 = 1;
			}
			disjoint += diameter[i];
		}
		if (q == 1) {
			System.out.println(disjoint);
		} else if (q == 2) {
			if (radius2 != 1) {
				println(radius1 + 1);
			} else {
				println(radius1);
			}
		}
		exit();
	}

	static long dfs(int cur, int parent) {
		vis[cur] = true;
		for (Edge e : a[cur]) {
			if (e.ev == parent) {
				continue;
			}
			long rec = dfs(e.ev, cur);
			// longest path
			if (rec + e.cost > step1[cur]) {
				recDown[cur] = e.ev;
				step2[cur] = step1[cur];
				step1[cur] = e.cost + rec;
			} else if (rec + e.cost > step2[cur]) {
				step2[cur] = rec + e.cost;
				// second longest path.
			}
		}
		return step1[cur];
	}

	static void diameter(int cur, int parent, long cost) {
		diameter[sets] = Math.max(diameter[sets], step1[cur] + Math.max(cost, step2[cur]));
		radius[sets] = Math.min(radius[sets], Math.max(step1[cur], cost));
		for (Edge e : a[cur]) {
			if (e.ev == parent) {
				continue;
			} else if (e.ev == recDown[cur]) {
				diameter(e.ev, cur, e.cost + Math.max(cost, step2[cur]));
			} else {
				diameter(e.ev, cur, e.cost + Math.max(cost, step1[cur]));
			}
		}
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
