package algorithm1;

public class ReverseBits {

	public int reverseBits(int n) {
		int reverse = 0;

		for (int i = 0; i < 32; i++, n >>= 1) {
			reverse <<= 1;
			if (n % 2 == 1)
				reverse += 1;
		}
		return reverse;
	}

	public static void main(String[] args) {

		int n = 0000001010010;
		ReverseBits obj = new ReverseBits();
		System.out.println(obj.reverseBits(n));
	}
}
