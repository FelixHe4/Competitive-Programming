package Unit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nccc6s2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < s.length; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		int a = 1, count = 0;
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = 0; j < n; j++) {
				if (a != arr[i][j]) {
					count++;
					a++;
					flag = true;
				} else {
					a++;
				}
			}
			if (flag) {
				System.out.println(count);
				System.exit(0);
			}
		}
	}
}
