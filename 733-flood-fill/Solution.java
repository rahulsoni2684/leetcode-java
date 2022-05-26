class Solution {
    //direction matrix of all possible directions
    int[][] dir = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
    
    public int[][] floodFill(int[][] image, int row, int col, int newColor) 
    {
        // current color of cooridnates in matrix
        int curColor = image[row][col];
        // if same then do nothing
        if (curColor == newColor) {
            return image;
        }
        // else assign new color in cell
        image[row][col] = newColor;
        
        for (int i = 0; i < dir.length; i ++) 
        {
            int nextX = row + dir[i][0];
            int nextY = col + dir[i][1];
            
            // validate the next cell is valid or not
            if (nextX < 0 || nextY < 0 || nextX >= image.length || nextY >= image[0].length) 
            {
                continue;
            }
            // check if this cell not having color to replace
            if (image[nextX][nextY] != curColor) {
                continue;
            }
            // if cell is having curColor to replace then call recursive function
            floodFill(image, nextX, nextY, newColor);
        }
        
        return image;
    }
}