package Unit2;
import java.io.*;
import java.util.*;
public class Graph {
	// Data Member
	// Vertices
	// Edges
	// Class only definition, Only a template
	int V; // How many vertices
	int E; // How many edges
	Edge[] edge;

	public class Edge implements Comparable<Edge> {
		int bv; // Beginning Vertex
		int ev; // Ending Vertex
		int cost; // Cost

		public int compareTo(Edge compareEdge) {
			return this.cost - compareEdge.cost;
		}
	}

	// Constructor
	// Use constructor to set the data member's value
	// Constructor name is the same as the class name
	public Graph(int v, int e) {
		this.V = v;
		this.E = e;
		edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			edge[i] = new Edge();
		}
	}

	public static void main(String[] args) throws IOException {
		Graph g = new Graph(4, 6);
		g.edge[0].bv = 0;
		g.edge[0].ev = 3;
		g.edge[0].cost = 3;

		g.edge[1].bv = 0;
		g.edge[1].ev = 1;
		g.edge[1].cost = 1;

		g.edge[2].bv = 0;
		g.edge[2].ev = 2;
		g.edge[2].cost = 4;

		g.edge[3].bv = 1;
		g.edge[3].ev = 2;
		g.edge[3].cost = 5;

		g.edge[4].bv = 2;
		g.edge[4].ev = 3;
		g.edge[4].cost = 6;

		g.edge[5].bv = 1;
		g.edge[5].ev = 3;
		g.edge[5].cost = 2;

		Arrays.sort(g.edge);
		for (int i = 0; i < 5; i++) {
			System.out.print(g.edge[i].bv + " ");
			System.out.print(g.edge[i].ev + " ");
			System.out.print(g.edge[i].cost);
			System.out.println();
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

	static PrintWriter pr = new PrintWriter(
			new BufferedWriter(new OutputStreamWriter(System.out)));

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
