package Unit2;
import java.util.*;
import java.io.*;
public class asdasd {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long count = 0;

		Deque<Integer> MaxQueue = new LinkedList<Integer>();
		Deque<Integer> MinQueue = new LinkedList<Integer>();

		st = new StringTokenizer(br.readLine());

		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// for (int l = 0, r = 0; r < N; r++) {
		// while (!MaxQueue.isEmpty() && MaxQueue.peek() < arr[r]) {
		// MaxQueue.poll();
		// }
		// MaxQueue.add(arr[r]);
		// while (!MinQueue.isEmpty() && MinQueue.peek() > arr[r]) {
		// MinQueue.poll();
		// }
		// MinQueue.add(arr[r]);
		// while (MaxQueue.peek() - MinQueue.peek() > K) {
		//
		// l++;
		// if (MaxQueue.peek() == arr[l]) {
		// MaxQueue.poll();
		// }
		// if (MinQueue.peek() == arr[l]) {
		// MaxQueue.poll();
		// }
		// }
		//
		// count += r - l + 1;
		//
		// }

		int[] MaxQ = new int[N];
		int[] MinQ = new int[N];

		int Maxf = 0;
		int Maxr = -1;
		int Minf = 0;
		int Minr = -1;
		for (int l = 0, r = 0; r < N; r++) {
			while (Maxf <= Maxr && MaxQ[Maxr] < arr[r]) {
				Maxr--;
			}
			while (Minf <= Minr && MinQ[Minr] > arr[r]) {
				Minr--;
			}

			MaxQ[++Maxr] = arr[r];
			MinQ[++Minr] = arr[r];
			while (MaxQ[Maxf] - MinQ[Minf] > K) {
				if (arr[l] == MaxQ[Maxf]) {
					Maxf++;
				}
				if (arr[l] == MinQ[Minf]) {
					Minf++;
				}
				l++;
			}
			count += r - l + 1;
		}

		// for(int i = 0; i<N; i++) {
		// int min = arr[i];
		// int max = arr[i];
		// for(int j = i; j<N; j++) {
		// min = Math.min(arr[j], min);
		// max = Math.max(arr[j], max);
		// if(max-min <= K) {
		// count++;
		// }
		// else {
		// break;
		// }
		// }
		//
		// }

		System.out.println(count);
	}

}