package Unit1;
import java.io.*;
import java.util.*;
public class ccc18s2 {

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = readInt();
			}
		}
		// find the smallest number
		int iC = 0;
		int jC = 0;
		int minimum = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] < minimum) {
					minimum = grid[i][j];
					iC = i;
					jC = j;
				}
			}
		}
		if (iC == 0 && jC == n - 1) {
			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					System.out.print(grid[j][i] + " ");
				}
				System.out.println();
			}
		}
		else if (iC == n - 1 && jC == n - 1) {
			for (int i = n - 1; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}
		}
		else if (iC == n - 1 && jC == 0) {
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j >= 0; j--) {
					System.out.print(grid[j][i] + " ");
				}
				System.out.println();
			}
		}
		else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}
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
