package Unit2;

import java.util.Scanner;

public class mockccc14j2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String[] A = new String[N];
		scan.nextLine();
		for (int i = 0; i < N; i++) {
			A[i] = scan.nextLine().trim();
		}
		for (int i = 0; i < A.length; i++) {
			String S = A[A.length - i - 1];
			if (i % 2 == 0) {
				System.out.println(S);
			}
			else {
				for (int j = S.length() - 1; j >= 0; j--) {
					System.out.println(S.charAt(j));
				}
			}
		}
		scan.close();
	}

}
