package Unit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nccc6s1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		float f = 0;
		for (int i = 0; i < n; i++) {
			f += Integer.parseInt(br.readLine());
		}
		System.out.printf("%.1f", (f / n));
	}
}
