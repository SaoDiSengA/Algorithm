import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,int[]> map = new HashMap<>();
        for(int[] arr : prerequisites){
            if(map.containsKey(arr[1]) && map.get(arr[1])[1] == arr[0]){
                map.remove(arr[1]);
            } else map.put(arr[0],arr);
        }
        System.out.println(map.size());
        return map.size() * 2 >= numCourses ? true : false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean a = s.canFinish(2,new int[][]{{1,0},{0,1}});
        System.out.println(a);
    }
}