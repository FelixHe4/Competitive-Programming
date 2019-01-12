package Unit2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
public class nccc1j4s2 {

	public static void main(String[] args) throws IOException {
		int n = readInt();
		char[][] c = new char[n][n];
		char[] temp = new char[n];
		int flag = 0;
		for (int i = 0; i < n; i++) {
			String s = readLine();
			c[i] = s.toCharArray();
			temp = s.toCharArray();
			if (isDup(temp)) {
				flag = 1;
				break;
			}

		}
		if (flag == 0) {
			if (Integer.valueOf(c[0][0]) == Integer.valueOf(c[0][1]) - 1) {
				flag = 3;
			} else {
				flag = 2;
			}
		}
		if (flag == 1) {
			System.out.println("No");
		} else if (flag == 2) {
			System.out.println("Latin");
		} else if (flag == 3) {
			System.out.println("Reduced");
		}

	}

	public static boolean isDup(char[] temp) {
		Arrays.sort(temp);
		boolean dup = false;
		for (int i = 0; i < temp.length - 1; i++) {
			if (temp[i] == temp[i + 1]) {
				dup = true;
				break;
			}
		}
		return dup;
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