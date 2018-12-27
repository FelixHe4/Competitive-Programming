package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class vmss7wc15c4p3 {
	public static class Edge implements Comparable<Edge> {
		int ev, cost;

		public Edge(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
		}

		public int compareTo(Edge o) {
			return cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		ArrayList<Edge>[] a = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < m; i++) {
			int c1 = readInt(), c2 = readInt(), cost = readInt();
			a[c1].add(new Edge(c2, cost));
			a[c2].add(new Edge(c1, cost));
		}
		int[] step = new int[n];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(0, 0));
		Arrays.fill(step, 1 << 30);
		step[0] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.cost > step[cur.ev]) {
				continue;
			}
			for (Edge e : a[cur.ev]) {
				if (step[e.ev] > step[cur.ev] + e.cost) {
					step[e.ev] = step[cur.ev] + e.cost;
					pq.add(new Edge(e.ev, step[e.ev]));
				}
			}
		}
		int[] step2 = new int[n];
		pq = new PriorityQueue<Edge>();
		Arrays.fill(step2, 1 << 30);
		step2[n - 1] = 0;
		pq.add(new Edge(n - 1, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.cost > step2[cur.ev]) {
				continue;
			}
			for (Edge e : a[cur.ev]) {
				if (step2[e.ev] > step2[cur.ev] + e.cost) {
					step2[e.ev] = step2[cur.ev] + e.cost;
					pq.add(new Edge(e.ev, step2[e.ev]));
				}
			}
		}
		long max = Long.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (max < step[i] + step2[i]) {
				max = step[i] + step2[i];
			}
		}
		System.out.println(max);
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
