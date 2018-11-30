package Unit2;
import java.io.*;
import java.util.*;
public class dmpg15s5 {
	static byte[][] grid;
	static byte[][] psa;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int a, b, c, d;
		psa = new byte[n + 100][n + 100];
		grid = new byte[n + 100][n + 100];
		for (int i = 0; i < m; i++) {
			a = readInt() + 1;
			b = readInt() + 1;
			c = readInt();
			d = readInt();
			compute(a, b, c, d);
		}
		// System.out.println();
		// for (int i = 0; i < n + 1; i++) {
		// for (int j = 0; j < n + 1; j++) {
		// System.out.print(grid[i][j] + " ");
		// }
		// System.out.println();
		// }
		int t = 0;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				psa[i][j] = (byte) (psa[i - 1][j] + psa[i][j - 1]
						- psa[i - 1][j - 1] + grid[i][j]);
			}
		}
		// psa 2d query r1, c1 to r2, c2
		// psa[r2][c2] - psa[r1 - 1][c2] - psa[r2][c1-1] + psa[r1-1][c1-1]
		// for (int i = 1; i < n + 1; i++) {
		// for (int j = 1; j < n + 1; j++) {
		// System.out.print(psa[i][j] + " ");
		// }
		// System.out.println();
		// }
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (psa[i][j] % 2 != 0) {
					t++;
				}

			}
		}
		System.out.println(t);
	}

	public static byte[][] compute(int x, int y, int w, int h) {
		grid[x][y]++;
		grid[x + w][y]--;
		grid[x][y + h]--;
		grid[x + w][y + h]++;
		return grid;
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
