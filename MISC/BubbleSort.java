package Unit2;
import java.util.*;
public class BubbleSort {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] A = new int[N];
		// manually do the code to sort
		for (int i = 0; i < N; i++) {
			boolean swap = false;
			for (int j = i; j < N - 1; j++) {
				if (A[j] > A[j + 1]) {
					// swap
					int temp = A[j + 1];
					A[j + 1] = A[j];
					A[j] = temp;
					swap = true;
				}
			}
			if (swap) {
				break;
			}
		}
	}

}
