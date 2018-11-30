package Unit2;
import java.io.*;
import java.util.*;
public class vmss15c1p4 {
	static class Node implements Comparable<Node> {
		int ev;
		long cost;

		public Node(int ev0, long cost0) {
			ev = ev0;
			cost = cost0;
		}

		public int compareTo(Node o) {
			return (int) (cost - o.cost);
		}
	}

	static ArrayList<Node>[] arr;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int t = readInt(), n = readInt(), m = readInt(), g = readInt();
		ArrayList<Integer> grocery = new ArrayList<Integer>();
		for (int i = 0; i < g; i++) {
			grocery.add(readInt());
		}
		arr = new ArrayList[n + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Node>();
		}
		long[][] hasConnection = new long[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int c1 = readInt(), c2 = readInt();
			long cost = readLong();
			if (hasConnection[c1][c2] == 0) {
				arr[c1].add(new Node(c2, cost));
				hasConnection[c1][c2] = cost;
			} else if (hasConnection[c1][c2] > cost) {
				for (int j = 0; j < arr[c1].size(); j++) {
					if (arr[c1].get(j).ev == c2) {
						arr[c1].get(j).cost = cost;
						hasConnection[c1][c2] = cost;
						break;
					}
				}
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(0, 0));
		long[] step = new long[n + 1];
		Arrays.fill(step, 1 << 30);
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			for (Node x : arr[cur.ev]) {
				if (step[x.ev] > cur.cost + x.cost) {
					step[x.ev] = cur.cost + x.cost;
					pq.add(new Node(x.ev, step[x.ev]));
				}
			}
		}
		int count = 0;
		for (int i = 0; i < grocery.size(); i++) {
			if (step[grocery.get(i)] <= t) {
				count++;
			}
		}
		println(count);
		exit();
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
