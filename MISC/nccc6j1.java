package Unit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nccc6j1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine()), b = Integer.parseInt(br.readLine());
		if (a > b) {
			System.out.println("CS452");
		} else if (b > a) {
			System.out.println("PHIL145");
		}

	}
}
