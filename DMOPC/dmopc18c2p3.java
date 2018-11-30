package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class dmopc18c2p3 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt(), K = readInt(), A = readInt(), B = readInt();
		ArrayList<Integer>[] a = new ArrayList[N + 1];
		for (int i = 0; i < a.length; i++) {
			a[i] = new ArrayList<Integer>();
		}
		int[] gifts = new int[K];
		for (int i = 0; i < K; i++) {
			gifts[i] = readInt();
		}
		for (int i = 0; i < M; i++) {
			int c1 = readInt();
			int c2 = readInt();
			a[c1].add(c2);
			a[c2].add(c1);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(A);
		int[] step1 = new int[N + 1];
		boolean[] vis = new boolean[N + 1];
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int j = 0; j < a[cur].size(); j++) {
				if (!vis[a[cur].get(j)]) {
					step1[a[cur].get(j)] = step1[cur] + 1;
					vis[a[cur].get(j)] = true;
					q.add(a[cur].get(j));
				}
			}
		}
		q.add(B);
		int[] step2 = new int[N + 1];
		vis = new boolean[N + 1];
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int j = 0; j < a[cur].size(); j++) {
				if (!vis[a[cur].get(j)]) {
					step2[a[cur].get(j)] = step2[cur] + 1;
					vis[a[cur].get(j)] = true;
					q.add(a[cur].get(j));
				}
			}
		}
		long z = Integer.MAX_VALUE;
		for (int i = 0; i < K; i++) {
			z = Math.min(z, step1[gifts[i]] + step2[gifts[i]]);
		}
		System.out.println(z);
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
