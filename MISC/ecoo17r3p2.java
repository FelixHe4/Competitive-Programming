package Unit2;
import java.io.*;
import java.util.*;
public class ecoo17r3p2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<String> family = new LinkedList<>();
		for (int x = 0; x < 10; x++) {
			int child = Integer.valueOf(br.readLine());
			for (int y = 0; y < child; y++) {
				String[] val = br.readLine().split("\\.");
				int count = 1;
				for (int s = val.length - 1; s >= 0; s--) { // iterater through val
					int number = Integer.valueOf(val[s]);
					for (int i = number; i >= 1; i--) { // iterate through numbers less then val
						String p = "";
						for (int j = 0; j < val.length - count; j++) {
							p += val[j] + ".";
						}
						p += i;
						if (!family.contains(p)) {
							family.add(p);
						}
					}
					count++;
				}
			}
			System.out.println(family.size() + 1);
			family.clear();
		}
	}

}