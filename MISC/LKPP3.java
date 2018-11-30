package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LKPP3 {

	public static void main(String[] args) throws IOException {
		int n = readInt();
		for (int i = 0; i < n; i++) {
			int d = readInt() + 1;
			int[] arr = new int[d];
			int m = d;
			for (int j = 0; j < d; j++) {
				arr[j] = readInt();
			}
			Set<Double> factors = new HashSet<Double>();
			while (m > 0) {
				Set<Double> a = new HashSet<Double>();
				Set<Double> factor1 = new HashSet<Double>();
				Set<Double> factor2 = new HashSet<Double>();
				for (int j = 1; j <= Math.sqrt(arr[d - m]); j++) {
					if (arr[d - m] % j == 0) {
						factor1.add((double) j);
						factor1.add((double) j * -1);
						if (j != arr[d - m] / (double) j) {
							factor1.add(arr[d - m] / (double) j);
							factor1.add((arr[d - m] / (double) j) * -1);
						}
					}
				}
				for (int k = 1; k < arr[arr.length - (((d - m) + 1))]; k++) {
					if (arr[arr.length - (((d - m) + 1))] % k == 0) {
						factor2.add((double) k);
						factor2.add((double) k * -1);
						if (k != arr[arr.length - (((d - m) + 1))] / (double) k) {
							factor2.add(arr[arr.length - (((d - m) + 1))] / (double) k);
							factor2.add((arr[arr.length - (((d - m) + 1))] / (double) k) * -1);
						}
					}
				}
				if (factor1.size() > 2) {
					Iterator f1 = factor1.iterator();
					Iterator f2 = factor2.iterator();
					while (f2.hasNext()) {
						double fa2 = (double) f2.next();
						while (f1.hasNext()) {
							double fa1 = (double) f1.next();
							if (fa2 / fa1 == (int) (fa2 / fa1)) {
								a.add(fa2 / fa1);
							}
						}
					}
				} else {
					a.addAll(factor2);
				}
				System.out.println(a);
				Iterator x = a.iterator();
				while (x.hasNext()) {
					long total = 0;
					double z = (double) x.next();
					for (int j = m - 1; j >= 0; j--) {
						total += Math.pow(z, j) * arr[arr.length - (j + 1)];
					}
					System.out.println(total);
					if (total == 0) {
						int c = factors.size();
						factors.add(z);
						if (factors.size() != c) {

							m--;
							break;
						}
					}
					break;
				}
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
