package Unit2;
import java.io.*;
import java.util.*;
public class PrefixSum2D {

	public static void main(String[] args) throws IOException {
		int[][] A = { { 4, 5, 11, 2, 1 },
				{ 1, 2, 3, 4, 5 },
				{ 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 } };
		// from 1,1 to 2,3 rectangle shape sum
		int[][] prefixSum = new int[5][5];

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (r == 0 && c == 0) {
					prefixSum[r][c] = A[r][c];
				}
				else if (r == 0) {
					prefixSum[r][c] = prefixSum[r][c - 1] + A[r][c];
				}
				else if (c == 0) {
					prefixSum[r][c] = prefixSum[r - 1][c] + A[r][c];
				}
				else {
					prefixSum[r][c] = prefixSum[r - 1][c] +
							prefixSum[r][c - 1] - prefixSum[r - 1][c - 1] + A[r][c];
				}
			}
		}
		int LR = 1;
		int LC = 1;
		int RR = 2;
		int RC = 3;
		System.out.println(prefixSum[RR][RC] - prefixSum[LR - 1][RC] -
				prefixSum[RR][LC - 1] + prefixSum[LR - 1][LC - 1]);

	}

}
