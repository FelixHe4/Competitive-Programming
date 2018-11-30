package Unit1;
import java.util.*;
public class ccc09s3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean[][] con = new boolean[50][50];
		// only store 0,1 not 1,0
		// do not repeat the values
		con[1][6] = con[2][6] = con[3][4] = con[3][5] = con[3][6] = con[3][15] = con[4][5] = con[4][6] = con[5][6] = con[6][7] = con[7][8] = con[8][9] = con[9][10] = con[9][12] = con[10][11] = con[11][12] = con[12][13] = con[13][14] = con[13][15] = con[16][17] = con[16][18] = con[17][18] = true;
		int x;
		int y;
		int ans;
		int[] minDist;
		while (true) {
			switch (scan.next()) {
			case "i":
				x = scan.nextInt();
				y = scan.nextInt();
				con[Math.min(x, y)][Math.max(x, y)] = true;
				break;
			case "d":
				x = scan.nextInt();
				y = scan.nextInt();
				con[Math.min(x, y)][Math.max(x, y)] = false;
				break;
			case "n":
				x = scan.nextInt();
				ans = 0;
				for (int i = 0; i < 50; i++) {
					if (con[i][x] || con[x][i]) {
						ans++;
					}
				}
				System.out.println(ans);
				break;
			case "f":
				x = scan.nextInt();
				minDist = new int[50];
				Arrays.fill(minDist, Integer.MAX_VALUE);
				minDist[x] = 0;
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 50; j++) {
						for (int k = 0; k < 50; k++) {
							if (con[j][k] || con[k][j]) {
								if (minDist[j] < minDist[k] - 1) {
									minDist[k] = minDist[j] + 1;
								}
								else if (minDist[k] < minDist[j] - 1) {
									minDist[j] = minDist[k] + 1;
								}
								// there is a connection change number to one
								// if there is another connection (to find friends of friends)
								// change the value to 2
							}
						}
					}
				}
				ans = 0;
				for (int d : minDist) {
					if (d == 2) {
						ans++;
					}
				}
				System.out.println(ans);
				break;
			case "s":
				x = scan.nextInt();
				y = scan.nextInt();

				minDist = new int[50];
				Arrays.fill(minDist, Integer.MAX_VALUE);
				minDist[x] = 0;
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(x);
				// or q.offer (Same thing)
				while (!q.isEmpty()) {
					int curr = q.poll();
					for (int i = 0; i < 50; i++) {
						if (con[i][curr] || con[curr][i]) {
							if (minDist[i] == Integer.MAX_VALUE) {
								minDist[i] = minDist[curr] + 1;
								q.add(i);
							}
						}
					}
				}
				if (minDist[y] == Integer.MAX_VALUE) {
					System.out.println("Not connected");
				}
				else {
					System.out.println(minDist[y]);
				}
				break;
			case "q":
				scan.close();
				System.exit(0);
			}
		}
	}
}
