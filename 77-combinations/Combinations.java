package algorithm1;
import java.util.LinkedList;
import java.util.List;

/**
 * 77- Combinations
 */
public class Combinations {
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new LinkedList<>();

		if (k == 0) {
			result.add(new LinkedList<Integer>());
			return result;
		}
		backtrack(1, new LinkedList<>(), n, k, result);

		return result;
	}
	
	public void backtrack(int begin, LinkedList<Integer> temp, int n, int k, List<List<Integer>> result) {
		if (temp.size() == k) {
			result.add(new LinkedList<>(temp));
		}

		for (int i = begin; i <= n && temp.size() < k; i++) {
			temp.add(i);
			backtrack(i + 1, temp, n, k, result);
			temp.removeLast();
		}
	}

	
	public static void main(String[] args) {
		Combinations obj = new Combinations();
		List<List<Integer>> output = obj.combine(4, 2);
		System.out.println(output);
	}
}
