package Unit1;
import java.io.IOException;
import java.util.*;
public class ccc16s2 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int questionT = scan.nextInt();
		int bikers = scan.nextInt();
		int total1 = 0;
		int[] dmoj = new int[bikers];
		int[] peg = new int[bikers];
		for (int i = 0; i < bikers; i++) {
			dmoj[i] = scan.nextInt();
		}
		for (int i = 0; i < bikers; i++) {
			peg[i] = scan.nextInt();
		}
		for (int i = 0; i < bikers; i++) {

		}
		if (questionT == 1) {
			Arrays.sort(dmoj);
			Arrays.sort(peg);
			for (int j = 0; j < bikers; j++) {
				int maxim = Math.max(dmoj[j], peg[j]);
				total1 += maxim;
			}
		}

		else if (questionT == 2) {
			List<Integer> dmojList = new ArrayList<Integer>();
			for (int j = 0; j < dmoj.length; j++) {
				dmojList.add(dmoj[j]);
			}
			Collections.sort(dmojList, Collections.reverseOrder());
			Arrays.sort(peg);
			for (int j = 0; j < bikers; j++) {
				int maxim = Math.max((int) dmojList.toArray()[j], peg[j]);
				total1 += maxim;
			}
		}
		System.out.println(total1);
	}

}
