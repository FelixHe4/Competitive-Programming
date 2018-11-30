package Unit2;
import java.io.*;
import java.util.*;
import java.math.*;
public class SegmentTreeHeight {
	static int[] ST;

	public static void main(String[] args) {
		int height = (int) Math.ceil((Math.log(11) / Math.log(2)));
		int[] A = new int[8];
		for (int i = 0; i < 8; i++) {
			A[i] = i + 1;
		}
		// if height equals to 2
		// 2 of power 3 - 1
		// 7

		// if height equals 3
		// 2 to the power of 4 - 1
		// 15
		int maxsize = (int) Math.pow(2, height + 1) - 1;
		System.out.println(maxsize);
		ST = new int[maxsize];
	}

}
