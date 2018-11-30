package Unit2;
import java.io.*;
import java.util.*;
public class dmopc16c3p2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		long N = Integer.parseInt(s.split(" ")[0]);
		long K = Integer.parseInt(s.split(" ")[1]);
		long D = Integer.parseInt(s.split(" ")[2]);
		ArrayList<Long> a = new ArrayList<Long>();
		LinkedList<Integer> l = new LinkedList<Integer>();
		for (int runs = 0; runs < N; runs++) {
			String S = br.readLine();
			boolean[] arr = new boolean[(int) K];
			if (S.equals("T")) {
				a.add((long) 1);
			}
			else {
				long breaks = Integer.parseInt(S.split(" ")[1]);
				for (int i = 0; i < a.size(); i++) {
					if (l.contains(i)) {
						i++;
					}
					if (arr[i] == true && (a.get(i) * breaks > D || a.get(i) < 0)) {
						System.out.println("dust");
						arr[i] = false;
						l.add(i);
					}
					else {
						a.set(i, a.get(i) * breaks);
					}
				}

			}
		}
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) > D) {
				System.out.println("dust");
			}
			else {
				System.out.println(a.get(i));
			}
		}
	}

}
