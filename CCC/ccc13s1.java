package Unit1;
import java.util.*;
public class ccc13s1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		int val2 = val;
		int orgVal = val;
		val2++;
		Set<Integer> set = new HashSet<Integer>();
		int count = 0;
		int firstRun = 0;
		while (true) {
			while (val > 0) {
				if (firstRun == 0) {
					set.add((int) Integer
							.parseInt(
									String.valueOf(String.valueOf(val2)
											.charAt(String.valueOf(val2).length() - 1))));
					firstRun++;
					count++;
				}
				else {
					int tempVal = val2 % 10;
					set.add(tempVal);
					val2 = val2 / 10;
					count++;
					firstRun++;
				}
				if (firstRun == String.valueOf(val).length() + 1) {
					break;
				}
			}
			if (count - 1 != set.size()) {
				val++;
				val2 = val;
				set.clear();
				firstRun = 0;
				count = 0;
			}
			else {
				break;

			}
		}
		if (val == orgVal) {
			System.out.println(val + 1);
		}
		else {
			System.out.println(val);
		}
	}

}
