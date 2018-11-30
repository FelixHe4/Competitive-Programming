package Unit2;
import java.io.*;
import java.util.*;
public class triwaylvl2p2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int P = readInt();
		int S = readInt();
		ArrayList<Integer>[] grid = new ArrayList[n + 1];
		for (int i = 0; i < grid.length; i++) {
			grid[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int a = readInt();
			int b = readInt();
			grid[a].add(b);
			grid[b].add(a);
		}
		int T = readInt();
		int[] step = new int[n + 5];
		boolean[] vis = new boolean[n + 5];
		Arrays.fill(step, Integer.MAX_VALUE);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(P);
		vis[P] = true;
		step[P] = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int node : grid[cur]) {
				if (!vis[node] && step[node] > step[cur] + 1) {
					step[node] = step[cur] + 1;
					vis[node] = true;
					q.add(node);
				}
			}
		}
		q.clear();
		q.add(S);
		int[] step2 = new int[n + 5];
		boolean[] vis2 = new boolean[n + 5];
		Arrays.fill(step2, Integer.MAX_VALUE);
		step2[S] = 0;
		vis2[S] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int node : grid[cur]) {
				if (!vis2[node] && step2[node] > step2[cur] + 1) {
					step2[node] = step2[cur] + 1;
					vis2[node] = true;
					q.add(node);
				}
			}
		}
		if (step[T] < step2[T]) {
			System.out.println("yes! :)");
		}
		else if (step[T] > step2[T]) {
			System.out.println("no! :(");
		}
		else {
			System.out.println("meh :|");
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
