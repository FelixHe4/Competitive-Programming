package Unit2;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class LKP2P3 {
	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Triangle {
		public double x3, y3;
		public double ya, xa, yb, xb;
		public double det, minD, maxD;

		public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
			this.x3 = x3;
			this.y3 = y3;
			ya = y2 - y3;
			xa = x3 - x2;
			yb = y3 - y1;
			xb = x1 - x3;
			det = ya * xb - xa * yb;
			minD = Math.min(det, 0);
			maxD = Math.max(det, 0);
		}

		boolean contains(double x, double y) {
			double dx = x - x3;
			double dy = y - y3;
			double a = ya * dx + xa * dy;
			if (a < minD || a > maxD)
				return false;
			double b = yb * dx + xb * dy;
			if (b < minD || b > maxD)
				return false;
			double c = det - a - b;
			if (c < minD || c > maxD)
				return false;
			return true;
		}

	}

	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		Pair[] Pair = new Pair[n];
		for (int i = 0; i < n; i++) {
			Pair[i] = new Pair(readInt(), readInt());
		}
		for (int i = 0; i < m; i++) {
			Triangle z = new Triangle(readInt(), readInt(), readInt(), readInt(), readInt(), readInt());
			long count = 0;
			for (int j = 0; j < n; j++) {
				// spent the entire time debugging because my Pair[j] was Pair[i];
				if (z.contains(Pair[j].x, Pair[j].y)) {
					count++;
				}
			}
			println(count);
		}
		exit();
	}
//
//	public static boolean onLine(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
//		double slope1 = (y2 - y1) / (x2 - x1);
//		double b1 = y2 - (slope1 * x2);
//		boolean flag1 = (x * slope1 + b1) == y;
//		double slope2 = (y3 - y1) / (x3 - x1);
//		double b2 = y3 - (slope1 * x3);
//		boolean flag2 = (x * slope2 + b2) == y;
//		double slope3 = (y3 - y2) / (x3 - x2);
//		double b3 = y3 - (slope1 * x3);
//		boolean flag3 = (x * slope3 + b3) == y;
//		return flag1 || flag2 || flag3;
//	}

	public static double calculateArea(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3);
	}

	public static boolean inside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
		double s = y1 * x3 - x1 * y3 + (y3 - y1) * x + (x1 - x3) * y;
		double t = x1 * y2 - y1 * x2 + (y1 - y2) * x + (x2 - x1) * y;
		if ((s < 0) != (t < 0)) {
			return false;
		}
		double A = -y2 * x3 + y1 * (x3 - x2) + x1 * (y2 - y3) + x2 * y3;
		return s > 0 && t > 0 && (s + t) <= A;
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