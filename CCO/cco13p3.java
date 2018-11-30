package Unit2;
import java.util.*;
import java.io.*;
public class cco13p3 {
	static int max;
	static int total;
	static ArrayList<ArrayList<Integer>> adj;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		adj = new ArrayList<ArrayList<Integer>>();
		for (int x = 0; x < n; x++)
			adj.add(new ArrayList<Integer>());
		for (int x = 0; x < n - 1; x++) {
			int a = readInt() - 1;
			int b = readInt() - 1;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		// dfs
		int end = 0;
		Queue<State> moves = new LinkedList<State>();
		v = new boolean[n];
		v[0] = true;
		moves.offer(new State(0, 0));
		while (!moves.isEmpty()) {
			State curr = moves.poll();
			if (curr.moves > max) {
				max = curr.moves;
				end = curr.dest;
			}
			for (Integer i : adj.get(curr.dest))
				if (!v[i]) {
					v[i] = true;
					moves.offer(new State(i, curr.moves + 1));
				}
		}
		moves.clear();
		v = new boolean[n];
		int[] prev = new int[n];
		v[end] = true;
		prev[end] = -1;
		moves.offer(new State(end, 0));
		max = 0;
		int best = 0;
		// diameter
		while (!moves.isEmpty()) {
			State curr = moves.poll();
			if (curr.moves > max) {
				max = curr.moves;
				best = curr.dest;
			}
			for (Integer i : adj.get(curr.dest))
				if (!v[i]) {
					v[i] = true;
					prev[i] = curr.dest;
					moves.offer(new State(i, curr.moves + 1));
				}
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		int curr = best;
		while (curr != -1) {
			path.add(curr);
			curr = prev[curr];
		}
		// if 2 centers, split to 2 subtrees:
		ArrayList<Integer> centers = new ArrayList<Integer>();
		double split = (path.size() - 1) / 2.0d;
		for (int x = (int) Math.floor(split); x <= (int) Math.ceil(split); x++)
			centers.add(path.get(x));
		for (int x = 0; x < centers.size() - 1; x++) {
			int a = centers.get(x);
			int b = centers.get(x + 1);
			int index1 = adj.get(a).indexOf(b);
			int index2 = adj.get(b).indexOf(a);
			adj.get(a).remove(index1);
			adj.get(b).remove(index2);
		}
		v = new boolean[n];
		int pathLength = max;
		max = max / 2;
		long sum = 1;
		ArrayList<Long> subtrees = new ArrayList<Long>();

		if (centers.size() == 1) {
			v[centers.get(0)] = true;
			subtrees.clear();
			long currTotal = 0;
			long currPaths = 0;
			for (Integer i : adj.get(centers.get(0))) {
				v[i] = true;
				long add = dfs(i, 1);

				currTotal += (add) * currPaths;
				currPaths += add;
			}
			sum = currTotal;
		}
		else {
			for (int x = 0; x < centers.size(); x++) {
				v[centers.get(x)] = true;
				subtrees.clear();
				for (Integer i : adj.get(centers.get(x))) {
					v[i] = true;
					long add = dfs(i, 1);
					subtrees.add(add);
				}
				long currSum = 0;
				for (int y = 0; y < subtrees.size(); y++)
					currSum += subtrees.get(y);
				if (currSum != 0)
					sum *= currSum;
			}

		}
		pr.println(pathLength + 1 + " " + sum);
		pr.close();
	}

	private static long dfs(Integer i, int l) {
		long total = 0;
		for (Integer next : adj.get(i)) {
			if (!v[next]) {
				v[next] = true;
				long n = dfs(next, l + 1);
				total += n;
			}
		}
		if (l == max) {
			++total;
		}
		return total;
	}

	static class State {
		int moves;
		int dest;

		State(int dest, int moves) {
			this.dest = dest;
			this.moves = moves;
		}
	}

	final private static int BufferS = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BufferS];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	public static String readLine() throws IOException {
		byte[] buf = new byte[64];
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
		}
		while (c != -1 && c != ' ' && c != '\n' && c != '\r');
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
		}
		while ((c = Read()) >= '0' && c <= '9');

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
		}
		while ((c = Read()) >= '0' && c <= '9');
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
		}
		while ((c = Read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = Read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	static char readChar() throws IOException {
		return next().charAt(0);
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

	private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BufferS);
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