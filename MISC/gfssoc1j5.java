package Unit2;
import java.io.*;
import java.util.*;
public class gfssoc1j5 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int t = readInt();
		ArrayList<Integer>[] grid = new ArrayList[n + 1];
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i < grid.length; i++) {
			grid[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int a = readInt();
			int b = readInt();
			grid[a].add(b);
		}
		int runs = readInt();
		for (int k = 1; k < n + 1; k++) {
			Queue<Integer> q = new LinkedList<Integer>();
			int[] step = new int[n + 1];
			boolean[] vis = new boolean[n + 1];
			step[k] = 0;
			q.add(k);
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int j = 0; j < grid[cur].size(); j++) {
					if (!vis[grid[cur].get(j)]) {
						step[grid[cur].get(j)] = step[cur] + 1;
						dp[k][grid[cur].get(j)] = step[cur] + 1;
						vis[grid[cur].get(j)] = true;
						q.add(grid[cur].get(j));
					}
				}
			}
		}
		for (int i = 0; i < runs; i++) {
			int a = readInt();
			int b = readInt();
			if (dp[a][b] == 0) {
				println("Not enough hallways!");
			}
			else {
				println(dp[a][b] * t);
			}
		}
		exit();
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
