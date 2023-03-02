
import java.util.*;

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
     *剑指 Offer 53 - II. 0～n-1中缺失的数字
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *示例 1:
     *
     * 输入: [0,1,3]
     * 输出: 2
     * 示例 2:
     *
     * 输入: [0,1,2,3,4,5,6,7,9]
     * 输出: 8
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int len = nums.length + 1; //避免越界
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return len - 1;  //返回len-1主要是避免当前数组没有消失的数
    }


    /***
     *
     * 剑指 Offer 04. 二维数组中的查找
     * 在一个 n * m 的二维数组中，每一行都按照从左到右非递减的顺序排序，每一列都按照从上到下非递减的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *  示例:
     * 现有矩阵 matrix 如下：
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     *
     * 给定 target=5，返回true。
     * 给定target=20，返回false。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while(row >= 0 && row < matrix.length && col >= 0 && col <= matrix[0].length){
            if(target < matrix[row][col]){
                col--;
                continue;
            }
            if(target > matrix[row][col]){
                row++;
                continue;
            }
            if(target == matrix[row][col]){
                return true;
            }

        }
        return false;
    }


    /***
     * 剑指 Offer 11. 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     *
     * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
     * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。 
     *
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]]
     * 示例 1：
     *
     * 输入：numbers = [3,4,5,1,2]
     * 输出：1
     * 示例 2：
     *
     * 输入：numbers = [2,2,2,0,1]
     * 输出：0
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers.length == 1) return numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] < numbers[i-1]){
                return numbers[i];
            }
        }
        //没有找到转折点，数组为升序
        return numbers[0];

//        int low = 0;
//        int high = numbers.length - 1;
//        while (low < high) {
//            int pivot = low + (high - low) / 2;
//            if (numbers[pivot] < numbers[high]) {
//                high = pivot;
//            } else if (numbers[pivot] > numbers[high]) {
//                low = pivot + 1;
//            } else {
//                high -= 1;            因为有重复的数，所以相等的情况不能简单的判断该左还是该右，所以high--
//            }
//        }
//        return numbers[low];
    }


    /***
     *
     * 剑指 Offer 50. 第一个只出现一次的字符
     * 示例 1:
     * 输入：s = "abaccdeff"
     * 输出：'b'
     * 示例 2:
     * 输入：s = ""
     * 输出：' '
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            int integer = map.get(s.charAt(i));
            if (integer==1) return s.charAt(i);
        }
        return ' ';
    }


    /***
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * 例如:
     * 给定二叉树:[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(root==null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }


        return res;
    }


    /***
     * 剑指 Offer 32 - I. 从上到下打印二叉树
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * 例如:
     * 给定二叉树:[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回：
     *
     * [3,9,20,15,7]
     *
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        int[] level = new int[]
        List<Integer> res = new ArrayList<>();
        if (root==null) return new int[]{};
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode currentTreeNode = queue.poll();
            res.add(currentTreeNode.val);
            if(currentTreeNode.left!=null) queue.offer(currentTreeNode.left);
            if(currentTreeNode.right!=null) queue.offer(currentTreeNode.right);
        }
        int[] a = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            a[i] = res.get(i);
        }
        return a;
    }


    /***
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印
     * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     *
     * 例如:
     * 给定二叉树:[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if(root==null) return ans;

        Queue<TreeNode> nodeQueue = new LinkedList<>();  // 双端队列

        nodeQueue.offer(root);

        boolean isOrderLeft = true;

        while(!nodeQueue.isEmpty()){
            Deque<Integer> level = new LinkedList<>(); // 双端队列
            int currentLevelSize = nodeQueue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft){
                    level.offerLast(curNode.val);
                } else {
                    level.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new ArrayList<>(level));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }


    /***
     * 剑指 Offer 26. 树的子结构
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * 例如:
     * 给定的树 A:
     *
     *   3
     *   / \
     *  4   5
     * / \
     * 1  2
     * 给定的树 B：
     *
     *  4
     *  /
     * 1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if(A == null || B == null){
            return false;
        }

        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    private boolean recur(TreeNode A, TreeNode B) {
        // 若B走完了,说明查找完毕,B为A的子结构
        if(B == null) {
            return true;
        }
        // 若B不为空并且A为空或者A与B的值不相等,直接可以判断B不是A的子结构
        if(A == null || A.val != B.val) {
            return false;
        }
        // 当A与B当前节点值相等,若要判断B为A的子结构
        // 还需要判断B的左子树是否为A左子树的子结构 && B的右子树是否为A右子树的子结构
        // 若两者都满足就说明B是A的子结构,并且该子结构以A根节点为起点
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    /***
     * 剑指 Offer 27. 二叉树的镜像
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * 例如输入：
     *
     *   4
     *  /  \
     *  2   7
     * / \  / \
     * 1  3 6  9
     * 镜像输出：
     *
     *   4
     *  /  \
     *  7   2
     * / \  / \
     * 9  6 3 1
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null) stack.add(node.right);
            if(node.left != null) stack.add(node.left);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        Solution solution = new Solution();
        boolean repeatNumber = solution.findNumberIn2DArray(a,20);
        System.out.println(repeatNumber);
    }

}
