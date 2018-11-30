package Unit2;
import java.io.*;
import java.util.*;
public class dmopc13c1p4 {

	public static void main(String[] args) throws IOException {
		int testCases = readInt();
		for (int t = 0; t < testCases; t++) {
			int C = readInt();
			int R = readInt();
			char[][] grid = new char[R][C];
			int[][] step = new int[R][C];
			for (int r = 0; r < R; r++) {
				grid[r] = readLine().toCharArray();
			}
			for (int i = 0; i < R; i++) {
				Arrays.fill(step[i], Integer.MAX_VALUE);
			}
			int startX = 0;
			int startY = 0;
			int endX = 0;
			int endY = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (grid[i][j] == 'C') {
						startX = i;
						startY = j;
					}
					if (grid[i][j] == 'W') {
						endX = i;
						endY = j;
					}
					if (grid[i][j] == 'X') {
						step[i][j] = -1;
					}
				}
			}
			Queue<Integer> rowQ = new LinkedList<Integer>();
			Queue<Integer> colQ = new LinkedList<Integer>();
			step[startX][startY] = 0;
			rowQ.add(startX);
			colQ.add(startY);
			while (!rowQ.isEmpty()) {
				int curX = rowQ.poll();
				int curY = colQ.poll();
				if (curX - 1 >= 0 && step[curX - 1][curY] > step[curX][curY] + 1) {
					step[curX - 1][curY] = step[curX][curY] + 1;
					rowQ.add(curX - 1);
					colQ.add(curY);
				}
				if (curX + 1 < R && step[curX + 1][curY] > step[curX][curY] + 1) {
					step[curX + 1][curY] = step[curX][curY] + 1;
					rowQ.add(curX + 1);
					colQ.add(curY);
				}
				if (curY - 1 >= 0 && step[curX][curY - 1] > step[curX][curY] + 1) {
					step[curX][curY - 1] = step[curX][curY] + 1;
					rowQ.add(curX);
					colQ.add(curY - 1);
				}
				if (curY + 1 < C && step[curX][curY + 1] > step[curX][curY] + 1) {
					step[curX][curY + 1] = step[curX][curY] + 1;
					rowQ.add(curX);
					colQ.add(curY + 1);
				}
			}
			if (step[endX][endY] >= 60) {
				System.out.println("#notworth");
			}
			else {
				System.out.println(step[endX][endY]);
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
