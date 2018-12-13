package Unit2;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class dmopc18c4p5 {
	static class Edge {
		int ev, cost, uses, used;

		public Edge(int ev, int cost, int uses, int used) {
			this.ev = ev;
			this.cost = cost;
			this.uses = uses;
			this.used = used;
		}
	}

	static class Pair implements Comparable<Pair> {
		int index, cost;

		public Pair(int index, int cost) {
			this.cost = cost;
			this.index = index;
		}

		public int compareTo(Pair o) {
			return o.cost - cost;
		}
	}

	static ArrayList<Edge>[] a;
	static int max, start;
	static int[] vis;
	static boolean[] vis1;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		a = new ArrayList[n + 1];
		vis = new int[n + 1];
		Arrays.fill(vis, 1);
		for (int i = 0; i < n + 1; i++) {
			a[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < k; i++) {
			int x = readInt();
			vis[x - 1] = 2;
		}
		for (int i = 0; i < n - 1; i++) {
			int c1 = readInt(), c2 = readInt(), cost = readInt();
			if (vis[i] == 2) {
				a[c1].add(new Edge(c2, cost, 2, 0));
				a[c2].add(new Edge(c1, cost, 2, 0));
			} else {
				a[c1].add(new Edge(c2, cost, 1, 0));
				a[c2].add(new Edge(c1, cost, 1, 0));
			}
		}
		vis1 = new boolean[n + 1];
		max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(longest(i, 0), max);
		}
		System.out.println(max);
	}

	public static int longest(int x, int d) {
		if (d > max) {
			max = d;
		}
		for (Edge e : a[x]) {
			if (e.used < e.uses) {
				e.used++;
				for (int i = 0; i < a[e.ev].size(); i++) {
					if (a[e.ev].get(i).ev == x) {
						a[e.ev].get(i).used++;
						break;
					}
				}
				longest(e.ev, d + e.cost);
				e.used--;
				for (int i = 0; i < a[e.ev].size(); i++) {
					if (a[e.ev].get(i).ev == x) {
						a[e.ev].get(i).used--;
						break;
					}
				}
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