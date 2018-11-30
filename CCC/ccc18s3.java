package Unit1;
import java.io.*;
import java.util.*;
public class ccc18s3 {

	public static void main(String[] args) throws IOException {
		// Store relationship or map into 2D array
		int R = readInt();
		int C = readInt();
		char[][] grid = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = readLine();
			// for (int j = 0; j < C; j++) {
			// grid[i][j] = s.charAt(j);
			// }
			grid[i] = s.toCharArray();
		}
		// Step array to store which step access the location or page
		// locations where the robot can go, put Integer.MAX_VALUE
		// locations where the robot can't go, put -1
		int[][] step = new int[R][C];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (grid[r][c] == 'W') {
					step[r][c] = -1;
				}
				else if (grid[r][c] == 'C') {
					step[r][c] = -1;
					// set the camera zone to 01;
					// up
					for (int i = r - 1; i >= 0; i--) {
						if (grid[i][c] == 'W') {
							break;
						}
						else {
							if (grid[i][c] == '.' || grid[i][c] == 'S') {
								step[i][c] = -1;
							}
						}
					}
					// down
					for (int i = r + 1; i < R; i++) {
						if (grid[i][c] == 'W') {
							break;
						}
						else {
							if (grid[i][c] == '.' || grid[i][c] == 'S') {
								step[i][c] = -1;
							}
						}
					}
					// left
					for (int i = c - 1; i >= 0; i--) {
						if (grid[r][i] == 'W') {
							break;
						}
						else {
							if (grid[r][i] == '.' || grid[r][i] == 'S') {
								step[r][i] = -1;
							}
						}
					}
					// right
					for (int i = c + 1; i < C; i++) {
						if (grid[r][i] == 'W') {
							break;
						}
						else {
							if (grid[r][i] == '.' || grid[r][i] == 'S') {
								step[r][i] = -1;
							}
						}
					}
				}
				if (step[r][c] != -1) {
					step[r][c] = Integer.MAX_VALUE;
				}
			}
		}
		// Start our BFS
		// Queue to store the process order
		// Put the first location into queue
		// find out all the "." and store the location
		// using rowQ and colQ to store the processing order
		LinkedList<Integer> rowQ = new LinkedList<Integer>();
		LinkedList<Integer> colQ = new LinkedList<Integer>();
		// using x and y to store all the . locations
		LinkedList<Integer> x = new LinkedList<Integer>();
		LinkedList<Integer> y = new LinkedList<Integer>();
		// First location store here
		int Sr = 0;
		int Sc = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (grid[r][c] == '.') {
					x.add(r);
					y.add(c);
				}
				else if (grid[r][c] == 'S') {
					Sr = r;
					Sc = c;
				}
			}
		}
		if (step[Sr][Sc] == -1) {
			for (int i = 0; i < x.size(); i++) {
				System.out.println(-1);
			}
			return;
		}
		step[Sr][Sc] = 0;
		rowQ.add(Sr);
		colQ.add(Sc);
		while (!rowQ.isEmpty()) {
			int r = rowQ.poll();
			int c = colQ.poll();
			// check the neighbour
			// 4 neighbour (up down left right)
			// Valid neighbour boundary
			if (grid[r][c] == '.' || grid[r][c] == 'S') {
				// go up
				if (r - 1 >= 0 && step[r - 1][c] != -1) {
					if (grid[r - 1][c] == '.') {
						if (step[r - 1][c] > step[r][c] + 1) {
							step[r - 1][c] = step[r][c] + 1;
							rowQ.add(r - 1);
							colQ.add(c);
						}
					}
					else if (grid[r - 1][c] == 'U' || grid[r - 1][c] == 'D' ||
							grid[r - 1][c] == 'L' || grid[r - 1][c] == 'R') {
						if (step[r - 1][c] > step[r][c]) {
							step[r - 1][c] = step[r][c];
							rowQ.add(r - 1);
							colQ.add(c);
						}
					}
				}
				// down
				if (r + 1 < R && step[r + 1][c] != -1) {
					if (grid[r + 1][c] == '.') {
						if (step[r + 1][c] > step[r][c] + 1) {
							step[r + 1][c] = step[r][c] + 1;
							rowQ.add(r + 1);
							colQ.add(c);
						}
					}
					else if (grid[r + 1][c] == 'U' || grid[r + 1][c] == 'D' ||
							grid[r + 1][c] == 'L' || grid[r + 1][c] == 'R') {
						if (step[r + 1][c] > step[r][c]) {
							step[r + 1][c] = step[r][c];
							rowQ.add(r + 1);
							colQ.add(c);
						}
					}
				}
				// left
				if (c - 1 >= 0 && step[r][c - 1] != -1) {
					if (grid[r][c - 1] == '.') {
						if (step[r][c - 1] > step[r][c] + 1) {
							step[r][c - 1] = step[r][c] + 1;
							rowQ.add(r);
							colQ.add(c - 1);
						}
					}
					else if (grid[r][c - 1] == 'U' || grid[r][c - 1] == 'D' ||
							grid[r][c - 1] == 'L' || grid[r][c - 1] == 'R') {
						if (step[r][c - 1] > step[r][c]) {
							step[r][c - 1] = step[r][c];
							rowQ.add(r);
							colQ.add(c - 1);
						}
					}
				}
				// right
				if (c + 1 < C && step[r][c + 1] != -1) {
					if (grid[r][c + 1] == '.') {
						if (step[r][c + 1] > step[r][c] + 1) {
							step[r][c + 1] = step[r][c] + 1;
							rowQ.add(r);
							colQ.add(c + 1);
						}
					}
					else if (grid[r][c + 1] == 'U' || grid[r][c + 1] == 'D' ||
							grid[r][c + 1] == 'L' || grid[r][c + 1] == 'R') {
						if (step[r][c + 1] > step[r][c]) {
							step[r][c + 1] = step[r][c];
							rowQ.add(r);
							colQ.add(c + 1);
						}
					}
				}
			}
			if (grid[r][c] == 'U') {
				if (r - 1 >= 0 && step[r - 1][c] != -1) {
					if (grid[r - 1][c] == '.') {
						if (step[r - 1][c] > step[r][c] + 1) {
							step[r - 1][c] = step[r][c] + 1;
							rowQ.add(r - 1);
							colQ.add(c);
						}
					}
					else if (grid[r - 1][c] == 'U' || grid[r - 1][c] == 'D' ||
							grid[r - 1][c] == 'L' || grid[r - 1][c] == 'R') {
						if (step[r - 1][c] > step[r][c]) {
							step[r - 1][c] = step[r][c];
							rowQ.add(r - 1);
							colQ.add(c);
						}
					}
				}
			}
			else if (grid[r][c] == 'D') {
				if (r + 1 < R && step[r + 1][c] != -1) {
					if (grid[r + 1][c] == '.') {
						if (step[r + 1][c] > step[r][c] + 1) {
							step[r + 1][c] = step[r][c] + 1;
							rowQ.add(r + 1);
							colQ.add(c);
						}
					}
					else if (grid[r + 1][c] == 'U' || grid[r + 1][c] == 'D' ||
							grid[r + 1][c] == 'L' || grid[r + 1][c] == 'R') {
						if (step[r + 1][c] > step[r][c]) {
							step[r + 1][c] = step[r][c];
							rowQ.add(r + 1);
							colQ.add(c);
						}
					}
				}
			}
			else if (grid[r][c] == 'L') {
				if (c - 1 >= 0 && step[r][c - 1] != -1) {
					if (grid[r][c - 1] == '.') {
						if (step[r][c - 1] > step[r][c] + 1) {
							step[r][c - 1] = step[r][c] + 1;
							rowQ.add(r);
							colQ.add(c - 1);
						}
					}
					else if (grid[r][c - 1] == 'U' || grid[r][c - 1] == 'D' ||
							grid[r][c - 1] == 'L' || grid[r][c - 1] == 'R') {
						if (step[r][c - 1] > step[r][c]) {
							step[r][c - 1] = step[r][c];
							rowQ.add(r);
							colQ.add(c - 1);
						}
					}
				}
			}
			else if (grid[r][c] == 'R') {
				if (c + 1 < C && step[r][c + 1] != -1) {
					if (grid[r][c + 1] == '.') {
						if (step[r][c + 1] > step[r][c] + 1) {
							step[r][c + 1] = step[r][c] + 1;
							rowQ.add(r);
							colQ.add(c + 1);
						}
					}
					else if (grid[r][c + 1] == 'U' || grid[r][c + 1] == 'D' ||
							grid[r][c + 1] == 'L' || grid[r][c + 1] == 'R') {
						if (step[r][c + 1] > step[r][c]) {
							step[r][c + 1] = step[r][c];
							rowQ.add(r);
							colQ.add(c + 1);
						}
					}
				}
			}

		}
		for (int i = 0; i < x.size(); i++) {
			int n = step[x.get(i)][y.get(i)];
			if (n == Integer.MAX_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(n);
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