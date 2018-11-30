package Unit2;
import java.io.*;
import java.util.*;
public class MockCCC14s4 {
	public static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		A = new int[n];
		String s = br.readLine();
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(s.split(" ")[i]);
		}
		boolean dip = false;
		for (int range = A.length; range >= 1; range--) {
			for (int i = 0; i <= A.length - range; i++) {
				if (isDip(i, i + range)) {
					dip = true;
					if (range >= 3) {
						System.out.println(range);
					}
					else {
						System.out.println(0);
					}
					break;
				}
			}
			if (dip) {
				break;
			}
		}
		if (!dip) {
			System.out.println(0);
		}
	}

	public static boolean isDip(int b, int e) {
		// one by one go downs
		// one by one go flat
		// one by one go up
		// check if reach to the endIndex
		// if yes return true
		// if no return false
		int bI = b;
		int eI = e;
		boolean decreasing = false;
		// increasing will be decrease as false
		while (true) {
			if (bI + 1 < eI && A[bI] > A[bI + 1]) {
				// decreasing
				decreasing = true;
				bI++;
			}
			else {
				// when we are no longer decreasing
				break;
			}
		}
		while (true) {
			if (bI + 1 < eI && A[bI] == A[bI + 1]) {
				// equal
				bI++;
			}
			else {
				// when we are no longer decreasing
				break;
			}
		}
		boolean increasing = false;
		while (true) {
			if (bI + 1 < eI && A[bI] < A[bI + 1]) {
				// increasing
				increasing = true;
				bI++;
			}
			else {
				// when we are no longer decreasing
				break;
			}
		}
		if (bI == eI - 1 && decreasing == true && increasing == true) {
			return true;
		}
		else {
			return false;
		}
	}
}
