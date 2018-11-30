package Unit1;
import java.io.*;
import java.util.*;
public class ccc13j2 {

	public static void main(String[] args) throws IOException {
		String s = readLine();
		boolean flag = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'I' || s.charAt(i) == 'X' || s.charAt(i) == 'O' || s.charAt(i) == 'S'
					|| s.charAt(i) == 'H' || s.charAt(i) == 'Z' || s.charAt(i) == 'N') {
				flag = false;
			}
			else {
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
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
