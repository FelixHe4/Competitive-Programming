package Unit2;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
public class coci06c3p5 {
	static ArrayList<Integer>[] grid;
	static int n;
	static boolean[] vis;
	static long[] count;
	static boolean[] cycle;
	static boolean inf;
	public static final long MOD = 1000000000;
	static boolean[] needMod;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		n = readInt();
		int m = readInt();
		grid = new ArrayList[n + 1];
		count = new long[n + 1];
		vis = new boolean[n + 1];
		vis[1] = true;
		count[1] = 1;
		cycle = new boolean[n + 1];
		inf = false;
		needMod = new boolean[n + 1];
		for (int i = 0; i < grid.length; i++) {
			grid[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int c1 = readInt();
			int c2 = readInt();
			grid[c2].add(c1);
		}
		dfs(2, -1);
		// System.out.println(Arrays.toString(count));
		// System.out.println(Arrays.toString(cycle));
		if (inf) {
			System.out.println("inf");
		} else {
			if (needMod[2] || count[2] == 4) {
				String s = count[2] + "";
				for (int i = 0; i < 9 - s.length(); i++) {
					System.out.print("0");
				}
				System.out.println(s);
			} else {
				System.out.println(count[2]);
			}
		}

	}

	static void dfs(int cur, int prev) {
		if (vis[cur]) {
			cycle[cur] = true;
		}
		vis[cur] = true;
		for (int c : grid[cur]) {
			if (!vis[c]) {
				dfs(c, cur);
			}
			count[cur] += count[c];
			if (count[cur] > 999999999) {
				needMod[cur] = true;
			}
			count[cur] %= MOD;
			if (cycle[cur]) {
				inf = true;
			}
		}
	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static String readLine() throws IOException {
		byte[] buf = new byte[1000000]; // line length
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
