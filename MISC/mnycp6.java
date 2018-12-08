package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;

public class mnycp6 {
	static void Update(int n, long v) {
		for (int i = n; i <= 10001; i += (i & -i)) {
			BIT[i] += v;
		}
	}

	static long Query(int x) {
		long sum = 0;
		for (int i = x; i > 0; i -= (i & -i)) {
			sum += BIT[i];
		}
		return sum;
	}

	static long stringValue(String s) {
		long sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - 'a' + 1;
		}
		return sum;
	}

	static long[] BIT;
	static HashMap<String, Integer> hm;

	public static void main(String[] args) throws IOException {
		int q = readInt();
		BIT = new long[10005];
		hm = new HashMap<String, Integer>();
		int rockCount = 1;
		while (q-- > 0) {
			String command = read();
			if (command.equals("A")) {
				String r = read();
				if (hm.containsKey(r)) {
					System.out.println("Can't add " + r);
				} else {
					hm.put(r, rockCount);
					Update(rockCount, stringValue(r));
					rockCount++;
				}
			} else if (command.equals("S")) {
				String x = read(), y = read();
				Update(hm.get(x), stringValue(y) - stringValue(x));
				Update(hm.get(y), stringValue(x) - stringValue(y));
				int temp = hm.get(x);
				hm.put(x, hm.get(y));
				hm.put(y, temp);
			} else if (command.equals("M")) {
				String x = read(), y = read();
				if (hm.get(x) == 1) {
					System.out.println(Query(hm.get(y)));
				} else if (hm.get(y) == 1) {
					System.out.println(Query(hm.get(x)));
				} else if (hm.get(x) > hm.get(y)) {
					System.out.println(Query(hm.get(x)) - Query(hm.get(y) - 1));
				} else {
					System.out.println(Query(hm.get(y)) - Query(hm.get(x) - 1));
				}
			} else if (command.equals("R")) {
				String x = read(), y = read();
				Update(hm.get(x), stringValue(y) - stringValue(x));
				hm.put(y, hm.get(x));
				hm.remove(x);
			} else if (command.equals("N")) {
				System.out.println(hm.size());
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
