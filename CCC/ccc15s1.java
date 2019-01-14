package Unit1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class ccc15s1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringBuilder s = new StringBuilder();
		ArrayList<Integer> l = new ArrayList<Integer>();
		int e = 0;
		for (int i = 0; i < k; i++) {
			e = Integer.parseInt(br.readLine());
			l.add(e);
		}
		int i = 0;
		while (l.contains(0)) {
			if (l.get(i) == 0) {
				l.remove(i);
				l.remove(i - 1);
				i -= 2;
			}
			i++;
		}
		int total = 0;
		for (int j = 0; j < l.size(); j++) {
			total += l.get(j);
		}
		System.out.println(total);
	}
}
