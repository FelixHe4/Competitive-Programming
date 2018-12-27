package Unit1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
public class ccc05s1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		hm.put('A', 2);
		hm.put('B', 2);
		hm.put('C', 2);
		hm.put('D', 3);
		hm.put('E', 3);
		hm.put('F', 3);
		hm.put('G', 4);
		hm.put('H', 4);
		hm.put('I', 4);
		hm.put('J', 5);
		hm.put('K', 5);
		hm.put('L', 5);
		hm.put('M', 6);
		hm.put('N', 6);
		hm.put('O', 6);
		hm.put('P', 7);
		hm.put('Q', 7);
		hm.put('R', 7);
		hm.put('S', 7);
		hm.put('T', 8);
		hm.put('U', 8);
		hm.put('V', 8);
		hm.put('W', 9);
		hm.put('X', 9);
		hm.put('Y', 9);
		hm.put('Z', 9);
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			s = s.replace("-", "");
			s = s.substring(0, 10);
			for (int j = 0; j < s.length(); j++) {
				if (Character.isDigit(s.charAt(j))) {
					a.add(Integer.parseInt(String.valueOf(s.charAt(j))));
				}
				if (hm.containsKey(s.charAt(j))) {
					a.add(hm.get(s.charAt(j)));
				}
			}
			for (int k = 0; k < a.size(); k++) {
				if (k == 3 || k == 6) {
					System.out.print("-");
				}
				System.out.print(a.get(k));
			}
			a.clear();
			System.out.println(" ");
		}
	}
}