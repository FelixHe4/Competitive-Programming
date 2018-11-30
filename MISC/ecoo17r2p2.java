package Unit2;
import java.io.*;
import java.util.*;
public class ecoo17r2p2 {

	public static void main(String[] args) throws IOException {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(0, 0);
		hm.put(1, 49);
		hm.put(2, 50);
		hm.put(3, 51);
		hm.put(4, 52);
		hm.put(5, 53);
		hm.put(6, 54);
		hm.put(7, 55);
		hm.put(8, 56);
		hm.put(9, 57);
		for (int runs = 0; runs < 10; runs++) {
			int N = readInt();
			int treasures = 0;
			int keys = 0;
			char[][] grid = new char[N][N];
			int[][] step = new int[N][N];
			for (int i = 0; i < N; i++) {
				grid[i] = readLine().toCharArray();
				Arrays.fill(step[i], Integer.MAX_VALUE);
			}
			int startX = 0;
			int startY = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (grid[i][j] == '#') {
						step[i][j] = -1;
					}
					if (grid[i][j] == 'S') {
						grid[i][j] = '.';
						step[i][j] = 0;
						startX = i;
						startY = j;
					}
				}
			}
			System.out.println();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}
			Queue<Integer> rowQ = new LinkedList<Integer>();
			Queue<Integer> colQ = new LinkedList<Integer>();
			rowQ.add(startX);
			colQ.add(startY);
			while (!rowQ.isEmpty()) {
				int curX = rowQ.poll();
				int curY = colQ.poll();
				if (curX - 1 >= 0 && step[curX - 1][curY] > step[curX][curY] + 1) {
					if ((int) grid[curX - 1][curY] >= 49 && grid[curX - 1][curY] <= 57) {
						if ((int) grid[curX - 1][curY] <= hm.get(keys)) {
							step[curX - 1][curY] = step[curX][curY] + 1;
							rowQ.add(curX - 1);
							colQ.add(curY);
						}
					}
					else {
						step[curX - 1][curY] = step[curX][curY] + 1;
						rowQ.add(curX - 1);
						colQ.add(curY);
					}
					if (grid[curX - 1][curY] == 'K') {
						keys++;
						grid[curX - 1][curY] = '.';
					}
					if (grid[curX - 1][curY] == 'T') {
						treasures++;
						grid[curX - 1][curY] = '.';
					}
				}
				if (curX + 1 < N && step[curX + 1][curY] > step[curX][curY] + 1) {
					if ((int) grid[curX + 1][curY] >= 49 && grid[curX + 1][curY] <= 57) {
						if ((int) grid[curX + 1][curY] <= hm.get(keys)) {
							step[curX + 1][curY] = step[curX][curY] + 1;
							rowQ.add(curX + 1);
							colQ.add(curY);
						}
					}
					else {
						step[curX + 1][curY] = step[curX][curY] + 1;
						rowQ.add(curX - 1);
						colQ.add(curY);
					}
					if (grid[curX + 1][curY] == 'K') {
						keys++;
						grid[curX + 1][curY] = '.';
					}
					if (grid[curX + 1][curY] == 'T') {
						treasures++;
						grid[curX + 1][curY] = '.';
					}
				}
				if (curY - 1 >= 0 && step[curX][curY - 1] > step[curX][curY] + 1) {
					if ((int) grid[curX][curY - 1] >= 49 && grid[curX - 1][curY] <= 57) {
						if ((int) grid[curX][curY - 1] <= hm.get(keys)) {
							step[curX][curY - 1] = step[curX][curY] + 1;
							rowQ.add(curX);
							colQ.add(curY - 1);
						}
					}
					else {
						step[curX][curY - 1] = step[curX][curY] + 1;
						rowQ.add(curX);
						colQ.add(curY - 1);
					}
					if (grid[curX][curY - 1] == 'K') {
						keys++;
						grid[curX][curY - 1] = '.';
					}
					if (grid[curX][curY - 1] == 'T') {
						treasures++;
						grid[curX][curY - 1] = '.';
					}
				}
				if (curY + 1 < N && step[curX][curY + 1] > step[curX][curY] + 1) {
					if ((int) grid[curX][curY + 1] >= 49 && grid[curX + 1][curY] <= 57) {
						if ((int) grid[curX][curY + 1] <= hm.get(keys)) {
							step[curX][curY + 1] = step[curX][curY] + 1;
							rowQ.add(curX);
							colQ.add(curY + 1);
						}
					}
					else {
						step[curX][curY + 1] = step[curX][curY] + 1;
						rowQ.add(curX);
						colQ.add(curY - 1);
					}
					if (grid[curX][curY + 1] == 'K') {
						keys++;
						grid[curX][curY + 1] = '.';
					}
					if (grid[curX][curY + 1] == 'T') {
						treasures++;
						grid[curX][curY + 1] = '.';
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
