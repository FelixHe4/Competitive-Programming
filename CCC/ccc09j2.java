package Unit1;
import java.io.*;
import java.util.*;
public class ccc09j2 {

	public static void main(String[] args) throws IOException {
		int t = readInt();
		int pi = readInt();
		int pick = readInt();
		int total = readInt();
		int c = 0;
		for (int i = 0; i <= total; i++) {
			for (int j = 0; j <= total; j++) {
				for (int k = 0; k <= total; k++) {
					if ((i > 0 || j > 0 || k > 0) && (i * t + j * pi + pick * k <= total)) {
						c++;
						System.out.println(i + " Brown Trout, " + j + " Northern Pike, " + k
								+ " Yellow Pickerel");
					}
				}
			}
		}
		System.out.println("Number of ways to catch fish: " + c);
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
