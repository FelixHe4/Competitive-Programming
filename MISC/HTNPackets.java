package Unit2;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
public class HTNPackets {

	public static void main(String[] args) throws IOException {
		String s = readLine();
		String[] arr = s.split("8=HtN\\|");
		int[] val = new int[26];
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].equals("")) {
				String[] arr2 = arr[i].split("\\|");
				System.out.println(Arrays.toString(arr2));
				int change = 0;
				int mult = 0;
				int acc = 0;
				for (int j = 0; j < arr2.length; j++) {
					if (arr2[j].charAt(0) == '3') {
						change = Integer.parseInt(arr2[j].substring(2));
					} else if (arr2[j].charAt(0) == '5') {
						System.out.println(arr2[j].substring(2));
						acc = Integer.valueOf(arr2[j].substring(2));
					} else {
						if (arr2[j].substring(2).equals("ADD")) {
							mult = 1;
						} else if (arr2[j].substring(2).equals("MUL")) {
							mult = 2;
						} else {
							mult = 3;
						}
					}
				}
				if (mult == 1) {
					val[acc - 'A'] += change;
				} else if (mult == 2) {
					val[acc - 'A'] *= change;
				} else {
					val[acc - 'A'] -= change;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (val[i] != 0) {
				System.out.println((char) (i + 'A') + " " + val[i]);
			}
		}
	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	public static String readLine() throws IOException {
		byte[] buf = new byte[10000000]; // line length
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
