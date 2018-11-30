package Unit2;
import java.util.Scanner;
public class BinarySearch {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input size of the array:");
		int size = sc.nextInt();
		double[] data = new double[size];

		System.out.println("Please input " + size + " numbers:");

		for (int i = 0; i < size; i++) {
			data[i] = sc.nextDouble();
		}

		System.out.println("Please input which number you want to search:");

		double key = sc.nextDouble();
		System.out.println("Found key at index number: " + binary(data, key));

	}

	public static int binary(double[] data, double key) {
		int low = 0;
		int high = data.length - 1;
		int found = -1;
		while (high >= low) {
			int middle = (low + high) / 2;
			if (data[middle] == key) {
				found = middle;
				return middle;
			}
			if (data[middle] < key) {
				low = middle + 1;
			}
			if (data[middle] > key) {
				high = middle - 1;
			}
		}
		return found;
	}

}
