package Unit2;
import java.io.*;
import java.util.*;
class gggraph {
	int V;
	int E;
	Edge[] Edge;
	Edge[] MST;
	int parent[];

	public class Edge implements Comparable<Edge> {
		int bv;
		int ev;
		int cost;

		public int compareTo(Edge compareEdge) {
			return this.cost - compareEdge.cost;
			// return compareEdge.cost = this.cost;
			// will return greatest to least
		}
	}

	public gggraph(int v, int e) {
		this.V = v;
		this.E = e;
		Edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			Edge[i] = new Edge();
		}
		MST = new Edge[V - 1];
		for (int i = 0; i < E; i++) {
			MST[i] = new Edge();
		}
		parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[V] = -1;
		}
	}

	public void union(int pb, int pe) {
		parent[pb] = pe;
	}

	public int find(int v) {
		if (parent[v] == -1) {
			return v;
		}
		else {
			return find(parent[v]);
		}
	}

	public static void main(String[] args) throws IOException {
		int V = readInt();
		int E = readInt();
		gggraph g = new gggraph(V, E);
		for (int i = 0; i < E; i++) {
			g.Edge[i].bv = readInt();
			g.Edge[i].ev = readInt();
			g.Edge[i].cost = readInt();
		}
		Arrays.sort(g.Edge);
		int j = 0;
		for (int i = 0; i < E; i++) {
			int bv = g.Edge[i].bv;
			int ev = g.Edge[i].ev;
			int pb = g.find(bv);
			int pe = g.find(ev);
			if (pb != pe) {
				g.MST[j].bv = g.Edge[i].bv;
				g.MST[j].ev = g.Edge[i].ev;
				g.MST[j].cost = g.Edge[i].cost;
				g.union(pb, pe);
				j++;
			}
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
