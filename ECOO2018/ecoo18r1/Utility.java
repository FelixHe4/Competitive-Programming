package ecoo18r1;
import java.util.ArrayList;

public class Utility {
	/*
	 * public static void main(String[] args) { DecimalFormat df = new
	 * DecimalFormat("00.00"); System.out.println(df.format(4.509)); }
	 */

	static int indexOf(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value)
				return i;
		}
		return -1;
	}

	static int indexOf(String[] array, String value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(value))
				return i;
		}
		return -1;
	}

	static int indexOf(double[] array, double value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value)
				return i;
		}
		return -1;
	}

	static boolean isPrime(int n) {
		if (n % 2 == 0)
			return false;
		int max = (int) Math.sqrt(n);
		for (int i = 3; i <= max; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	static ArrayList<Integer> getPrimeFactors(int n) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		while (n % 2 == 0) {
			factors.add(2);
			n /= 2;
		}
		for (int i = 3; i * i <= n; i += 2) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1)
			factors.add(n);
		return factors;
	}

	static ArrayList<Integer> getAllFactors(int n) {
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int max = (int) Math.sqrt(n);
		for (int i = 1; i <= max; ++i) {
			if (n % i == 0) {
				factors.add(i);
				if (i != n / i) {
					factors.add(n / i);
				}
			}
		}
		return factors;
	}

	// CHANGE THIS ONE
	static char[][] getCharGrid(String[] lines) {
		char[][] grid = new char[lines[0].length()][lines.length];
		for (int j = 0; j < lines.length; j++) {
			for (int i = 0; i < lines[0].length(); i++) {
				grid[j][i] = lines[j].charAt(i);
			}
		}

		return grid;
	}

	static int[][] getIntGrid(String[] lines) {
		int[][] grid = new int[lines[0].length()][lines.length];
		for (int j = 0; j < lines.length; j++) {
			for (int i = 0; i < lines[0].length(); i++) {
				grid[j][i] = (int) (lines[j].charAt(i));
			}
		}

		return grid;
	}

	static int factorial(int num) {
		int sum = 1;
		for (int i = num; i > 1; i--) {
			sum *= i;
		}

		return sum;
	}

	static int greatestCommonDenominator(int a, int b) {
		if (b == 0)
			return a;
		else
			return greatestCommonDenominator(b, a % b);
	}

	static int[] bubbleSort(int[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length - 1; j++) {
				if (data[j] > data[j + 1]) {
					int tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;
				}
			}
		}
		return data;
	}

	// better with arraylists / linkedlists
	static int[] mergeSort(int[] data) {
		if (data.length == 1)
			return data;
		int middle = data.length / 2;
		int[] left = mergeSort(subArray(data, 0, middle - 1));
		int[] right = mergeSort(subArray(data, middle, data.length - 1));
		int[] result = new int[data.length];
		int dPtr = 0;
		int lPtr = 0;
		int rPtr = 0;
		while (dPtr < data.length) {
			if (lPtr == left.length) {
				result[dPtr] = right[rPtr];
				rPtr++;
			}
			else if (rPtr == right.length) {
				result[dPtr] = left[lPtr];
				lPtr++;
			}
			else if (left[lPtr] < right[rPtr]) {
				result[dPtr] = left[lPtr];
				lPtr++;
			}
			else {
				result[dPtr] = right[rPtr];
				rPtr++;
			}
			dPtr++;
		}
		return result;
	}

	// better with arrays
	static void quicksort(int arr[], int p, int q) {
		if (p < q) {
			int r = partition(arr, p, q);
			quicksort(arr, p, r - 1);
			quicksort(arr, r + 1, q);
		}
	}

	private static int partition(int arr[], int p, int q) {
		int x = arr[p];
		int i = p;
		for (int j = p + 1; j < q; j++) {
			if (arr[j] <= x) {
				i = i + 1;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		int tmp = arr[p];
		arr[p] = arr[i];
		arr[i] = tmp;
		return i;
	}

	static int[] subArray(int[] data, int start, int inclusiveEnd) {
		int[] sub = new int[inclusiveEnd - start + 1];
		for (int i = 0; i < inclusiveEnd - start + 1; i++) {
			sub[i] = data[start + i];
		}
		return sub;
	}

	// METHODS TP PRINT OUT A 1D ARRAY
	public static void printArray(int[] anArray) {
		for (int i = 0; i < anArray.length; i++) {
			System.out.println();
			System.out.print(anArray[i]);
		}
	}

	public static void printArray(double[] anArray) {
		for (int i = 0; i < anArray.length; i++) {
			System.out.println();
			System.out.print(anArray[i]);
		}
	}

	// METHOD TP PRINT OUT A 2D ARRAY
	public static void print2DArray(double[][] anArray) {
		for (int i = 0; i < anArray.length; i++) {
			System.out.print("row " + i + "           ");
			for (int j = 0; j < anArray[i].length; j++) {
				System.out.print(anArray[i][j] + "    ");
			}
			System.out.println();
		}
	}

	// METHOD THAT CALCULATES THE SUM OF EACH ROW
	public static void sumEachRow(double[][] anArray) {
		for (int i = 0; i < anArray.length; i++) {
			int sum = 0;
			;
			for (int j = 0; j < anArray[i].length; j++) {
				sum = (int) (sum + anArray[i][j]);
			}
		}
	}

	// SEARCHING ROUTINES
	/**
	 * /* BINARY SEARCH
	 * /* This simple method traverses an array in a binary search.
	 * /* binarySearch() takes an array and an int.
	 * /* This method will run as long as the start value
	 * /* is <= the end value and that item has not been found.
	 **/

	public static int binarySearch(int[] data, int lookfor) {
		int start = 0;
		int end = data.length - 1;
		int middle = 0;
		boolean found = false;
		int location = -1;
		while (start <= end && !found) {
			middle = (start + end) / 2;
			if (data[middle] == lookfor) // FOUND IT!
			{
				found = true;
				location = middle;
			}
			else if (data[middle] < lookfor)
				start = middle + 1;
			else
				end = middle - 1;
		}
		return location;
	}

	/**
	 * /* A simple LINEAR SEARCH
	 * /* Simple algorithm that traverses an array looking for a similar string.
	 * /* It will return either -1 indicating that the match has not been found,
	 * /* or the position of the matching string.
	 * /* NOTE that this algorithm WILL stop when the string is found.
	 **/
	public static int LinSearch(String[] data, String lookfor) {
		int position = -1; // flag
		boolean found = false;
		for (int i = 0; i < data.length && !found; i++) {
			if (data[i].equals(lookfor)) {
				return i;

			}
		}
		return position;
	}

	// SORTING ROUTINES
	/**
	 * /* BUBBLE SORT
	 * /* Simple algorithm that sorts the data in an array in ascending order.
	 **/
	public static void BubbleSort(String[] data) {
		boolean done = false;
		for (int end = data.length - 1; end > 0 && !done; end--) {
			done = true;
			for (int i = 0; i < end; i++) {
				if (data[i].compareTo(data[i + 1]) > 0) {
					done = false;
					String temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
				}
			}
		}
	}

	/**
	 * /*SELECTION SORT
	 * /* Simple algorithm that sorts the data in an array in ascending order.
	 **/
	public static void SelectionSort(int[] data) {
		for (int end = data.length - 1; end > 0; end--) {
			int biggie = 0;
			// Location of largest number
			for (int i = 1; i <= end; i++) {
				if (data[i] > data[biggie]) {
					biggie = i;
				}
			}
			int temp = data[end];
			data[end] = data[biggie];
			data[biggie] = temp;
		}
	}

	/**
	 * /* INSERTION SORT
	 * /* Simple algorithm that sorts the data in an array in ascending order.
	 */
	public static void InsertionSort(int[] data) {
		for (int end = 1; end < data.length; end++) {
			int item = data[end];
			int i = end;
			while (i > 0 && item < data[i - 1]) {
				data[i] = data[i - 1];
				i--;
			}
			data[i] = item;
		}
	}

	// FIBONACI CALCULATOR WITH RECURSION
	class FibonacciCalc {
		public int fib(int n) {
			if (n == 1)
				return 1;
			else if (n == 2)
				return 1;
			else
				return fib(n - 1) + fib(n - 2);
		}
	}

	/**
	 * class WordScramble
	 * /* an algorithm that creates all the possible scrambled words,
	 * /* starting with given word
	 **/
	class WordScramble {
		public void main(String[] args) {
			String letters = "NUF";
			System.out.println("Word Scramble \n");
			scrambleWords(letters, "");
		}

		public void scrambleWords(String word, String scrambledLetters) {
			String remainingLetters;
			String origWord = word;
			String origscrambledLetters = scrambledLetters;

			if (word.length() == 1) {
				System.out.println(scrambledLetters + word);
			}
			else {
				for (int pos = 0; pos < origWord.length(); pos++) {
					remainingLetters = origWord.substring(0, pos) +
							origWord.substring(pos + 1, origWord.length());

					scrambleWords(remainingLetters, origscrambledLetters + origWord.charAt(pos));
				}
			}
		}
	}

	class FibonacciTester {
		public void main(String[] args) {
			int argument = Integer.parseInt(args[0]); // Get N from the command line.
			FibonacciCalc f = new FibonacciCalc();
			int result = f.fib(argument);
			System.out.println("fib(" + argument + ") is " + result);
		}
	}
}
