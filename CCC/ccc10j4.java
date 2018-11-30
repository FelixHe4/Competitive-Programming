package Unit1;
import java.io.*;
import java.util.*;
public class ccc10j4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int counter = 0;
		while (s.charAt(0) != '0') {
			if (counter == 1) {
				System.out.println(s);
			}
			counter++;
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
				System.out.println(diff);
				boolean flag = true;
				if (diff.size() > 2) {
					if (diff.contains(13)) {
						System.out.println(diff.size());
						flag = false;
					}
					else {
						for (int i = 1; i < diff.size() - 1; i++) {
							if (diff.get(0) == diff.get(i)) {
								if (i == 1) {
									if (diff.get(i + 1) != diff.get(0)) {
										System.out.println(diff.size());
										flag = false;
									}
									else {
										System.out.println(i);
										flag = false;
										break;
									}
								}
								else {
									System.out.println(i);
									flag = false;
									break;
								}
							}
						}
					}
				}
				else {
					if (diff.size() == 1) {
						System.out.println(diff.size());
						flag = false;
					}
					else if (diff.get(0) == diff.get(1)) {
						System.out.println(1);
						flag = false;
					}
					else {
						System.out.println(diff.size());
						flag = false;
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
