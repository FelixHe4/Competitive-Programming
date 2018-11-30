package Unit1;
import java.io.*;
import java.util.*;
public class ccc09s4 {
	static int[][] grid;
	static int N;
	static int[] step;

	public static void main(String[] args) throws IOException {
		N = readInt(); // Number of Cities
		int T = readInt(); // Number of Trade Routes
		grid = new int[N + 1][N + 1];
		step = new int[N + 1];
		int[] cost = new int[N + 1];
		Arrays.fill(cost, 65535);
		for (int i = 0; i < T; i++) {
			int n1 = readInt();
			int n2 = readInt();
			int c = readInt();
			if (n1 >= 1 && n1 <= N && n2 >= 1 && n2 <= N) {
				grid[n1][n2] = c;
				grid[n2][n1] = c;
			}
		}
		int D = readInt(); // Shipping City
		for (int i = 0; i < D; i++) {
			int start = readInt();
			int startcost = readInt();
			if (start >= 1 && start <= N) {
				cost[start] = startcost;
			}
		}
		int destination = readInt();
		Djikstras(destination);
		int min = Integer.MAX_VALUE;
		int endcost = 0;
		for (int i = 1; i <= N; i++) {
			endcost = cost[i] + step[i];
			if (endcost < min)
				min = endcost;
		}
		System.out.println(min);
	}

	public static void Djikstras(int d) {
		boolean[] vis = new boolean[N + 1];
		int cur = 0;
		int s = 0;
		int count = 0;
		step = new int[N + 1];
		for (int i = 0; i < step.length; i++) {
			step[i] = Integer.MAX_VALUE;
		}
		step[d] = 0;
		while (count < N) {
			s = Integer.MAX_VALUE;
			cur = 1;
			for (int i = 1; i <= N; i++) {
				if (!vis[i] && step[i] < s) {
					s = step[i];
					cur = i;
				}
			}
			vis[cur] = true;
			count++;
			for (int i = 1; i <= N; i++) {
				if (grid[cur][i] > 0 && !vis[i]) {
					if (step[i] > step[cur] + grid[cur][i]) {
						step[i] = step[cur] + grid[cur][i];
					}
				}
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
