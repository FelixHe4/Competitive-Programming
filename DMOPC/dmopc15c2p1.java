package Unit2;
import java.io.*;
public class dmopc15c2p1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(N);
		int K = Integer.parseInt(br.readLine());
		System.out.println(K);
		int total = N;
		int perS = N / K;
		// 5
		// per sword
		int extraS = N % K;
		total += perS;
		extraS += perS;
		int perS2 = extraS / K;
		total += perS2;
		System.out.println(total);
	}

}
