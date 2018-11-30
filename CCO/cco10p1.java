package Unit2;
import java.io.*;
import java.util.*;
public class cco10p1 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int d = readInt();
		ArrayList<Integer>[] a = new ArrayList[d];
		int[] dog = new int[d];
		for (int i = 0; i < a.length; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < d; i++) {
			int b = readInt();
			dog[i] = b;
		}
		int f = readInt();
		for (int i = 0; i < f; i++) {
			int dogA = readInt() - 1, dogB = readInt() - 1;
			a[dogA].add(dogB);
		}
		int t = readInt();
		int[] barks = new int[d];
		barks[0]++;
		int[] da = new int[d];
		for (int i : a[0]) {
			da[i] = dog[i];
		}
		for (int i = 0; i <= t; i++) {
			boolean[] s = new boolean[d];
			for (int j = 0; j < d; j++) {
				if (da[j] > 0 && !s[j]) {
					da[j]--;
					if (da[j] == 0) {
						barks[j]++;
						s[j] = true;
						for (int k : a[j]) {
							if (da[k] == 0 && !s[k]) {
								da[k] = dog[k];
								s[k] = true;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < d; i++) {
			println(barks[i]);
		}
		exit();
	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static String readLine() throws IOException {
		byte[] buf = new byte[64]; // line length
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
