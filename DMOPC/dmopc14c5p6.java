package Unit2;
import java.io.*;
import java.util.*;
public class dmopc14c5p6 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int N = readInt();
		ArrayList<Integer> arr[] = new ArrayList[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N - 1; i++) {
			int a = readInt() - 1;
			int b = readInt() - 1;
			arr[a].add(b);
			arr[b].add(a);
		}
		boolean[] vis = new boolean[N];
		int[] d = new int[N];
		int max = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		int n = 0;
		while (!q.isEmpty()) {
			int v = q.poll();
			vis[v] = true;
			for (int j = 0; j < arr[v].size(); j++) {
				if (!vis[arr[v].get(j)]) {
					q.add(arr[v].get(j));
					d[arr[v].get(j)] = d[v] + 1;
					if (d[arr[v].get(j)] > max) {
						max = d[arr[v].get(j)];
						n = arr[v].get(j);
					}
				}
			}
		}
		int[] d2 = new int[N];
		Arrays.fill(vis, false);
		q.add(n);
		while (!q.isEmpty()) {
			int v = q.poll();
			vis[v] = true;
			for (int j = 0; j < arr[v].size(); j++) {
				if (!vis[arr[v].get(j)]) {
					q.add(arr[v].get(j));
					d2[arr[v].get(j)] = d2[v] + 1;
					if (d2[arr[v].get(j)] >= max) {
						max = d2[arr[v].get(j)];
						n = arr[v].get(j);
					}
				}
			}
		}
		int[] d3 = new int[N];
		Arrays.fill(vis, false);
		q.add(n);
		while (!q.isEmpty()) {
			int v = q.poll();
			vis[v] = true;
			for (int j = 0; j < arr[v].size(); j++) {
				if (!vis[arr[v].get(j)]) {
					q.add(arr[v].get(j));
					d3[arr[v].get(j)] = d3[v] + 1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Math.max(d2[i], d3[i]) + 1);
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
