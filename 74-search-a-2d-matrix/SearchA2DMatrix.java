package algorithm2;

public class SearchA2DMatrix {

	static boolean searchMatrix(int[][] matrix, int target) {

		int targetRow = findTargetRow(matrix, target);
		if (targetRow == -1) {
			return false;
		}
		return findTargetInRow(matrix[targetRow], target);
	}

	/**
	 * Method to find the target from potential target row
	 * 
	 * @param targetRowArray
	 * @param target
	 * @return
	 */
	static boolean findTargetInRow(int[] targetRowArray, int target) {

		int low = 0;
		int high = targetRowArray.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (target == targetRowArray[mid]) {
				return true;
			} else if (target < targetRowArray[mid]) {
				high = mid - 1;
			}

			else if (target > targetRowArray[mid]) {
				low = mid + 1;
			}
		}

		return false;
	}

	/**
	 * Method to find the potential target row
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	static int findTargetRow(int[][] matrix, int target) {
		int low = 0;
		int high = matrix.length - 1;
		int lastColum = matrix[0].length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (target >= matrix[mid][0] && target <= matrix[mid][lastColum]) {
				return mid;
			} else if (target < matrix[mid][0]) {
				high = mid - 1;
			} else if (target > matrix[mid][lastColum]) {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] nums = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };

		System.out.println(SearchA2DMatrix.searchMatrix(nums, 17));
	}
}