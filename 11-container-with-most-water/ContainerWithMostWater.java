package algorithm2;

public class ContainerWithMostWater {

	static int maxArea(int[] height) {
		int low = 0;
		int high = height.length - 1;
		int waterArea = 0;

		while (low < high) {
			waterArea = Math.max(waterArea, Math.min(height[low], height[high]) * (high - low));

			if (height[low] < height[high])
				low++;
			else
				high--;
		}
		
		return waterArea;
	}

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}
}
