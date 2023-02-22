import java.util.HashMap;

public class Solution {

    /***
     * 剑指 Offer 58 - II. 左旋转字符串
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     *示例 1：
     * 输入: s = "abcdefg", k = 2
     * 输出:"cdefgab"
     *
     * 示例 2：
     * 输入: s = "lrloseumgh", k = 6
     * 输出:"umghlrlose"
     *
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {

        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if(i < n){
                temp.append(s.charAt(i));
            }else{
                res.append(s.charAt(i));
            }
        }
        res.append(temp);
        return res.toString();

        /*
         * 方法二
         * return s.substring(n, s.length()) + s.substring(0, n);  截取拼接
         */

    }


    /***
     *剑指 Offer 03. 数组中重复的数字
     *找出数组中重复的数字。
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 示例 1：
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        for (int a : map.keySet()) {
            if(map.get(a) > 1){
                return a;
            }
        }
        return 0;
    }

    /***
     *
     * 剑指 Offer 53 - I. 在排序数组中查找数字 I
     * 统计一个数字在排序数组中出现的次数。
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     * 示例2:
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                total += 1;
            }
        }
        return total;
    }


    /***
     *
     * 
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int len = nums.length + 1;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return len - 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1};
        Solution solution = new Solution();
        int repeatNumber = solution.findRepeatNumber(a);
        System.out.println(repeatNumber);
    }

}
