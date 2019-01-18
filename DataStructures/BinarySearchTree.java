package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BinarySearchTree {
	// Redid JeffreyXiao's template
	Node root;

	public static class Node {
		int key, value;
		Node left, right;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public Node(int key) {
			this.key = key;
			this.value = key;
		}
	}

	public static void traverse(Node n) {
		if (n != null) {
			traverse(n.left);
			traverse(n.right);
		}
	}

	public static boolean contains(Node n, int k) {
		if (n != null) {
			if (k > n.key) {
				return contains(n.right, k);
			} else if (k < n.key) {
				return contains(n.left, k);
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public static int get(Node n, int k) {
		if (n != null) {
			if (k > n.key) {
				return get(n.right, k);
			} else if (k < n.key) {
				return get(n.left, k);
			}
			return n.value;
		} else {
			return 0;
		}
	}

	public static Node add(Node n, int k, int v) {
		if (n == null) {
			return new Node(k, v);
		} else {
			if (v > n.key) {
				n.right = add(n.right, k, v);
			} else if (v < n.key) {
				n.left = add(n.left, k, v);
			} else {
				n.key = v;
			}
			return n;
		}
	}

	public static Node remove(Node n, int k) {
		if (n == null) {
			return null;
		}
		if (k > n.key) {
			n.right = remove(n.right, k);
		} else if (k < n.key) {
			n.left = remove(n.left, k);
		} else {
			// this node to remove;
			if (n.left == null) {
				n = n.right;
				return n;
			} else if (n.right == null) {
				n = n.left;
				return n;
			} else {
				Node replace = min(n.right);
				n.key = replace.key;
				n.value = replace.value;
				n.right = remove(n.right, n.key);
				return n;
			}
		}
		return n;
	}

	public static Node min(Node n) {
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}

	public static void main(String[] args) throws IOException {
		// root = remove(root, k);
		// contains(root, k);
		// get(root, k);
		// add(root, k, v);
		// add(root, k, k);
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
