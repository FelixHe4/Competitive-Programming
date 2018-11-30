package Unit2;
import java.io.*;
import java.util.*;
public class dmopc16c4p5 {

	public static class Pair implements Comparable<Pair> {
		int node, wt;

		public Pair(int node, int wt) {
			this.node = node;
			this.wt = wt;
		}

		@Override
		public int compareTo(Pair o) {
			return Integer.compare(o.wt, this.wt);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		ArrayList<Pair> graph[] = new ArrayList[N + 1];
		int max[] = new int[N + 1];
		int weight[] = new int[N + 1];
		int parent[] = new int[N + 1];
		boolean visited[] = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Pair>();

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
					wt = Integer.parseInt(st.nextToken());

			graph[a].add(new Pair(b, wt));
			graph[b].add(new Pair(a, wt));
		}

		PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
		queue.add(new Pair(1, Integer.MAX_VALUE));
		weight[1] = max[1] = max[0] = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			if (weight[p.node] != p.wt)
				continue;
			visited[p.node] = true;
			max[p.node] = Math.min(weight[p.node], max[parent[p.node]]);

			for (Pair e : graph[p.node]) {
				if (weight[e.node] < e.wt && !visited[e.node]) {
					weight[e.node] = e.wt;
					parent[e.node] = p.node;
					queue.add(new Pair(e.node, e.wt));
				}
			}
		}

		System.out.println(0);
		for (int i = 2; i <= N; i++)
			System.out.println(max[i]);

	}

}
