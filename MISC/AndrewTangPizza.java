package Unit2;
import java.util.*;
public class AndrewTangPizza {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		double min = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < n; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			if (Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2)) < min) {
				min = Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
				index = i + 1;
			}
		}
		System.out.printf("%.2f", min);
		System.out.println();
		System.out.println(index);
		sc.close();
	}

}
