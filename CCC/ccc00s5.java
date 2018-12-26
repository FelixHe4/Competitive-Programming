package Unit1;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ccc00s5 {
	static class Pair {
		double x, y;

		public Pair(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		int n = readInt();
		Pair[] Pair = new Pair[n];
		// DecimalFormat df = new DecimalFormat("#.#####");
		for (int i = 0; i < n; i++) {
			double x = readDouble();
			double y = readDouble();
			Pair[i] = new Pair(x, y);
		}
//		for (int i = 0; i < Pair.length; i++) {
//			System.out.println(Pair[i].x + " " + Pair[i].y);
//		}
		ArrayList<Pair> a = new ArrayList<Pair>();
		for (double i = 0; i <= 1000; i += 0.01) {
			int index = 0;
			double cur = Integer.MAX_VALUE;
			for (int j = 0; j < Pair.length; j++) {
				Pair p = Pair[j];
				double distance = (p.x - i) * (p.x - i) + p.y * p.y;
				// System.out.println(distance);
				// distance = Double.valueOf(df.format(distance));
				if (distance < cur) {
					cur = distance;
					index = j;
				}
			}
			boolean flag = false;
			for (int j = 0; j < a.size(); j++) {
				if (a.get(j).x == Pair[index].x && Pair[index].y == a.get(j).y) {
					flag = true;
				}
			}
			if (!flag) {
				a.add(new Pair(Pair[index].x, Pair[index].y));
			}
		}
		for (Pair p : a) {
			System.out.print("The sheep at (");
			System.out.printf("%.2f", p.x);
			System.out.print(", ");
			System.out.printf("%.2f", p.y);
			System.out.println(") might be eaten.");
			// ", " + p.y + ") might be eaten.");
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
