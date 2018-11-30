package Unit1;
import java.util.*;
public class ccc10s4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, ArrayList<int[]>> map = new HashMap<String, ArrayList<int[]>>();
		int M = scan.nextInt();
		for (int i = 0; i < M; i++) {
			int e = scan.nextInt();
			int[] corner = new int[e], cost = new int[e];
			for (int j = 0; j < e; j++)
				corner[j] = scan.nextInt();
			for (int j = 0; j < e; j++)
				cost[j] = scan.nextInt();

			for (int j = 0; j < e; j++) {
				int a = corner[j], b = corner[(j + 1) % e], c = cost[j];
				String edge = Math.min(a, b) + " " + Math.max(a, b);
				if (!map.containsKey(edge))
					map.put(edge, new ArrayList<int[]>());
				map.get(edge).add(new int[] { i, c });
			}
		}

		int[][] graph = new int[M + 1][M + 1];
		for (int i = 0; i <= M; i++)
			for (int j = 0; j <= M; j++)
				graph[i][j] = Integer.MAX_VALUE;

		for (ArrayList<int[]> edges : map.values())
			if (edges.size() == 1) {
				int[] v = edges.get(0);
				graph[v[0]][M] = graph[M][v[0]] = Math.min(v[1], graph[v[0]][M]);
			}
			else {
				int[] v1 = edges.get(0), v2 = edges.get(1);
				graph[v1[0]][v2[0]] = graph[v2[0]][v1[0]] = Math.min(v1[1], graph[v1[0]][v2[0]]);
			}

		System.out.println(Math.min(prim(graph, M), prim(graph, M + 1)));
	}

	static long prim(int[][] graph, int M) {
		// for (int row=0; row<M; row++) {
		// for (int col=0; col<M; col++) {
		// System.out.print(graph[row][col]+"\t");
		// }
		// System.out.println();
		// }
		int[] lowestCost = new int[M];
		int[] adjV = new int[M];

		lowestCost[0] = 0;
		for (int i = 1; i < M; i++) {
			lowestCost[i] = graph[0][i];
		}

		// System.out.println("Max");
		for (int i = 1; i < M; i++) {
			int max = -1;
			for (int j = 1; j < M; j++) {
				if (lowestCost[j] != 0 && (max == -1 || lowestCost[j] < lowestCost[max])) {
					max = j;
				}
			}
			// System.out.println(max);
			lowestCost[max] = 0;
			for (int j = 1; j < M; j++) {
				if (lowestCost[j] > graph[max][j]) {
					lowestCost[j] = graph[max][j];
					adjV[j] = max;
				}
			}
		}

		// System.out.println("Output min path");
		long ans = 0;
		for (int i = 1; i < M; i++) {
			// System.out.println(graph[adjV[i]][i]+" "+adjV[i]+" "+i);
			ans = ans + graph[adjV[i]][i];
		}
		return ans;

		// 10
		// 3 4 1 5 4 4 16
		// 3 5 1 10 4 12 26
		// 3 2 3 5 10 3 3
		// 3 3 4 5 5 16 3
		// 3 9 6 11 10 11 25
		// 3 1 2 10 12 6 12
		// 3 2 5 10 3 26 6
		// 3 6 7 11 13 17 11
		// 3 7 8 11 17 2 17
		// 3 8 9 11 2 25 2
		//
		// boolean[] visited = new boolean[M];
		// int[] key = new int[M];
		// for(int i=1;i<M;i++)
		// key[i] = Integer.MAX_VALUE;
		//
		// for(int i=0;i<M;i++)
		// {
		// int min = -1;
		// for(int j=0;j<M;j++)
		// if(!visited[j] && (min == -1 || key[j] < key[min]))
		// min = j;
		//
		// if(key[min] == Integer.MAX_VALUE)
		// return Integer.MAX_VALUE;
		// ans += key[min];
		// visited[min] = true;
		//
		// for(int j=0;j<M;j++)
		// key[j] = Math.min(key[j],graph[min][j]);
		// }

	}
}