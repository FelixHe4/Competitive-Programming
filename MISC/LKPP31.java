package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LKPP31 {
	static Set<Double> Factors, Factors1, Factors2;
	static ArrayList<Long> fFactors;
	static ArrayList<Integer> a;
	static int m;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		for (int i = 0; i < n; i++) {
			int exp = readInt() + 1;
			a = new ArrayList<Integer>();
			Factors = new HashSet<Double>();
			Factors1 = new HashSet<Double>();
			Factors2 = new HashSet<Double>();
			fFactors = new ArrayList<Long>();
			m = exp - 1;
			for (int j = 0; j < exp; j++) {
				a.add(readInt());
			}
			boolean flag = false;
			for (int j = 1; j < Math.sqrt(Math.abs(a.get(a.size() - 1))); j++) {
				if (a.get(a.size() - 1) % j == 0) {
					Factors2.add((double) j);
					Factors2.add((double) j * -1);
					if (a.get(a.size() - 1) / (double) j != j) {
						Factors2.add((double) (a.get(a.size() - 1) / (double) j));
						Factors2.add((double) (a.get(a.size() - 1) / (double) j) * -1);
					}
				}
			}
			if (Factors2.size() == 0) {
				flag = true;
			}
			while (m >= 3) {
				findNums();
				if (a.get(0) == 0) {
					m--;
				}
				if (flag) {
					for (int j = 1; j < Math.sqrt(Math.abs(a.get(a.size() - 1))); j++) {
						if (a.get(a.size() - 1) % j == 0) {
							Factors2.add((double) j);
							if (a.get(a.size() - 1) / (double) j != j) {
								Factors2.add((double) (a.get(a.size() - 1) / (double) j));
							}
						}
					}
					if (Factors2.size() == 0) {
						flag = true;
					} else {
						flag = false;
					}
				}
				m--;
			}
			int first = a.get(1) * (-1);
			int second = (int) (Math.sqrt((a.get(1) * a.get(1)) - (4 * a.get(0) * a.get(2))));
			int third = 2 * a.get(0);
			long f1 = (first + second) / third;
			long f2 = (first - second) / third;
			if (f1 != 0) {
				fFactors.add(f1);
			}
			if (f2 != 0) {
				fFactors.add(f2);
			}
			Collections.sort(fFactors);
			for (long b : fFactors) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

	static void findNums() {
		for (int i = 1; i <= Math.sqrt(Math.abs(a.get(0))); i++) {
			if (a.get(0) % i == 0) {
				Factors1.add((double) i);
				Factors1.add((double) i * -1);
				if (a.get(0) / (double) i != i) {
					Factors1.add((double) (a.get(0) / (double) i));
					Factors1.add((double) (a.get(0) / (double) i) * -1);
				}
			}
		}
		Iterator<Double> x = Factors1.iterator();
		Iterator<Double> y = Factors2.iterator();
		if (Factors2.size() == 0) {
			fFactors.add((long) 0);
		}
		while (x.hasNext()) {
			double z = x.next();
			while (y.hasNext()) {
				double w = y.next();
				if (w / z == (int) (w / z)) {
					Factors.add(w / z);
				}
			}
		}
		Iterator<Double> v = Factors.iterator();
		if (Factors.size() == 0) {
			a.remove(a.size() - 1);
			m--;
			return;
		}
		while (v.hasNext()) {
			double cur = v.next();
			long total = 0;
			for (int i = 0; i < a.size(); i++) {
				total += Math.pow(cur, (m + 1) - i) * a.get(i);
			}
			if (total == 0) {
				fFactors.add((long) cur);
				Synthesis((int) cur);
				return;
			}
		}
	}

	static void Synthesis(int n) {
		n *= -1;
		int curT = 0;
		ArrayList<Integer> copy = new ArrayList<Integer>();
		for (int i = 0; i < a.size(); i++) {
			if (i == 0) {
				curT += a.get(0);
			} else {
				curT *= n;
				curT = a.get(i) - curT;
			}
			if (i != a.size() - 1) {
				copy.add(curT);
			}
		}
		a = copy;
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
