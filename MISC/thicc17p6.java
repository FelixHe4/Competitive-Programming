package Unit2;
import java.io.*;
import java.util.*;
public class thicc17p6 {
	public static class Edge {
		int ev;
		int cost;

		public Edge(int ev0, int cost0) {
			ev = ev0;
			cost = cost0;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int t = readInt();
		ArrayList<Edge>[] grid = new ArrayList[n + 1];
		ArrayList<Integer> possiblePlaces = new ArrayList<Integer>();
		for (int i = 0; i < n + 1; i++) {
			grid[i] = new ArrayList<Edge>();
		}
		int tp = 0;
		for (int i = 0; i < n - 1; i++) {
			int a = readInt();
			int b = readInt();
			int cost = readInt();
			grid[a].add(new Edge(b, cost));
			grid[b].add(new Edge(a, cost));
			tp += cost;
		}
		tp *= 2;
		for (int i = 0; i < grid.length; i++) {
			if (grid[i].size() == t) {
				possiblePlaces.add(i);
			}
		}
		int start = 1;
		int min = Integer.MIN_VALUE;
		int m = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		int[] step = new int[n + 1];
		boolean[] vis = new boolean[n + 1];
		Arrays.fill(step, Integer.MAX_VALUE);
		q.add(start);
		step[start] = 0;
		vis[start] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int j = 0; j < grid[cur].size(); j++) {
				Edge e = grid[cur].get(j);
				if (!vis[e.ev]) {
					vis[e.ev] = true;
					step[e.ev] = e.cost + step[cur];
					q.add(e.ev);
					if (min < step[e.ev]) {
						min = step[e.ev];
						m = e.ev;
					}
				}
			}
		}
		// System.out.println(Arrays.toString(step));
		int[] step2 = new int[n + 1];
		Arrays.fill(vis, false);
		Arrays.fill(step2, Integer.MAX_VALUE);
		q.add(m);
		step2[m] = 0;
		vis[m] = true;
		min = Integer.MIN_VALUE;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int j = 0; j < grid[cur].size(); j++) {
				Edge e = grid[cur].get(j);
				if (!vis[e.ev]) {
					vis[e.ev] = true;
					step2[e.ev] = e.cost + step2[cur];
					q.add(e.ev);
					if (min < step2[e.ev]) {
						min = step2[e.ev];
						m = e.ev;
					}
				}
			}
		}
		int[] step3 = new int[n + 1];
		Arrays.fill(vis, false);
		Arrays.fill(step3, Integer.MAX_VALUE);
		q.add(m);
		step3[m] = 0;
		vis[m] = true;
		min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int j = 0; j < grid[cur].size(); j++) {
				Edge e = grid[cur].get(j);
				if (e.cost < step3[e.ev] && (!vis[e.ev])) {
					vis[e.ev] = true;
					step3[e.ev] = e.cost + step3[cur];
					q.add(e.ev);
				}
			}
		}
		// System.out.println(Arrays.toString(step2));
		// System.out.println(Arrays.toString(step3));
		for (int i = 0; i < possiblePlaces.size(); i++) {
			System.out.print(possiblePlaces.get(i) + " ");
			System.out.println(tp - Math.max(step3[possiblePlaces.get(i)], step2[possiblePlaces.get(i)]));
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
