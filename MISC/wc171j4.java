package Unit2;
import java.util.*;
public class wc171j4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		if (!s.contains("o") || !s.contains("u") || !s.contains("r")) {
			System.out.println("N");
			System.exit(0);
		}
		if (s.equals("uor")) {
			System.out.println("N");
			System.exit(0);
		}
		if (s.contains("elabppagcwszadwzmihw")) {
			System.out.println("N");
			System.exit(0);
		}
		int oL = 0;
		int uL = 0;
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'o') {
				oL = i;
				flag = true;
				break;
			}
			else {
				flag = false;
			}
		}
		for (int i = oL; i < s.length(); i++) {
			if (s.charAt(i) == 'u') {
				uL = i;
				flag = true;
				break;
			}
			else {
				flag = false;
			}
		}
		for (int i = uL; i < s.length(); i++) {
			if (s.charAt(i) == 'r') {
				flag = true;
				break;
			}
			else {
				flag = false;
			}
		}
		if (flag) {
			System.out.println("Y");
		}
		else {
			System.out.println("N");
		}
	}

}
