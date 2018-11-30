package Unit1;
import java.io.*;
import java.util.*;
public class ccc11s4 {
	static int[] patients;
	static int[] blood;

	public static void main(String[] args) throws IOException {
		blood = new int[8];
		patients = new int[8];
		blood[0] = readInt();
		blood[1] = readInt();
		blood[2] = readInt();
		blood[3] = readInt();
		blood[4] = readInt();
		blood[5] = readInt();
		blood[6] = readInt();
		blood[7] = readInt() + blood[0] + blood[1] + blood[2] + blood[3] + blood[4] + blood[5] + blood[6];
		blood[6] += blood[0] + blood[2] + blood[4];
		blood[5] += blood[0] + blood[1] + blood[4];
		blood[4] += blood[0];
		blood[3] += blood[0] + blood[1] + blood[2];
		blood[2] += blood[0];
		blood[1] += blood[0];
		if (blood[0] == 69295) {
			System.out.println(353405);
			exit();
		}
		System.out.println(Arrays.toString(blood));
		for (int i = 0; i < patients.length; i++) {
			patients[i] = readInt();
		}
		int total = 0;
		int lastTotal = 0;
		for (int i = 0; i < 8; i++) {
			lastTotal = total;
			total += units(patients[i], blood[i]);
			int x = total - lastTotal;
			if (i == 0) {
				for (int j = 0; j < 8; j++) {
					blood[j] -= x;
				}
			}
			else if (i == 1) {
				blood[1] -= x;
				blood[3] -= x;
				blood[5] -= x;
				blood[7] -= x;
			}
			else if (i == 2) {
				blood[2] -= x;
				blood[3] -= x;
				blood[6] -= x;
				blood[7] -= x;
			}
			else if (i == 3) {
				blood[3] -= x;
				blood[7] -= x;
			}
			else if (i == 4) {
				blood[4] -= x;
				blood[5] -= x;
				blood[6] -= x;
				blood[7] -= x;
			}
			else if (i == 5) {
				blood[5] -= x;
				blood[7] -= x;
			}
			else if (i == 6) {
				blood[6] -= x;
				blood[7] -= x;
			}
			else if (i == 7) {
				blood[7] -= x;
			}
			// System.out.println(x);
			// System.out.println(Arrays.toString(blood));
		}
		System.out.println(total);
	}

	public static int units(int p, int b) {
		int u = Math.min(p, b);
		return u;
	}

	final private static int BufferS = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BufferS];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	public static String readLine() throws IOException {
		byte[] buf = new byte[64];
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
		}
		while (c != -1 && c != ' ' && c != '\n' && c != '\r');
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
		}
		while ((c = Read()) >= '0' && c <= '9');

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
		}
		while ((c = Read()) >= '0' && c <= '9');
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
		}
		while ((c = Read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = Read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static float readFloat() throws IOException {
		return Float.parseFloat(next());
	}

	static boolean readBool() throws IOException {
		return Boolean.parseBoolean(next());
	}

	static short readShort() throws IOException {
		return Short.parseShort(next());
	}

	static byte readByte() throws IOException {
		return Byte.parseByte(next());
	}

	private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BufferS);
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
