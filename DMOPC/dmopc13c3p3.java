package Unit2;
import java.io.*;
import java.util.*;
public class dmopc13c3p3 {
	// public static int moves[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	// public static class E {
	// 	int x, y;

	// 	public E(int x, int y) {
	// 		this.x = x;
	// 		this.y = y;
	// 	}
	// }

	// public static boolean valid(int x, int y) {
	// 	if (x >= 1 && x <= num_rows && y >= 1 && y <= num_cols)
	// 		return true;
	// 	return false;
	// }

	public static void main(String[] args) throws IOException {
		int N = readInt();
		int H = readInt();
		boolean[][] visited = new boolean[N][N];
		int[][] grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = readInt();
			}
		}

		// Queue<E> q = new LinkedList<E>();
		// q.add(new E(0, 0));
		// while (!q.isEmpty()) {
		// 	E current = q.poll();
		// 	int x = current.x, y = current.y;
		// 	for (int i = 0; i < 4; i++) {
		// 		int nx = x + moves[i][0], ny = y + moves[i][1];
		// 		if (!vis[nx][ny] && valid(nx, ny)) {
		// 			vis[nx][ny] = true;
		// 			dis[nx][ny] = dis[x][y] + 1;
		// 			q.push(new E(nx, ny));
		// 		}
		// 	}
		// }

		Queue<Integer> rowQ = new LinkedList<Integer>();
		Queue<Integer> colQ = new LinkedList<Integer>();
		rowQ.add(1);
		colQ.add(1);
		while (!rowQ.isEmpty()) {
			int curX = rowQ.poll();
			int curY = colQ.poll();
			if (curX - 1 >= 0 && visited[curX - 1][curY] == false
					&& (grid[curX][curY] - grid[curX - 1][curY] <= H && grid[curX][curY] - grid[curX - 1][curY] >= 0
							|| grid[curX - 1][curY] - grid[curX][curY] <= H
									&& grid[curX - 1][curY] - grid[curX][curY] >= 0)) {
				visited[curX - 1][curY] = true;
				rowQ.add(curX - 1);
				colQ.add(curY);
			}
			if (curX + 1 < N && visited[curX + 1][curY] == false
					&& (grid[curX][curY] - grid[curX + 1][curY] <= H && grid[curX][curY] - grid[curX + 1][curY] >= 0
							|| grid[curX + 1][curY] - grid[curX][curY] <= H
									&& grid[curX + 1][curY] - grid[curX][curY] >= 0)) {
				visited[curX + 1][curY] = true;
				rowQ.add(curX + 1);
				colQ.add(curY);
			}
			if (curY - 1 >= 0 && visited[curX][curY - 1] == false
					&& (grid[curX][curY] - grid[curX][curY - 1] <= H && grid[curX][curY] - grid[curX][curY - 1] >= 0
							|| grid[curX][curY - 1] - grid[curX][curY] <= H
									&& grid[curX][curY - 1] - grid[curX][curY] >= 0)) {
				visited[curX][curY - 1] = true;
				rowQ.add(curX);
				colQ.add(curY - 1);
			}
			if (curY + 1 < N && visited[curX][curY + 1] == false
					&& (grid[curX][curY] - grid[curX][curY + 1] <= H && grid[curX][curY] - grid[curX][curY + 1] >= 0
							|| grid[curX][curY + 1] - grid[curX][curY] <= H
									&& grid[curX][curY + 1] - grid[curX][curY] >= 0)) {
				visited[curX][curY + 1] = true;
				rowQ.add(curX);
				colQ.add(curY + 1);
			}
		}
		if (visited[N - 1][N - 1] == true) {
			System.out.println("yes");
		} else {
			System.out.println("no");
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
