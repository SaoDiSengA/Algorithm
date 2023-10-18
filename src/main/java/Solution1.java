class Solution1 {
    char[][] matrix;
    int ans = 0;

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        this.matrix = matrix;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == '1') {
                    // ans = Math.max(ans,1);
                    dfs(i,j,Math.min(m-i,n-j));
                }
            }
        }
        return ans *ans;
    }

    void dfs(int x,int y,int len){
        // if(x + len > matrix.length || y + len > matrix[0].length || len < 1)
        //     return;
        // if(len < 1) return;
        if(len < ans) return;
        for(int i = x;i < x + len;i++){
            for(int j = y;j < y + len;j++){
                if(matrix[i][j] == '0'){
                    return;
                }
            }
        }
        ans = Math.max(ans,len);
        dfs(x, y, len - 1);
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int i = s.maximalSquare(new char[][]{{'1', '1', '0'}, {'1', '1', '0'},{'1', '1', '0'}});
        System.out.println(i);
    }
}