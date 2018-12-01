package ecoo18r1;
import java.util.*;
import java.io.*;
public class ecoo18r1p2 {

	public static void main(String[] args) throws IOException {
		try {

			for (int test = 0; test < 10; test++) {// change to # test cases
				ArrayList<HashMap<Integer, Boolean>> maps = new ArrayList<HashMap<Integer, Boolean>>();
				for (int i = 0; i < 701; i++)
					maps.add(null);
				int N = Integer.parseInt(br.readLine());
				int[] ids = new int[N];
				int local_min = Integer.MAX_VALUE, abs_min = Integer.MAX_VALUE;
				String ans = "";
				ArrayList<Integer> ansints = new ArrayList<Integer>();
				for (int j = 0; j < N; j++) {
					String[] in = br.readLine().split(" ");
					int ID = Integer.parseInt(in[0]);
					ids[j] = ID;
					int R = Integer.parseInt(in[1]);
					maps.set(ID, new HashMap<Integer, Boolean>());
					for (int i = 0; i < R; i++) {
						int x = Integer.parseInt(in[i + 2]);
						if (x < local_min)
							local_min = x;
						maps.get(ID).put(x, true);
					}
					if (local_min < abs_min)
						abs_min = local_min;
					local_min = Integer.MAX_VALUE;
				}

				System.out.print(abs_min + " " + "{");

				for (int i = 0; i < N; i++) {
					if (maps.get(ids[i]).get(abs_min) != null)
						ansints.add(ids[i]);
				}
				Collections.sort(ansints);
				for (int i = 0; i < ansints.size(); i++) {
					ans += ansints.get(i) + ",";
				}
				char[] ans_chars = ans.toCharArray();
				for (int i = 0; i < ans_chars.length; i++) {
					if (i == ans_chars.length - 1)
						continue;
					System.out.print(ans_chars[i]);
				}
				System.out.print("}");
				System.out.println();
			} // PER CASE
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found...");
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
