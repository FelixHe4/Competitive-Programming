package Unit2;
import java.io.*;
import java.util.*;
public class dmopc15c5p1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int X = Integer.parseInt(br.readLine());
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i = 1; i < X + 1; i += A) {
			a.add(i);
		}
		for (int i = 1; i < X + 1; i += B) {
			b.add(i);
		}
		int counter = 0;
		if (a.size() >= b.size()) {
			for (int i = 0; i < a.size(); i++) {
				for (int j = 0; j < b.size(); j++) {
					if (a.get(i) == b.get(j)) {
						counter++;
					}
				}
			}
		}
		else if (a.size() < b.size()) {
			for (int i = 0; i < b.size(); i++) {
				for (int j = 0; j < a.size(); j++) {
					if (a.get(i) == b.get(j)) {
						counter++;
					}
				}
			}
		}
		System.out.println(counter);
	}

}
