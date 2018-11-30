package Unit1;
import java.io.*;
public class ccc11s3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			int mag = Integer.parseInt(s.split(" ")[0]);
			int xCoord = Integer.parseInt(s.split(" ")[1]);
			int yCoord = Integer.parseInt(s.split(" ")[2]);
			int OneFifth = (int) (Math.pow(5, mag)) / 5;
			int LoneFifth = (int) (Math.pow(5, mag - 1) / 5);
			System.out.println(OneFifth);
			if (xCoord < OneFifth || xCoord > (OneFifth * 4 - 1) || yCoord >= ((Math.pow(5, mag) - 1) / 2)) {
				System.out.println("empty");
			}
			if (yCoord <= (OneFifth - 1) && (!(xCoord < OneFifth) || !(xCoord > (OneFifth * 4 - 1)))) {
				System.out.println("crystal");
			}
			// check for the cones
			if (xCoord >= OneFifth && xCoord <= (OneFifth * 4 - 1) && yCoord >= OneFifth && yCoord <= (Math.pow(5, mag) - 1) / 2) {
				// if (xCoord >= OneFifth + LoneFifth || (xCoord >= OneFifth * 4 && xCoord <=
				// OneFifth - 1) || xCoord == OneFifth * 3
				// || xCoord >= OneFifth * 4 - 1) {
				// RECURSION TIME
				// }
				triangle(mag, xCoord, yCoord);
			}
		}
	}

	public static boolean triangle(int mag, int x, int y) {
		// test if its in the boundaries
		int OneFifth = (int) (Math.pow(5, mag) / 5);
		boolean flag = true;
		if (mag == 0) {
			return true;
		}
		else {
			int LoneFifth = (int) (Math.pow(5, mag - 1) / 5);
			if (x > OneFifth && x < LoneFifth + OneFifth && y >= OneFifth && y <= LoneFifth + OneFifth) {
				triangle(mag - 1, x, y);
			}
			else if (y > OneFifth * 2 && y < LoneFifth + OneFifth * 2
					&& (x > (OneFifth * 2 + LoneFifth - 1) && x < (OneFifth * 3 - LoneFifth))) {
				triangle(mag - 1, x, y);
			}
			else if (x > (OneFifth * 3 + LoneFifth - 1) && x < (OneFifth * 4 - LoneFifth) && y >= OneFifth && y <= LoneFifth + OneFifth) {
				triangle(mag - 1, x, y);
			}
			else {
				return false;
			}
		}
		return false;
	}
}