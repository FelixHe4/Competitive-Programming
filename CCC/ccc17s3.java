package Unit1;
import java.io.*;
import java.util.*;
public class ccc17s3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), maxh = 0;
		int[] h = new int[2001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			h[x]++;
			maxh = Math.max(maxh, x);
		}
		int[] sum = new int[2 * maxh + 1];
		for (int i = 1; i <= maxh; i++) {
			sum[i + i] += h[i] / 2;
			for (int j = i + 1; j <= maxh; j++) {
				sum[i + j] += Math.min(h[i], h[j]);
			}
		}
		int max = 0;
		int count = 0;
		for (int i = 0; i <= 2 * maxh; i++) {
			if (sum[i] > max) {
				max = sum[i];
				count = 1;
			} else if (sum[i] == max) {
				count++;
			}
		}
		System.out.println(max + " " + count);
	}

}