class Solution {
    
    int[][] direction = {{1,0},{-1,0}, {0,1}, {0,-1}};
    
    public int longestIncreasingPath(int[][] matrix) {
		if(matrix == null || matrix.length == 0) 
            return 0;
        
        int rows = matrix.length;
		int cols = matrix[0].length;
		int longestPath = 0;
		int[][] pathResult = new int[rows][cols];
		
		for(int i = 0 ; i < rows; i++){
			for(int j = 0; j < cols ; j++){
				int path = dfs(matrix, rows, cols, i, j, pathResult);
				longestPath = Math.max(path, longestPath);
			}
		}
		
		return longestPath;
    }
	
	public int dfs(int[][] matrix, int rows, int cols, int i, int j, int [][] pathResult)
	{
		if(pathResult[i][j] > 0) return pathResult[i][j];
		int max = 0;
		for(int[] d : direction){
			int x = i + d[0];
			int y = j + d[1];
			
			if(x >= 0 && y >= 0 && x < rows && y < cols && matrix[x][y] > matrix[i][j])
			{
				max = Math.max(max, dfs(matrix, rows, cols, x, y, pathResult));
			}
		}
		pathResult[i][j] = max + 1;
		
		return max + 1;
	}
}