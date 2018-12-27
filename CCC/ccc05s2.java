package Unit1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ccc05s2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int counter = 0;
		int borderC = 0;
		int borderR = 0;
		int locationC = 0;
		int locationR = 0;
		while (true) {
			String s = br.readLine();
			int s1 = Integer.parseInt(s.split(" ")[0]);
			int s2 = Integer.parseInt(s.split(" ")[1]);
			if (s1 == 0 && s2 == 0) {
				break;
			}
			if (counter == 0) {
				borderC = s1;
				borderR = s2;
				counter++;
				s1 = 0;
				s2 = 0;
			} else {
				locationC += s1;
				if (locationC >= borderC) {
					locationC = borderC;
				}
				if (locationC <= 0) {
					locationC = 0;
				}
				locationR += s2;
				if (locationR >= borderR) {
					locationR = borderR;
				}
				if (locationR <= 0) {
					locationR = 0;
				}
				System.out.println(locationC + " " + locationR);
			}
		}

	}

}