package Unit2;
import java.io.*;
import java.util.*;
public class ecoo17r1p2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<String> cNames = new ArrayList<String>();
		ArrayList<String> numbers = new ArrayList<String>();
		ArrayList<Integer> gValues = new ArrayList<Integer>();
		ArrayList<Integer> fValues = new ArrayList<Integer>();
		ArrayList<Integer> pValues = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			if (i == 0) {
				cNames.add(br.readLine());
			}
			String line = "";
			while ((line = br.readLine()).startsWith("J")) {
				numbers.add(line.substring(2, line.length()));
			}
			int total = 0;
			int totalG = 0;
			int totalF = 0;
			int totalP = 0;
			for (int j = 0; j < numbers.size(); j++) {
				for (int k = 0; k < numbers.get(j).length(); k += 2) {
					total += Integer.parseInt(String.valueOf(numbers.get(j).charAt(k)));
					if (k == numbers.get(j).length() - 1) {
						totalG += Integer.parseInt(String.valueOf(numbers.get(j).charAt(k)));
					}
					else if (k == numbers.get(j).length() - 3) {
						totalF += Integer.parseInt(String.valueOf(numbers.get(j).charAt(k)));
					}
					else if (k == numbers.get(j).length() - 5) {
						totalP += Integer.parseInt(String.valueOf(numbers.get(j).charAt(k)));
					}
				}

			}
			a.add(total);
			gValues.add(totalG);
			fValues.add(totalF);
			pValues.add(totalP);
			total = 0;
			numbers.clear();
			System.out.println(a);
			System.out.println(gValues);
			System.out.println(fValues);
			System.out.println(pValues);
		}
	}
}
