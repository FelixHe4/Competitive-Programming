package Unit1;
import java.util.*;
public class ccc07s3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int distance;
		int[] friend = new int[10000];
		boolean[] visited = new boolean[10000];
		Arrays.fill(friend, 0);
		for (int i = 0; i < n; i++) {
			friend[scan.nextInt()] = scan.nextInt();
		}
		int x = scan.nextInt();
		int y = scan.nextInt();
		while (!(x == 0 && y == 0)) {
			Arrays.fill(visited, false);
			distance = 0;
			while (!visited[x] && x != y) {
				visited[x] = true;
				distance++;
				x = friend[x];
			}
			if (x == y) {
				System.out.println("Yes " + (distance - 1));
			}
			else {
				System.out.println("No");
			}
			x = scan.nextInt();
			y = scan.nextInt();
		}
	}

}
