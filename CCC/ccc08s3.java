package Unit1;
import java.io.*;
import java.util.*;
public class ccc08s3 {

	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int runs = 0; runs < t; runs++) {
			int R = readInt();
			int C = readInt();
			char[][] grid = new char[R][C];
			int[][] step = new int[R][C];
			for (int i = 0; i < R; i++) {
				Arrays.fill(step[i], Integer.MAX_VALUE);
			}
			for (int i = 0; i < R; i++) {
				String s = readLine();
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) == '+') {
						grid[i][j] = 'a';
					}
					if (s.charAt(j) == '|') {
						grid[i][j] = 'b';
					}
					if (s.charAt(j) == '-') {
						grid[i][j] = 'c';
					}
					if (s.charAt(j) == '*') {
						grid[i][j] = 'd';
						step[i][j] = -1;
					}
				}
			}
			int startX = 0;
			int startY = 0;
			Queue<Integer> rowQ = new LinkedList<Integer>();
			Queue<Integer> colQ = new LinkedList<Integer>();
			rowQ.add(startX);
			colQ.add(startY);
			step[startX][startY] = 1;
			while (!rowQ.isEmpty()) {
				int curX = rowQ.poll();
				int curY = colQ.poll();
				if (grid[curX][curY] == 'a') {
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
				if (grid[curX][curY] == 'b') {
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
				}
				if (grid[curX][curY] == 'c') {
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
			}
			if (step[R - 1][C - 1] == Integer.MAX_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(step[R - 1][C - 1]);
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
