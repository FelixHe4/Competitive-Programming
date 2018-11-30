package Unit2;
import java.util.*;
public class PursuitOfKnowledge {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// initial variables
		int n = scan.nextInt();
		int m = scan.nextInt();
		int t = scan.nextInt();
		ArrayList<Integer>[] arr = new ArrayList[n + 1];
		// visited
		boolean vis[] = new boolean[n + 1];
		// distance
		int dis[] = new int[n + 1];

		// create empty arraylist arrays
		for (int i = 0; i < n + 1; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		// add values to arraylists
		for (int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			arr[a].add(b);
		}

		// debug
		// for(int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]);
		// }

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
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

		for (int i = 0; i < arr.length; i++) {
			// System.out.print(vis[i]);
			System.out.print(dis[i] + " ");
		}
	}
}