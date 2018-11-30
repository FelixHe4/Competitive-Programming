package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;

public class dwite11c2p5 {
	static int find(int n) {
		if (dsu[n] == n) {
			return n;
		} else {
			return dsu[n] = find(dsu[n]);
		}
	}

	static int[] dsu;

	public static void main(String[] args) throws IOException {
		for (int j = 0; j < 5; j++) {
			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			int q = readInt();
			int cur = 0;
			dsu = new int[1000000];
			for (int i = 0; i < dsu.length; i++) {
				dsu[i] = i;
			}
			while (q-- > 0) {
				String op = read();
				if (op.equals("p")) {
					String c1 = read(), c2 = read();
					if (!hm.containsKey(c1)) {
						hm.put(c1, cur);
						cur++;
					}
					if (!hm.containsKey(c2)) {
						hm.put(c2, cur);
						cur++;
					}
					int fa = find(hm.get(c1));
					int fb = find(hm.get(c2));
					if (fa != fb) {
						dsu[fb] = fa;
					}
				} else {
					String c1 = read(), c2 = read();
					boolean flag = false;
					if (!hm.containsKey(c1)) {
						hm.put(c1, cur);
						cur++;
						if (!c1.equals(c2)) {
							flag = true;
						}
					}
					if (!hm.containsKey(c2)) {
						hm.put(c2, cur);
						cur++;
						if (!c2.equals(c1)) {
							flag = true;
						}
					}
					if (!flag) {
						int fa = find(hm.get(c1));
						int fb = find(hm.get(c2));
						if (fa != fb) {
							println("not connected");
						} else {
							println("connected");
						}
					} else {
						println("not connected");
					}
				}
			}
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
