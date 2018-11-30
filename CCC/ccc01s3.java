package Unit1;
import java.util.*;
public class ccc01s3 {

	public static int[][] map;
	public static ArrayList<String> bridge;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		map = new int[26][26];
		bridge = new ArrayList<>();
		while (true) {
			String input = scan.nextLine();
			if (input.equals("**")) {
				break;
			}
			map[(int) (input.charAt(0)) - 65][(int) (input.charAt(1)) - 65] = 1;
			map[(int) (input.charAt(1)) - 65][(int) (input.charAt(0)) - 65] = 1;
		}
		for (int i = 0; i < 26; i++) {
			for (int j = i + 1; j < 26; j++) {
				if (map[i][j] == 1) {
					map[i][j] = 0;
					map[j][i] = 0;
					visited = new boolean[26];
					for (int k = 0; k < 26; k++) {
						visited[k] = false;
					}
					dfs(0);
					if (!visited[1]) {
						String holder = "";
						holder += (char) (i + 65);
						holder += (char) (j + 65);
						bridge.add(holder);
					}
					map[i][j] = 1;
					map[j][i] = 1;
				}
			}
		}
		if (bridge.size() == 0) {
			System.out.println("There are 0 disconnecting roads.");
		}
		else {
			for (String s : bridge) {
				System.out.println(s);
			}
			System.out.println("There are " + bridge.size() + " disconnecting roads.");
		}
	}

	public static void bfs(int cur) {
		LinkedList<Integer> rowQ = new LinkedList<Integer>();
		visited[cur] = true;
		rowQ.add(cur);
		while (!rowQ.isEmpty()) {
			int r = rowQ.poll();
			for (int c = 0; c < 26; c++) {
				if (map[r][c] == 1 && visited[c] == false) {
					visited[c] = true;
					rowQ.add(c);
				}
			}
		}
	}

	public static void dfs(int cur) {
		// cur is 0 at the beginning
		visited[cur] = true; // go to map or 2d array to check the nieghbours.
		for (int i = 0; i < 26; i++) {
			if (map[cur][i] > 0 && !visited[i]) {
				dfs(i);
			}
		}
	}
}
