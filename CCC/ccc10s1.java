package Unit1;
import java.io.*;
import java.util.*;
public class ccc10s1 {
	public static class Type implements Comparable<Type> {
		String name;
		int value;

		public Type(String name, int value) {
			this.name = name;
			this.value = value;
		}

		public int compareTo(Type t) {
			return value - t.value;
		}
	}

	public static void main(String[] args) throws IOException {
		int n = readInt();
		if (n == 0) {
			return;
		}
		if (n == 1) {
			print(read());
			exit();
		}
		Type[] val = new Type[n];
		for (int i = 0; i < n; i++) {
			String s = read();
			int R = readInt(), S = readInt(), D = readInt();
			val[i] = new Type(s, 2 * R + 3 * S + D);
		}
		Arrays.sort(val);
		if (val[val.length - 1].value == val[val.length - 2].value) {
			if (val[val.length - 1].name.compareTo(val[val.length - 2].name) > 0) {
				println(val[val.length - 2].name);
				println(val[val.length - 1].name);
			} else {
				println(val[val.length - 1].name);
				println(val[val.length - 2].name);
			}
		} else if (val[val.length - 2].value == val[val.length - 3].value) {
			if (val[val.length - 2].name.compareTo(val[val.length - 3].name) > 0) {
				println(val[val.length - 1].name);
				println(val[val.length - 3].name);
			} else {
				println(val[val.length - 1].name);
				println(val[val.length - 2].name);
			}
		} else {
			println(val[val.length - 1].name);
			println(val[val.length - 2].name);
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
