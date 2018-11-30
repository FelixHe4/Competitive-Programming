package Unit2;
import java.io.*;
public class year2018p1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int hours = Integer.parseInt(s.split(" ")[0]);
		int minutes = Integer.parseInt(s.split(" ")[1]);
		int seconds = Integer.parseInt(s.split(" ")[2]);
		if (seconds >= 60) {
			minutes += seconds / 60;
			seconds %= 60;
		}
		if (minutes >= 60) {
			hours += minutes / 60;
			minutes %= 60;
		}
		if (hours >= 12) {
			hours %= 12;
		}
		if (seconds == 0 && minutes == 0) {
			System.out.println((12 - hours) + ":00:00");
		}
		else if (seconds == 0) {
			System.out.println((12 - hours) + ":" + (59 - minutes) + ":00");
		}
		else if (minutes == 0) {
			if (60 - seconds < 10) {
				System.out.println((12 - hours) + ":00" + ":0" + (60 - seconds));
			}
			else {
				System.out.println((12 - hours) + ":00" + ":" + (60 - seconds));
			}
		}
		else if (hours == 0) {
			if (60 - seconds < 10) {
				System.out.println(11 + ":" + (59 - minutes) + ":0" + (60 - seconds));
			}
			else {
				System.out.println(11 + ":" + (59 - minutes) + ":" + (60 - seconds));
			}
		}
		else {
			if (60 - seconds < 10) {
				System.out.println((12 - hours) + ":" + (59 - minutes) + ":0" + (60 - seconds));
			}
			else {
				System.out.println((12 - hours) + ":" + (59 - minutes) + ":" + (60 - seconds));
			}
		}
	}

}
