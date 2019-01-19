package Unit2;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class dpf {
	static String s1, s2;
	static char[] lcs;

	public static void main(String[] args) throws IOException {
		s1 = readLine();
		s2 = readLine();
		char[] NArr = new char[s1.length()], MArr = new char[s2.length()];
		for (int i = 0; i < s1.length(); i++) {
			NArr[i] = s1.charAt(i);
		}
		for (int i = 0; i < s2.length(); i++) {
			MArr[i] = s2.charAt(i);
		}
		LCS(NArr, MArr);
		for (int i = 0; i < lcs.length - 1; i++) {
			print(lcs[i]);
		}
		println();
		exit();
	}

	static void LCS(char[] NArr, char[] MArr) {
		int[][] LCS = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < LCS.length; i++) {
			for (int j = 0; j < LCS[i].length; j++) {
				if (i == 0 || j == 0) {
					LCS[i][j] = 0;
					// nothing
				} else if (NArr[i - 1] == MArr[j - 1]) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				} else {
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
				}
			}
		}
		int cur = LCS[s1.length()][s2.length()];
		lcs = new char[LCS[s1.length()][s2.length()] + 1];
		lcs[lcs.length - 1] = '#';
		int i = s1.length(), j = s2.length();
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				lcs[cur - 1] = s1.charAt(i - 1);
				i--;
				j--;
				cur--;
			} else if (LCS[i - 1][j] > LCS[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static String readLine() throws IOException {
		byte[] buf = new byte[1000000]; // line length
		int cnt = 0, c;
		while ((c = Read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}

	public static String read() throws IOException {
		byte[] ret = new byte[1024];
		int idx = 0;
		byte c = Read();
		while (c <= ' ') {
			c = Read();
		}
		do {
			ret[idx++] = c;
			c = Read();
		} while (c != -1 && c != ' ' && c != '\n' && c != '\r');
		return new String(ret, 0, idx);
	}

	public static int readInt() throws IOException {
		int ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}

	public static long readLong() throws IOException {
		long ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public static double readDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();

		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = Read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private static byte Read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}

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
		din.close();
		pr.close();
		System.exit(0);
	}
}
