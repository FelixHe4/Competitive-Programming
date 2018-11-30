package Unit2;
import java.util.Scanner;

public class tssp1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (1 <= n && n <= 100) {
			System.out.println("bad");
		} else if (101 <= n && n <= 200) {
			System.out.println("ok");
		} else if (201 <= n && n <= 300) {
			System.out.println("good");
		}
	}
}