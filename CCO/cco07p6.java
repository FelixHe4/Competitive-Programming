package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class cco07p6 {
	public static class Edge {
		int bv, ev;

		public Edge(int bv, int ev) {
			this.bv = bv;
			this.ev = ev;
		}
	}

	static ArrayList<Edge>[] a;
	static Edge[] Edge;
	static boolean[] vis;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		a = new ArrayList[n + 1];
		Edge = new Edge[m];
		vis = new boolean[n + 1];
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < m; i++) {
			int c1 = readInt(), c2 = readInt();
			Edge[i] = new Edge(c1, c2);
			a[c1].add(new Edge(c1, c2));
			a[c2].add(new Edge(c2, c1));
		}
		for (Edge e : Edge) {
			dfs(1, e.bv, e.ev);
			for (int i = 1; i < vis.length; i++) {
				if (!vis[i]) {
					System.out.println(e.bv + " " + e.ev);
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}

	static void dfs(int start, int c1, int c2) {
		for (int i = 0; i < a[start].size(); i++) {
			if ((start == c1 && a[start].get(i).ev == c2) || (start == c2 && a[start].get(i).ev == c1)) {
				continue;
			} else {
				if (!vis[a[start].get(i).ev]) {
					vis[a[start].get(i).ev] = true;
					dfs(a[start].get(i).ev, c1, c2);
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
