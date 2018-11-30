package Unit2;
import java.io.*;
import java.util.*;
public class suspicious {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<String> l = new LinkedList<String>();
		int spaces = 0;
		try {
			while (true) {
				String s = sc.nextLine();
				String s2 = s.replaceAll(" ", "");
				spaces = s2.length() - s.length();
				l.add(s);
			}
		} catch (Exception e) {

		}
		System.out.println("a");
		char[][] c = new char[l.size()][spaces];
		for (int i = 0; i < l.size(); i++) {
			for (int j = 0; j < spaces; j++) {
				c[i][j] = l.get(i).charAt(j);
				System.out.println(c[i][j]);
			}
		}
		int counter = 0;
		int dir = spaces;
		int x = 0;
		int times = 0;
		while (true) {
			for (int i = 0; i < spaces; i++) {
				System.out.print(c[x][i]);
			}
			if (times == 1) {
				dir--;
				times = 0;
			} else {
				times++;
			}
			if (x == 3) {
				x = 0;
			} else {
				x++;
			}
		}
	}
}

/**
 * 
 * 1 2 3 4 5 6 7 8 9
 */
