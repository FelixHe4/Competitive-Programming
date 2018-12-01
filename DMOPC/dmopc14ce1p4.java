package Unit2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class dmopc14ce1p4 {
	public static class Edge {
		int ev;
		double cost;

		public Edge(int ev, double cost) {
			this.ev = ev;
			this.cost = cost;
		}

		public void print() {
			System.out.println(ev);
			System.out.println(cost);
		}
	}

	public static class Node implements Comparable<Node> {
		int v;
		double step;

		public Node(int v, double step2) {
			this.v = v;
			this.step = step2;
		}

		public int compareTo(Node o) {
			return (int) (this.step - o.step);
		}
	}

	static int v;
	static int e;
	static ArrayList<Edge>[] a;
	static int parents[];
	static double[] step;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		v = readInt();
		e = readInt();
		int c1, c2;
		double length, speed, kpm;
		a = new ArrayList[v + 1];
		for (int i = 0; i < a.length; i++) {
			a[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < e; i++) {
			boolean flag = false;
			c1 = readInt();
			c2 = readInt();
			length = readInt();
			speed = readInt();
			kpm = (length / speed) * 60;
			a[c1].add(new Edge(c2, kpm));
			a[c2].add(new Edge(c1, kpm));
		}
		// for (int i = 0; i < a.length; i++) {
		// for (int j = 0; j < a[i].size(); j++) {
		// System.out.println(i);
		// System.out.println(a[i].get(j).ev);
		// System.out.println(a[i].get(j).cost);
		// }
		// }
		Djikstras(v);
		// double total = 0;
		// int cloc;
		// int eloc = v;
		// while (true) {
		// if (parents[eloc] == 0) {
		// break;
		// }
		// cloc = parents[eloc];
		// for (int i = 0; i < a[cloc].size(); i++) {
		// if (a[cloc].get(i).ev == eloc) {
		// total += (a[cloc].get(i).length / (a[cloc].get(i).speed * 0.75)) * 60;
		// }
		// }
		// eloc = cloc;
		// }
		// System.out.println(Math.round(total - step[v]));
	}

	public static void Djikstras(int dest) {
		step = new double[v + 1];
		int[] step2 = new int[v + 1];
		boolean[] vis = new boolean[v + 1];
		parents = new int[v + 1];
		Arrays.fill(step, Integer.MAX_VALUE);
		Arrays.fill(step2, Integer.MAX_VALUE);
		step[1] = 0;
		step2[1] = 0;
		vis[1] = true;
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(1, step[1]));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			ArrayList<Edge> neighbour = a[cur.v];
			for (int i = 0; i < neighbour.size(); i++) {
				Edge e = neighbour.get(i);
				if ((step[e.ev] > step[cur.v] + e.cost)) {
					step[e.ev] = step[cur.v] + e.cost;
					step2[e.ev] = step2[cur.v] + 1;
					parents[e.ev] = cur.v;
					q.add(new Node(e.ev, step[e.ev]));
				}
			}
		}
		System.out.println(step2[dest]);
		System.out.println(Math.round(step[dest] / 0.75 - step[dest]));
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