package algorithm2;

public class NumberOfProvinces {
	static int findCircleNum(int[][] isConnected) {

		int gridLen = isConnected.length;
		int proviceCount = 0;
		boolean[] cellVisited = new boolean[gridLen];

		for (int i = 0; i < gridLen; i++) {
			if (!cellVisited[i]) {
				proviceCount++;
				dfs(isConnected, i, cellVisited, gridLen);
			}
		}
		
		return proviceCount;
	}

	static void dfs(int[][] isConnected, int i, boolean[] cellVisited, int gridLen) {
		for (int j = 0; j < gridLen; j++) {
			if (!cellVisited[j] && isConnected[i][j] == 1) {
				cellVisited[j] = true;
				dfs(isConnected, j, cellVisited, gridLen);
			}
		}
	}

	public static void main(String[] args) {
		int[][] isConnected1 = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(findCircleNum(isConnected1));

		int[][] isConnected2 = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
		System.out.println(findCircleNum(isConnected2));
	}
}
