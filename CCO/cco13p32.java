package Unit2;
import java.util.*;
import java.io.*;
public class cco13p32 {
	static int N;
	static ArrayList<Integer>[] adj;
	static long d, cnt, d1[], cnt1[];
	static boolean vis[];

	static void dfs(int u) {
		// System.out.println(u);
		vis[u] = true;
		d1[u] = 0;
		cnt1[u] = 1;
		for (int v : adj[u]) {
			// System.out.println(d1[v}+" "+cnt1[v]);
			if (vis[v])
				continue;
			dfs(v);
			if (d1[u] + d1[v] + 1 > d) {
				d = d1[u] + d1[v] + 1;
				cnt = cnt1[u] * cnt1[v];
			}
			else if (d1[u] + d1[v] + 1 == d) {
				cnt += cnt1[u] * cnt1[v];
			}
			if (d1[u] < d1[v] + 1) {
				d1[u] = d1[v] + 1;
				cnt1[u] = cnt1[v];
			}
			else if (d1[u] == d1[v] + 1) {
				cnt1[u] += cnt1[v];
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO code application logic here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1];
		vis = new boolean[N + 1];
		d1 = new long[N + 1];
		cnt1 = new long[N + 1];
		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<Integer>();
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		dfs(1);
		System.out.println(d + 1 + " " + cnt);
	}

}
