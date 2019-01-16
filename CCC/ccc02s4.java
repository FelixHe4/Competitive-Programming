package Unit1;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
public class ccc02s4 {
	static class Pair {
		String name;
		int time;

		public Pair(String name, int time) {
			this.name = name;
			this.time = time;
		}
	}

	static int[] index;
	static Pair[] Pair;

	public static void main(String[] args) throws IOException {
		int m = readInt(), q = readInt();
		Pair = new Pair[q + 1];
		int[] dp = new int[q + 1];
		index = new int[q + 1];
		int[] group = new int[q + 1];
		for (int i = 1; i <= q; i++) {
			Pair[i] = new Pair(read(), readInt());
			dp[i] = 1 << 30;
			group[i] = -1;
		}
		for (int i = 1; i <= q; i++) {
			int speed = 0;
			for (int j = 1; j <= m; j++) {
				if (j > i) {
					continue;
				} else {
					speed = Math.max(speed, Pair[i - j + 1].time);
					if (dp[i - j] + speed < dp[i]) {
						dp[i] = speed + dp[i - j];
						index[i] = j;
					}
				}
			}
		}
		System.out.println("Total Time: " + dp[q]);
		indexFind(q);
		exit();
	}

	static void indexFind(int indexF) {
		if (indexF != 0) {
			indexFind(indexF - index[indexF]);
			for (int i = indexF - index[indexF] + 1; i <= indexF; i++) {
				System.out.print(Pair[i].name + " ");
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
