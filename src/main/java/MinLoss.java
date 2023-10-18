import java.util.*;

class MinLoss {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            int index = Collections.binarySearch(list,nums[i]);
            index = -index - 1;
            if(index == list.size()) list.add(nums[i]);
            else if(index < 0) list.set(0,nums[i]);
            else if(index < list.size() && index >= 0) list.set(index,nums[i]);
        }
//        for(Integer x : list){
//            System.out.println(x);
//        }
        return list.size();
    }


    public static void main(String[] args) {
        MinLoss m = new MinLoss();
        int a = m.lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12});
        System.out.println(a);

    }
}