package Unit1;
import java.io.*;
import java.util.*;
public class ccc06j4 {
	@SuppressWarnings("unchecked")
	static PriorityQueue<Integer> q;

	public static void main(String[] args) throws IOException {
		ArrayList<Integer>[] a = new ArrayList[8];
		for (int i = 0; i < a.length; i++) {
			a[i] = new ArrayList<Integer>();
		}
		ArrayList<Integer> order = new ArrayList<Integer>();
		a[1].add(7);
		a[1].add(4);
		a[2].add(1);
		a[3].add(4);
		a[3].add(5);
		while (true) {
			int c1 = readInt(), c2 = readInt();
			if (c1 == 0 && c2 == 0) {
				break;
			} else {
				a[c1].add(c2);
			}
		}

		boolean[] vis = new boolean[8];
		int[] deg = new int[8];
		for (int i = 0; i < a.length; i++) {
			for (int x : a[i]) {
				deg[x]++;
			}
		}
		q = new PriorityQueue<Integer>();
		for (int i = 0; i < 8; i++) {
			if (deg[i] == 0) {
				q.add(i);
				vis[i] = true;
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			order.add(cur);
			for (int x : a[cur]) {
				if (!vis[x]) {
					deg[x]--;
					if (deg[x] == 0) {
						q.add(x);
						vis[x] = true;
					}
				}
			}
		}
		if (order.size() == 8) {
			for (int i = 1; i < order.size(); i++) {
				print(order.get(i) + " ");
			}
		} else {
			System.out.println("Cannot complete these tasks. Going to bed.");
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
