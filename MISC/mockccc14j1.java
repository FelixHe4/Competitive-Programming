package Unit2;
import java.util.*;
public class mockccc14j1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double a = scan.nextInt();
		double b = scan.nextInt();
		double r = scan.nextInt();
		if (a > r) {
			System.out.println("Bob overdoses on day 1.");
		}
		else if (a / 2 + b > r) {
			System.out.println("Bob overdoses on day 2.");
		}
		else {
			System.out.println("Bob never overdoses.");
		}
	}

}
