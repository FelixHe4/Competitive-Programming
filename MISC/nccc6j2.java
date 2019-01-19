package Unit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nccc6j2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "pusheen";
		String s2 = br.readLine();
		int count = 0;
		for (int i = 0; i < 7; i++) {
			if (s.charAt(i) != s2.charAt(i)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
