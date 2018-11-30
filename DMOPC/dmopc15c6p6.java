package Unit2;
import java.io.*;
import java.util.*;
public class dmopc15c6p6 {

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int k = readInt();
		boolean[][] grid = new boolean[n + 1][n + 1];
		int[][] val = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int a = readInt();
			int b = readInt();
			grid[a][b] = true;
			grid[b][a] = true;
		}
		for (int i = 1; i < n + 1; i++) {
			Queue<Integer> q = new LinkedList<Integer>();
			int[] step = new int[n + 1];
			boolean[] vis = new boolean[n + 1];
			step[i] = 0;
			vis[i] = true;
			q.add(i);
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int j = 1; j < n + 1; j++) {
					if (grid[cur][j] == true && !vis[j]) {
						step[j] = step[cur] + 1;
						val[i][j] = step[cur] + 1;
						vis[j] = true;
						q.add(j);
					}
				}
			}
		}
		// System.out.println();
		// for (int i = 0; i < n + 1; i++) {
		// for (int j = 0; j < n + 1; j++) {
		// System.out.print(val[i][j] + " ");
		// }
		// System.out.println();
		// }
		int t = 0;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (val[i][j] <= k) {
					t++;
				}
			}
			System.out.println(t);
			t = 0;
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
