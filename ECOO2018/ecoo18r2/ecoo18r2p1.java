package ecoo18r2;
import java.io.*;
import java.util.*;
public class ecoo18r2p1 {

	static List<int[]> dp;

	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\Users\\Dingding\\eclipse-workspace\\ecoo2018\\src\\ecoo18r2\\DATA11.txt"));
			while (br.ready()) {// change to # test cases\
				dp = new ArrayList<>();
				int[] stock = new int[4];
				String[] str = br.readLine().split(" ");
				for (int i = 0; i < 4; i++) {
					stock[i] = Integer.parseInt(str[i]);
				}
				str = br.readLine().split(" ");
				int lc = Integer.parseInt(str[0]), lo = Integer.parseInt(str[3]),
						lw = Integer.parseInt(str[1]), ls = Integer.parseInt(str[2]);
				str = br.readLine().split(" ");
				int fc = Integer.parseInt(str[2]), fo = Integer.parseInt(str[1]),
						fw = Integer.parseInt(str[3]), fs = Integer.parseInt(str[0]);
				dp.add(new int[4]);
				boolean b = true;
				if (lc + lw > fo + fs) {
					b = false;
				}
				for (int i = 0; i < 50; i++) {
					if (b) {
						calculateLeaf(stock, lc, lo, lw, ls);
						b = false;
					}
					else {
						calculateFish(stock, fc, fo, fw, fs);
						b = true;
					}
				}
				int max = 0;
				for (int[] i : dp) {
					max = Math.max(i[1], max);
				}
				System.out.println(max);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found...");
		}
	}

	public static void calculateLeaf(int[] stock, int carbon, int oxy, int water, int sugar) {
		if (stock[0] == 0)
			return;
		if (stock[2] == 0)
			return;
		int hold = stock[0];
		hold = stock[0] / carbon;
		int hold2 = stock[2];
		hold2 = stock[2] / water;
		boolean b = true;
		int times = 0;
		if (hold < hold2) {
			times = hold;
		}
		else {
			times = hold2;
			b = false;
		}
		stock[0] = b ? stock[0] % carbon : stock[0] - (times * carbon);
		stock[1] += times * oxy;
		stock[2] = !b ? stock[2] % water : stock[2] - (times * water);
		stock[3] += times * sugar;
		dp.add(stock.clone());
	}

	public static void calculateFish(int[] stock, int carbon, int oxy, int water, int sugar) {
		if (stock[3] == 0)
			return;
		if (stock[1] == 0)
			return;
		int hold = stock[3];
		hold = stock[3] / sugar;
		int hold2 = stock[1];
		hold2 = stock[1] / oxy;
		boolean b = true;
		int times = 0;
		if (hold < hold2) {
			times = hold;
		}
		else {
			times = hold2;
			b = false;
		}
		stock[0] += times * carbon;
		stock[1] = !b ? stock[1] % oxy : stock[1] - (times * oxy);
		stock[2] += times * water;
		stock[3] = b ? stock[3] % sugar : stock[3] - (times * sugar);
		dp.add(stock.clone());
	}

}
