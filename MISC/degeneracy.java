package Unit2;

import java.io.IOException;

public class degeneracy {

	public static void main(String[] args) throws IOException {
		double sum = 0;
		for (int i = 1; i < 2005; i++) {
			sum += i * 0.20 + 1;
		}
		System.out.println(sum);
	}
}
