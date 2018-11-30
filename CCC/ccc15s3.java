package Unit1;
import java.io.*;
public class ccc15s3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ports = Integer.parseInt(br.readLine());
		int numPlanes = Integer.parseInt(br.readLine());
		int[] planes = new int[ports + 1];
		int total = 0;
		int i = 0;
		boolean keepGoing = true;
		while (i < numPlanes && keepGoing) {
			int cPlane = Integer.parseInt(br.readLine());
			while (cPlane > 0 && planes[cPlane] > 0) {
				int t = planes[cPlane];
				planes[cPlane] = planes[cPlane] + 1;
				cPlane = cPlane - t;
			}
			if (cPlane <= 0) {
				keepGoing = false;
			}
			else {
				planes[cPlane] = 1;
				total = total + 1;
			}
			i = i + 1;
		}
		System.out.println(total);
	}
}