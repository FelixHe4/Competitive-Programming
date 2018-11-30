package Unit2;
import java.io.*;
import java.util.*;

public class JonathanIsaDegen {

	static Node[] st;

	static class Node {
		int s, e, gcd, cnt, val;

		Node(int a, int b, int c, int d) {
			this.s = a;
			this.e = b;
			this.gcd = c;
			this.cnt = d;
		}
	}

	static int gcd(int p, int q) {
		if (q == 0)
			return p;
		return gcd(q, p % q);
	}

	static void pushUp(int p) {
		st[p].val = Math.min(st[p * 2 + 1].val, st[p * 2 + 2].val);
		st[p].gcd = gcd(st[p * 2 + 1].gcd, st[p * 2 + 2].gcd);
		st[p].cnt = 0;
		if (st[p].gcd == st[p * 2 + 1].gcd)
			st[p].cnt += st[p * 2 + 1].cnt;
		if (st[p].gcd == st[p * 2 + 2].gcd)
			st[p].cnt += st[p * 2 + 2].cnt;
	}

	static void createST(int s, int e, int p) {
		st[p] = new Node(s, e, 0, 0);
		if (s != e) {
			int mid = (s + e) / 2;
			createST(s, mid, p * 2 + 1);
			createST(mid + 1, e, p * 2 + 2);
			pushUp(p);
		}
	}

	static void update(int i, int p, int v) {
		if (st[p].s == st[p].e) {
			st[p].val = v;
			st[p].gcd = v;
			st[p].cnt = 1;
		}
		else {
			int mid = (st[p].s + st[p].e) / 2;
			if (i <= mid)
				update(i, p * 2 + 1, v);
			else
				update(i, p * 2 + 2, v);
			pushUp(p);
		}
	}

	static int minQuery(int s, int e, int p) {
		if ((st[p].s == s && st[p].e == e) || st[p].s == st[p].e)
			return st[p].val;
		else {
			int mid = (st[p].s + st[p].e) / 2;
			if (e <= mid)
				return minQuery(s, e, p * 2 + 1);
			else if (s > mid)
				return minQuery(s, e, p * 2 + 2);
			else
				return Math.min(minQuery(s, e, p * 2 + 1), minQuery(s, e, p * 2 + 2));
		}
	}

	static int gcdQuery(int s, int e, int p) {
		if ((st[p].s == s && st[p].e == e) || st[p].s == st[p].e)
			return st[p].gcd;
		else {
			int mid = (st[p].s + st[p].e) / 2;
			if (e <= mid)
				return gcdQuery(s, e, p * 2 + 1);
			else if (s > mid)
				return gcdQuery(s, e, p * 2 + 2);
			else
				return gcd(gcdQuery(s, e, p * 2 + 1), gcdQuery(s, e, p * 2 + 2));
		}
	}

	static int cntQuery(int s, int e, int p, int v) {
		if ((st[p].s == s && st[p].e == e) || st[p].s == st[p].e) {
			if (st[p].gcd == v)
				return st[p].cnt;
			else
				return 0;
		}
		else {
			int mid = (st[p].s + st[p].e) / 2;
			if (e <= mid)
				return cntQuery(s, e, p * 2 + 1, v);
			else if (s > mid)
				return cntQuery(s, e, p * 2 + 2, v);
			else
				return cntQuery(s, e, p * 2 + 1, v) + cntQuery(s, e, p * 2 + 2, v);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(str.nextToken());
		int q = Integer.parseInt(str.nextToken());
		st = new Node[2 * (int) Math.pow(2, (int) (Math.ceil(Math.log(n) / Math.log(2)))) - 1];
		createST(0, n - 1, 0);
		str = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			update(i, 0, Integer.parseInt(str.nextToken()));
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < q; i++) {
			str = new StringTokenizer(br.readLine());
			String cmd = str.nextToken();
			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());
			if (cmd.equals("C")) {
				update(x - 1, 0, y);
			}
			else if (cmd.equals("M")) {
				bw.write(minQuery(x - 1, y - 1, 0) + "\n");
			}
			else if (cmd.equals("G")) {
				bw.write(gcdQuery(x - 1, y - 1, 0) + "\n");
			}
			else {
				int a = gcdQuery(x - 1, y - 1, 0);
				bw.write(cntQuery(x - 1, y - 1, 0, a) + "\n");
			}
		}
		bw.flush();
	}

}
