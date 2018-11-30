package Unit1;
import java.util.*;
public class ccc13s3 {
	static LinkedList game = new LinkedList();

	public static void main(String[] args) {
		// set possible game pair
		game.add("12");
		game.add("13");
		game.add("14");
		game.add("23");
		game.add("24");
		game.add("34");
		// using s to store win lose result
		char[] original = new char[6];
		Scanner scan = new Scanner(System.in);
		// input your favor team
		int t = scan.nextInt(); // input how many games they have already played.
		int g = scan.nextInt();
		for (int i = 0; i < g; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int sa = scan.nextInt();
			int sb = scan.nextInt();
			int index = game.indexOf("" + a + "" + b);
			if (sa > sb) {
				original[index] = 'W';
			}
			else if (sa < sb) {
				original[index] = 'L';
			}
			else {
				original[index] = 'T';
			}
		}
		LinkedList<String> possible = new LinkedList<String>();
		String choice = "WLT";
		int[] go = new int[6];
		for (int i = 0; i < original.length; i++) {
			if (original[i] == '\u0000') {
				go[i] = 3;
			}
			else {
				go[i] = 1;
			}
			// System.out.print(original[i]);
			// System.out.print(go[i]);
			// System.out.println();
		}
		for (int a = 0; a < go[0]; a++) {
			for (int b = 0; b < go[1]; b++) {
				for (int c = 0; c < go[2]; c++) {
					for (int d = 0; d < go[3]; d++) {
						for (int e = 0; e < go[4]; e++) {
							for (int f = 0; f < go[5]; f++) {
								String s = "";
								if (go[0] == 1)
									s = s + original[0];
								else
									s = s + choice.charAt(a);
								if (go[1] == 1)
									s = s + original[1];
								else
									s = s + choice.charAt(b);
								if (go[2] == 1)
									s = s + original[2];
								else
									s = s + choice.charAt(c);
								if (go[3] == 1)
									s = s + original[3];
								else
									s = s + choice.charAt(d);
								if (go[4] == 1)
									s = s + original[4];
								else
									s = s + choice.charAt(e);
								if (go[5] == 1)
									s = s + original[5];
								else
									s = s + choice.charAt(f);
								possible.add(s);
							}
						}
					}
				}
			}
		}
		int count = 0;
		for (String p1 : possible) {
			// will go through each string in possible
			char[] p = p1.toCharArray();
			for (int i = 0; i < p.length; i++) {
				// System.out.print(p[i]);
			}
			// System.out.println();
			if (winning(p, t - 1))
				count = count + 1;
		}
		System.out.println(count);
	}

	public static boolean winning(char[] s, int t) {
		int[] score = { 0, 0, 0, 0 };
		for (int i = 0; i < game.size(); i++) {
			int l = (int) String.valueOf(game.get(i)).charAt(0) - 49;
			// System.out.println("l" + l);
			int r = (int) String.valueOf(game.get(i)).charAt(1) - 49;
			// System.out.println("r:" + r);
			if (s[i] == 'W') {
				score[l] = score[l] + 3;
				score[r] = score[r] + 0;
			}
			else if (s[i] == 'L') {
				score[l] = score[l] + 0;
				score[r] = score[r] + 3;
			}
			else {
				score[l] = score[l] + 1;
				score[r] = score[r] + 1;
			}
		}
		boolean win = true;
		for (int i = 0; i < score.length; i++) {
			if (score[t] <= score[i] && i != t) {
				win = false;
			}
		}
		return win;
	}
}
