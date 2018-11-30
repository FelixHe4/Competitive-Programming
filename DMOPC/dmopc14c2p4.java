package Unit2;
import java.io.*;
import java.util.Arrays;
public class dmopc14c2p4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long total = 0;
	static long Q1 = 0;
	static long Q2 = 0;
	static String s = "";
	static long[] a;
	static long[] b;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		a = new long[N];
		b = new long[N];
		for (int i = 0; i < N; i++) {
			a[i] = Long.parseLong(br.readLine());
		}
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				b[i] = a[i];
			}
			else {
				b[i] = a[i] + b[i - 1];
			}
		}
		System.out.println(Arrays.toString(b));
		long Q = Long.parseLong(br.readLine());
		for (int i = 0; i < Q; i++) {
			total = 0;
			s = br.readLine();
			Q1 = Long.parseLong(s.split(" ")[0]);
			Q2 = Long.parseLong(s.split(" ")[1]);
			if (Q1 == 0) {
				total = b[(int) Q2];
			}
			else {
				total = b[(int) Q2] - b[(int) Q1 - 1];
			}
			System.out.println(total);
			total = 0;
		}

	}

}