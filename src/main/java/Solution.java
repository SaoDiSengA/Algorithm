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


}
