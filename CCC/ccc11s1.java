package Unit1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class ccc11s1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<String> l = new LinkedList<String>();
		int n = Integer.parseInt(br.readLine());
		if (n <= 0 || n >= 10000) {
			System.exit(0);
		}
		for (int i = 0; i < n; i++) {
			l.add(br.readLine());
		}
		String s = l.toString();
		int ts = 0;
		int ss = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'T' || s.charAt(i) == 't') {
				ts++;
			} else if (s.charAt(i) == 'S' || s.charAt(i) == 's') {
				ss++;
			} else {

			}
		}
		if (ts == ss) {
			System.out.println("French");
		} else if (ts > ss) {
			System.out.println("English");
		} else if (ss > ts) {
			System.out.println("French");
		}
	}
}