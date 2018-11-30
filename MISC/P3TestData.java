package Unit2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;

public class P3TestData {

	public static void main(String[] args) throws IOException {
		PrintWriter prt = new PrintWriter(
				new OutputStreamWriter(new FileOutputStream("/Users/felixhe4/Desktop/GFSSOC/P3TestData/input20.txt")));
		Random rand = new Random();
		int n = rand.nextInt(100000) + 1;
		int m = rand.nextInt(1000000) + n;
		int e = rand.nextInt(7538000);
		int f = rand.nextInt(n) + 1;
		prt.println(n + " " + m + " " + e);
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < m; i++) {
			int a = rand.nextInt(n) + 1;
			int b = rand.nextInt(n) + 1;
			int c = rand.nextInt(7538) + 1;
			if (i == m / 2) {
				a = f;
			}
			String s = a + " " + b;
			int x = set.size();
			set.add(s);
			if (set.size() != x) {
				prt.println(a + " " + b + " " + c);
			} else {
				i--;
			}
		}
		prt.println(f);
		prt.close();
	}
}
