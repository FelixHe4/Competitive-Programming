package Unit1;
import java.util.*;
public class ccc17s4 {
	int V;
	int E;
	Edge[] edge;
	Edge[] mst;
	int[] parent;

	public class Edge implements Comparable<Edge> {
		int bv;
		int ev;
		int cost;
		int active;

		@Override
		public int compareTo(Edge o) {
			if (this.cost < o.cost) {
				return -1;
			} else if (this.cost > o.cost) {
				return 1;
			} else {
				if (this.active < o.active) {
					return -1;
				} else if (this.active > o.active) {
					return 1;
				} else {
					return 0;
				}
			}
		}

	}

	public ccc17s4(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			edge[i] = new Edge();
		}

		parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = -1;
		}

		mst = new Edge[V - 1];
		for (int i = 0; i < V - 1; i++) {
			mst[i] = new Edge();
		}
	}

	public int find(int v) {
		if (parent[v] == -1) {
			return v;
		} else {
			return parent[v] = find(parent[v]);
		}
	}

	public void union(int pb, int pe) {
		parent[pb] = pe;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // city vertices
		int M = sc.nextInt(); // pipe edges
		int D = sc.nextInt();
		ccc17s4 graph = new ccc17s4(N, M);
		for (int i = 0; i < M; i++) {
			graph.edge[i].bv = sc.nextInt() - 1;
			graph.edge[i].ev = sc.nextInt() - 1;
			graph.edge[i].cost = sc.nextInt();
			if (i < N - 1) {
				graph.edge[i].active = 0;
			} else {
				graph.edge[i].active = 1;
			}
		}
		Arrays.sort(graph.edge);
		int j = 0;
		int day = 0;
		int max = 0;
		int maxn = 0;
		for (int i = 0; i < M; i++) {
			int bv = graph.edge[i].bv;
			int ev = graph.edge[i].ev;
			int pb = graph.find(bv);
			int pe = graph.find(ev);
			if (pb != pe) {
				graph.union(pb, pe);
				graph.mst[j].bv = bv;
				graph.mst[j].ev = ev;
				graph.mst[j].cost = graph.edge[i].cost;
				graph.mst[j].active = graph.edge[i].active;
				day = day + graph.mst[j].active;
				max = graph.mst[j].cost;
				maxn = graph.mst[j].active;
				j++;
			}
		}
		if (maxn == 1) {
			for (int i = 0; i < N; i++) {
				graph.parent[i] = -1;
			}
			for (int i = 0; i < M; i++) {
				int cost = graph.edge[i].cost;
				int bv = graph.edge[i].bv;
				int ev = graph.edge[i].ev;
				int pb = graph.find(bv);
				int pe = graph.find(ev);
				if (pb != pe) {
					if (cost < max || cost == max && graph.edge[i].active == 0) {
						graph.union(pb, pe);
					} else if (graph.edge[i].active == 0 && cost - D <= 0) {
						day--;
						break;
					}

				}
			}
		}
		System.out.println(day);

	}
}