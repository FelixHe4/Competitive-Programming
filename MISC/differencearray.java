package Unit2;
import java.util.*;
public class differencearray {

	public static void main(String[] args) {
		int[] a = { 3, 12, 45, 23, 53 };
		int[] d = new int[4];
		d[0] = a[0];
		for (int i = 1; i < d.length; i++) {
			d[i] = a[i] - a[i - 1];
			System.out.println(Arrays.toString(d));
		}
	}

}
