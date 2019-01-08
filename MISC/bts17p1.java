package Unit2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class bts17p1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		System.out.print(s.charAt(0));
		String end = "";
		for (int i = 1; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				end = end.substring(0, end.length() - 1);
				end += ". ";
				end += s.charAt(i);
			} else {
				end += s.charAt(i);
			}
		}
		System.out.println(end + ".");
	}

}
