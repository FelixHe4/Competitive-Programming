package Unit2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class tsoc15c1p5ants {

	static ArrayList<ArrayList<Integer>> possiblePaths;
	static ArrayList<Integer> graph[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int goodDist[] = new int[N + 1];
		int badDist[] = new int[N + 1];
		Arrays.fill(goodDist, Integer.MAX_VALUE);
		Arrays.fill(badDist, Integer.MAX_VALUE);
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Integer>();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int W = Integer.parseInt(br.readLine());
		for (int i = 1; i <= W; i++) {
			int w = Integer.parseInt(br.readLine());
			queue.add(w);
			badDist[w] = 0;
		}
		while (!queue.isEmpty()) {
			int currentNode = queue.pop();
			for (int e : graph[currentNode]) {
				if (badDist[e] > badDist[currentNode] + 1) {
					badDist[e] = badDist[currentNode] + 1;
					queue.add(e);
				}
			}
		}
		for (int i = 1; i <= N; i++)
			if (badDist[i] != Integer.MAX_VALUE)
				badDist[i] *= 4;

		queue.add(1);
		goodDist[1] = 0;
		while (!queue.isEmpty()) {
			int currentNode = queue.pop();
			for (int e : graph[currentNode]) {
				if (goodDist[e] > goodDist[currentNode] + 1 && goodDist[currentNode] + 1 < badDist[e]) {
					goodDist[e] = goodDist[currentNode] + 1;
					queue.add(e);
				}
			}
		}
		if (goodDist[N] == Integer.MAX_VALUE)
			System.out.println("sacrifice bobhob314");
		else System.out.println(goodDist[N]);
	}

	public static void BFS(int dist[], LinkedList<Integer> queue) {

		while (!queue.isEmpty()) {
			int currentNode = queue.pop();
			for (int e : graph[currentNode]) {
				if (dist[e] > dist[currentNode] + 1) {
					dist[e] = dist[currentNode] + 1;
					queue.add(e);
				}
			}
		}

	}
}