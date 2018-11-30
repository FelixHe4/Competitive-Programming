package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class dmopc17c5p3 {

	public static void main(String[] args) throws IOException {
		int n = readInt();
		long[] arr = new long[n];
		long GCD = -1;
		for (int i = 0; i < n; i++) {
			arr[i] = readLong();
			if (arr[i] == 1) {
				println("DNE");
				exit();
			}
			if (i == 1) {
				GCD = GCD(arr[i], arr[i - 1]);
			} else if (i > 1) {
				GCD = GCD(GCD, arr[i]);
			}
		}
//		Set<Long> s = primeFactorize(GCD);
//		long ans = Long.MIN_VALUE;
//		for (long z : s) {
//			ans = Math.max(ans, z);
//		}
		long ans = primeFactorizeMax(GCD);
		if (ans == Long.MIN_VALUE) {
			println("DNE");
		} else {
			println(ans);
		}
		exit();
	}

	public static long GCD(long a, long b) {
		return b == 0 ? a : GCD(b, a % b);
	}

	public static Set<Long> primeFactorize(long n) {
		Set<Long> a = new HashSet<Long>();
		while (n % 2 == 0) {
			long x = 2;
			a.add(x);
			n /= 2;
		}
		for (long i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				a.add(i);
				n /= i;
			}
		}
		if (n > 2) {
			a.add(n);
		}
		return a;
	}

	public static Long primeFactorizeMax(long n) {
		long x = Long.MIN_VALUE;
		while (n % 2 == 0) {
			x = Math.max(x, 2);
			n /= 2;
		}
		for (long i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				x = Math.max(x, i);
				n /= i;
			}
		}
		if (n > 2) {
			x = Math.max(x, n);
		}
		return x;
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
