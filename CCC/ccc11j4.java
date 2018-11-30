package Unit1;
import java.util.*;
public class ccc11j4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int StartH = 199;
		int StartV = 4;
		int FinalH = 0;
		int FinalV = StartV;
		int x = 1;
		int[][] array = new int[1000][1000];
		for (int[] row : array) {
			Arrays.fill(row, 0);
		}
		array[200][0] = 1;
		array[200][1] = 1;
		array[200][2] = 1;
		array[201][2] = 1;
		array[202][2] = 1;
		array[203][2] = 1;
		array[203][3] = 1;
		array[203][4] = 1;
		array[204][4] = 1;
		array[205][4] = 1;
		array[205][3] = 1;
		array[205][2] = 1;
		array[206][2] = 1;
		array[207][2] = 1;
		array[207][3] = 1;
		array[207][4] = 1;
		array[207][5] = 1;
		array[207][6] = 1;
		array[206][6] = 1;
		array[205][6] = 1;
		array[204][6] = 1;
		array[203][6] = 1;
		array[202][6] = 1;
		array[201][6] = 1;
		array[200][6] = 1;
		array[199][6] = 1;
		array[199][5] = 1;
		array[199][4] = 1;
		do {

			String direction = scan.next();
			int spaces = scan.nextInt();
			if (direction.equalsIgnoreCase("L")) {
				FinalH = StartH - spaces;
			}
			else if (direction.equalsIgnoreCase("R")) {
				FinalH = StartH + spaces;
			}
			else if (direction.equalsIgnoreCase("U")) {
				FinalV -= spaces;
			}
			else if (direction.equalsIgnoreCase("D")) {
				FinalV += spaces;
			}
			else if (direction.equalsIgnoreCase("Q")) {
				break;
			}
			// if (direction != "L" || "R" || "U" || "D" || "Q"){
			// break;
			// }
			for (int i = 0; i < spaces; i++) {
				if (direction.equalsIgnoreCase("L")) {
					StartH = StartH - 1;
				}
				else if (direction.equalsIgnoreCase("R")) {
					StartH = StartH + 1;
				}
				else if (direction.equalsIgnoreCase("U")) {
					StartV = StartV - 1;
				}
				else if (direction.equalsIgnoreCase("D")) {
					StartV = StartV + 1;
				}
				if (StartH < 0 || StartH > 400) {
					x = 0;
					break;
				}
				else if (StartV > 200 || StartV < 0) {
					x = 0;
					break;
				}
				else if (array[StartH][StartV] == 1) {
					x = 0;
					break;
				}
				else {
					array[StartH][StartV] = 1;
				}
			}
			if (x == 0) {
				System.out.print(FinalH - 200);
				System.out.print(" ");
				System.out.print(-1 - FinalV);
				System.out.print(" ");
				System.out.println("DANGER");
				break;
			}
			else if (array[StartH][StartV] == 1) {
				System.out.print(StartH - 200);
				System.out.print(" ");
				System.out.print(-1 - StartV);
				System.out.print(" ");
				System.out.println("safe");
			}

		}
		while (x == 1);

	}

}