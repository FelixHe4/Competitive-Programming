package Unit1;
import java.io.*;
import java.util.*;
public class ccc09s2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		int r = Integer.parseInt(br.readLine());
		LinkedList<String> c1 = new LinkedList<String>();
		for (int i = 0; i < c; i++) {
			String s = br.readLine();
			s = s.replaceAll("\\s+", "");
			c1.add(s);
		}
		LinkedList<String> pre = new LinkedList<String>();
		pre.add(c1.get(0));
		for (int i = 1; i < c; i++) {
			LinkedList<String> cur = new LinkedList<String>();
			cur.add(c1.get(i)); // add current row
			for (int j = 0; j < pre.size(); j++) {
				String newP = combine(c1.get(i), pre.get(j));
				if (!cur.contains(newP)) {
					cur.add(newP);
				}
				// add current row and current row & previous combined
			}
			pre = cur;
		}
		System.out.println(pre.size());
	}

	// static means that it is global
	// so it can be called.
	// String means to return the string
	public static String combine(String s1, String s2) {
		String S = "";
		// find a way to get the input without the spaces
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				S = S + "0";
			}
			else {
				S = S + "1";
			}
		}
		return S;
	}
}
