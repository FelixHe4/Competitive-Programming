package Unit1;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class ccc15s5 {
	static int n, m;
	static int[] pies, bag;
	static int[][][][] dp;

	public static void main(String[] args) throws IOException {
		n = readInt();
		pies = new int[n + 1];
		dp = new int[3010][2][105][105];
		// 0 will represent not taken, 1 will represent taken
		for (int i = 1; i <= n; i++) {
			pies[i] = readInt();
		}
		m = readInt();
		for (int i = 0; i < n + 5; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < m + 5; k++) {
					for (int l = 0; l < m + 5; l++) {
						dp[i][j][k][l] = -1;
					}
				}
			}
		}
		bag = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			bag[i] = readInt();
		}
		Arrays.sort(bag);
		println(dp(1, 0, 1, m) + 1);
		exit();
	}

	static int dp(int cur, int taken, int left, int right) {
		if (dp[cur][taken][left][right] != -1) {
			return dp[cur][taken][left][right];
		}
		int max = -1;
		if (cur == n + 1) {
			if (left <= right) {
				if (taken == 0) {
					max = Math.max(max, dp(cur, 1, left, right - 1) + bag[right]);
				} else {
					max = Math.max(max, dp(cur, 0, left + 1, right));
				}
			}
		} else {
			if (taken == 1) {
				max = Math.max(max, dp(cur + 1, 0, left, right));
				if (left <= right) {
					max = Math.max(max, dp(cur, 0, left + 1, right));
				}
			} else {
				max = Math.max(dp(cur + 1, 1, left, right) + pies[cur], dp(cur + 1, 0, left, right));
				if (left <= right) {
					max = Math.max(max, dp(cur, 1, left, right - 1) + bag[right]);
				}
			}
		}
		return dp[cur][taken][left][right] = max;
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
