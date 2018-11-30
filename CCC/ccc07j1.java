package Unit1;

import java.io.*;
import java.util.*;

public class ccc07j1 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if ((a > b && c > a) || (a > c && b > a)) {
			System.out.println(a);
		} else if ((b > a && c > b) || (b > c && a > b)) {
			System.out.println(b);
		} else {
			System.out.println(c);
		}
	}
}
