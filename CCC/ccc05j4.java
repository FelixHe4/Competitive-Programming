package Unit1;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ccc05j4 {

	public static void main(String[] args) throws IOException {
		int c = readInt(), r = readInt();
		boolean[][] vis = new boolean[r][c];
		int w = readInt(), h = readInt();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				vis[i][j] = true;
			}
		}
		for (int i = r - h; i < r; i++) {
			for (int j = 0; j < w; j++) {
				vis[i][j] = true;
			}
		}
		for (int i = 0; i < h; i++) {
			for (int j = c - 1; j >= c - w; j--) {
				vis[i][j] = true;
			}
		}
		for (int i = r - h; i < r; i++) {
			for (int j = c - 1; j >= c - w; j--) {
				vis[i][j] = true;
			}
		}
//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < c; j++) {
//				System.out.print(vis[i][j] + " ");
//			}
//			System.out.println();
//		}
		int step = readInt();
		int curR = 0, curC = w;
		vis[curR][curC] = true;
		boolean move = false;
		int count = 0;
		while (true) {
			if (curR - 1 == -1 || curC + 1 == c || vis[curR - 1][curC] || vis[curR][curC + 1]) {
				if (curC + 1 < c && vis[curR][curC + 1] == false) {
					curC++;
					vis[curR][curC] = true;
					count++;
					move = true;
				} else if (curR + 1 < r && vis[curR + 1][curC] == false) {
					curR++;
					vis[curR][curC] = true;
					count++;
					move = true;
				} else if (curC - 1 >= 0 && vis[curR][curC - 1] == false) {
					curC--;
					vis[curR][curC] = true;
					count++;
					move = true;
				} else if (curR - 1 >= 0 && vis[curR - 1][curC] == false) {
					curR--;
					vis[curR][curC] = true;
					count++;
					move = true;
				}
			} else {
				if (curC - 1 >= 0 && vis[curR][curC - 1] == false) {
					curC--;
					vis[curR][curC] = true;
					count++;
					move = true;
				} else if (curR - 1 >= 0 && vis[curR - 1][curC] == false) {
					curR--;
					vis[curR][curC] = true;
					count++;
					move = true;
				} else if (curC + 1 < c && vis[curR][curC + 1] == false) {
					curC++;
					vis[curR][curC] = true;
					count++;
					move = true;
				} else if (curR + 1 < r && vis[curR + 1][curC] == false) {
					curR++;
					vis[curR][curC] = true;
					count++;
					move = true;
				}
			}
			if (!move) {
				break;
			} else {
				move = false;
			}
			if (count >= step) {
				break;
			}
			// System.out.println(curC + " " + curR);
		}
		System.out.println((curC + 1));
		System.out.println((curR + 1));

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
