package Unit1;
import java.io.*;
import java.util.*;
public class ccc16s5 {
	static int n;
	static long t;
	static long[] before;
	static long[] after;

	public static void main(String[] args) throws IOException {
		n = readInt();
		t = readLong();
		before = new long[n];
		String s = readLine();
		for (long i = 0; i < s.length(); i++) {
			before[(int) i] = s.charAt((int) i) - '0';
		}
		after = new long[(int) n];
		rec(t);
	}

	public static void rec(long t) {
		if (t == 0) {
			for (int i = 0; i < before.length; i++) {
				System.out.print(before[i]);
			}
			return;
		}
		if (t == 1) {
			for (int i = 0; i < n; i++) {
				if (i == 0) { // first one
					after[i] = before[(int) n - 1] ^ before[i + 1];
				}
				else if (i == n - 1) { // last one
					after[i] = before[i - 1] ^ before[0];
				}
				else {
					after[i] = before[i - 1] ^ before[i + 1];
				}
				System.out.print(after[i]);
			}
			System.out.println();
			return;
		}
		else {
			long two = 2;
			while (two <= t) {
				two *= 2;
			}
			two /= 2;
			t -= two;
			// remainder (recursion the t);
			// the distance between the value horizontally and down is the biggest power of
			// 2
			for (int i = 0; i < before.length; i++) {
				int temp = (int) (two % before.length);
				int down = i - temp;
				int up = i + temp;
				if (down < 0) {
					down = before.length + down;
				}
				if (up >= before.length) {
					up = up - before.length;
				}
				after[i] = before[down] ^ before[up];
			}
			for (int i = 0; i < before.length; i++) {
				before[i] = after[i];
			}
			rec(t);

		}

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
