package Unit1;
import java.io.*;
import java.util.*;
public class ccc12s3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == max) {
				a.add(j);
			}
		}

		System.out.println(a);
		int max2 = 0;
		int max3 = 0;
		// find the second maximum
		int topNum = 0;
		if (a.size() == 1) {
			topNum = a.get(0);
			a.remove(0);
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > max2) {
					if (arr[i] != max) {
						max2 = arr[i];
					}
				}
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == max2) {
					a.add(i);
				}
			}
			Collections.sort(a);
			System.out.println(a);
			if (topNum > a.get(0)) {
				System.out.println(topNum - a.get(0));
			}
			else {
				System.out.println(a.get(a.size() - 1) - topNum);
			}
			System.exit(0);
		}
		else {
			System.out.println(a.get(a.size() - 1) - a.get(0));
			System.exit(0);
		}

	}

}
