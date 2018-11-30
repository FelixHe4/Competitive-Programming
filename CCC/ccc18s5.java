package Unit1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
public class ccc18s5 {
	public static class Edge implements Comparable<Edge> {
		int bv, ev;
		long cost;
		boolean type;

		public Edge(int bv0, int ev0, long cost0, boolean type0) {
			bv = bv0;
			ev = ev0;
			cost = cost0;
			type = type0;
		}

		public int compareTo(Edge o) {
			return (int) (cost - o.cost);
		}

	}

	static int find(int n, int[] dsu) {
		if (dsu[n] == n) {
			return n;
		} else {
			return dsu[n] = find(dsu[n], dsu);
		}
	}

	static int n, m, p, q;
	static Edge[] Edge;
	static int[] dsu;
	static int[] dsu2;

	public static void main(String[] args) throws IOException {
		int n = readInt(); // planets
		int m = readInt(); // cities in each planet
		int p = readInt(); // number of flights
		int q = readInt(); // number of portals
		int[] rank = new int[n + m + 1];
		int[] rank2 = new int[n + m + 1];
		Edge = new Edge[p + q];
		long total = 0;
		for (int i = 0; i < p; i++) {
			int a = readInt(), b = readInt();
			long c = readLong();
			// flights are true, portals are false
			total += c * n;
			Edge[i] = new Edge(a, b, c, true);
		}
		for (int i = p; i < p + q; i++) {
			int a = readInt(), b = readInt();
			long c = readLong();
			total += c * m;
			Edge[i] = new Edge(a, b, c, false);
		}
//		System.out.println(total);
		dsu = new int[n + m + 1];
		dsu2 = new int[n + m + 1];
		for (int i = 0; i < dsu.length; i++) {
			dsu[i] = i;
			dsu2[i] = i;
		}
		Arrays.sort(Edge);
		int curn = 0;
		int curm = 0;
		for (Edge e : Edge) {
			if ((curn == n - 1 && !e.type) || (curm == m - 1 && e.type)) {
				continue;
			}
			int a = e.bv, b = e.ev;
			long c = e.cost;
			boolean type = e.type;
			if (type) {
				int fa = find(a, dsu);
				int fb = find(b, dsu);
				if (fa != fb) {
					if (rank[fa] > rank[fb]) {
						dsu[fb] = fa;
					} else {
						dsu[fa] = fb;
						if (rank[fa] == rank[fb]) {
							rank[fb]++;
						}
					}
					total -= (n - curn) * c;
					curm++;
				}
			} else {
				int fa = find(a, dsu2);
				int fb = find(b, dsu2);
				if (fa != fb) {
					if (rank2[fa] > rank2[fb]) {
						dsu2[fb] = fa;
					} else {
						dsu2[fa] = fb;
						if (rank2[fa] == rank2[fb]) {
							rank2[fb]++;
						}
					}
					total -= (m - curm) * c;
					curn++;
				}
			}
		}
		System.out.println(total);
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
