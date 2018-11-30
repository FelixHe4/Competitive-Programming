package Unit2;
import java.io.*;
import java.util.*;
public class ecoo13r1p2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			int grandTotal = 0;
			st = new StringTokenizer(s, " ");
			String one = st.nextToken();
			String total1 = "";
			int check1 = 0;
			ArrayList<Integer> t1 = new ArrayList<Integer>();
			String two = st.nextToken();
			String total2 = "";
			int check2 = 0;
			String three = st.nextToken();
			String total3 = "";
			int check3 = 0;
			String four = st.nextToken();
			String total4 = "";
			int check4 = 0;
			String five = st.nextToken();
			String total5 = "";
			int check5 = 0;
			for (int j = one.length() - 1; j >= 0; j -= 2) {
				total1 = String.valueOf(Integer.parseInt(String.valueOf(one.charAt(j))) * 2);
				if (total1.length() >= 2) {
					t1.add(Integer.parseInt(String.valueOf(total1.charAt(0))));
					t1.add(Integer.parseInt(String.valueOf(total1.charAt(1))));
				} else {
					t1.add(Integer.parseInt(String.valueOf(total1.charAt(0))));
				}
			}
			for (int j = 0; j < t1.size(); j++) {
				grandTotal += t1.get(j);
			}
			if (one.length() % 2 == 0) {
				for (int j = 0; j < one.length(); j += 2) {
					grandTotal += Integer.parseInt(String.valueOf(one.charAt(j)));
				}
			} else {
				for (int j = 1; j < one.length(); j += 2) {
					grandTotal += Integer.parseInt(String.valueOf(one.charAt(j)));
				}
			}
			while (grandTotal % 10 != 0) {
				check1++;
				grandTotal++;
			}
			grandTotal = 0;
			t1.clear();
			for (int j = two.length() - 1; j >= 0; j -= 2) {
				total2 = String.valueOf(Integer.parseInt(String.valueOf(two.charAt(j))) * 2);
				if (total2.length() >= 2) {
					t1.add(Integer.parseInt(String.valueOf(total2.charAt(0))));
					t1.add(Integer.parseInt(String.valueOf(total2.charAt(1))));
				} else {
					t1.add(Integer.parseInt(String.valueOf(total2.charAt(0))));
				}
			}
			for (int j = 0; j < t1.size(); j++) {
				grandTotal += t1.get(j);
			}
			if (two.length() % 2 == 0) {
				for (int j = 0; j < two.length(); j += 2) {
					grandTotal += Integer.parseInt(String.valueOf(two.charAt(j)));
				}
			} else {
				for (int j = 1; j < two.length(); j += 2) {
					grandTotal += Integer.parseInt(String.valueOf(two.charAt(j)));
				}
			}
			while (grandTotal % 10 != 0) {
				check2++;
				grandTotal++;
			}
			grandTotal = 0;
			t1.clear();
			for (int j = three.length() - 1; j >= 0; j -= 2) {
				total3 = String.valueOf(Integer.parseInt(String.valueOf(three.charAt(j))) * 2);
				if (total3.length() >= 2) {
					t1.add(Integer.parseInt(String.valueOf(total3.charAt(0))));
					t1.add(Integer.parseInt(String.valueOf(total3.charAt(1))));
				} else {
					t1.add(Integer.parseInt(String.valueOf(total3.charAt(0))));
				}
			}
			for (int j = 0; j < t1.size(); j++) {
				grandTotal += t1.get(j);
			}
			if (three.length() % 2 == 0) {
				for (int j = 0; j < three.length(); j += 2) {
					grandTotal += Integer.parseInt(String.valueOf(three.charAt(j)));
				}
			} else {
				for (int j = 1; j < three.length(); j += 2) {
					grandTotal += Integer.parseInt(String.valueOf(three.charAt(j)));
				}
			}
			while (grandTotal % 10 != 0) {
				check3++;
				grandTotal++;
			}
			grandTotal = 0;
			t1.clear();
			for (int j = four.length() - 1; j >= 0; j -= 2) {
				total4 = String.valueOf(Integer.parseInt(String.valueOf(four.charAt(j))) * 2);
				if (total4.length() >= 2) {
					t1.add(Integer.parseInt(String.valueOf(total4.charAt(0))));
					t1.add(Integer.parseInt(String.valueOf(total4.charAt(1))));
				} else {
					t1.add(Integer.parseInt(String.valueOf(total4.charAt(0))));
				}
			}
			for (int j = 0; j < t1.size(); j++) {
				grandTotal += t1.get(j);
			}
			if (four.length() % 2 == 0) {
				for (int j = 0; j < four.length(); j += 2) {
					grandTotal += Integer.parseInt(String.valueOf(four.charAt(j)));
				}
			} else {
				for (int j = 1; j < four.length(); j += 2) {
					grandTotal += Integer.parseInt(String.valueOf(four.charAt(j)));
				}
			}
			while (grandTotal % 10 != 0) {
				check4++;
				grandTotal++;
			}
			grandTotal = 0;
			t1.clear();
			for (int j = five.length() - 1; j >= 0; j -= 2) {
				total5 = String.valueOf(Integer.parseInt(String.valueOf(five.charAt(j))) * 2);
				if (total5.length() >= 2) {
					t1.add(Integer.parseInt(String.valueOf(total5.charAt(0))));
					t1.add(Integer.parseInt(String.valueOf(total5.charAt(1))));
				} else {
					t1.add(Integer.parseInt(String.valueOf(total5.charAt(0))));
				}
			}
			for (int j = 0; j < t1.size(); j++) {
				grandTotal += t1.get(j);
			}
			if (five.length() % 2 == 0) {
				for (int j = 0; j < five.length(); j += 2) {
					grandTotal += Integer.parseInt(String.valueOf(five.charAt(j)));
				}
			} else {
				for (int j = 1; j < five.length(); j += 2) {
					grandTotal += Integer.parseInt(String.valueOf(five.charAt(j)));
				}
			}
			while (grandTotal % 10 != 0) {
				check5++;
				grandTotal++;
			}
			grandTotal = 0;
			t1.clear();
			System.out.println(check1 + "" + check2 + "" + check3 + "" + check4 + "" + check5);

		}
	}
}
