package algorithm1;

public class NumberOf1Bits {
	
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int count = 0;
		// Brian Kernighan’s Algorithm
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		int n = 00000000000000000000000000001011;
		NumberOf1Bits obj = new NumberOf1Bits();
		System.out.println(obj.hammingWeight(n));
	}
}
