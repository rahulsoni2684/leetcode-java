package algorithm1;

public class PowerOfTwo {

	public boolean isPowerOfTwo(int n) {
		if (n < 0 || n == 0) {
			return false;
		}

		while (n % 2 == 0) {
			n = n / 2;
		}
		if (n == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		PowerOfTwo obj = new PowerOfTwo();
		System.out.println(obj.isPowerOfTwo(16));
	}
}
