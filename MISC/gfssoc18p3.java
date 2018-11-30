package Unit2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class gfssoc18p3 {
	public static class Edge implements Comparable<Edge> {
		int bv, ev;
		long cost;

		public Edge(int bv, int ev, long cost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
		}

		public int compareTo(Edge o) {
			return (int) (cost - o.cost);
		}
	}

	static ArrayList<Edge>[] a;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		PrintWriter prt = new PrintWriter(
				new OutputStreamWriter(new FileOutputStream("/Users/felixhe4/Desktop/GFSSOC/P3TestData/output10.txt")));
		BufferedReader br = new BufferedReader(new FileReader("/Users/felixhe4/Desktop/GFSSOC/P3TestData/input10.txt"));
		String s = br.readLine();
		int n = Integer.parseInt(s.split(" ")[0]), m = Integer.parseInt(s.split(" ")[1]),
				e = Integer.parseInt(s.split(" ")[2]);
		a = new ArrayList[n + 1];
		for (int i = 0; i < a.length; i++) {
			a[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < m; i++) {
			s = br.readLine();
			int c1 = Integer.parseInt(s.split(" ")[0]), c2 = Integer.parseInt(s.split(" ")[1]),
					cost = Integer.parseInt(s.split(" ")[2]);
			a[c1].add(new Edge(c1, c2, cost));
			a[c2].add(new Edge(c2, c1, cost));
		}
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(1, 0, 0));
		long[] step = new long[n + 1];
		Arrays.fill(step, 1 << 30);
		step[1] = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (int i = 0; i < a[cur.bv].size(); i++) {
				if (step[a[cur.bv].get(i).ev] > step[cur.bv] + a[cur.bv].get(i).cost) {
					step[a[cur.bv].get(i).ev] = step[cur.bv] + a[cur.bv].get(i).cost;
					pq.add(new Edge(a[cur.bv].get(i).ev, 0, step[a[cur.bv].get(i).ev]));
				}
			}
		}
		s = br.readLine();
		int f = Integer.parseInt(s.split(" ")[0]);
		if (e <= step[f]) {
			prt.println("Griffy is sad");
		} else {
			prt.println(e - step[f]);
		}
		br.close();
		prt.close();
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
