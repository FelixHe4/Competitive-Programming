package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SparseTable {

	// Answers static range minimum/maximum query
	// cannot be updated
	// used to find LCA (Lowest Common Ancestry)
	// What is the smallest element between l and r
	// Seg tree is O(nlogn) preprocess
	// and O(nlogn) query
	// O(nlogn) preprocessing
	// O(1) query
	// Precompute RMQ over a set of ranges such that there are fewer ??
	// Compute RMQ for ranges starting at i of size 1, 2, 4, 8, 16 ... as long as they still fit in the array.
	// Gives both large and small ranges starting at any point in the array.
	// Only O(logn) ranges computed for each array element.
	// total number of ranges is O(nlonn)
	// Any range in the array can be formed as the union of two of these ranges.
	// if range is 18, take the highest 2^k
	// then, go from left up 2^k and from right down 2^k
	// take the minimum
	// RMQ(i, j)
	// largest k such that 2^k <. j-i+1
	// use log to do the k.
	// ranges are [i, i + 2^k - 1] and [j - 2^k + 1, j]

	// LCA

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int q = readInt();
		int k = (int) 16;
		int k2 = (int) 15;
		int[][] minsparse = new int[n][k];
		int[][] maxsparse = new int[n][k];
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = readInt();
		}
		for (int i = 0; i < n; i++) {
			minsparse[i][0] = arr[i];
			maxsparse[i][0] = arr[i];
		}
		for (int j = 1; j <= k2; j++) {
			for (int i = 0; i + (1 << j) - 1 < n; i++) {
				minsparse[i][j] = Math.min(minsparse[i][j - 1], minsparse[i + (1 << (j - 1))][j - 1]);
				maxsparse[i][j] = Math.max(maxsparse[i][j - 1], maxsparse[i + (1 << (j - 1))][j - 1]);
			}
		}
		for (int i = 0; i < q; i++) {
			int l = readInt() - 1, r = readInt() - 1;
			long ans = (1 << 30);
			long ans2 = (-1 << 30);
			k = 31 - Integer.numberOfLeadingZeros(r - l + 1);
			ans = Math.min(minsparse[l][k], minsparse[r - (1 << k) + 1][k]);
			ans2 = Math.max(maxsparse[l][k], maxsparse[r - (1 << k) + 1][k]);
			System.out.println(ans2 - ans);
		}

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
