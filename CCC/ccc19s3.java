package Unit1;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ccc19s3 {
	static long[][] arr;

	public static void main(String[] args) throws IOException {
		arr = new long[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				String c = read();
				if (c.equals("X")) {
					arr[i][j] = Long.MAX_VALUE;
				} else {
					arr[i][j] = Integer.parseInt(c);
				}
			}
		}
		solve3();
		solve3();
		solve3();
		solve3();
		boolean flag = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i][j] == Long.MAX_VALUE) {
					flag = false;
				}
			}
		}
		if (flag) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					print(arr[i][j] + " ");
				}
				println();
			}
			exit();
		} else {
			if (arr[1][1] == Long.MAX_VALUE) {
				arr[1][1] = 0;
				solve3();
				solve3();
				solve3();
				solve3();
			}
			if (arr[0][1] == Long.MAX_VALUE) {
				arr[0][1] = 0;
				solve3();
				solve3();
				solve3();
				solve3();
			}
			if (arr[1][0] == Long.MAX_VALUE) {
				arr[1][0] = 0;
				solve3();
				solve3();
				solve3();
				solve3();
			}
			if (arr[2][1] == Long.MAX_VALUE) {
				arr[2][1] = 0;
				solve3();
				solve3();
				solve3();
				solve3();
			}
			if (arr[1][2] == Long.MAX_VALUE) {
				arr[1][2] = 0;
				solve3();
			}
			solve3();
			solve3();
			solve3();
			solve3();
			flag = true;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (arr[i][j] == Long.MAX_VALUE) {
						flag = false;
					}
				}
			}
			if (flag) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						print(arr[i][j] + " ");
					}
					println();
				}
				exit();
			} else {
				if (arr[0][0] == Long.MAX_VALUE) {
					arr[0][0] = 0;
					solve3();
					solve3();
					solve3();
					solve3();
				}
				if (arr[0][2] == Long.MAX_VALUE) {
					arr[0][2] = 0;
					solve3();
					solve3();
					solve3();
					solve3();
				}
				if (arr[2][0] == Long.MAX_VALUE) {
					arr[2][0] = 0;
					solve3();
					solve3();
					solve3();
					solve3();
				}
				if (arr[2][2] == Long.MAX_VALUE) {
					arr[2][2] = 0;
					solve3();
					solve3();
					solve3();
					solve3();
				}
				solve3();
				solve3();
				solve3();
				solve3();
				solve3();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						print(arr[i][j] + " ");
					}
					println();
				}
				exit();
			}
		}
	}

	public static void solve3() {
		if (arr[0][0] != Long.MAX_VALUE && arr[0][1] != Long.MAX_VALUE && arr[0][2] == Long.MAX_VALUE) {
			arr[0][2] = arr[0][1] - arr[0][0] + arr[0][1];
		}
		if (arr[1][0] != Long.MAX_VALUE && arr[1][1] != Long.MAX_VALUE && arr[1][2] == Long.MAX_VALUE) {
			arr[1][2] = arr[1][1] - arr[1][0] + arr[1][1];
		}
		if (arr[2][0] != Long.MAX_VALUE && arr[2][1] != Long.MAX_VALUE && arr[2][2] == Long.MAX_VALUE) {
			arr[2][2] = arr[2][1] - arr[2][0] + arr[2][1];
		}
		if (arr[0][0] != Long.MAX_VALUE && arr[0][2] != Long.MAX_VALUE && arr[0][1] == Long.MAX_VALUE) {
			arr[0][1] = (arr[0][2] - arr[0][0]) / 2 + arr[0][0];
		}
		if (arr[1][0] != Long.MAX_VALUE && arr[1][2] != Long.MAX_VALUE && arr[1][1] == Long.MAX_VALUE) {
			arr[1][1] = (arr[1][2] - arr[1][0]) / 2 + arr[1][0];
		}
		if (arr[2][0] != Long.MAX_VALUE && arr[2][2] != Long.MAX_VALUE && arr[2][1] == Long.MAX_VALUE) {
			arr[2][1] = (arr[2][2] - arr[2][0]) / 2 + arr[2][0];
		}
		if (arr[0][1] != Long.MAX_VALUE && arr[0][2] != Long.MAX_VALUE && arr[0][0] == Long.MAX_VALUE) {
			arr[0][0] = arr[0][1] - (arr[0][2] - arr[0][1]);
		}
		if (arr[1][1] != Long.MAX_VALUE && arr[1][2] != Long.MAX_VALUE && arr[1][0] == Long.MAX_VALUE) {
			arr[1][0] = arr[1][1] - (arr[1][2] - arr[1][1]);
		}
		if (arr[2][1] != Long.MAX_VALUE && arr[2][2] != Long.MAX_VALUE && arr[2][0] == Long.MAX_VALUE) {
			arr[2][0] = arr[2][1] - (arr[2][2] - arr[2][1]);
		}
		if (arr[0][0] != Long.MAX_VALUE && arr[1][0] != Long.MAX_VALUE && arr[2][0] == Long.MAX_VALUE) {
			arr[2][0] = (arr[1][0] - arr[0][0]) + arr[1][0];
		}
		if (arr[0][1] != Long.MAX_VALUE && arr[1][1] != Long.MAX_VALUE && arr[2][1] == Long.MAX_VALUE) {
			arr[2][1] = (arr[1][1] - arr[0][1]) + arr[1][1];
		}
		if (arr[0][2] != Long.MAX_VALUE && arr[1][2] != Long.MAX_VALUE && arr[2][2] == Long.MAX_VALUE) {
			arr[2][2] = (arr[1][2] - arr[0][2]) + arr[1][2];
		}
		if (arr[0][0] != Long.MAX_VALUE && arr[2][0] != Long.MAX_VALUE && arr[1][0] == Long.MAX_VALUE) {
			arr[1][0] = (arr[2][0] - arr[0][0]) / 2 + arr[0][0];
		}
		if (arr[0][1] != Long.MAX_VALUE && arr[2][1] != Long.MAX_VALUE && arr[1][1] == Long.MAX_VALUE) {
			arr[1][1] = (arr[2][1] - arr[0][1]) / 2 + arr[0][1];
		}
		if (arr[0][2] != Long.MAX_VALUE && arr[2][2] != Long.MAX_VALUE && arr[1][2] == Long.MAX_VALUE) {
			arr[1][2] = (arr[2][2] - arr[0][2]) / 2 + arr[0][2];
		}
		if (arr[1][0] != Long.MAX_VALUE && arr[2][0] != Long.MAX_VALUE && arr[0][0] == Long.MAX_VALUE) {
			arr[0][0] = arr[1][0] - (arr[2][0] - arr[1][0]);
		}
		if (arr[1][1] != Long.MAX_VALUE && arr[2][1] != Long.MAX_VALUE && arr[0][1] == Long.MAX_VALUE) {
			arr[0][1] = arr[1][1] - (arr[2][1] - arr[1][1]);
		}
		if (arr[1][2] != Long.MAX_VALUE && arr[2][2] != Long.MAX_VALUE && arr[0][2] == Long.MAX_VALUE) {
			arr[0][2] = arr[1][2] - (arr[2][2] - arr[1][2]);
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
