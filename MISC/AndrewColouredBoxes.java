package Unit2;
import java.util.*;
public class AndrewColouredBoxes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // boxes
		int k = sc.nextInt(); // colours
		int[] boxes = new int[n + 1];
		int[] colourCount = new int[k + 1];
		for (int i = 1; i <= n; i++) {
			int c = sc.nextInt();
			boxes[i] = c;
			colourCount[c]++;
		}
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int op = sc.nextInt();
			if (op == 1) {
				int p = sc.nextInt();
				int c = sc.nextInt();
				colourCount[boxes[p]]--;
				boxes[p] = c;
				colourCount[boxes[p]]++;
			}
			else {
				System.out.println(colourCount[sc.nextInt()]);
			}
		}
	}

}
