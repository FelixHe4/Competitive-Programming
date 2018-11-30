package Unit2;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class LKPP4 {
	static class Edge implements Comparable<Edge> {
		int ev, ticket;
		long cost;

		public Edge(int ev, long cost, int ticket) {
			this.ev = ev;
			this.cost = cost;
			this.ticket = ticket;
		}

		public int compareTo(Edge o) {
			return (int) (cost - o.cost);
		}
	}

	static ArrayList<Edge>[] a;
	static int start, end;
	static long time;
	static int n, m;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		a = new ArrayList[n + 1];
		for (int i = 0; i < a.length; i++) {
			a[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < m; i++) {
			int c1 = readInt(), c2 = readInt(), cost = readInt();
			a[c1].add(new Edge(c2, cost, i + 1));
			a[c2].add(new Edge(c1, cost, i + 1));
		}
		start = readInt();
		end = readInt();
		time = readLong();
		long low = 1, high = m, mid = 0;
		long ans = Long.MAX_VALUE;
		while (low <= high) {
			mid = (low + high) / 2;
			if (dijkstras(start, mid) <= time) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		System.out.println(ans == Long.MAX_VALUE ? -1 : ans);

	}

	static long dijkstras(int start, long mid) {
		long[] step = new long[n + 1];
		Arrays.fill(step, Long.MAX_VALUE);
		step[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(start, 0, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (step[cur.ev] < cur.cost) {
				continue;
			}
			for (Edge e : a[cur.ev]) {
				if (e.ticket <= mid) {
					if (step[e.ev] > step[cur.ev] + e.cost) {
						step[e.ev] = step[cur.ev] + e.cost;
						pq.add(new Edge(e.ev, step[e.ev], 0));
					}
				} else {
					break;
				}
			}
		}
		return step[end];
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