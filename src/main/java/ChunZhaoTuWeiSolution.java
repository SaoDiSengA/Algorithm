import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class ChunZhaoTuWeiSolution {
    
    /***
     * @Description: 1. 两数之和
     * 这个是非有序的，双指针不适用，采用hash
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     * @param: [nums, target]
     * @return: int[]
     * @Author: SaoDiSeng
     * @Date: 2023-03-79 17:06:32
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(hashmap.containsKey(target - nums[i])){
                return new int[]{hashmap.get(target - nums[i]),i};
            }
            hashmap.put(nums[i],i);
        }
        return new int[2];
    }

    /***
     * @Description: 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     *
     * 输入：s = "(]"
     * 输出：false
     *
     * @param: [s]
     * @return: boolean
     * @Author: SaoDiSeng
     * @Date: 2023-03-79 17:07:38
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<Character,Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey((s.charAt(i)))){
                if (stack.isEmpty() || stack.peek() != map.get(s.charAt(i))) return false;
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

}
