package daily;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static long maxKelements(int[] nums, int k) {

        int n = nums.length;
        int max = 0;

        PriorityQueue<Integer> maxhead = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < n; i++) {
            maxhead.add(nums[i]);
        }

        while(k-- > 0){
            int temp = maxhead.poll();
            max += temp;
            temp = (int) Math.ceil(temp / 3.0);
            maxhead.add(temp);
        }

        return max;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,10,3,3,3};
        int k = 3;
        long l = maxKelements(nums, k);
        System.out.println(l);
    }
}