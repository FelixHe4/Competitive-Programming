package Unit2;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BBSTAvlTree {
	// rocoded Jeffrey Xiao's template
	static Node root;

	public static class Node {
		int key, height, size;
		Node left, right;

		public Node(int key, int height, int size) {
			this.key = key;
			this.height = height;
			this.size = size;
		}
	}

	public static void reset(Node n) {
		n.size = getSize(n.left) + getSize(n.right) + 1;
		// System.out.println(getSize(n.left));
		n.height = Math.max(getHeight(n.left), getHeight(n.right)) + 1;
	}
	// get the higher one's height + 1 for your current node's height.

	// get the higher one's height + 1 for your current node's height.
	// returns the height of the node
	public static int getHeight(Node n) {
		if (n == null) {
			return -1;
		} else {
			return n.height;
		}
	}

	// returns the size of the node (amount of nodes under it)
	public static int getSize(Node n) {
		if (n == null) {
			return 0;
		} else {
			return n.size;
		}
	}

	// get the value in the node
	public static int getKey(Node n) {
		if (n == null) {
			return -1;
		} else {
			return n.key;
		}
	}

	// traverse from a given node.
	public static void traverse(Node n) {
		if (n != null) {
			traverse(n.left);
			print(n.key + " ");
			traverse(n.right);
		}
		return;
	}

	// get the element at index
	public static int smallestElement(Node n, int index) {
		if (n != null) {
			if (getSize(n.left) == index) {
				return n.key;
			} else if (getSize(n.left) > index) {
				return smallestElement(n.left, index);
			} else {
				return smallestElement(n.right, index - getSize(n.left) - 1);
			}
		} else {
			return -1;
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
			return n.key;
		} else {
			return 0;
		}
	}

	// add a node into the tree
	public static Node add(Node n, int k) {
		if (n == null) {
			return new Node(k, 0, 1);
			// node's initial height is 0, size is 1 (itself)
			// rebalance/reset will change the values into proper values
		} else {
			if (k < n.key) {
				n.left = add(n.left, k);
			} else {
				n.right = add(n.right, k);
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
			// this node to remove;
			if (n.left == null) {
				return n.right;
			} else if (n.right == null) {
				return n.left;
			} else {
				Node replace = n;
				n = min(replace.right);
				n.right = minR(replace.right);
				n.left = replace.left;
			}
		}
		return balance(n);
	}

	// finds the lowest left most node.
	public static Node minR(Node n) {
		if (n.left == null) {
			return n.right;
		} else {
			n.left = minR(n.left);
			return balance(n);
		}
	}

	public static Node min(Node n) {
		if (n.left == null) {
			return n;
		} else {
			return min(n.left);
		}
	}

	// balance needs to be reset when the heights of a subtrees of a given node differ by more than 1
	// method used to rebalance the BST
	public static Node balance(Node n) {
		reset(n);
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
		reset(n);
		reset(x);
		return x;
	}

	public static Node rotateRight(Node n) {
		Node x = n.left;
		n.left = x.right;
		x.right = n;
		reset(n);
		reset(x);
		return x;
	}

	public static void main(String[] args) throws IOException {
		// root = remove(root, k);
		// contains(root, k);
		// get(root, k);
		// add(root, k, v);
		// add(root, k, k);
		int n = readInt(), m = readInt();
		for (int i = 0; i < n; i++) {
			int x = readInt();
			root = add(root, x);
		}
		int lastAns = 0;
		while (m-- > 0) {
			String s = read();
			int v = readInt() ^ lastAns;
			if (s.equals("I")) {
				root = add(root, v);
			} else if (s.equals("R")) {
				root = remove(root, v);
			} else if (s.equals("S")) {
				lastAns = smallestElement(root, v);
				System.out.println(lastAns);
			} else {
				lastAns = get(root, v);
				System.out.println(lastAns);
			}
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
