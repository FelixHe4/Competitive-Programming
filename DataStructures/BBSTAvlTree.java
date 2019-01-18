package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BBSTAvlTree {
	// redid Jeffrey Xiao's template
	Node root;

	public static class Node {
		int key, value, height;
		Node left, right;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.height = 0;
		}

		public Node(int key) {
			this.key = key;
			this.value = key;
			this.height = 0;
		}
	}

	public static void resetHeight(Node n) {
		n.height = Math.max(getHeight(n.left), getHeight(n.right)) + 1;
	}
	// get the higher one's height + 1 for your current node's height.

	public static int getHeight(Node n) {
		if (n == null) {
			return -1;
		} else {
			return n.height;
		}
	}

	// traverse from a given node.
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
	// standard BST get and contains

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
			return balance(n);
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
		return balance(n);
	}

	// finds the lowest left most node.
	public static Node min(Node n) {
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}

//method used to rebalance the BST
	public static Node balance(Node n) {
		resetHeight(n);
		// first reset the height of n
		int diff1 = getHeight(n.left) - getHeight(n.right);
		// get the difference between the heights of the two subtrees
		if (diff1 >= 2) {
			// there is an imbalance in the BST, rebalance it.
			// The left subtree is larger than the right subtree, rebalance the left side
			int diff2 = getHeight(n.left.right) - getHeight(n.left.left);
			// get the difference between the subtrees of the left subtree
			if (diff2 > 0) {
				n.left = rotateLeft(n.left);
			}
			n = rotateRight(n);
		} else if (diff1 <= -2) {
			// The left subtree is smaller than the right subtree.
			int diff2 = getHeight(n.right.left) - getHeight(n.right.right);
			// get the difference between the subtrees of the right subtree.
			if (diff2 > 0) {
				n.right = rotateRight(n.right);
			}
			n = rotateLeft(n);
		}
		return n;
	}

	public static Node rotateLeft(Node n) {
		Node x = n.right;
		n.right = x.left;
		x.left = n;
		resetHeight(n);
		resetHeight(x);
		return x;
	}

	public static Node rotateRight(Node n) {
		Node x = n.left;
		n.left = x.right;
		x.right = n;
		resetHeight(n);
		resetHeight(x);
		return x;
	}

	public static void main(String[] args) throws IOException {

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
