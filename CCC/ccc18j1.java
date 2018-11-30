package Unit1;
import java.util.*;

public class ccc18j1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int c = scan.nextInt();
		int d = scan.nextInt();
		int b = scan.nextInt();
		if ((a == 8 || a == 9) && (b == 8 || b == 9) && (c == d)) {
			System.out.println("ignore");
		}
		else {
			System.out.println("answer");
		}

	}
}
