package Unit2;
import java.util.*;
import java.io.*;

public class aaaaaaaaaaaaa {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Integer N = Integer.parseInt(st.nextToken());
		Integer T = Integer.parseInt(st.nextToken());
		int[] pre = new int[T + 1];
		int[] now = new int[T + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			Integer P1 = Integer.parseInt(st.nextToken());
			Integer V1 = Integer.parseInt(st.nextToken());
			Integer P2 = Integer.parseInt(st.nextToken());
			Integer V2 = Integer.parseInt(st.nextToken());
			Integer P3 = Integer.parseInt(st.nextToken());
			Integer V3 = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= T; j++) {
				now[j] = pre[j];
				if (j >= P1) {
					now[j] = Math.max(now[j], V1 + pre[j - P1]);
				}
				if (j >= P2) {
					now[j] = Math.max(now[j], V2 + pre[j - P2]);
				}
				if (j >= P3) {
					now[j] = Math.max(now[j], V3 + pre[j - P3]);
				}
			}
			for (int j = 0; j <= T; j++)
				pre[j] = now[j];
		}
		System.out.println(now[T]);
	}
}
