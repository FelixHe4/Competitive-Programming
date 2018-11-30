package Unit2;
import java.util.*;
public class MockCCC14s3 {
	public static int[][] a;
	static int R;
	static int C;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		int col = scan.nextInt();
		a = new int[rows][col];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				a[i][j] = scan.nextInt();
			}
		}

		int N = scan.nextInt();
		for (int i = 0; i < N; i++) {
			int c = scan.nextInt();
			bubbleSort(c - 1);
		}
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.println(a[r][c] + " ");
			}
			System.out.println();
		}
	}

	public static void bubbleSort(int col) {
		for (int i = 0; i < R; i++) {
			boolean swap = false;
			for (int r = 0; r < R - 1; r++) {
				if (a[r][col] > a[r + 1][col]) {
					swap = true;
					swapRow(r, r + 1);
				}
			}
			if (!swap) {
				break;
			}
		}
	}

	public static void swapRow(int r1, int r2) {
		for (int i = 0; i < C; i++) {
			int temp = a[r1][i];
			a[r1][i] = a[r2][i];
			a[r2][i] = temp;
		}
	}
}
