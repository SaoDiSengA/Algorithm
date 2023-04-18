class Solution {

    char[][] board;
    String word;
    boolean[][] flag;
    boolean ans;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.flag = new boolean[board.length][board[0].length];
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int i ,int j,int index){ //当前遍历到的位置
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || flag[i][j] == true || board[i][j] != word.charAt(index)) return false;
        if(index == word.length() - 1) return true;
        flag[i][j] = true;
        ans = dfs(i+1,j,index+1) || dfs(i-1,j,index+1) || dfs(i,j+1,index+1) || dfs(i,j-1,index+1);
        flag[i][j] = false;
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean a = solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCB");
        System.out.println(a);
    }
}