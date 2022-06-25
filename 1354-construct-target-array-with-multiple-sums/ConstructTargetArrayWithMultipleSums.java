package daily;

import java.util.Collections;
import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {

	/**
	 * This method is based on the backtrack approach Logic here is to get starting
	 * by the target array and do process until get the array of ones.
	 * 
	 * @param target
	 * @return
	 */
	public boolean isPossible(int[] target) {
		// If array is having one element equals to 1 then, returning true else
		// false.
		if (target.length == 1) {
			return target[0] == 1;
		}
		// largest number of array is required each time, so putting all numbers into a
		// max-heap.
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
		// sum is the total of all elements of array
		int sum = 0;
		
		for (int item : target) {
			pQueue.add(item);
			sum += item;
		}
		
		while (pQueue.peek() != 1) {
			int cur = pQueue.poll();
			// sum - cur is the sum of all elements of array except the current max element
			// and if this value is equals to 1 means no further processing is required and
			// then
			// return true.
			if (sum - cur == 1) {
				return true;
			}
			// get the value x to replace the current max element on the same index
			int x = cur % (sum - cur);
			// update the sum based on the new value of x
			sum = sum - cur + x;
			// In first case, it is impossible to get the array of ones so returning false
			// In second case, there is no change in value x by mod operator, so returning
			// false
			if (x == 0 || x == cur)
				return false;
			else
				// adding new value x on the same index into queue for next iteration of
				// processing
				pQueue.add(x);
		}
		return true;
	}

	public static void main(String[] args) {
		int[] target = { 1, 1, 1, 2 };
		ConstructTargetArrayWithMultipleSums obj = new ConstructTargetArrayWithMultipleSums();
		System.out.println(obj.isPossible(target));
	}
}
