package Unit2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
// Felix's second best spanning tree code!! (This took me around 30 mins)
public class SecondBestSpanningTree {
	//
	public static class Edge implements Comparable<Edge> {
		int bv, ev, cost;

		public Edge(int bv0, int ev0, int cost0) {
			bv = bv0;
			ev = ev0;
			cost = cost0;
		}

		public int compareTo(Edge o) {
			return cost - o.cost;
		}
	}

	static Edge[] edge;
	static Edge[] MST;
	static int[] parent;
	static int[] parent2;
	static int n;
	static int m;

	static int find(int n) {
		if (parent[n] == n) {
			return n;
		} else {
			parent[n] = find(parent[n]);
			return parent[n];
		}
	}

	static int find1(int n) {
		if (parent2[n] == n) {
			return n;
		} else {
			parent2[n] = find1(parent2[n]);
			return parent2[n];
		}
	}

	public static void main(String[] args) throws IOException {
		n = readInt();
		m = readInt();
		parent = new int[n + 1];
		MST = new Edge[m];
		for (int i = 0; i < n + 1; i++) {
			parent[i] = i;
		}
		edge = new Edge[m];
		for (int i = 0; i < m; i++) {
			int a = readInt();
			int b = readInt();
			int c = readInt();
			edge[i] = new Edge(a, b, c);
		}
		int edgesT = 0;
		long sum = 0;
		Arrays.sort(edge);
		for (Edge e : edge) {
			int a = e.bv, b = e.ev, c = e.cost;
			int fa = find(a);
			int fb = find(b);
			if (fa != fb) {
				parent[fb] = fa;
				MST[edgesT] = e;
				edgesT++;
				sum += c;
			}
		}
		for (int i = 0; i < MST.length; i++) {
			if (MST[i] != null) {
				System.out.println(MST[i].bv + " " + MST[i].ev + " " + MST[i].cost);
			}
		}
		int aaa = 0;
		int sum2 = Integer.MAX_VALUE;
		for (Edge mst : MST) {
			if (mst != null) {
				int sum1 = 0;
				parent2 = new int[n + 1];
				for (int k = 0; k < n + 1; k++) {
					parent2[k] = k;
				}
				for (Edge e : edge) {
					if (e != mst) {
						int a = e.bv, b = e.ev, c = e.cost;
						int fa = find1(a);
						int fb = find1(b);
						if (fa != fb) {
							// System.out.println(a + " " + b + " " + c);
							sum1 += c;
							parent2[fb] = fa;
							aaa++;
						}
					}
				}
				if (sum1 != sum && aaa == n - 1) {
					sum2 = Math.min(sum2, sum1);
				}
				aaa = 0;
			}
		}
		if (sum2 == Integer.MAX_VALUE) {
			println(-1);
		} else {
			println(sum2);
		}
		exit();
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
		return readLine().charAt(0);
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