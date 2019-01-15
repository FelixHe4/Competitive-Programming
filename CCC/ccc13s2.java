package Unit1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class ccc13s2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalW = Integer.parseInt(br.readLine());
		int currentWeight = 0;
		int cars = Integer.parseInt(br.readLine());
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < cars; i++) {
			a.add(Integer.parseInt(br.readLine()));
		}
		int rNumber = 0;
		int counter = 0;
		for (int i = 0; i < cars; i++) {
			if (i >= 4) {
				rNumber = a.get(i - 4);
			}
			currentWeight += a.get(i);
			if (counter >= 4) {
				currentWeight -= rNumber;
			}
			if (currentWeight > totalW) {
				System.out.println(i);
				break;
			} else if (i == cars - 1) {
				System.out.println(i + 1);
				break;
			}
			counter++;
		}
	}

}