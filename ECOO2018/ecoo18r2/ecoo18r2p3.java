package ecoo18r2;
import java.io.*;
import java.util.*;
public class ecoo18r2p3 {

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\Users\\Dingding\\eclipse-workspace\\ecoo2018\\src\\ecoo18r2\\DATA31.txt"));
			String in[];
			boolean[] primes = new boolean[1_000_000];
			for (int i = 0; i < primes.length; i++)
				primes[i] = true;
			for (int i = 2; 2 * i < 1_000_000; i++) {
				primes[2 * i] = false;
			}
			for (int i = 3; i < 1000; i += 2) {
				if (!primes[i])
					continue;
				if (isPrime(i)) {
					for (int j = 2; j * i < 1_000_000; j++) {
						primes[j * i] = false;
					}
				}
			}
			// System.out.println(isPrime(15));
			while (br.ready()) {// change to # test cases\\
				ArrayList<Pair> factors = new ArrayList<Pair>();
				in = br.readLine().split(" ");
				int K = Integer.parseInt(in[0]);
				int M = Integer.parseInt(in[1]);

				for (int i = 2; i < primes.length; i++) {
					if (primes[i]) {

						if (K % i == 0) {
							// System.out.println(i);
							int r = 1;
							while (K % Math.pow(i, r) == 0) {
								r++;
							}
							factors.add(new Pair(i, (r - 1) * M));

						}
					}
				}
				// for (int i = 0; i < factors.size(); i++) {
				// System.out.println(factors.get(i).value + " " + factors.get(i).power);
				// }
				int ans[] = new int[factors.size()];
				for (int i = 0; i < factors.size(); i++) {
					int f = factors.get(i).value;
					int mult = 0;

					while (factors.get(i).power > 0) {
						int r = 1;
						mult++;
						while (mult * f % Math.pow(f, r) == 0)
							r++;
						// System.out.println(r);
						factors.get(i).power -= (r - 1);
					}
					ans[i] = mult * f;
				}

				Arrays.sort(ans);
				System.out.println(ans[ans.length - 1]);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found...");
		}
	}

	static boolean isPrime(int n) {
		if (n % 2 == 0)
			return false;
		int max = (int) Math.sqrt(n);
		for (int i = 3; i <= max; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}

class Pair {
	int value, power;

	Pair(int value, int power) {
		this.value = value;
		this.power = power;
	}
}
