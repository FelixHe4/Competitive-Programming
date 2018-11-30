package Unit2;

import java.io.IOException;

public class reverse {

	public static void main(String[] args) throws IOException {
		String s = "abcdefghijk";
		String x = s.substring(3, 6);
		String z = s.substring(6);
		s = s.substring(0, 3);
		for (int i = 0; i < x.length(); i++) {
			s += x.charAt(x.length() - (i + 1));
		}
		s += z;
		System.out.println(s);
	}
}
