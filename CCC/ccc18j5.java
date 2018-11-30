package Unit1;
import java.util.*;

public class ccc18j5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		LinkedList<Integer> endPage = new LinkedList<Integer>();
		boolean[][] A = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if (n == 0) {
				endPage.add(i);
			}
			else {
				for (int j = 0; j < n; j++) {
					int p = sc.nextInt();
					A[i][p - 1] = true;
				}
			}
		}
		int[] step = new int[N];
		for (int i = 0; i < N; i++) {
			step[i] = Integer.MAX_VALUE;
		}
		step[0] = 1;
		LinkedList<Integer> nextPage = new LinkedList<Integer>();
		nextPage.add(0);

		int minPath = Integer.MAX_VALUE;
		LinkedList<Integer> reachPage = new LinkedList<Integer>();
		reachPage.add(0);
		while (!nextPage.isEmpty()) {
			int p = nextPage.poll();
			for (int c = 0; c < N; c++) {
				if (A[p][c]) {
					if (step[c] > step[p] + 1) {
						reachPage.add(c);
						step[c] = step[p] + 1;
						if (endPage.contains(c)) {
							if (minPath > step[c]) {
								minPath = step[c];
							}
						}
						else {
							nextPage.add(c);
						}
					}
				}
			}
		}
		if (reachPage.size() == N) {
			System.out.println("Y");
		}
		else {
			System.out.println("N");
		}

		System.out.println(minPath);
		sc.close();
	}

}