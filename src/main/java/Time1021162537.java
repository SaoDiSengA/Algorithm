public class Time1021162537 {


    public static long countPairs(int n, int[][] edges) {
        int[][] path = new int[n][n];
        for (int i = 0; i < n; i++) {
            path[i][i] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            if(edges[i][0] < edges[i][1]) path[ edges[i][0] ][ edges[i][1] ] = 1;
            else path[ edges[i][1] ][ edges[i][0] ] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            int last = edges[i][1];
            int first = edges[i][0];
            for (int j = i; j < edges.length; j++) {
                int first_j = edges[j][0];
                if(first_j == last) {
                    path[ edges[i][0] ][ edges[j][1] ] = 1;
                }
                if(first == first_j){
                    path[ edges[i][1] ][ edges[j][1] ] = 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(path[i][j] == 0) ans++;
            }
        }

        return ans;



    }


    public static void main(String[] args) {
        Time1021162537.countPairs(7,new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}});
        System.out.println(1);
    }

    
}
