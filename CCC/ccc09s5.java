package Unit1;
import java.io.*;
import java.util.*;

public class ccc09s5 {

	public static void main(String[] args) throws IOException {
		int M = readInt();
		int N = readInt();
		int K = readInt();
		int l;
		int r;
		int[][] array = new int[M + 1][N + 1];
		for (int i = 0; i < M + 1; i++) {
			Arrays.fill(array[i], 0);
		}
		for (int i = 0; i < K; i++) {
			int x = readInt() - 1;
			int y = readInt() - 1;
			int R = readInt();
			int B = readInt();
			for (int j = Math.max(0, x - R); j <= Math.min(N - 1, x + R); j++) {
				l = Math.max(0, y - (int) Math.sqrt(R * R - (x - j) * (x - j)));
				r = Math.min(M - 1, y + (int) Math.sqrt(R * R - (x - j) * (x - j)));
				array[l][j] += B;
				array[r + 1][j] -= B;
			}
		}
		int best = 0;
		int count = 0;
		for (int i = 0; i < M; i++)
			for (int j = 0; j < N; j++) {
				// calculate the actual bitrate at (i,j) by adding
				if (i > 0) {
					array[i][j] += array[i - 1][j];
				}
				if (array[i][j] == best) {
					count++;
				}
				if (array[i][j] > best) {
					best = array[i][j];
					count = 1;
				}
			}
		System.out.println(best);
		System.out.println(count);
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
