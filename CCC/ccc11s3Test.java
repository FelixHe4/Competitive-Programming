package Unit1;
import java.io.*;
public class ccc11s3Test {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			int mag = Integer.parseInt(s.split(" ")[0]);
			int xCoord = Integer.parseInt(s.split(" ")[1]);
			int yCoord = Integer.parseInt(s.split(" ")[2]);
			if (yCoord < Crystal(mag, xCoord)) {
				System.out.println("crystal");
			}
			else {
				System.out.println("empty");
			}
		}
	}

	public static int Crystal(int mag, int xCoord) {
		if (mag >= 1) {
			int power = (int) Math.pow(5, mag - 1);
			int place = (int) Math.floor(xCoord / power);
			if (place == 0 || place == 4) {
				return 0;
			}
			else if (place == 1 || place == 3) {
				return 1 * power + Crystal(mag - 1, xCoord % power);
			}
			else if (place == 2) {
				return 2 * power + Crystal(mag - 1, xCoord % power);
			}
		}
		return 0;
	}

}
