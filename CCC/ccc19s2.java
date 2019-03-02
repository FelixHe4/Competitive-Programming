package Unit1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc19s2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		System.out.println();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			n *= 2;
			for (int j = n; j >= 2; j--) {
				if (isPrime(j) && isPrime(n - j) && n - j != 1) {
					System.out.println(j + " " + (n - j));
					break;
				}
			}
		}
	}

	static boolean isPrime(int n) {
		if (n % 2 == 0)
			return false;
		int max = (int) Math.sqrt(n);
		for (int i = 3; i <= max; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
