package Unit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nccc6j3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), n = Integer.parseInt(s[2]);
			if (a == n || b == n) {
				System.out.println("YES");
				continue;
			}
			int aC = 0;
			int bC = 0;
			boolean flag = false;
			while (bC * b <= n) {
				while (aC * a + bC * b <= n) {
					if (aC * a + bC * b == n) {
						System.out.println("YES");
						flag = true;
						break;
					}
					aC++;
				}
				if (flag) {
					break;
				}
				bC++;
				aC = 0;
			}
			if (!flag) {
				System.out.println("NO");
			}
		}
	}
}
