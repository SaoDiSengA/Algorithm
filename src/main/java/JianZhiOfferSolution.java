
import java.util.*;

public class JianZhiOfferSolution {

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
            if (i < n) {
                temp.append(s.charAt(i));
            } else {
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int a : map.keySet()) {
            if (map.get(a) > 1) {
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
            if (nums[i] == target) {
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
        while (row >= 0 && row < matrix.length && col >= 0 && col <= matrix[0].length) {
            if (target < matrix[row][col]) {
                col--;
                continue;
            }
            if (target > matrix[row][col]) {
                row++;
                continue;
            }
            if (target == matrix[row][col]) {
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
            if (numbers[i] < numbers[i - 1]) {
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
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            int integer = map.get(s.charAt(i));
            if (integer == 1) return s.charAt(i);
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

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
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
    public int[] levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        int[] level = new int[]
        List<Integer> res = new ArrayList<>();
        if (root == null) return new int[]{};
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentTreeNode = queue.poll();
            res.add(currentTreeNode.val);
            if (currentTreeNode.left != null) queue.offer(currentTreeNode.left);
            if (currentTreeNode.right != null) queue.offer(currentTreeNode.right);
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
    public List<List<Integer>> levelOrder2(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<TreeNode> nodeQueue = new LinkedList<>();  // 双端队列

        nodeQueue.offer(root);

        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> level = new LinkedList<>(); // 双端队列
            int currentLevelSize = nodeQueue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
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

        if (A == null || B == null) {
            return false;
        }

        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode A, TreeNode B) {
        // 若B走完了,说明查找完毕,B为A的子结构
        if (B == null) {
            return true;
        }
        // 若B不为空并且A为空或者A与B的值不相等,直接可以判断B不是A的子结构
        if (A == null || A.val != B.val) {
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
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

    /***
     * 剑指 Offer 28. 对称的二叉树
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /***
     * 剑指 Offer 10- I. 斐波那契数列
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     * 输入：n = 2
     * 输出：1
     *
     * 示例 2：
     * 输入：n = 5
     * 输出：5
     *
     * @param n
     * @return
     *
     */
    public int fib(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }


    /***
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     *
     * 输入：n = 0
     * 输出：1
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0) return 0;
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    /***
     * 剑指 Offer 63. 股票的最大利润
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                if (temp > max) max = temp;
            }
        }
        return max;

    }

    public int maxProfit1(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;

    }

    /***
     * 剑指 Offer 42. 连续子数组的最大和
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
     * 示例1:
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    /***
     * 剑指 Offer 47. 礼物的最大价值
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     *示例 1:
     *
     * 输入:
     * [
     *  [1,3,1],
     *  [1,5,1],
     *  [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     *
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int n = grid.length;
        ;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[n - 1][m - 1];
    }


    /***
     * 剑指 Offer 46. 把数字翻译成字符串
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *
     * 示例 1:
     *
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     *
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String s = num + ""; //String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i); //最后一个不算，处理i-2 i-1
            System.out.println(tmp);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;

        /***
         *     public int translateNum(int num) {
         *         String s = num + "";
         *         int[] dp = new int[s.length()];
         *         if(s.length() < 2) return s.length();
         *         dp[0] = 1;
         *         for(int i = 1;i < s.length();i++){
         *             int pre = Integer.parseInt(String.valueOf(s.charAt(i-1)));
         *             int cur = Integer.parseInt(String.valueOf(s.charAt(i)));
         *             if(pre == 1) dp[i] = dp[i-1] + 1;
         *             else if(pre == 2 && cur <= 5) dp[i] = dp[i-1] + 1;
         *             else dp[i] = dp[i-1];
         *         }
         *         return dp[s.length()-1];
         *     }
         */
    }

    /***
     * 剑指 Offer 48. 最长不含重复字符的子字符串
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, temp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1);
            dic.put(s.charAt(j), j);
            temp = temp < j - i ? temp + 1 : j - i;
            res = Math.max(res, temp);
        }
        return res;

    }

    /***
     * 剑指 Offer 18. 删除链表的节点
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * 示例 1:
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    /***
     * 剑指 Offer 22. 链表中倒数第k个节点
     *
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     *
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
//        int size = 0;
//        ListNode p = head;
//        while(p != null){
//            size++;
//            p = p.next;
//        }
//        int temp = size - k;
//        while(temp > 0){
//            --temp;
//            head = head.next;
//        }
//        return head;
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            head = head.next;
        }
        return head;
    }

    /***
     * 剑指 Offer 25. 合并两个排序的链表
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 示例1：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        ListNode nodeNew = new ListNode(0);
        ListNode nodeNew_tail = nodeNew;
        ListNode l1_cur = l1;
        ListNode l2_cur = l2;
        while (l1 != null && l2 != null) {
            if (l1_cur.val < l2_cur.val) {
                l1 = l1_cur.next;
                nodeNew_tail.next = l1_cur;
                l1_cur = l1;
            } else {
                l2 = l2_cur.next;
                nodeNew_tail.next = l2_cur;
                l2_cur = l2;
            }
            nodeNew_tail = nodeNew_tail.next;
        }
        if (l2 != null) {
            nodeNew_tail.next = l2;
        }
        if (l1 != null) {
            nodeNew_tail.next = l1;
        }
        return nodeNew.next;
    }

    /***
     *
     * 剑指 Offer 52. 两个链表的第一个公共节点
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     *
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> set = new HashSet<>();
        ListNode headA_tail = headA;
        ListNode headB_tail = headB;
        while (headA != null && headB != null) {
            headA_tail = headA_tail.next;
            headB_tail = headB_tail.next;
            if (!set.add(headA)) return headA;
            if (!set.add(headB)) return headB;
            headA = headA_tail;
            headB = headB_tail;
        }
        while (headA != null) {
            headA_tail = headA_tail.next;
            if (!set.add(headA)) return headA;
            headA = headA_tail;
        }
        while (headB != null) {
            headB_tail = headB_tail.next;
            if (!set.add(headB)) return headB;
            headB = headB_tail;
        }
        return null;
    }

    /***
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
//        int[] res = new int[nums.length];
//        List<Integer> odd_list = new ArrayList<>();
//        List<Integer> even_list = new ArrayList<>();
//        for (int num : nums){
//            if (num % 2 == 1) odd_list.add(num);
//            if (num % 2 == 0) even_list.add(num);
//        }
//        for (int i = 0; i < odd_list.size(); i++) {
//            res[i] = odd_list.get(i);
//        }
//        for (int i = odd_list.size(); i < res.length; i++) {
//            res[i] = even_list.get(i- odd_list.size());
//        }
//        return res;
        int i = 0;
        int j = nums.length - 1;
        int temp;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && (nums[j] & 1) == 0) j--;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    /***
     * 剑指 Offer 57. 和为s的两个数字
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * 示例 2：
     *
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

//        int[] res = new int[2];
//        int target1 = 0;
//        int target2 = 0;
//        for (int i = 0; i < nums.length; i++) {
//            target1 = nums[i];
//            target2 = target - nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target2) {
//                    res[0] = target1;
//                    res[1] = target2;
//                    return res;
//                }
//            }
//        }
//        return res;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) i++;
            else if (s > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }

    /***
     * @Description:
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     * 示例 1：
     *
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * 示例 2：
     *
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     *
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * @param: [s]
     * @return: java.lang.String
     * @Author: SaoDiSeng
     * @Date: 2023-03-76 21:40:57
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int i = s.length() - 1;
        int j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }

    /***
     * @Description: 剑指 Offer 12. 矩阵中的路径
     * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * 示例 1：
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：false
     * @param: [board, word]
     * @return: boolean
     * @Author: SaoDiSeng
     * @Date: 2023-03-77 21:04:44
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k]) return false;
        if (k == words.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i, j + 1, k + 1) ||
                dfs(board, words, i - 1, j, k + 1) || dfs(board, words, i, j - 1, k + 1);
        board[i][j] = words[k];
        return res;
    }


    /***
     * @Description:
     * @param: [m, n, k]
     * @return: int
     * @Author: SaoDiSeng
     * @Date: 2023-03-79 10:21:25
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int i = 0;
        int j = 0;
        return dfs(i, j, sums(i), sums(j), m, n, k, visited);
    }

    private int dfs(int i, int j, int si, int sj, int m, int n, int k, boolean[][] visited) {
        if (i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, sums(i + 1), sums(j), m, n, k, visited) + dfs(i, j + 1, sums(i), sums(j + 1), m, n, k, visited);
    }

    int sums(int x) {
        int s = 0;
        while (x != 0) {
            s += x % 10;
            x = x / 10;
        }
        return s;
    }


    /***
     * @Description: 剑指 Offer 34. 二叉树中和为某一值的路径
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：[]
     * 输入：root = [1,2], targetSum = 0
     * 输出：[]
     * @param: [root, target]
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     * @Author: SaoDiSeng
     * @Date: 2023-03-79 20:02:50
     */
    LinkedList<List<Integer>> resList = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return resList;
    }

    void recur(TreeNode root, int target) {
        if (root == null) return;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null)
            resList.add(new LinkedList<>(list));
        recur(root.left, target);
        recur(root.right, target);
        list.removeLast();
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    /***
     * @Description: 剑指 Offer 36. 二叉搜索树与双向链表
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     * 为了让您更好地理解问题，以下面的二叉搜索树为例：
     * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
     * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
     * @param: [root]
     * @return: JianZhiOfferSolution.Node
     * @Author: SaoDiSeng
     * @Date: 2023-03-79 21:29:00
     */
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        recur(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void recur(Node root) {
        if (root == null) return;
        recur(root.left);
        if (pre != null) pre.right = root;
        else head = root;
        root.left = pre;
        pre = root;
        recur(root.right);
    }

    /***
     * @Description: 剑指 Offer 54. 二叉搜索树的第k大节点
     * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
     * @param: [root, k]
     * @return: int
     * @Author: SaoDiSeng
     * @Date: 2023-03-79 21:54:20
     */
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
//    public int kthLargest(TreeNode root, int k) {
//        List<Integer> list = new ArrayList<>();
//        dfs(root);
//        return list.get(list.size() - k);
//    }
//
//    private void dfs(TreeNode root) {
//        if (root == null) return;
//        dfs(root.left);
//        list.add(root.val);
//        dfs(root.right);
//    }


    /***
     * @Description: 面试题45. 把数组排成最小的数
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 输入: [10,2]
     * 输出: "102"
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     * @param: [nums]
     * @return: java.lang.String
     * @Author: SaoDiSeng
     * @Date: 2023-03-80 17:31:55
     */
//    List<Integer> minNumberList = new ArrayList<>();
//    public String minNumber(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            sum(nums[i]);
//        }
//        Collections.sort(minNumberList);
//        String s = minNumberList.toString();
//        System.out.println(s);
//        s = s.replace(",","");
//        s = s.replace(" ","");
//        s = s.replace("[","");
//        s = s.replace("]","");
//        int m = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i)=='0'){
//                m++;
//            }else break;
//        }
//        String s1 = s.substring(0,m);
//        String s2 = s.substring(m,s.length());
//        return s2.substring(0,1)+s1+s2.substring(1,s2.length());
//    }
//    void sum(int x){
//        while(x != 0){
//            minNumberList.add(x % 10);
//            x = x / 10;
//        }
//    }
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs,0, strs.length-1);
        StringBuilder res = new StringBuilder();
        for(String s : strs) res.append(s);
        return res.toString();
    }
    void quickSort(String[] strs,int low,int high) {
        if (low > high) return;
        int left = low;
        int right = high;
        String pivot = strs[low];
        String temp = "";
        while (left < right) {
            while (left < right && (strs[right] + pivot).compareTo(pivot + strs[right]) >= 0) right--;
            while (left < right && (strs[left] + pivot).compareTo(pivot + strs[left]) <= 0) left++;
            if (left <= right) {
                temp = strs[left];
                strs[left] = strs[right];
                strs[right] = temp;
            }
        }
        strs[low] = strs[left];
        strs[left] = pivot;
        quickSort(strs, low, left - 1);
        quickSort(strs, left + 1, high);
    }


    /***
     * @Description: 1626. 无矛盾的最佳球队
     * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
     * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
     * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
     * 输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
     * 输出：34
     * 解释：你可以选中所有球员。
     * 输入：scores = [4,5,6,5], ages = [2,1,2,1]
     * 输出：16
     * 解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
     * @param: [scores, ages]
     * @return: int
     * @Author: SaoDiSeng
     * @Date: 2023-03-81 11:27:11
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] people = new int[n][2];
        for (int i = 0; i < n; ++i) {
            people[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < people.length; i++) {
            System.out.print(people[i][0]);
            System.out.println(people[i][1]);
        }
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /***
     * @Description:
     * @param: [head, left, right]
     * @return: ListNode
     * @Author: SaoDiSeng
     * @Date: 2023-03-82 19:47:15
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode head1 = new ListNode(0);
        head1.next = head;
        head = head1;
        ListNode pre = head;
        ListNode tail = head;
        ListNode a = head;
        ListNode b = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == left){
                while(pre.next != cur){
                    pre = pre.next;
                }
                a = cur; //进行头插法
                b = cur;
            }
            if(cur.val == right){
                tail = cur.next;
                cur.next = null;
            }
            cur = cur.next;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        while(a != null){ //头插
            a = a.next;
            b.next = newHead.next;
            newHead.next = b;
            b = a;
        }
        b = newHead;
        while(b.next!=null){
            b = b.next;
        }
        pre.next = newHead.next;
        b.next = tail;
        return head.next;
    }


    /***
     * @Description:
     * @param: [temperatures]
     * @return: int[]
     * @Author: SaoDiSeng
     * @Date: 2023-03-86 11:14:54
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0;i < temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > stack.peek()){
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }



    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n-1] = 0;
        for(int i = n - 2;i >= 0;i--){
            if(nums[i] > nums[i+1]){
                dp[i] = dp[i+1] + 1;
            }else dp[i] = dp[i+1];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(dp[i]);
        }
        return list;
    }

    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0;i < nums.length;i++){
            map.put(nums[i],map.getOrDefault(map.get(nums[i]),0)+1);
            System.out.println(map.get(nums[i]));
            if(map.get(nums[i]) >= 2) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }




    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        JianZhiOfferSolution jianZhiOfferSolution = new JianZhiOfferSolution();
        int[] repeatNumber = jianZhiOfferSolution.exchange(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(repeatNumber));
        String s = "    ni  ni ni ";
        String s1 = jianZhiOfferSolution.reverseWords(s);
        int count = jianZhiOfferSolution.movingCount(11, 8, 16);
        System.out.println(count);
        String s2 = jianZhiOfferSolution.minNumber(new int[]{3,30,34,5,9,3});
        System.out.println(s2);
        int i = jianZhiOfferSolution.bestTeamScore(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5});
        Map<Integer,Integer> map = new HashMap<>();
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        int left = 1;
        int right = 1;
        ListNode listNode = jianZhiOfferSolution.reverseBetween(head, left, right);


        char mychar = 'g';
        String mystring = Character.toString(mychar);
        System.out.println(mystring);
        mystring = String.valueOf(mychar);
        System.out.println(mystring);


        int[] ints = jianZhiOfferSolution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(ints);
        ArrayList<Integer> list = new ArrayList<>();
        list.trimToSize();


        int duplicate = jianZhiOfferSolution.findDuplicate(new int[]{2, 1, 1});
        System.out.println(duplicate);

    }

}
