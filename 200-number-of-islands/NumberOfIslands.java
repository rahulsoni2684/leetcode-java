package algorithm2;

public class NumberOfIslands {
	static int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}
		int numOfIsland = 0;
		// traversing through each cell if '1' 
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					// Adding island by 1 and applying search surrounding to this cell
					numOfIsland += dfs(grid, i, j);
				}
			}
		}
		return numOfIsland;
	}

	static int dfs(char[][] grid, int i, int j) {
		// case of grid out of bound and water and processed cells to skip
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0' || grid[i][j] == 'P') {
			return 0;
		} else {
			// mark the cell as processed
			grid[i][j] = 'P';
			// apply search in all 4 direction of this cell
			dfs(grid, i + 1, j);
			dfs(grid, i - 1, j);
			dfs(grid, i, j + 1);
			dfs(grid, i, j - 1);
			
			return 1;
		}
	}

	public static void main(String[] args) {
		char[][] grid1 = { 
				{ '1', '1', '1', '1', '0' }, 
				{ '1', '1', '0', '1', '0' }, 
				{ '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } 
			};
		System.out.println(numIslands(grid1));
		
		char[][] grid2 = { 
					{ '1', '1', '0', '0', '0' }, 
					{ '1', '1', '0', '0', '0' }, 
					{ '0', '0', '1', '0', '0' },
					{ '0', '0', '0', '1', '1' } 
				};
		System.out.println(numIslands(grid2));
	}
}
