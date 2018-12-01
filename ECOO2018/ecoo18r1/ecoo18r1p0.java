package ecoo18r1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class ecoo18r1p0 {

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\Users\\a\\eclipse-workspace\\ecoo2018\\src\\ecoo2018\\DATA02"
							+ ".txt"));
			for (int test = 0; test < 5; test++) {
				int[] a = new int[6];
				String[] s = br.readLine().split(" ");
				for (int i = 0; i < 20; i++) {
					if (s[i].equals("LADYBUG")) {
						a[0]++;
					}
					if (s[i].equals("SPIDER")) {
						a[2]++;
					}
					if (s[i].equals("COCKROACH")) {
						a[1]++;
					}
					if (s[i].equals("ANT")) {
						a[3]++;
					}
					if (s[i].equals("BEDBUG")) {
						a[5]++;
					}
					if (s[i].equals("CENTIPEDE")) {
						a[4]++;
					}
				}
				int max = 0;
				int index = 0;
				for (int i = 0; i < 6; i++) {
					if (a[i] > max) {
						max = a[i];
						index = i;
					}
				}
				System.out.println(index % 2 == 0 ? "FRIEND" : "PEST");
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found...");
		}
	}
}
