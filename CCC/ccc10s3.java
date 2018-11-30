package Unit1;
import java.io.*;
import java.util.*;
public class ccc10s3 {

	static int[] h;
	static int n;

	public static void main(String[] args) throws IOException {
		int l = 1000000;
		n = readInt();
		h = new int[2 * n];
		for (int x = 0; x < n; x++) {
			h[x] = readInt();
		}
		Arrays.sort(h);
		for (int x = 0; x < n; x++) {
			h[x + n] = h[x] + l;
		}
		int k = readInt();
		int lo = 0;
		int hi = l;
		while (lo < hi) {
			int mid = (hi + lo) / 2;
			if (k >= p(mid)) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		System.out.println(lo);
	}

	public static int p(int mid) {
		int h = Integer.MAX_VALUE;
		for (int i = 0; i < Math.min(n, 10); i++) {
			h = Math.min(h, c(i, mid));
		}
		return h;
	}

	public static int c(int j, int mid) {
		int curr = j, fh = 1;
		for (int i = j; i < n + j; i++) {
			if (h[i] - h[curr] > 2 * mid) {
				curr = i;
				fh++;
			}
		}
		return fh;
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
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

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine();
	}

	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

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
		br.close();
		pr.close();
		System.exit(0);
	}
}
