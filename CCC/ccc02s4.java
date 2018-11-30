package Unit1;
import java.util.Scanner;
public class ccc02s4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int numOfPeople = sc.nextInt();
		int[][] dp = new int[numOfPeople + 1][2];
		int[] people = new int[numOfPeople + 1];
		String[] names = new String[numOfPeople + 1];
		for (int x = 1; x < people.length; x++) {
			names[x] = sc.next();
			people[x] = sc.nextInt();
			dp[x][0] = Integer.MAX_VALUE;
		}
		for (int x = 0; x < dp.length; x++) {
			int slowest = 0;
			for (int y = 1; y <= m && x + y < dp.length; y++) {
				slowest = Math.max(slowest, people[x + y]);
				if (slowest + dp[x][0] < dp[x + y][0]) {
					dp[x + y][0] = slowest + dp[x][0];
				}
			}
		}
		System.out.println("Total Time: " + dp[dp.length - 1][0]);
		for (int x = dp.length - 1; x >= 0; x--) {
			int slowest = 0;
			for (int y = 0; y < m && x - y - 1 >= 0; y++) {

				slowest = Math.max(slowest, people[x - y]);
				if (dp[x][0] == dp[x - y - 1][0] + slowest) {
					dp[x - y - 1][1] = y + 1;
					x -= y;
					break;
				}
			}
		}
		for (int x = 0; x < dp.length; x++) {
			int group = dp[x][1];
			if (group == 0)
				break;
			for (int y = 1; y <= group; y++) {
				System.out.print(names[x + y] + " ");
			}
			System.out.println();
			x += group - 1;
		}
	}
}
