package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class RogerNumbers {
	static long[] arr;
	static long[][][] dp;

	public static void main(String[] args) throws IOException {
		int l = readInt(), r = readInt();
		dp = new long[12][12][2];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		arr = new long[12];
		System.out.println(solve(r) - solve(l - 1));
	}

	static int solve(int x) {
		int n = 0;
		for (; x > 0; x /= 10) {
			arr[n++] = x % 10;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			long up = (i == n - 1) ? arr[n - 1] : 9;
			for (int j = 1; j <= up; j++) {
				count += fun(i - 1, j, i == n - 1 && j == arr[n - 1]);
			}
		}
		return count;
	}

	static long fun(int pos, int prev, boolean limit) {
		if (pos < 0) {
			return 1;
		}
		int z = 0;
		if (limit) {
			z = 1;
		}
		if (dp[pos][prev][z] != -1) {
			return dp[pos][prev][z];
		}
		long up = limit ? arr[pos] : 9, ret = 0;
		for (int i = 0; i <= up; i++) {
			if (Math.abs((i - prev)) >= 2) {
				ret += fun(pos - 1, i, limit && (i == arr[pos]));
			}
		}
		return dp[pos][prev][z] = ret;
	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static String readLine() throws IOException {
		byte[] buf = new byte[64]; // line length
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
