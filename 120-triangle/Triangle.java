package algorithm1;

import java.util.Arrays;
import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> t) {

		for (int i = t.size() - 2; i >= 0; i--) {

			for (int j = 0; j <= i; j++) {

				if (t.get(i + 1).get(j) < t.get(i + 1).get(j + 1)) {

					t.get(i).set(j, (t.get(i).get(j) + t.get(i + 1).get(j)));
				} else {

					t.get(i).set(j, (t.get(i).get(j) + t.get(i + 1).get(j + 1)));
				}
			}
		}
		return t.get(0).get(0);
	}

	public static void main(String[] args) {
		Triangle obj = new Triangle();

		List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7),
				Arrays.asList(4, 1, 8, 3));

		System.out.println(obj.minimumTotal(triangle));
	}
}
