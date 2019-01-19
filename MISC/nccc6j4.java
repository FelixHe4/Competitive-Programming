package Unit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class nccc6j4 {
	static class Pair implements Comparable<Pair> {
		String name;
		int value;

		public Pair(String name, int value) {
			this.name = name;
			this.value = value;
		}

		public int compareTo(Pair o) {
			if (o.value == value) {
				if (!name.equalsIgnoreCase("Ritzy Bitz")) {
					return o.name.length() - name.length();
				} else {
					return 1;
				}
			}
			return o.value - value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] arr = new int[4];
		while (t-- > 0) {
			String s = br.readLine();
			if (s.equals("Sashimi")) {
				arr[0]++;
			}
			if (s.equals("Deluxe Tuna Bitz")) {
				arr[1]++;
			}
			if (s.equals("Bonito Bitz")) {
				arr[2]++;
			}
			if (s.equals("Ritzy Bitz")) {
				arr[3]++;
			}
		}
		Pair[] Pair = new Pair[4];
		Pair[0] = new Pair("Sashimi", arr[0]);
		Pair[1] = new Pair("Deluxe Tuna Bitz", arr[1]);
		Pair[2] = new Pair("Bonito Bitz", arr[2]);
		Pair[3] = new Pair("Ritzy Bitz", arr[3]);
		Arrays.sort(Pair);
		for (int i = 0; i < Pair.length; i++) {
			if (Pair[i].value != 0) {
				System.out.println(Pair[i].name + " " + Pair[i].value);
			}
		}
	}
}
