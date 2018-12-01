package ecoo18r1;
import java.util.*;
import java.io.*;
public class ecoo18r1p44 {
	public static class Pair {
		long x, y;

		public Pair(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		// br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new FileReader(
				"C:\\Users\\Dingding\\eclipse-workspace\\ecoo2018\\src\\ecoo2018\\DATA41.txt"));
		// br = new BufferedReader(new FileReader("DATA42.txt"));
		long dp[] = new long[50];
		dp[0] = dp[1] = 1;
		Pair start = new Pair(1, -1);
		Pair[] coords = new Pair[50];
		coords[0] = start;
		for (int i = 2; i <= 49; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		for (int i = 1; i <= 49; i++) {
			long X = coords[i - 1].x;
			long Y = coords[i - 1].y;
			if (i % 4 == 1) {
				X = X - dp[i] - dp[i - 1];
			}
			if (i % 4 == 2) {
				Y = Y + dp[i] + dp[i - 1];
			}
			if (i % 4 == 3) {
				X = X + dp[i] + dp[i - 1];
			}
			if (i % 4 == 0) {
				Y = Y - dp[i] - dp[i - 1];
			}
			coords[i] = new Pair(X, Y);
		}

		// for(int i = 0; i<50; i++) System.out.println(coords[i].x + " " +
		// coords[i].y);
		for (int testcasenum = 0; testcasenum < 10; testcasenum++) {
			long X = readLong(), Y = readLong();
			for (int i = 0; i < 50; i++) {
				// System.out.println(i);
				if (i % 4 == 0) {
					if (X <= coords[i].x && X >= coords[i].x - dp[i] && Y >= coords[i].y
							&& Y <= coords[i].y + dp[i]) {
						System.out.println(i + 1);
						break;
					}
				}
				if (i % 4 == 1) {
					if (X <= coords[i].x + dp[i] && X >= coords[i].x && Y >= coords[i].y
							&& Y <= coords[i].y + dp[i]) {
						System.out.println(i + 1);
						break;
					}
				}
				if (i % 4 == 2) {
					if (X <= coords[i].x + dp[i] && X >= coords[i].x && Y >= coords[i].y - dp[i]
							&& Y <= coords[i].y) {
						System.out.println(i + 1);
						break;
					}
				}
				if (i % 4 == 3) {
					if (X <= coords[i].x && X >= coords[i].x - dp[i] && Y >= coords[i].y - dp[i]
							&& Y <= coords[i].y + dp[i]) {
						System.out.println(i + 1);
						break;
					}
				}
			}
		}
		flush();
		exit();
	}

	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static String read() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(read());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(read());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(read());
	}

	static char readCharacter() throws IOException {
		return read().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}

	static void println() throws IOException {
		pr.println();
	}

	static void println(Object o) throws IOException {
		pr.println(o);
	}

	static void print(Object o) throws IOException {
		pr.print(o);
	}

	static void flush() throws IOException {
		pr.flush();
	}

	static void exit() throws IOException {
		br.close();
		pr.close();
		System.exit(0);
	}
}