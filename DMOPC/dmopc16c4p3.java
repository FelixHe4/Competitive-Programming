package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dmopc16c4p3 {
	static class Pair implements Comparable<Pair> {
		int index, dis;

		public Pair(int index, int dis) {
			this.index = index;
			this.dis = dis;
		}

		@Override
		public int compareTo(Pair o) {
			if (dis == o.dis) {
				return index - o.index;
			}
			return dis - o.dis;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt(), s = readInt();
		int[] d = new int[n + 1];
		int[][] c = new int[n + 1][105];
		for (int i = 1; i <= n; i++) {
			d[i] = readInt();
		}
		PriorityQueue<Pair>[] a = new PriorityQueue[101];
		for (int i = 0; i < a.length; i++) {
			a[i] = new PriorityQueue<Pair>();
		}
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(c[i], -1);
		}
		for (int i = 0; i < s; i++) {
			int si = readInt(), fl = readInt();
			c[si][fl] = fl;
			a[fl].add(new Pair(si, d[si]));
		}
		int q = readInt();
		while (q-- > 0) {
			String op = read();
			if (op.equals("A")) {
				int x = readInt(), k = readInt();
				a[k].add(new Pair(x, d[x]));
				c[x][k] = k;
			} else if (op.equals("S")) {
				int x = readInt(), k = readInt();
				if (c[x][k] == k) {
					c[x][k] = -1;
				}
//				Pair p = new Pair(x, d[x]);
//				a[k].remove(p);
			} else if (op.equals("E")) {
				int x = readInt(), k = readInt();
//				Pair p = new Pair(x, d[x]);
//				for (int i = 0; i < a.length; i++) {
//					a[i].remove(p);
//				}
				for (int i = 0; i < 101; i++) {
					if (c[x][i] == i) {
						c[x][i] = -1;
					}
				}
				d[x] = k;
			} else if (op.equals("Q")) {
				int k = readInt();
				while (!a[k].isEmpty() && (c[a[k].peek().index][k] != k || d[a[k].peek().index] != a[k].peek().dis)) {
					a[k].poll();
				}
				if (a[k].isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(a[k].peek().index);
				}
			}
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
