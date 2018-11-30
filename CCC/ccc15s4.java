package Unit1;
import java.io.*;
import java.util.*;
public class ccc15s4 {
	static class Edge implements Comparable<Edge> {
		int vertex;
		int time;
		int hull;

		Edge(int v, int t, int h) {
			vertex = v;
			time = t;
			hull = h;
		}

		public int compareTo(Edge compareEdge) {
			if (this.time < compareEdge.time) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int K = readInt();
		int N = readInt();
		int M = readInt();
		ArrayList<Edge>[] al = new ArrayList[N + 1];
		int[][] sto = new int[N + 1][K + 1];
		for (int i = 0; i < al.length; i++) {
			al[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(sto[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < M; i++) {
			int a = readInt();
			int b = readInt();
			int t = readInt();
			int h = readInt();
			al[a].add(new Edge(b, t, h));
			al[b].add(new Edge(a, t, h));
		}
		int a = readInt();
		int b = readInt();
		Queue<Edge> q = new LinkedList<Edge>();
		q.add(new Edge(a, 0, K));
		sto[a][K] = 0;
		while (!q.isEmpty()) {
			Edge now = q.poll();
			if (sto[now.vertex][now.hull] < now.time) {
				continue;
			}
			for (Edge Do : al[now.vertex]) {
				if (now.hull - Do.hull > 0
						&& sto[now.vertex][now.hull] + Do.time < sto[Do.vertex][now.hull - Do.hull]) {
					sto[Do.vertex][now.hull - Do.hull] = sto[now.vertex][now.hull] + Do.time;
					q.add(new Edge(Do.vertex, sto[Do.vertex][now.hull - Do.hull], now.hull - Do.hull));
				}
			}

		}
		int com = Integer.MAX_VALUE;
		for (int i = 1; i <= K; i++) {
			com = Math.min(com, sto[b][i]);
		}
		if (com == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(com);
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
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

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine();
	}

	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

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
		br.close();
		pr.close();
		System.exit(0);
	}
}
