package algorithm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntervalListIntersections {

	static int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {

		int i = 0;
		int j = 0;
		List<List<Integer>> result = new ArrayList<>();

		while (i < firstList.length && j < secondList.length) {
			// check if s1 <= e2 and s2 <= e1 return true means chances of intersection
			// exists
			if (firstList[i][0] <= secondList[j][1] && secondList[j][0] <= firstList[i][1]) {
				// to get the intersection points, get max of (s1,s2) and min of (e1, e2)
				int x = Math.max(firstList[i][0], secondList[j][0]);
				int y = Math.min(firstList[i][1], secondList[j][1]);
				result.add(Arrays.asList(x, y));
			}
			// pointer will move further whose value will be small
			if (firstList[i][1] <= secondList[j][1]) {
				i++;
			} else {
				j++;
			}
		}

		int[][] res = result.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray())
				.toArray(int[][]::new);

		return res;
	}

	static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

		int i = 0;
		int j = 0;
		LinkedList<int[]> result = new LinkedList<>();

		while (i < firstList.length && j < secondList.length) {
			// check if s1 <= e2 and s2 <= e1 return true means chances of intersection
			// exists
			if (firstList[i][0] <= secondList[j][1] && secondList[j][0] <= firstList[i][1]) {
				// to get the intersection points, get max of (s1,s2) and min of (e1, e2)
				int x = Math.max(firstList[i][0], secondList[j][0]);
				int y = Math.min(firstList[i][1], secondList[j][1]);
				result.add(new int[] { x, y });
			}
			// pointer will move further whose value will be small
			if (firstList[i][1] <= secondList[j][1]) {
				i++;
			} else {
				j++;
			}
		}

		return result.toArray(new int[0][]);
	}

	public static void main(String[] args) {
		int[] firstList[] = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[] secondList[] = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

		System.out.println(Arrays.deepToString(intervalIntersection(firstList, secondList)));
	}

}
