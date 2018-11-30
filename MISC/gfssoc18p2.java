package Unit2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class gfssoc18p2 {
	public static int moves[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static class E {
		int x, y;

		public E(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static boolean valid(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/felixhe4/Desktop/GFSSOC/P2TestData/input6.txt"));
		N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		int xf = Integer.parseInt(s[0]);
		int yf = Integer.parseInt(s[1]);
		boolean[][] vis = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] s2 = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				if (s2[j].equals("X")) {
					vis[i][j] = true;
				}
			}
		}
		int[][] grid = new int[N][N];
		Queue<E> q = new LinkedList<E>();
		vis[x][y] = true;
		q.add(new E(x, y));
		while (!q.isEmpty()) {
			E current = q.poll();
			int curx = current.x, cury = current.y;
			for (int i = 0; i < 4; i++) {
				int nx = curx + moves[i][0], ny = cury + moves[i][1];
				if (valid(nx, ny) && !vis[nx][ny]) {
					vis[nx][ny] = true;
					grid[nx][ny] = grid[curx][cury] + 1;
					q.add(new E(nx, ny));
				}
			}
		}
		if (grid[xf][yf] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(grid[xf][yf]);
		}
	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

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
