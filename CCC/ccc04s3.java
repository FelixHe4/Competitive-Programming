package Unit1;
import java.io.*;
import java.util.*;
public class ccc04s3 {
	static String[][] s;
	static int[][] a;
	static HashMap<Character, Integer> hm;

	public static void main(String[] args) throws IOException {
		hm = new HashMap<Character, Integer>();
		hm.put('A', 0);
		hm.put('B', 1);
		hm.put('C', 2);
		hm.put('D', 3);
		hm.put('E', 4);
		hm.put('F', 5);
		hm.put('G', 6);
		hm.put('H', 7);
		hm.put('I', 8);
		hm.put('J', 9);
		s = new String[10][9];
		a = new int[10][9];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				s[i][j] = next();
				a[i][j] = -1;
			}
		}
		boolean c = true;
		while (c) {
			c = false;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 9; j++) {
					String[] s1 = s[i][j].split("\\+");
					int counter = 0;
					int v = 0;
					int x = 0;
					while (counter < s1.length && x != -1) {
						x = change(s1[counter]);
						if (x == -1) {
							v = -1;
						}
						else {
							v += x;
						}
						counter++;
					}
					if (a[i][j] != v) {
						c = true;
						a[i][j] = v;
					}

				}
			}
		}
		System.out.println();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 9; j++) {
				if (a[i][j] == -1) {
					System.out.print("*" + " ");
				}
				else {
					System.out.print(a[i][j] + " ");
				}
			}
			System.out.println();
		}

	}

	public static int change(String s) {
		int v;
		if (s.charAt(0) >= 'A' && s.charAt(0) <= 'J') {
			v = a[hm.get(s.charAt(0))][s.charAt(1) - '0' - 1];
		}
		else
			v = Integer.parseInt(s);
		return v;
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
