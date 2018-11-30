package Unit2;
import java.util.*;
public class testerer {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// initial variables
		int n = scan.nextInt();
		int m = scan.nextInt();
		int t = scan.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[n + 1];

		// create empty arraylist arrays
		for (int i = 0; i < n + 1; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		// add values to arraylists (a&b for bidirectional)(a for only unidirectional)
		for (int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			arr[a].add(b);
			// arr[b].add(a);
		}

		// debug
		// for(int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]);
		// }

		// amount of distances to be listed
		int u = scan.nextInt();

		for (int r = 0; r < u; r++) {
			int o = scan.nextInt();
			int p = scan.nextInt();
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(o);
			// visited
			boolean vis[] = new boolean[n + 1];
			// distance
			int dis[] = new int[n + 1];
			while (!(q.isEmpty())) {
				int cur = q.poll();
				for (int i = 0; i < arr[cur].size(); i++) {
					if (!(vis[arr[cur].get(i)])) {
						q.add(arr[cur].get(i));
						vis[arr[cur].get(i)] = true;
						dis[arr[cur].get(i)] = dis[cur] + 1;
					}
				}
			}
			if (dis[p] == 0) {
				System.out.println("Not enoguh hallways!");
			} else {
				System.out.println(dis[p] * t);
			}
		}

		// for(int i = 0; i < arr.length; i++) {
		// System.out.print(vis[i]);
		// System.out.println(dis[i]);
		// }
	}
}
