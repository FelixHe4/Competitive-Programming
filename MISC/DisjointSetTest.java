package Unit2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class DisjointSetTest {
	static int find(int n) {
		if (par[n] == n) {
			return n;
		} else {
			par[n] = find(par[n]);
			return par[n];
		}
	}

	static int[] par;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		par = new int[n];
		for (int i = 0; i < n; i++) {
			par[i] = i;
		}
		int x = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			if (x == n - 1) {
				break;
			}
			st = new StringTokenizer(in.readLine());
			int a = par[Integer.parseInt(st.nextToken()) - 1];
			int b = par[Integer.parseInt(st.nextToken()) - 1];
			int f1 = find(a);
			int f2 = find(b);
			if (f1 != f2) {
				par[f2] = f1;
				ans.add(i + 1);
				x++;
			}
		}
		if (x != n - 1) {
			System.out.println("Disconnected Graph");
		} else {
			for (int i : ans) {
				System.out.println(i);
			}
		}
	}
}