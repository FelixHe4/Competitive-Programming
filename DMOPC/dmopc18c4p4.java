package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class dmopc18c4p4 {
	static void Update(int index, long value) {
		for (int i = index; i <= 2000005; i += (i & -i)) {
			BIT[i] += value;
		}
	}

	static long Query(int index) {
		long sum = 0;
		for (int i = index; i > 0; i -= (i & -i)) {
			sum += BIT[i];
		}
		return sum;
	}

	static class Pair implements Comparable<Pair> {
		int value, index;

		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}

		public int compareTo(Pair o) {
			return value - o.value;
		}
	}

	static class query implements Comparable<query> {
		int l, r, cost, index;

		public query(int l, int r, int cost, int index) {
			this.l = l;
			this.r = r;
			this.cost = cost;
			this.index = index;
		}

		public int compareTo(query o) {
			return cost - o.cost;
		}
	}

	static long[] BIT;

	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		long[] psa = new long[n + 5];
		BIT = new long[2000005];
		ArrayList<Pair> b = new ArrayList<Pair>();
		for (int i = 1; i <= n; i++) {
			b.add(new Pair(readInt(), i));
			psa[i] = psa[i - 1] + b.get(i - 1).value;
		}
		ArrayList<query> a = new ArrayList<query>();
		for (int i = 1; i <= q; i++) {
			int l = readInt(), r = readInt(), k = readInt();
			a.add(new query(l, r, k, i));
		}
		Collections.sort(a, Collections.reverseOrder());
		Collections.sort(b, Collections.reverseOrder());
		long[] ans = new long[q + 1];
		int cur = 1;
		for (int i = 0; i < a.size(); i++) {
			long queryVal = a.get(i).cost;
			for (int j = cur; j < n + 1; j++) {
				if (queryVal <= b.get(j - 1).value) {
					Update(b.get(j - 1).index, b.get(j - 1).value);
					cur++;
				} else {
					break;
				}
			}
			long psaVal = psa[a.get(i).r] - psa[a.get(i).l - 1];
			long otherValue = Query(a.get(i).r) - Query(a.get(i).l - 1);
			// System.out.println(psaVal + " " + otherValue);
			ans[a.get(i).index] = otherValue * 2 - psaVal;
		}
		for (int i = 1; i < ans.length; i++) {
			System.out.println(ans[i]);
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
