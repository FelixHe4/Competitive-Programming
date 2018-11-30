package Unit2;
import java.io.*;
import java.math.*;
import java.util.*;
public class tc18summerf {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		if (a.compareTo(b) >= 1) {
			System.out.println("S");
		} else if (a.compareTo(b) == 0) {
			System.out.println("E");
		} else {
			System.out.println("T");
		}
		sc.close();
	}
}
