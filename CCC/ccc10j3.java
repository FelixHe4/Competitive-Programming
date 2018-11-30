package Unit1;
import java.io.*;
public class ccc10j3 {

	public static void main(String[] args) throws IOException {
		int a = 0, b = 0;
		while (true) {
			int op = readInt();
			if (op == 1) {
				char c = read().charAt(0);
				if (c == 'A') {
					a = readInt();
				} else {
					b = readInt();
				}
			} else if (op == 2) {
				char c = read().charAt(0);
				if (c == 'A') {
					System.out.println(a);
				} else {
					System.out.println(b);
				}
			} else if (op == 3) {
				char c = read().charAt(0);
				char d = read().charAt(0);
				if (c == 'A') {
					if (d == 'A') {
						a += a;
					} else {
						a += b;
					}
				} else {
					if (d == 'A') {
						b += a;
					} else {
						b += b;
					}
				}
			} else if (op == 4) {
				char c = read().charAt(0);
				char d = read().charAt(0);
				if (c == 'A') {
					if (d == 'A') {
						a *= a;
					} else {
						a *= b;
					}
				} else {
					if (d == 'A') {
						b *= a;
					} else {
						b *= b;
					}
				}
			} else if (op == 5) {
				char c = read().charAt(0);
				char d = read().charAt(0);
				if (c == 'A') {
					if (d == 'A') {
						a -= a;
					} else {
						a -= b;
					}
				} else {
					if (d == 'A') {
						b -= a;
					} else {
						b -= b;
					}
				}
			} else if (op == 6) {
				char c = read().charAt(0);
				char d = read().charAt(0);
				if (c == 'A') {
					if (d == 'A') {
						a /= a;
					} else {
						a /= b;
					}
				} else {
					if (d == 'A') {
						b /= a;
					} else {
						b /= b;
					}
				}
			} else if (op == 7) {
				exit();
			}
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
