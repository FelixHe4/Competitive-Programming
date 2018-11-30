package Unit2;

import java.io.IOException;

public class Runsin1Second {

	public static void main(String[] args) throws IOException, InterruptedException {
		for (int i = 0; i < 100000000; i++) {
			System.out.println(i);
		}
	}
}
