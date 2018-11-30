package Unit1;
import java.util.*;
public class ccc14s3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testC = scan.nextInt();
		for (int runs = 0; runs < testC; runs++) {
			int N = scan.nextInt();
			Stack<Integer> sta = new Stack<Integer>();
			for (int i = 0; i < N; i++) {
				sta.push(scan.nextInt());
			}
			Stack<Integer> bran = new Stack<Integer>();
			int lastInt = 0;
			boolean flag = true;
			while (!sta.isEmpty() || bran.size() >= 0) {
				boolean checker = true;
				if (sta.size() >= 1) {
					if (sta.peek() == lastInt + 1) {
						sta.pop();
						lastInt++;
					}
				}
				if (bran.size() >= 1) {
					if (bran.peek() == lastInt + 1) {
						bran.pop();
						lastInt++;
						checker = false;
					}
				}
				if (sta.size() == 1 || sta.size() == 0) {
					checker = false;
				}
				if (checker) {
					bran.push(sta.pop());
				}
				if (sta.size() == 0 && bran.size() == 0) {
					break;
				}
				if (sta.size() == 1 && sta.peek() != lastInt + 1 && bran.peek() != lastInt + 1) {
					flag = false;
					break;
				}
				if (sta.size() == 0 && bran.peek() != lastInt + 1) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("Y");
			}
			else if (!flag) {
				System.out.println("N");
			}
		}
		scan.close();
	}

}
