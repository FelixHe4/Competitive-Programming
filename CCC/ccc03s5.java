package Unit1;
import java.io.*;
import java.util.Scanner;
public class ccc03s5 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		int r = scan.nextInt();
		int d = scan.nextInt();
		int[][] grid = new int[c + 1][c + 1];
		for (int i = 0; i < r; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int cost = scan.nextInt();
			if (cost > grid[a][b]) {
				grid[a][b] = cost;
				grid[b][a] = cost;
			}
		}
		int[] dest = new int[d];
		for (int i = 0; i < d; i++) {
			dest[i] = scan.nextInt();
		}
		int[] val = new int[c + 1];
		boolean[] visited = new boolean[c + 1];
		int max11;
		int b;
		int max;
		for (int k = 0; k < c + 1; k++) {
			val[k] = 0;
			visited[k] = false;
		}
		val[1] = 100000;
		max11 = 1;
		do {
			b = max11;
			visited[max11] = true;
			max = 0;
			max11 = -1;
			for (int t = 1; t < c + 1; t++) {
				if (val[t] < Math.min(val[b], grid[b][t])) {
					val[t] = Math.min(val[b], grid[b][t]);
				}
				if (val[t] >= max && !visited[t]) {
					max = val[t];
					max11 = t;
				}
			}
		}
		while (max11 != -1);
		int small = 100000;
		for (int i = 0; i < d; i++) {
			if (val[dest[i]] < small) {
				small = val[dest[i]];
			}
		}
		System.out.println(small);
	}

}
