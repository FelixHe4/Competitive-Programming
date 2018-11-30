package Unit2;
import java.io.*;
import java.util.*;
public class dmopc15c1p5 {

	public static void main(String[] args) throws IOException {
		int w = readInt();
		int h = readInt();
		int n = readInt();
		int[][] grid = new int[h + 1][w + 1];
		for (int i = 1; i <= h; i++)
			for (int j = 1; j <= w; j++)
				grid[i][j] = readInt() + grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1];
		int ans = 0;
		for (int i = 1; i <= h; i++) {
			int width = n / i;
			if (width == 0)
				break;
			for (int j = 1; j <= h - i + 1; j++) {
				for (int k = 1; k <= w - width + 1; k++) {
					ans = Math.max(ans, grid[j + i - 1][k + width - 1] - grid[j - 1][k + width - 1]

							- grid[j + i - 1][k - 1] + grid[j - 1][k - 1]);
				}
				ans = Math.max(ans, grid[j + i - 1][Math.min(w, 1 + width - 1)]
						- grid[j - 1][Math.min(w, 1 + width - 1)] - grid[j + i - 1][1 - 1]
						+ grid[j - 1][1 - 1]);
			}
		}
		System.out.println(ans);
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