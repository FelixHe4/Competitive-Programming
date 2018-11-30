package Unit2;
import java.io.*;
import java.util.*;
public class dmopc14c2p3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		long N = Long.parseLong(br.readLine());
		ArrayList<Long> a = new ArrayList<Long>();
		ArrayList<Long> b = new ArrayList<Long>();
		String s1 = br.readLine();
		st = new StringTokenizer(s1, " ");
		while (st.hasMoreTokens()) {
			a.add(Long.parseLong(st.nextToken()));
		}
		String s2 = br.readLine();
		st = new StringTokenizer(s2, " ");
		while (st.hasMoreTokens()) {
			b.add(Long.parseLong(st.nextToken()));
		}
		Collections.sort(a);
		Collections.sort(b, Collections.reverseOrder());
		long total = 0;
		for (int i = 0; i < a.size(); i++) {
			total += a.get(i) * b.get(i);
		}
		System.out.println(total);
	}

}
