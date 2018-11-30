package Unit2;

import java.io.*;
import java.util.*;

public class dmpg15s6 {

	public static void main(String[] args) throws IOException {

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int n = readInt();
		int m = readInt();
		for (int i = 0; i < n; i++)
			hm.put(next(), i);
		ArrayList<Edge> e = new ArrayList<Edge>();
		for (int i = 0; i < m; i++) {
			int a = hm.get(next());
			int b = hm.get(next());
			double c = readDouble();
			e.add(new Edge(a, b, c));
		}
		double[] max = new double[n];
		int s = hm.get("APPLES");
		max[s] = 1.0;
		for (int i = 0; i < n; i++)
			for (Edge edge : e)
				max[edge.dest] = Math.max(max[edge.dest], max[edge.orig] * edge.cost);
		double prev = max[s];
		for (int i = 0; i < n; i++)
			for (Edge edge : e)
				max[edge.dest] = Math.max(max[edge.dest], max[edge.orig] * edge.cost);
		if (max[s] - prev > 0.1)
			System.out.println("YA");
		else
			System.out.println("NAW");
		System.out.close();
	}

	static class Edge {
		int orig, dest;
		double cost;

		Edge(int orig, int dest, double cost) {
			this.orig = orig;
			this.dest = dest;
			this.cost = cost;
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
