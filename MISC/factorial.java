package Unit2;

import java.io.IOException;

public class factorial {

	public static void main(String[] args) throws IOException {
		System.out.println(fac(5));
	}

	static long fac(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * fac(n - 1);
		}
	}
}
