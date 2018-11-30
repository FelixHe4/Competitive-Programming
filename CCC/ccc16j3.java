package Unit1;
import java.util.*;
public class ccc16j3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String x = scan.nextLine();
		int ans = 1;
		for (int i = 1; i < (x.length() + 1) / 2; i++) {
			for (int j = 0; j < x.length() - 2 * i; j++) {
				String reverse = new StringBuffer(x.substring(j + i + 1, j + 2 * i + 1)).reverse()
						.toString();
				if (x.substring(j, j + i).equals(reverse) && ans < i * 2 + 1) {
					ans = i * 2 + 1;
				}
			}
		}
		for (int i = ans / 2; i < x.length() / 2 + 1; i++) {
			for (int j = 0; j < x.length() - 2 * i + 1; j++) {
				String reverse = new StringBuffer(x.substring(j + i, j + 2 * i)).reverse()
						.toString();
				if (x.substring(j, j + i).equals(reverse) && ans < i * 2) {
					ans = i * 2;
				}
			}
		}
		System.out.println(ans);
	}
}