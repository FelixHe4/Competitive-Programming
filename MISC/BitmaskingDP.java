package Unit2;

public class BitmaskingDP {

	public static void main(String[] args) {
		// Can be represented using bits
		// combinations of many elements
		// if the set is 1 2 3 4 5
		// if 0 <= i <= 4
		// 0 0 0 0 1
		// this means that element 0 is chosen, nothing else
		// for example b = 0 1 0 1 0
		// to set an element, do: base|(1<<i) where i is the ith bit
		// let i = 0
		// end would be 0 1 0 1 0 | 0 0 0 0 1
		// = 0 1 0 1 1
		// this means the subset is {1, 2, 4}
		// to unset the ith bit, b&!(1<<i)
		// let i = 1
		// (1 << 1)
		// 0 0 0 1 0
		// !(1 << 1)
		// 1 1 1 0 1
		// 0 1 0 1 0 & 1 1 1 0 1
		// = 0 1 0 0 0
		// this means the subset is {4}
		// check if the ith bit is set: b&(1 << i)
		// if the ith bit is set, it returns a nonzero integer
		// else, we get 0
		// let i = 3
		// (1 << i) = 0 1 0 0 0
		// 0 1 0 1 0 & 0 1 0 0 0
		// 0 1 0 0 0
		// this means the subset is {4}

	}

}
