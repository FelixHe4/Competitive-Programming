package Unit2;
import java.io.*;
import java.util.*;
public class aplusb {

	public static void main(String[] args) throws IOException {
		int n = readInt();
		for (int i = 0; i < n; i++) {
			String s1 = readLine();
			String s2 = readLine();
			if (s1.contains("-")) {
				subtract(s1, s2);
			}
			else if (s2.contains("-")) {
				subtract(s2, s1);
			}
			else {
				add(s1, s2);
			}
		}
	}

	public static void add(String s1, String s2) {
		int carry = 0;
		LinkedList<String> l = new LinkedList<String>();
		if (s1.length() > s2.length()) {
			for (int i = s2.length(); i < s1.length(); i++) {
				s2 = "0" + s2;
			}
		}
		else if (s2.length() > s1.length()) {
			for (int i = s1.length(); i < s2.length(); i++) {
				s1 = "0" + s1;
			}
		}
		int l1 = s1.length() - 1;
		int l2 = s2.length() - 1;
		while (true) {
			int n1 = Integer.valueOf(Character.toString(s1.charAt(l1)));
			int n2 = Integer.valueOf(Character.toString(s2.charAt(l2)));
			l1--;
			l2--;
			int n3 = n1 + n2 + carry;
			if (n3 > 9) {
				carry = 1;
				n3 -= 10;
			}
			else {
				carry = 0;
			}
			l.add(String.valueOf(n3));
			l1--;
			l2--;
			if (l1 < 0) {
				l.add(String.valueOf(carry));
				break;
			}
		}
		Collections.reverse(l);
		for (String r : l) {
			System.out.print(r);
		}
	}

	public static void subtract(String s1, String s2) {
		int borrow = 0;
		int difference = 0;
		int digit_1 = 0;
		int digit_2 = 0;
		String result = "";
		int k = 0;
		char[] num1Char = s1.toCharArray();
		char[] num2Char = s2.toCharArray();
		int[] resultChar = new int[num1Char.length];

		// Array.Reverse (num1Char);
		// Array.Reverse (num2Char);

		int length1 = num1Char.length;
		int length2 = num2Char.length;

		for (int i = length1 - 1; i >= 0; i--) {

			digit_1 = num1Char[i] - '0';

			if (k > length2 - 1)
				digit_2 = 0;
			else
				digit_2 = num2Char[length2 - 1 - k] - '0';

			difference = (digit_1 - digit_2 - borrow);

			if (difference < 0) {
				difference += 10;
				borrow = 1;
			}
			else
				borrow = 0;

			k++;

			resultChar[i] = difference;
		}

		for (int i = 0; i < length1; i++)
			result.concat((resultChar[i]) + " ");
		System.out.println(result);
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
