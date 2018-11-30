package Unit2;
import java.util.*;
public class wc171j3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int teamA = 0;
		int teamB = 0;
		for (int i = 0; i < 7; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			if (x > y) {
				teamA++;
			}
			else {
				teamB++;
			}
			if (teamA == 4 || teamB == 4) {
				System.out.println(teamA + " " + teamB);
				break;
			}

		}
	}

}
