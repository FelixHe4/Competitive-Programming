package Unit1;
import java.util.*;
public class ccc10j5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int board[][] = new int[9][9];
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++)
				board[i][j] = 100;
		}
		LinkedList<Integer> X = new LinkedList<Integer>();
		LinkedList<Integer> Y = new LinkedList<Integer>();
		int a = scan.nextInt();
		int b = scan.nextInt();
		X.add(a);
		Y.add(b);
		board[a][b] = 0;
		while (!X.isEmpty()) {
			int x = X.peek();
			X.poll();
			int y = Y.peek();
			Y.poll();
			// x-2 > 0 || x+2 < 9 || y-2 > 0 || y+2 < 9
			// x-1 > 0 || x+1 < 9 || y-1 > 0 || y+1 < 9
			if (x - 2 > 0 && y - 1 > 0 && board[x - 2][y - 1] > board[x][y] + 1) {
				board[x - 2][y - 1] = board[x][y] + 1;
				X.add(x - 2);
				Y.add(y - 1);
			}
			if (x - 2 > 0 && y + 1 < 9 && board[x - 2][y + 1] > board[x][y] + 1) {
				board[x - 2][y + 1] = board[x][y] + 1;
				X.add(x - 2);
				Y.add(y + 1);
			}
			if (x + 2 < 9 && y - 1 > 0 && board[x + 2][y - 1] > board[x][y] + 1) {
				board[x + 2][y - 1] = board[x][y] + 1;
				X.add(x + 2);
				Y.add(y - 1);
			}
			if (x + 2 < 9 && y + 1 < 9 && board[x + 2][y + 1] > board[x][y] + 1) {
				board[x + 2][y + 1] = board[x][y] + 1;
				X.add(x + 2);
				Y.add(y + 1);
			}
			if (x - 1 > 0 && y - 2 > 0 && board[x - 1][y - 2] > board[x][y] + 1) {
				board[x - 1][y - 2] = board[x][y] + 1;
				X.add(x - 1);
				Y.add(y - 2);
			}
			if (x - 1 > 0 && y + 2 < 9 && board[x - 1][y + 2] > board[x][y] + 1) {
				board[x - 1][y + 2] = board[x][y] + 1;
				X.add(x - 1);
				Y.add(y + 2);
			}
			if (x + 1 < 9 && y - 2 > 0 && board[x + 1][y - 2] > board[x][y] + 1) {
				board[x + 1][y - 2] = board[x][y] + 1;
				X.add(x + 1);
				Y.add(y - 2);
			}
			if (x + 1 < 9 && y + 2 < 9 && board[x + 1][y + 2] > board[x][y] + 1) {
				board[x + 1][y + 2] = board[x][y] + 1;
				X.add(x + 1);
				Y.add(y + 2);
			}
		}
		a = scan.nextInt();
		b = scan.nextInt();
		System.out.println(board[a][b]);
	}
}