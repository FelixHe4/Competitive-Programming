package Unit2;
import java.io.*;
import java.util.*;
public class pegCake {
	static long[][] d;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		d = new long[n + 100][m + 100];
		long[][] psa = new long[n + 100][m + 100];
		int e = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			Update(x, y, x2, y2);
			// System.out.println();
			// for (int l = 0; l < n + 2; l++) {
			// for (int j = 0; j < m + 2; j++) {
			// System.out.print(d[l][j] + " ");
			// }
			// System.out.println();
			// }
		}
		for (int i = 1; i < n + 2; i++) {
			for (int j = 1; j < m + 2; j++) {
				d[i][j] += d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1];
				psa[i][j] = (psa[i - 1][j] + psa[i][j - 1]
						- psa[i - 1][j - 1] + d[i][j]);
			}
		}
		int run = sc.nextInt();
		for (int i = 0; i < run; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			System.out.println(psa[x2][y2] - psa[x2][y] - psa[x][y2] + psa[x][y]);
		}
	}

	public static long[][] Update(int x, int y, int x2, int y2) {
		d[x][y]++;
		d[x2 + 1][y]--;
		d[x][y2 + 1]--;
		d[x2 + 1][y2 + 1]++;
		return d;
	}

}
