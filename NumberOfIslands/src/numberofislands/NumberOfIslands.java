/*
 * Given a 2d grid map of '1' (land) and '0' (water)? count the number of
 * island. An island is surrounded by water and is formated by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges
 * of the grid are all surrounded by water.
 *
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 */
package numberofislands;

/**
 *
 * @author AKravchuk
 */
public class NumberOfIslands {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[][] grid1 = {{'1', '1', '1', '1', '0'},
                          {'1', '1', '0', '1', '0'},
                          {'1', '1', '0', '0', '0'},
                          {'0', '0', '0', '0', '0'}};
        
        char[][] grid2 = {{'1', '1', '0', '0', '0'},
                          {'1', '1', '0', '0', '0'},
                          {'0', '0', '1', '0', '0'},
                          {'0', '0', '0', '1', '1'}};
        
        System.out.println(numIslands(grid1));  // 1
        
        System.out.println(numIslands(grid2));  // 3
    }
    
    public static int numIslands(char[][] grid) {
        int count  = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    callBFS(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    public static void callBFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';
        callBFS(grid, i + 1, j); //up
        callBFS(grid, i - 1, j); //down
        callBFS(grid, i, j - 1); //left
        callBFS(grid, i, j + 1); //right
        
    }
    
}
