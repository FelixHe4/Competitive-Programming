package Unit2;
import java.io.*;
import java.util.*;
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
	static int max = 0;
	static int start;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		q = readInt();
		a = new ArrayList[n + 1];
		vis = new boolean[n + 1];
		for (int i = 0; i < a.length; i++) {
			a[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < m; i++) {
			int bv = readInt(), ev = readInt(), cost = readInt();
			a[bv].add(new Edge(ev, cost));
			a[ev].add(new Edge(bv, cost));
		}
		if (q == 1) {
			vis[1] = true;
			int x = dfs(1, 0);
			vis = new boolean[n + 1];
			vis[x] = true;
			int z = diameter(x, 0);
			int extra = (n - 1) - m;
			System.out.println(z + extra);
		} else if (q == 2) {

		}
	}

	static int dfs(int curr, int dist) {
		if (dist > max) {
			start = curr;
			max = dist;
		}
		for (Edge e : a[curr]) {
			if (!vis[e.ev]) {
				vis[e.ev] = true;
				dfs(e.ev, dist + e.cost);
			}
		}
		return start;
	}

	static int diameter(int curr, int dist) {
		if (dist > max) {
			max = dist;
		}
		for (Edge e : a[curr]) {
			if (!vis[e.ev]) {
				vis[e.ev] = true;
				diameter(e.ev, dist + e.cost);
			}
		}
		return max;
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
