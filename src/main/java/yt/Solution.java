package yt;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] ==1 && !visited[i][j]){
                    ans = Math.max(ans,dfs(i,j,visited,grid,row,col));
                }
            }
        }
        
        return ans;
    }

    private int dfs(int i, int j, boolean[][] visited, int[][] grid, int row, int col) {
        if(i >= row || j >= col || i < 0 || j < 0 || visited[i][j] || grid[i][j] == 0) return 0;
        visited[i][j] = true;
        int num = 1;
        num += dfs(i-1,j,visited,grid,row,col);
        num += dfs(i+1,j,visited,grid,row,col);
        num += dfs(i,j-1,visited,grid,row,col);
        num += dfs(i,j+1,visited,grid,row,col);
        return num;
    }


    public static void main(String[] args) {
        Solution yt = new Solution();
        int i = yt.maxAreaOfIsland(new int[][]{{1, 1, 0,0,0}, {1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}});
        System.out.println(i);
    }
}