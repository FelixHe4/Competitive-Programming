package Unit1;
import java.io.*;
import java.util.*;
public class ccc03s3 {

	public static void main(String[] args) throws IOException {
		int tiles = readInt();
		int R = readInt();
		int C = readInt();
		char[][] grid = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			grid[i] = readLine().toCharArray();
		}
		int x = 0;
		int y = 0;
		ArrayList<Integer> a = new ArrayList<Integer>();
		int rmsize = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == '.' && !visited[i][j]) {
					x = i;
					y = j;
					Queue<Integer> rowQ = new LinkedList<Integer>();
					Queue<Integer> colQ = new LinkedList<Integer>();
					rowQ.add(x);
					colQ.add(y);
					visited[x][y] = true;
					rmsize++;
					while (!rowQ.isEmpty()) {
						int curX = rowQ.poll();
						int curY = colQ.poll();
						if (curX - 1 > 0 && !visited[curX - 1][curY]
								&& grid[curX - 1][curY] == '.') {
							rmsize++;
							visited[curX - 1][curY] = true;
							rowQ.add(curX - 1);
							colQ.add(curY);
						}
						if (curX + 1 < R && !visited[curX + 1][curY]
								&& grid[curX + 1][curY] == '.') {
							rmsize++;
							visited[curX + 1][curY] = true;
							rowQ.add(curX + 1);
							colQ.add(curY);
						}
						if (curY - 1 > 0 && !visited[curX][curY - 1]
								&& grid[curX][curY - 1] == '.') {
							rmsize++;
							visited[curX][curY - 1] = true;
							rowQ.add(curX);
							colQ.add(curY - 1);
						}
						if (curY + 1 < C && !visited[curX][curY + 1]
								&& grid[curX][curY + 1] == '.') {
							rmsize++;
							visited[curX][curY + 1] = true;
							rowQ.add(curX);
							colQ.add(curY + 1);
						}
					}
					a.add(rmsize);
					rmsize = 0;
				}
			}

		}
		System.out.println(a);
		Collections.sort(a, Collections.reverseOrder());
		int trm = 0;
		for (int i = 0; i < a.size(); i++) {
			System.out.println(tiles);
			if (tiles - a.get(i) >= 0) {
				trm++;
				tiles -= a.get(i);
			}
			else {
				break;
			}
		}
		if (trm == 1) {
			System.out.println(trm + " room, " + tiles + " square metre(s) left over");
		}
		else {
			System.out.println(trm + " rooms, " + tiles + " square metre(s) left over");
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

	static PrintWriter pr = new PrintWriter(
			new BufferedWriter(new OutputStreamWriter(System.out)));

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
