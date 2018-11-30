package Unit2;

import java.awt.*;
import java.io.*;
import java.util.*;

public class hmm {
	public static final char INFINITY = 65535;

	static int n; // number of cities
	static char[] shipping; // shipping contains shippping cost
	// to that city from the destination city
	// char arrays are used to save space
	// 5000x5000 ints is a too much for
	// my computer :-)
	static char[][] edges;
	static char[] cost; // contains the cost of the pencils

	public static void main(String[] args) throws IOException {
		n = readInt();

		edges = new char[n + 1][n + 1];
		shipping = new char[n + 1];
		cost = new char[n + 1];

		for (int i = 1; i <= n; i++) {
			cost[i] = INFINITY;
			for (int j = 1; j <= n; j++)
				edges[i][j] = 0;
		}

		// Store trade routes (edges)
		int t = readInt();
		for (int i = 1; i <= t; i++) {
			int x = readInt();
			int y = readInt();
			char c = (char) readInt();
			if (x >= 1 && x <= n && y >= 1 && y <= n) // strangely some data files have invalid
														// cities??
			{
				edges[x][y] = c;
				edges[y][x] = c;
			}
		}

		// Store cities that sell pencils
		int k = readInt();
		char hold1, hold2;
		for (int i = 0; i < k; i++) {
			hold1 = (char) readInt();
			hold2 = (char) readInt();
			if (hold1 >= 1 && hold1 <= n)
				cost[hold1] = hold2;
		}

		int destination = readInt();

		Dijkstra(destination);

		// Dijkstra has given the minimum shipping costs from every city
		// to the destination. So the cheapest pencil we can get at that
		// city is from the city with the lowest shipping cost + pencil cost.
		int min = INFINITY;
		int totalCost = 0;
		for (int i = 1; i <= n; i++) {
			totalCost = cost[i] + shipping[i];
			System.out.println(totalCost);
			if (totalCost < min)
				min = totalCost;
		}
		System.out.println(min);
	}

	// Use Dijkstra's algorithm to find the cheapest path from the destination
	// to all other points in O(n^2) time.
	// In other words it fills the shipping array with the minimum shipping
	// cost from that city to the destination city.
	public static void Dijkstra(int start) {
		boolean[] used = new boolean[n + 1];
		int city, small, count;

		// step 1: fill all shipping values with a large value except the destination
		shipping = new char[n + 1];
		for (int i = 1; i <= n; i++) {
			used[i] = false;
			shipping[i] = INFINITY;
		}
		shipping[start] = 0;
		count = 0;
		while (count < n) {
			// Step 2: Choose the next city:
			// the one with the smallest shipping that hasn't been used.
			small = INFINITY;
			city = 1;
			for (int i = 1; i <= n; i++) {
				if (!used[i] && shipping[i] < small) {
					small = shipping[i];
					city = i;
				}
			}

			// Step 3: for all cities (i) connected to the city in question,
			// update their distance to city. It is the the distance
			// to the city plus the distance along the edge from
			// the ith city to the city, if that is smaller than
			// what is already stored in shipping for that city.
			used[city] = true;
			count++;
			for (int i = 1; i <= n; i++)
				if (edges[city][i] > 0 && !used[i])
					if (shipping[i] > shipping[city] + edges[city][i])
						shipping[i] = (char) (shipping[city] + edges[city][i]);
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
