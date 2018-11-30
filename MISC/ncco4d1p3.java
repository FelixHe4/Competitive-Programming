package Unit2;
import java.io.*;
import java.util.*;

public class ncco4d1p3 {

	static class E implements Comparable<E> {
		int v, w;

		E(int v0, int w0) {
			v = v0;
			w = w0;
		}

		public int compareTo(E x) {
			return Integer.compare(w, x.w);
		}
	}

	// w is weight because jonathan is a fag
	static ArrayList<E>[] con;
	static int n;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		n = readInt();
		int m = readInt();
		con = new ArrayList[n + 1];
		for (int i = 0; i < con.length; i++) {
			con[i] = new ArrayList<E>();
		}
		for (int i = 0; i < m; i++) {
			int c1 = readInt();
			int c2 = readInt();
			int cost = readInt();
			con[c1].add(new E(c2, cost));
			con[c2].add(new E(c1, cost));
		}
		Djikstras(n);
	}

	public static void Djikstras(int end) {
		int[] dis = new int[n + 1];
		int[] dis2 = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		Arrays.fill(dis2, Integer.MAX_VALUE);
		dis[1] = 0;
		PriorityQueue<E> q = new PriorityQueue<E>();
		q.add(new E(1, dis[1]));
		while (!q.isEmpty()) {
			E cur = q.poll();
			for (E e : con[cur.v]) {
				if (dis[e.v] > cur.w + e.w) {
					dis2[e.v] = dis[e.v];
					dis[e.v] = cur.w + e.w;
					q.add(new E(e.v, dis[e.v]));
				}
				else if (cur.w + e.w < dis2[e.v] && dis[e.v] != cur.w + e.w) {
					dis2[e.v] = cur.w + e.w;
					q.add(new E(e.v, dis2[e.v]));
				}
			}
		}
		// System.out.println(Arrays.toString(dis));
		// System.out.println(Arrays.toString(dis2));
		if (dis2[n] == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(dis2[n]);
		}
	}

	final private static int BufferS = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BufferS];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	public static String readLine() throws IOException {
		byte[] buf = new byte[64];
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
		}
		while (c != -1 && c != ' ' && c != '\n' && c != '\r');
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
		}
		while ((c = Read()) >= '0' && c <= '9');

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
		}
		while ((c = Read()) >= '0' && c <= '9');
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
		}
		while ((c = Read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = Read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static float readFloat() throws IOException {
		return Float.parseFloat(next());
	}

	static boolean readBool() throws IOException {
		return Boolean.parseBoolean(next());
	}

	static short readShort() throws IOException {
		return Short.parseShort(next());
	}

	static byte readByte() throws IOException {
		return Byte.parseByte(next());
	}

	private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BufferS);
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
