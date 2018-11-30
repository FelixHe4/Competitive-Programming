package Unit2;
import java.io.*;
import java.util.*;
import java.text.*;
public class bts17p2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat(".####");
		int testCases = Integer.parseInt(br.readLine());
		LinkedList<Double> l = new LinkedList<Double>();
		for (int i = 0; i < testCases; i++) {
			String s = br.readLine();
			double a = Integer.parseInt(s.split(" ")[0]);
			double b = Integer.parseInt(s.split(" ")[1]);
			double c = b - a;
			l.add((double) c / b);
		}
		double total = 1;
		for (int i = 0; i < l.size(); i++) {
			total *= l.get(i);
		}
		System.out.println(total);
	}

}
