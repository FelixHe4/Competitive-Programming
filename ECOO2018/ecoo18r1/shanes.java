package ecoo18r1;
import java.io.*;
import java.util.*;
public class shanes {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));// verify name
																					// BEFORE
																					// judging
		for (int i = 0; i < 10; i++) {
			int backlog = 0;
			String line1 = in.readLine();
			String[] TN = line1.split(" ");
			int t = Integer.parseInt(TN[0]);
			int n = Integer.parseInt(TN[1]);
			String[] days = new String[n];

			for (int x = 0; x < n; x++) {
				days[x] = in.readLine();
				if (days[x].equalsIgnoreCase("B")) {
					backlog = backlog + t;
				}
				if (backlog != 0) {
					backlog = backlog - 1;
				}
			}
			System.out.println(backlog);
		}
	}

}