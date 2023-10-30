import java.util.*;

public class ZuoCai {

    public int[] singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer num : map.keySet()){
            if(map.get(num) == 1) list.add(num);
        }
        return new int[]{list.get(0), list.get(1)};

    }


    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        int i = 0;
        while(j >= 0){
            if(nums[j] == val) j--;
            else break;
        }
        while(i <= j){
            if(nums[i] == val){
                nums[i] = nums[j];
                nums[j] = val;
                j--;
            }
            i++;
        }
        return j+1;
    }




    private int dfs(int i, int j, int n, int k, int target) {
        int count = 0;
        if(i > n){
            if(target == 0) return count+1;
            return 0;
        }

        for (int m = j; m <= k; m++) {
            count += dfs(i+1,0,n,k,target - m);
        }

        return count;
    }


    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i = 1;i <= n;i++){
            int temp = i * i;
            String str = String.valueOf(temp);
            if(check(i,str,str.length(),str.length())){
                ans += temp;
            }
        }
        return ans;
    }

    private boolean check(int target, String str, int index,int last_index) {
        if(index < 0) {
            if(target == 0) return true;
            return false;
        }

        for (int i = index; i >= 0; i--) {

            int temp = Integer.parseInt(str.substring(index,last_index));
            if(check(target-temp,str,i-1,index)){
                return true;
            }

        }

        return false;

    }



}
