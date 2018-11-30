package Unit1;
import java.util.*;
public class ccc09j4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] words = "WELCOME TO CCC GOOD LUCK TODAY .".split(" ");
		int w = in.nextInt();
		ArrayList<String> a = new ArrayList<>();
		ArrayList<ArrayList<String>> lines = new ArrayList<>();
		int lineNum = 0;
		int lineSize = 7;
		boolean isOneWord = true;
		String spaces = "";
		a.add(words[0]);
		for (int i = 1; i < 7; i++) {
			if (lineSize + 1 + words[i].length() > w || i == 6) {
				if (isOneWord) {
					for (int j = 0; j < w - lineSize; j++) {
						spaces += ".";
					}
					a.add(spaces);
					spaces = "";
					lines.add((ArrayList<String>) a.clone());
				}
				else {
					for (int j = 0; true; j += 2) {
						if (lineSize == w) {
							break;
						}
						a.add(j, a.get(j) + ".");
						a.remove(j + 1);
						lineSize++;

						if (j == a.size() - 3) {
							j = -2;
						}
					}
					lines.add((ArrayList<String>) a.clone());
				}
				isOneWord = true;
				lineSize = words[i].length();
				lineNum++;
				a.clear();
				a.add(words[i]);
			}
			else {
				a.add(".");
				a.add(words[i]);
				lineSize += 1 + words[i].length();
				isOneWord = false;
			}
		}
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < lines.get(i).size(); j++) {
				System.out.print(lines.get(i).get(j));
			}
			System.out.println("");
		}
	}
}