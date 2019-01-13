package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class nccc1s4 {
	static class Edge {
		int ev, c, d;

		public Edge(int ev, int c, int d) {
			this.ev = ev;
			this.c = c;
			this.d = d;
		}
	}

	static ArrayList<Edge>[] a;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		int s = readInt(), t = readInt();
		a = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			a[i] = new ArrayList<Edge>();
		}
		Set<Integer> store = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			int c1 = readInt(), c2 = readInt(), c3 = readInt(), c4 = readInt();
			if ((c1 >= 1 && c1 <= n) && (c2 >= 1 && c2 <= n)) {
				a[c1].add(new Edge(c2, c3, c4));
				store.add(c4 + 1);
				// store.add(c3);
//				store.add(c4 - 1);
//				// store.add(c4 + 1);
				store.add(c3);
//				store.add(c3 + 1);

			}
		}
//		store.add(1);
//		store.add(k - 2);
//		store.add(k - 3);
//		store.add(2);
//		store.add(k);
		// store.add(k + 1);
		// System.out.println(store.size());
		// store.add(k);
		long count = 0;
		// store.add(1);
		ArrayList<Integer> aaa = new ArrayList<Integer>();
		aaa.addAll(store);
		Collections.sort(aaa);
		// System.out.println(store);
		// System.out.println(aaa);
		for (int i = 0; i < aaa.size() - 1; i++) {
			int limit = aaa.get(i);
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(s);
			boolean[] vis = new boolean[n + 1];
			vis[s] = true;
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (Edge e : a[cur]) {
					if (!vis[e.ev] && e.c <= limit && limit <= e.d) {
						vis[e.ev] = true;
						q.add(e.ev);
					}
				}
			}
			if (vis[t]) {
				count += aaa.get(i + 1) - aaa.get(i);
			}
		}
		System.out.println(count);
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
