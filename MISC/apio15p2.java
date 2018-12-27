package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class apio15p2 {
	static class Pair implements Comparable<Pair> {
		int ev, cost;

		public Pair(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;

		}

		public int compareTo(Pair o) {
			return cost - o.cost;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		ArrayList<Integer>[] aaa = new ArrayList[n + 1];
		for (int i = 0; i < aaa.length; i++) {
			aaa[i] = new ArrayList<Integer>();
		}
		int startJ = 0, endJ = 0;
		for (int i = 0; i < m; i++) {
			int c1 = readInt(), c2 = readInt();
			if (i == 0) {
				startJ = c1;
			}
			if (i == 1) {
				endJ = c1;
			}
			aaa[c1].add(c2);
		}
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(startJ, 0));
		int[] step = new int[n];
		Arrays.fill(step, Integer.MAX_VALUE);
		step[startJ] = 0;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			for (int i : aaa[cur.ev]) {
				int count = 0;
				for (int j = cur.ev + i; j < n; j += i) {
					count++;
					if (step[j] > step[cur.ev] + count) {
						step[j] = step[cur.ev] + count;
						q.add(new Pair(j, step[j]));
					}
				}
				count = 0;
				for (int j = cur.ev - i; j >= 0; j -= i) {
					count++;
					if (step[j] > step[cur.ev] + count) {
						step[j] = step[cur.ev] + count;
						q.add(new Pair(j, step[j]));
					}
				}
			}
		}
		System.out.println(Arrays.toString(step));
		System.out.println(step[endJ] == Integer.MAX_VALUE ? -1 : step[endJ]);
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
