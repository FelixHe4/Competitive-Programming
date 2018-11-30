package Unit2;
import java.io.*;
import java.util.*;
public class dmopc15c3p4 {
	public static class Coord {
		int x, y;

		public Coord(int x0, int y0) {
			x = x0;
			y = y0;
		}
	}

	public static class Edge {
		int ev;
		long cost;

		public Edge(int ev0, long cost0) {
			ev = ev0;
			cost = cost0;
		}
	}

	static ArrayList<Coord> a;
	static ArrayList<Edge>[] b;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		a = new ArrayList<Coord>();
		b = new ArrayList[n];
		for (int i = 0; i < b.length; i++) {
			b[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < n; i++) {
			int x = readInt(), y = readInt();
			a.add(new Coord(x, y));
		}
		long[] step = new long[n];
		Arrays.fill(step, Long.MAX_VALUE);
		boolean[] vis = new boolean[n];
		int x = readInt() - 1;
		step[x] = 0;
		for (int i = 0; i < n - 1; i++) {
			long min = Long.MAX_VALUE;
			int minN = 0;
			for (int j = 0; j < n; j++) {
				if (!vis[j] && step[j] < min) {
					min = step[j];
					minN = j;
				}
			}
			if (min == Long.MAX_VALUE) {
				break;
			}
			vis[minN] = true;
			for (int v = 0; v < n; v++) {
				long root_x = a.get(minN).x - a.get(v).x, root_y = a.get(minN).y - a.get(v).y;
				long check_dis = root_x * root_x + root_y * root_y;
				if (!vis[v] && check_dis + step[minN] < step[v]) {
					step[v] = check_dis + step[minN];
				}
			}
		}
		int q = readInt();
		Arrays.sort(step);
		for (int i = 0; i < q; i++) {
			long t = readLong();
			int high = n, low = 0;
			while (low < high) {
				int mid = (low + high) / 2;
				if (step[mid] > t)
					high = mid;
				else
					low = mid + 1;
			}
			println(low);
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
