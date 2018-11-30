package Unit1;
import java.io.*;
import java.util.*;
public class ccc05s5 {
//	static int BinarySearch(int val) {
//		int high = n - 1;
//		int low = 0;
//		while (low <= high) {
//			int mid = (low + high) / 2;
//			if (sorted[mid] == val) {
//				return mid;
//			} else if (sorted[mid] > val) {
//				low = mid + 1;
//			} else high = mid - 1;
//		}
//		return -1;
//	}

	static long getSum(int idx) {
		long sum = 0;
		for (int i = idx; i > 0; i -= (i & -i)) {
			sum += BIT[i];
		}
		return sum;
	}

	static void update(long val, int idx) {
		for (int i = idx; i <= n; i += (i & -i)) {
			BIT[i] += val;
		}
	}

	static class Pair implements Comparable<Pair> {
		int f, s;

		public Pair(int f, int s) {
			this.f = f;
			this.s = s;
		}

		public int compareTo(Pair o) {
			return f - o.f;
		}
	}

	static int n;
	static int[] arr;
	static Pair[] index;
	static long[] BIT;

	public static void main(String[] args) throws IOException {
		n = readInt();
		arr = new int[n];
		index = new Pair[n];
		BIT = new long[n + 3];
		for (int i = 0; i < n; i++) {
			arr[i] = readInt();
			index[i] = new Pair(arr[i], i);
		}
		Arrays.sort(index);
		Collections.reverse(Arrays.asList(index));
//		System.out.println(Arrays.toString(sorted));
		for (int i = 0; i < arr.length; i++) {
			arr[index[i].s] = i + 1;
		}
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans += getSum(arr[i]) + 1;
			update(1, arr[i]);
		}
		// easy solution
		double x = ans * 100 / n / 100.0;
		System.out.printf("%.2f", x);
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
