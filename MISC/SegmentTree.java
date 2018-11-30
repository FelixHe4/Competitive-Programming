package Unit2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class SegmentTree {
	// RANGED QUERY IN AN ARRAY
	// MAX IN A CERTAIN RANGE
	// SUM IN A CERTAIN RANGE

	static class node {
		long l, r, root, min, gcd, sum;

		node(long l0, long r0, long root0, long m0, long gcd0, long sum0) {
			l = l0;
			r = r0;
			root = root0;
			gcd = gcd0;
			min = m0;
			sum = sum0;
		}
	}

	static node[] seg;
	static long[] ori;

	static void Build(long l, long r, int root) {
		seg[(int) root] = new node(l, r, root, 0, 0, 0);
		if (l == r) {
			seg[root].min = ori[(int) l];
			seg[root].gcd = ori[(int) l];
			seg[root].sum = 1;
		} else {
			long mid = (l + r) / 2;
			Build(l, mid, root * 2);
			Build(mid + 1, r, root * 2 + 1);
			seg[root].min = Math.min(seg[(root * 2)].min, seg[root * 2 + 1].min);
			seg[root].gcd = gcd(seg[root * 2].gcd, seg[root * 2 + 1].gcd);
			if (seg[root].gcd == seg[root * 2].gcd) {
				seg[root].sum += seg[root * 2].sum;
			}
			if (seg[root].gcd == seg[root * 2 + 1].gcd) {
				seg[root].sum += seg[root * 2 + 1].sum;
			}
		}
	}

	public static void Update(long x, long v, int root) {
		seg[root] = new node(seg[root].l, seg[root].r, root, 0, 0, 0);
		if (seg[root].l == seg[root].r && seg[root].l == x) {
			seg[root].min = v;
			seg[root].gcd = v;
			seg[root].sum = 1;
		} else {
			long mid = (seg[root].l + seg[root].r) / 2;
			if (x <= mid) {
				Update(x, v, root * 2);
			} else {
				Update(x, v, root * 2 + 1);
			}
			seg[root].min = Math.min(seg[2 * root].min, seg[2 * root + 1].min);
			seg[root].gcd = gcd(seg[2 * root].gcd, seg[2 * root + 1].gcd);
			if (seg[root].gcd == seg[2 * root].gcd)
				seg[root].sum += seg[2 * root].sum;
			if (seg[root].gcd == seg[2 * root + 1].gcd)
				seg[root].sum += seg[2 * root + 1].sum;
		}
	}

	// RANGED MINIMUM QUERY
	static long Minimum(long l, long r, long low, long high, int root) {
		if (l > high || r < low) {
			return Long.MAX_VALUE;
		}
		if (l <= low && r >= high) {
			return seg[(int) root].min;
		}
		long mid = (low + high) / 2;
		return Math.min(Minimum(l, r, low, mid, root * 2), Minimum(l, r, mid + 1, high, root * 2 + 1));
	}

	// RANGED GCD QUERY
	public static long GCD(long l, long r, int pos) {
		if (seg[pos].l >= l && seg[pos].r <= r) {
			return seg[pos].gcd;
		} else {
			long mid = (seg[pos].l + seg[pos].r) / 2;
			if (r <= mid) {
				return GCD(l, r, pos * 2);
			} else if (l > mid) {
				return GCD(l, r, pos * 2 + 1);
			} else {
				return gcd(GCD(l, r, pos * 2), GCD(l, r, pos * 2 + 1));
			}
		}
	}

	public static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	static long gcdSum(long l, long r, int root, long m) {
		if (seg[root].l == l && seg[root].r == r) {
			if (seg[root].gcd == m) {
				return seg[root].sum;
			} else {
				return 0;
			}
		} else {
			long mid = (seg[root].l + seg[root].r) / 2;
			if (r <= mid) {
				return gcdSum(l, r, 2 * root, m);
			} else if (l > mid) {
				return gcdSum(l, r, 2 * root + 1, m);
			} else {
				return (gcdSum(l, mid, 2 * root, m) + gcdSum(mid + 1, r, 2 * root + 1, m));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		long N = readLong();
		long M = readLong();
		seg = new node[(int) (N * 4 + 1)];
		ori = new long[(int) (N + 1)];
		for (long i = 1; i <= N; i++) {
			ori[(int) i] = readLong();
		}
		Build(1, N, 1);
		for (long i = 1; i <= M; i++) {
			char c = readChar();
			if (c == 'C') {
				long x = readInt();
				long v = readInt();
				ori[(int) x] = v;
				Update(x, v, 1);
			}
			if (c == 'M') {
				long l = readInt();
				long r = readInt();
				System.out.println(Minimum(l, r, 1, N, 1));
			}
			if (c == 'G') {
				long l = readInt();
				long r = readInt();
				System.out.println(GCD(l, r, 1));
			}
			if (c == 'Q') {
				long l = readInt();
				long r = readInt();
				System.out.println(gcdSum(l, r, 1, GCD(l, r, 1)));
			}
			// for (int j = 0; j < seg.length; j++) {
			// if (seg[j] != null) {
			// System.out.print(seg[j].l + " ");
			// System.out.print(seg[j].r + " ");
			// System.out.print(seg[j].min + " ");
			// System.out.println(seg[j].sum);
			// }
			// }
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
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

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readChar() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine();
	}

	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

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
		br.close();
		pr.close();
		System.exit(0);
	}
}
