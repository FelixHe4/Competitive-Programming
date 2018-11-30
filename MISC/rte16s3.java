package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class rte16s3 {
	public static class Edge {
		int ev0, cost0;

		public Edge(int ev, int cost) {
			ev0 = ev;
			cost0 = cost;
		}
	}

	static ArrayList<Edge>[] arr;
	static boolean[] vis;
	static int[] step, depth;
	static int[][] LCA;
	static int k;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		arr = new ArrayList[n];
		step = new int[n];
		vis = new boolean[n];
		depth = new int[n];
		k = (int) (Math.log(n) / Math.log(2));
		LCA = new int[(int) k][n];
		for (int i = 0; i < LCA.length; i++) {
			Arrays.fill(LCA[i], -1);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < n - 1; i++) {
			int a = readInt();
			int b = readInt();
			int c = readInt();
			arr[a].add(new Edge(b, c));
			arr[b].add(new Edge(a, c));
		}
		vis[0] = true;
		dfs(0);
		int q = readInt();
		while (q-- > 0) {
			int a = readInt(), b = readInt(), l = Query(a, b);
//			System.out.println(step[a] + " " + step[b] + " " + step[l]);
			println(step[a] + step[b] - 2 * step[l]);
		}
		exit();
	}

	static int Query(int u, int v) {
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

	static void Build() {
		for (int i = 0; i < LCA.length; i++) {
			for (int j = 0; j < LCA[i].length; j++) {
				if (LCA[i - 1][j] != -1) {
					LCA[i][j] = LCA[i - 1][LCA[i - 1][j]];
				}
			}
		}
	}

	static void dfs(int cur) {
		for (Edge i : arr[cur]) {
			if (!vis[i.ev0]) {
				depth[i.ev0] = depth[cur] + 1;
				LCA[0][i.ev0] = cur;
				vis[i.ev0] = true;
				step[i.ev0] = step[cur] + i.cost0;
				dfs(i.ev0);
			}
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
