package Unit1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc19s1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[][] a = { { 1, 2 }, { 3, 4 } };
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'V') {
				int z1 = a[0][1];
				int z2 = a[1][1];
				int z3 = a[0][0];
				int z4 = a[1][0];
				a[0][0] = z1;
				a[0][1] = z3;
				a[1][0] = z2;
				a[1][1] = z4;
			} else {
				int z1 = a[0][1];
				int z2 = a[1][1];
				int z3 = a[0][0];
				int z4 = a[1][0];
				a[0][0] = z4;
				a[0][1] = z2;
				a[1][0] = z3;
				a[1][1] = z1;
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
