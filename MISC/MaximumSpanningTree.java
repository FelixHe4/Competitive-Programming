package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class MaximumSpanningTree {
	static class Edge implements Comparable<Edge> {
		int bv, ev, cost;

		public Edge(int bv, int ev, int cost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
		}

		public int compareTo(Edge o) {
			return o.cost - cost;
		}
	}

	static int find(int n) {
		if (dsu[n] == n) {
			return n;
		}
		return dsu[n] = find(dsu[n]);

	}

	static boolean dest() {
		for (int i = 0; i < dest.length; i++) {
			if (!vis[dest[i]]) {
				return false;
			}
		}
		return true;
	}

	static int[] dsu;
	static int[] dest;
	static boolean[] vis;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int d = readInt();
		dsu = new int[n + 1];
		Edge[] Edge = new Edge[m];
		vis = new boolean[n + 1];
		for (int i = 0; i < dsu.length; i++) {
			dsu[i] = i;
		}
		for (int i = 0; i < m; i++) {
			Edge[i] = new Edge(readInt(), readInt(), readInt());
		}
		Arrays.sort(Edge);
		dest = new int[d];
		for (int i = 0; i < dest.length; i++) {
			dest[i] = readInt();
		}
		int cur = 0;
		for (int i = 0; i < Edge.length; i++) {
			int a = Edge[i].bv;
			int b = Edge[i].ev;
			int c = Edge[i].cost;
			int fa = find(a);
			int fb = find(b);
			if (fa != fb) {
				dsu[fb] = fa;
				cur = c;
				vis[a] = vis[b] = true;
				if (dest()) {
					println(cur);
					exit();
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
