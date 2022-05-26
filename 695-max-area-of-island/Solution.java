class Solution {
    private int rows, cols;
    
    public int maxAreaOfIsland(int[][] grid) 
    {
        rows = grid.length;
        // if empty matrix then return 0
        if (rows == 0) {
             return 0;
        }
        
        cols = grid[0].length;
        int area = 0;
        //traverse all elements in the matrix
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] > 0)
					area = Math.max(area, dfs(i, j, grid));              
            }
        }
        return area;
    }
    
   private int dfs(int i, int j, int[][] grid)
    {
        // skip all invalid and processed blocks from matrix
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] < 1)
        {
            return 0;
        }
        //mark the cell traversed
        grid[i][j] = 0;
        // traverse the matrix till depth in all four direction with increament recursively
        return 1 + dfs(i-1, j, grid) + dfs(i, j-1, grid) +
            dfs(i+1, j, grid) + dfs(i, j+1, grid);
    }
}