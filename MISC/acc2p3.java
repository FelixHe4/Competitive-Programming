package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class acc2p3 {
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

	public static class Node {
		int ev, cost;

		public Node(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
		}
	}

	static Edge[] edge;
	static int[] parent, depth;
	static boolean[] vis;
	static int n, m, k;
	static int[][] LCA, cost;
	static ArrayList<Edge>[] arr;
	static ArrayList<Node>[] MST;

	static int find(int n) {
		if (parent[n] == n) {
			return n;
		} else {
			parent[n] = find(parent[n]);
			return parent[n];
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		n = readInt();
		m = n - 1;
		k = (int) (Math.log(n) / Math.log(2) + 1);
		parent = new int[n + 1];
		vis = new boolean[m + 1];
		depth = new int[n + 1];
		arr = new ArrayList[n + 1];
		MST = new ArrayList[n + 1];
		LCA = new int[(int) k][n + 1];
		cost = new int[(int) k][n + 1];
		for (int i = 0; i < LCA.length; i++) {
			Arrays.fill(LCA[i], -1);
			Arrays.fill(cost[i], -1);
		}
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
			arr[i] = new ArrayList<Edge>();
			MST[i] = new ArrayList<Node>();
		}
		edge = new Edge[m];
		for (int i = 0; i < m; i++) {
			int a = readInt();
			int b = readInt();
			int c = readInt();
			MST[a].add(new Node(b, c));
			MST[b].add(new Node(a, c));
		}
		dfs(1, 0);
		Build();
		for (int i = 0; i < LCA.length; i++) {
			for (int j = 0; j < LCA[i].length; j++) {
				System.out.print(cost[i][j] + " ");
			}
			System.out.println();
		}
		int q = readInt();
		while (q-- > 0) {
			int x = readInt(), y = readInt();
			int rT = getLCA(x, y);
			int maxCost = Math.max(query(x, rT), query(y, rT));
			System.out.println(query(x, rT) + " " + query(y, rT) + " " + maxCost);
			long sec = maxCost;
			System.out.println(sec);
		}
	}

	static int query(int u, int rt) {
		int ret = 0;
		for (int i = (int) k - 1; i >= 0; i--) {
			if (depth[u] >= depth[rt] + (1 << i)) {
				ret = Math.max(ret, cost[i][u]);
				u = LCA[i][u];
			}
		}
		return ret;
	}

	static int getLCA(int u, int v) {
		if (depth[u] < depth[v]) {
			int x = u;
			u = v;
			v = x;
		}
		for (int i = (int) k - 1; i >= 0; i--) {
			if (LCA[i][u] != -1 && depth[LCA[i][u]] >= depth[v]) {
				u = LCA[i][u];
			}
		}
		if (u == v) {
			return u;
		}
		for (int i = (int) k - 1; i >= 1; i--) {
			if (LCA[i][u] != 1 && LCA[i][v] != -1 && LCA[i][u] != LCA[i][v]) {
				u = LCA[i][u];
				v = LCA[i][v];
			}
		}
		return LCA[0][u];
	}

	// build the two sparse tables.
	static void Build() {
		for (int i = 1; i < LCA.length; i++) {
			for (int j = 1; j < LCA[i].length; j++) {
				if (LCA[i - 1][j] != -1) {
					LCA[i][j] = LCA[i - 1][LCA[i - 1][j]];
					cost[i][j] = Math.max(cost[i - 1][j], cost[i - 1][LCA[i - 1][j]]);
				}
			}
		}
	}

	// DFS the minimum spanning trees
	static void dfs(int cur, int parent) {
		for (Node i : MST[cur]) {
			if (i.ev == parent) {
				continue;
			}
			depth[i.ev] = depth[cur] + 1;
			LCA[0][i.ev] = cur;
			cost[0][i.ev] = i.cost;
			dfs(i.ev, cur);
		}
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
