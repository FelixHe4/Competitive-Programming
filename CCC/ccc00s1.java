package Unit1;
import java.util.Scanner;

public class ccc00s1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int count = 0;
		while (true) {
			if (total > 0) {
				total--;
				count++;
			}
			else {
				break;
			}
			a++;
			if (a % 35 == 0) {
				total += 30;
			}
			if (total > 0) {
				total--;
				count++;
			}
			else {
				break;
			}
			b++;
			if (b % 100 == 0) {
				total += 60;
			}
			if (total > 0) {
				total--;
				count++;
			}
			else {
				break;
			}
			c++;
			if (c % 10 == 0) {
				total += 9;
			}
		}
		System.out.println("Martha plays " + count + " times before going broke.");
	}

}