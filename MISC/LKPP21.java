package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class LKPP21 {
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for (int runs = 0; runs < n; runs++) {
			int x = readInt();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int i = 0; i <= x; i++) {
				arr.add(readInt());
			}
			int z = 1, y = 1;
			ArrayList<Integer> f = new ArrayList<Integer>();
			while (true) {
				if (f.size() == x) {
					break;
				}
				z = y;
				for (int j = 0; j <= 1; j++) {
					int total = 0;
					if (j == 1) {
						z *= -1;
					}
					for (int i = 0; i < arr.size(); i++) {
						if (j == 0) {
							total += Math.pow(z, (x) - i) * arr.get(i);
						} else {
							total += Math.pow(z, (x) - i) * arr.get(i);
						}
					}
					if (total == 0) {
						f.add(z);
						z *= -1;
						int curT = 0;
						ArrayList<Integer> copy = new ArrayList<Integer>();
						for (int i = 0; i < arr.size(); i++) {
							if (i == 0) {
								curT += arr.get(0);
							} else {
								curT *= z;
								curT = arr.get(i) - curT;
							}
							if (i != arr.size() - 1) {
								copy.add(curT);
							}
						}
						arr = copy;
						y = 0;
					}
				}
				y++;
			}
			Collections.sort(f);
			for (int i = 0; i < f.size(); i++) {
				System.out.print(f.get(i) + " ");
			}
			System.out.println();
		}
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
