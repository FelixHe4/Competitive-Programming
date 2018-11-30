package Unit2;
import java.io.*;
public class tle16c6s1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] sa = new String[T];
		for (int i = 0; i < T; i++) {
			sa[i] = br.readLine();
		}
		int N = Integer.parseInt(br.readLine());
		String[] sa2 = new String[N];
		for (int i = 0; i < N; i++) {
			sa2[i] = br.readLine();
		}
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < N; j++) {
				if (sa[i].equals(sa2[j])) {
					System.out.println(j + 1);
				}
			}
		}
	}

}
