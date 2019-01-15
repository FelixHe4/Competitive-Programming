package Unit1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ccc08s2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int N = Integer.parseInt(br.readLine());
			int total = 0;
			if (N == 0)
				break;
			// y = squareroot of N^2 - x^2
			// y = squareroot of 4 - 1
			for (int x = 1; x <= N; x++) {
				int y = (int) Math.sqrt(N * N - x * x);
				total += y;
			}
			total = 4 * total + 4 * N + 1;
			System.out.println(total);
		}

	}
}