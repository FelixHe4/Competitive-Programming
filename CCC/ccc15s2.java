package Unit1;
import java.util.Scanner;
public class ccc15s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int j = sc.nextInt();
		int a = sc.nextInt();
		sc.nextLine();
		int[] jerseys = new int[j];
		for (int i = 0; i < j; i++) {
			String s = sc.nextLine();
			if (s.equals("S")) {
				jerseys[i] = 1;
			} else if (s.equals("M")) {
				jerseys[i] = 2;
			} else if (s.equals("L")) {
				jerseys[i] = 3;
			}
		}
		int count = 0;
		for (int i = 0; i < a; i++) {
			String cur = sc.next();
			int cur1 = 0;
			if (cur.equals("S")) {
				cur1 = 1;
			} else if (cur.equals("M")) {
				cur1 = 2;
			} else if (cur.equals("L")) {
				cur1 = 3;
			}
			int pos = sc.nextInt();
			if (jerseys[pos - 1] >= cur1) {
				count++;
				jerseys[pos - 1] = Integer.MIN_VALUE;
			}
		}
		System.out.println(count);
		sc.close();
	}
}