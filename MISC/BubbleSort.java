package Unit2;
import java.util.Scanner;
public class BubbleSort {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				boolean swap = false;
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swap = true;
				}
				if (swap) {
					for (int k = 0; k < N; k++) {
						System.out.print(arr[k] + " ");
					}
					System.out.println();
				}
			}
		}
	}
}
