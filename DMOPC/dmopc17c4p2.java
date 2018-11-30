package Unit2;
import java.io.*;
import java.util.*;
public class dmopc17c4p2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int q = readInt();
		int[] val = new int[n + 1];
		int[] connections = new int[n + 1];
		ArrayList<Integer> vals = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			int x = readInt();
			val[i] = x;
			if (!vals.contains(x)) {
				vals.add(x);
			}
		}
		for (int i = 0; i < n - 1; i++) {
			int c1 = readInt();
			int c2 = readInt();
			connections[c1] = c2;
		}
		for (int i = 0; i < q; i++) {
			int query = readInt();
			if (query == 1) {
				int amount = 0;
				int total = 0;
				int a = readInt();
				int b = readInt();
				while (a != b) {
					amount++;
					total += val[a];
					a = connections[a];
				}
				total += val[b];
				amount++;
				System.out.println(Math.round(total / amount));
			}
			if (query == 2) {
				int a = readInt();
				int b = readInt();
				ArrayList<Integer> med = new ArrayList<Integer>();
				while (a != b) {
					med.add(val[a]);
					a = connections[a];
				}
				med.add(val[b]);
				Collections.sort(med);
				if (med.size() % 2 == 0) {
					System.out.println(med.get(med.size() / 2 - 1));
				}
				else {
					System.out.println(med.get(med.size() / 2));
				}
			}
			if (query == 3) {
				int a = readInt();
				int b = readInt();
				int[] mode1 = new int[100000];
				while (a != b) {
					mode1[val[a]]++;
					a = connections[a];
				}
				mode1[val[b]]++;
				int max = Integer.MIN_VALUE;
				ArrayList<Integer> mode2 = new ArrayList<Integer>();
				for (int j = 0; j < vals.size(); j++) {
					if (max < mode1[vals.get(j)]) {
						max = mode1[vals.get(j)];
					}
				}
				for (int j = 0; j < vals.size(); j++) {
					if (max == mode1[vals.get(j)]) {
						mode2.add(vals.get(j));
					}
				}
				Collections.sort(mode2);
				System.out.println(mode2.get(0));
			}
		}
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
