package Unit1;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ccc01s1 {

	public static void main(String[] args) throws IOException {
		String s = readLine();
		System.out.println("Cards Dealt              Points");
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		hm.put('A', 4);
		hm.put('K', 3);
		hm.put('Q', 2);
		hm.put('J', 1);
		HashSet<Character> hs = new HashSet<Character>();
		hs.add('C');
		hs.add('D');
		hs.add('H');
		hs.add('S');
		int totalV = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'C') {
				int value = 0;
				ArrayList<Character> a = new ArrayList<Character>();
				System.out.print("Clubs ");
				for (int j = i; j < s.length(); j++) {
					if (s.charAt(j) == 'D') {
						break;
					} else {
						if (hs.contains(s.charAt(j))) {
							continue;
						}
						if (hm.containsKey(s.charAt(j))) {
							value += hm.get(s.charAt(j));
						}
						System.out.print(s.charAt(j) + " ");
						a.add(s.charAt(j));
					}
				}
				if (a.size() == 0) {
					value += 3;
				}
				if (a.size() == 1) {
					value += 2;
				}
				if (a.size() == 2) {
					value += 1;
				}
				if (value < 10) {
					for (int j = 0; j < 25 - a.size() * 2 - 1; j++) {
						System.out.print(" ");
					}
				} else {
					for (int j = 0; j < 25 - a.size() * 2 - 2; j++) {
						System.out.print(" ");
					}
				}
				System.out.println(value);
				totalV += value;
			}
			if (s.charAt(i) == 'D') {
				int value = 0;
				ArrayList<Character> a = new ArrayList<Character>();
				System.out.print("Diamonds ");
				for (int j = i; j < s.length(); j++) {
					if (s.charAt(j) == 'H') {
						break;
					} else {
						if (hs.contains(s.charAt(j))) {
							continue;
						}
						if (hm.containsKey(s.charAt(j))) {
							value += hm.get(s.charAt(j));
						}
						System.out.print(s.charAt(j) + " ");
						a.add(s.charAt(j));
					}
				}
				if (a.size() == 0) {
					value += 3;
				}
				if (a.size() == 1) {
					value += 2;
				}
				if (a.size() == 2) {
					value += 1;
				}
				if (value < 10) {
					for (int j = 0; j < 22 - a.size() * 2 - 1; j++) {
						System.out.print(" ");
					}
				} else {
					for (int j = 0; j < 22 - a.size() * 2 - 2; j++) {
						System.out.print(" ");
					}
				}
				System.out.println(value);
				totalV += value;
			}
			if (s.charAt(i) == 'H') {
				int value = 0;
				ArrayList<Character> a = new ArrayList<Character>();
				System.out.print("Hearts ");
				for (int j = i; j < s.length(); j++) {
					if (s.charAt(j) == 'S') {
						break;
					} else {
						if (hs.contains(s.charAt(j))) {
							continue;
						}
						if (hm.containsKey(s.charAt(j))) {
							value += hm.get(s.charAt(j));
						}
						System.out.print(s.charAt(j) + " ");
						a.add(s.charAt(j));
					}
				}
				if (a.size() == 0) {
					value += 3;
				}
				if (a.size() == 1) {
					value += 2;
				}
				if (a.size() == 2) {
					value += 1;
				}
				if (value < 10) {
					for (int j = 0; j < 24 - a.size() * 2 - 1; j++) {
						System.out.print(" ");
					}
				} else {
					for (int j = 0; j < 24 - a.size() * 2 - 2; j++) {
						System.out.print(" ");
					}
				}
				System.out.println(value);
				totalV += value;
			}
			if (s.charAt(i) == 'S') {
				int value = 0;
				ArrayList<Character> a = new ArrayList<Character>();
				System.out.print("Spades ");
				for (int j = i; j < s.length(); j++) {
					if (hs.contains(s.charAt(j))) {
						continue;
					}
					if (hm.containsKey(s.charAt(j))) {
						value += hm.get(s.charAt(j));
					}
					System.out.print(s.charAt(j) + " ");
					a.add(s.charAt(j));
				}
				if (a.size() == 0) {
					value += 3;
				}
				if (a.size() == 1) {
					value += 2;
				}
				if (a.size() == 2) {
					value += 1;
				}
				if (value < 10) {
					for (int j = 0; j < 24 - a.size() * 2 - 1; j++) {
						System.out.print(" ");
					}
				} else {
					for (int j = 0; j < 24 - a.size() * 2 - 2; j++) {
						System.out.print(" ");
					}
				}
				System.out.println(value);
				totalV += value;
			}
		}
		if (totalV > 10) {
			System.out.println("                       Total " + totalV);
		} else {
			System.out.println("                        Total " + totalV);
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
