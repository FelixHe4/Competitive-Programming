package Unit1;
import java.io.*;
import java.util.*;
public class ccc05j5 {

	public static void main(String[] args) throws IOException {
		while (true) {
			String s = readLine();
			if (s.equals("X")) {
				exit();
			}
			if (mWord(s)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}

	public static boolean aWord(String s) {
		if (s.equals("A")) {
			return true;
		}
		else if (s.length() >= 3 && s.charAt(0) == 'B'
				&& mWord(String.valueOf(s.subSequence(1, s.length() - 1)))
				&& s.charAt(s.length() - 1) == 'S') {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean mWord(String s) {
		if (aWord(s)) {
			return true;
		}
		else {
			boolean flag = false;
			for (int i = 1; i < s.length() - 1; i++) {
				if (aWord(s.substring(0, i)) && s.charAt(i) == 'N' && mWord(s.substring(i + 1))) {
					flag = true;
					break;
				}
			}
			return flag;
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
