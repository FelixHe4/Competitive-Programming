package Unit1;
import java.io.*;
import java.util.*;
public class ccc10j4p2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		while (s.charAt(0) != '0') {
			int numbers = Integer.parseInt(s.split(" ")[0]);
			ArrayList<Integer> a = new ArrayList<Integer>();
			ArrayList<Integer> diff = new ArrayList<Integer>();
			if (numbers == 1 || numbers == 0) {
				System.out.println(0);
			}
			else {
				for (int i = 1; i < numbers + 1; i++) {
					a.add(Integer.valueOf(s.split(" ")[i]));
				}

				for (int i = 0; i < a.size() - 1; i++) {
					diff.add(0 - (a.get(i) - a.get(i + 1)));
				}
				boolean flag = true;
				for (int i = 1; i < diff.size(); i++) {
					if (diff.get(0) == diff.get(i)) {
						System.out.println(i);
						flag = false;
						break;
					}
				}
				if (flag) {
					System.out.println(diff.size());
				}
			}
			s = br.readLine();
		}

	}

}