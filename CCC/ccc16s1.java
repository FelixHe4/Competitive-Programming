package Unit1;
import java.io.*;
import java.util.*;
public class ccc16s1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int[] a1 = new int[27];
		int[] a2 = new int[27];
		for (int i = 0; i < a.length(); i++) {
			a1[(int) a.charAt(i) - 97]++;
			if (b.charAt(i) == '*') {
				a2[26]++;
			}
			else {
				a2[(int) b.charAt(i) - 97]++;
			}
		}
		boolean flag = true;
		for (int i = 0; i < a1.length - 1; i++) {
			if (a2[i] > a1[i]) {
				flag = false;
			}
		}
		if (!flag) {
			System.out.println("N");
		}
		else {
			System.out.println("A");
		}

	}

}
