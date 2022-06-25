package algorithm1;

public class ClimbStairs {

	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		// one way with one stair
		int first = 1;
		// two way with two stairs
		int second = 2;

		for (int i = 3; i <= n; i++) {
			int third = first + second;
			first = second;
			second = third;
		}
		return second;
	}
}
