package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class sssp {
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

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		ArrayList<Edge>[] arr = new ArrayList[n + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			arr[a].add(new Edge(b, c));
			arr[b].add(new Edge(a, c));
		}
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(1, 0));
		int[] step = new int[n + 1];
		Arrays.fill(step, 1 << 30);
		step[1] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (int i = 0; i < arr[cur.ev].size(); i++) {
				int ev = arr[cur.ev].get(i).ev;
				int cost = arr[cur.ev].get(i).cost;
				if (step[ev] > step[cur.ev] + cost) {
					step[ev] = step[cur.ev] + cost;
					pq.add(new Edge(ev, step[ev]));
				}
			}
		}
		for (int i = 1; i < step.length; i++) {
			println(step[i] == 1 << 30 ? -1 : step[i]);
		}
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
