package Unit2;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
public class LKP2P6 {

	public static ArrayList<Edge>[] adj;
	static int start, max = 0;
	static boolean[] pho;
	static boolean[] vis;

	public static boolean dfs(int x, int d) {
		if (d > max && pho[x]) {
			start = x;
			max = d;
		}
		for (Edge i : adj[x]) {
			if (!vis[i.ev]) {
				vis[i.ev] = true;
				if (dfs(i.ev, d += i.cost)) {
					pho[x] = true;
				}
			}
		}
		return pho[x];
	}

	static int find(int n) {
		if (dsu[n] == n) {
			return n;
		}
		return dsu[n] = find(dsu[n]);
	}

	public static class Edge {
		int bv, ev, cost;

		public Edge(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
		}
	}

	public static class Edges implements Comparable<Edges> {
		int bv, ev, cost;

		public Edges(int bv, int ev, int cost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
		}

		public int compareTo(Edges o) {
			return cost - o.cost;

		}
	}

	static Edges[] Edge;
	static int[] dsu;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		int N = readInt();
		int M = readInt();
		int k = readInt();
		pho = new boolean[N + 1];
		Edge = new Edges[N - 1];
		start = 0;
		dsu = new int[N + 1];
		for (int i = 0; i < dsu.length; i++) {
			dsu[i] = i;
		}
		for (int i = 0; i < k; i++) {
			int p = readInt();
			pho[p] = true;
			if (i == 0) {
				start = p;
			}
		}
		adj = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < N - 1; i++) {
			int A = readInt();
			int B = readInt();
			int c = readInt();
			adj[A].add(new Edge(B, c));
			adj[B].add(new Edge(A, c));
			Edge[i] = new Edges(A, B, c);
		}
		vis = new boolean[N + 1];
		vis[start] = true;
		dfs(start, 0);
		long cost = 0;
		// System.out.println(Arrays.toString(pho));
		for (int i = 0; i < N - 1; i++) {
			if (pho[Edge[i].bv] && pho[Edge[i].ev]) {
				int a = Edge[i].bv, b = Edge[i].ev, c = Edge[i].cost;
				int fa = find(a);
				int fb = find(b);
				if (fa != fb) {
					dsu[fb] = fa;
					cost += c;
				}
			}
		}
		System.out.println(cost);
		for (int i = 0; i < M; i++) {
			int op = readInt();
			if (op == 1) {
				int x = readInt();
				if (pho[x]) {
					pho[x] = false;
				} else {
					pho[x] = true;
				}
				vis = new boolean[N + 1];
				vis[start] = true;
				dfs(start, 0);
				cost = 0;
				for (int j = 0; j < N - 1; j++) {
					if (pho[Edge[j].bv] && pho[Edge[j].ev]) {
						int a = Edge[j].bv, b = Edge[j].ev, c = Edge[j].cost;
						int fa = find(a);
						int fb = find(b);
						if (fa != fb) {
							dsu[fb] = fa;
							cost += c;
						}
					}
				}
				System.out.println(cost);
			} else {

			}
		}
		System.out.println(cost);
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