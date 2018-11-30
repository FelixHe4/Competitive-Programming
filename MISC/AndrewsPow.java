package Unit2;

public class AndrewsPow {

	public static void main(String[] args) {

	}

	public static long pow(int b, int e) {
		if (e == 0) {
			return 1;
		}
		long half = (long) Math.pow(b, e / 2);
		if (e % 2 == 0) {
			return half * half;
		}
		else {
			return half * half * b;
		}
	}
}
