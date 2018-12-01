package ecoo18r2;
import java.io.*;
import java.util.*;
public class ecoo18r2p0 {

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\Users\\Dingding\\eclipse-workspace\\ecoo2018\\src\\ecoo18r2\\DATA.txt"));
			while (br.ready()) {// change to # test cases\
				System.out.println(br.readLine());
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found...");
		}
	}
}
