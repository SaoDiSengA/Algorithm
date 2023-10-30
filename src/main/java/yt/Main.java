package yt;

import java.util.*;

public class Main {
    private static int min;
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] ans = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(mat[i][j] == 1){
                    min = Integer.MAX_VALUE;
                    dfs(i,j,mat,visited,row,col,1);
                    ans[i][j] = min;
                } else ans[i][j] = 0;

            }
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] mat, boolean[][] visited, int row, int col,int cur) {
        if(i >= row || j >= col || i < 0 || j < 0 || visited[i][j]) {
            return ;
        }
        if(min < cur) return;
        if(mat[i][j] == 0) min = Math.min(min,cur);
        visited[i][j] = true;
        dfs(i-1,j,mat,visited,row,col,cur+1);
        dfs(i+1,j,mat,visited,row,col,cur+1);
        dfs(i,j-1,mat,visited,row,col,cur+1);
        dfs(i,j+1,mat,visited,row,col,cur+1);
        visited[i][j] = false;
    }





    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long max = 0;
        int pre_h = 0;
        int pre_v = 0;
        int heigth = 0;
        int width = 0;
        for (int i = 0; i <= horizontalCuts.length; i++) {
            heigth = i == horizontalCuts.length ? h : horizontalCuts[i];
            int x = heigth - pre_h;
            for (int j = 0; j <= verticalCuts.length; j++) {
                width = j == verticalCuts.length ? w : verticalCuts[j];
                int y = width - pre_v;
                long area = (long) x * y;
                max = Math.max(max,area);
                pre_v = j == verticalCuts.length ? 0 : verticalCuts[j];
            }
            pre_h = i == horizontalCuts.length ? 0 : horizontalCuts[i];
        }
        return (int) (max % 1000000007);
    }

    public static void main(String[] args) {
        Main ma = new Main();
        int i = ma.maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2});
        System.out.println(i);
    }


    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }
        );
        for (int i = 0; i < gifts.length; i++) {
            queue.add(gifts[i]);
        }
        while(k-- > 0){
            int poll = queue.poll();
            int temp = (int) Math.sqrt(poll);
            queue.add(temp);
        }
        long ans = 0;
        while(!queue.isEmpty())
            ans += queue.poll();
        return ans;
    }


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        ddfs(0,graph,path,ans);
        return ans;
    }

    private void ddfs(int i, int[][] graph, List<Integer> path, List<List<Integer>> ans) {
        if(i == graph.length - 1){
            ans.add(new ArrayList<>(path));
            return ;
        }
        for (int k = 0; k < graph[i].length; k++) {
            path.add(graph[i][k]);
            ddfs(graph[i][k],graph,path,ans);
            path.remove(path.size()-1);
        }

    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int num = citations.length - 1;
        while (num >= 0 && citations[num] > h){
            h++;
            num--;
        }
        return h;
    }


    //构建有向图
    List<List<Integer>> edges;
    Boolean[] visited;
    int[] result;
    //是否有环
    boolean recur = false;
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new Boolean[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        for(int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
        }

        for (int i = 0; i < numCourses && !recur; i++) {
            if(visited[i] == null){
                dddfs(i);
            }
        }
        if(recur) return new int[0];
        return result;

    }

    private void dddfs(int u) {
        visited[u] = true;
        for (int v : edges.get(u)) {
            if(visited[v] == null) {
                dddfs(v);
                if(recur) return;
            } else if (visited[v]){
                recur = true;
                return;
            }
        }

        visited[u] = false;
        result[index--] = u;
    }


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        return 1;
    }
}
