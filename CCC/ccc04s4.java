package Unit1;
import java.util.*;
public class ccc04s4 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int z1 = sc.nextInt();
		x = x1 - x;
		y = y1 - y;
		z = z1 - z;
		double min = x * x + y * y + z * z;
		int distance = sc.nextInt();
		int nx = x - distance;
		if (nx * x < 0)
			min = Math.min(min, y * y + z * z);
		else
			min = Math.min(min, nx * nx + y * y + z * z);
		char turn = sc.next().charAt(0);
		while (turn != 'E') {
			if (turn == 'U') {
				x = z;
				z = -nx;
			}
			else if (turn == 'D') {
				x = -z;
				z = nx;
			}
			else if (turn == 'R') {
				x = -y;
				y = nx;
			}
			else if (turn == 'L') {
				x = y;
				y = -nx;
			}
			distance = sc.nextInt();
			nx = x - distance;
			if (nx * x < 0)
				min = Math.min(min, y * y + z * z);
			else
				min = Math.min(min, nx * nx + y * y + z * z);
			turn = sc.next().charAt(0);
		}
		System.out.printf("%.2f", Math.sqrt(min));
	}
}
