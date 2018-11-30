package Unit2;

import java.io.IOException;
import java.math.BigInteger;

public class BigInt {

	public static void main(String[] args) throws IOException {
		BigInteger b = new BigInteger("1");
		for (int i = 1; i <= 2005; i++) {
			b = b.multiply(BigInteger.valueOf(i));
		}
		System.out.println(b);
	}
}
