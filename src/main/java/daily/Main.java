package daily;

import java.util.*;

public class Main {

    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = nums[i] * nums[j];
                map.put(key,map.getOrDefault(key,0)+1);
            }
        }
        int ans = 0;
        for (Integer v : map.values()){
            ans += (v * (v-1)) / 2 * 8;   // c(2,n);
        }

        boolean flag = false;
        System.out.println(flag);
        return ans ;

    }

    static int sum = 0;
    static int sum2(int...nums){

        for (int i : nums){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum2(1,2,3,4));;

        System.out.println();
        boolean flag = false;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(null,null);
        map.put(null,123);
        Map<Integer,Integer> map1 = new Hashtable<>();
        map.put(null,123);
        System.out.println(map.get(null));
        System.out.println(flag);

        String str = new String("123");

        String str1 = new String("456");



        System.out.println(str==str1);
        System.out.println(str == "123");


//        for (int i = -5; i < 10; i++) {
//            try {
//                int q = 1 / i;
//                System.out.println("haha"+i);
//            }catch (Exception e){
//                System.out.println("cuowu");
//            }finally {
//                System.out.println("zuihou ");
//            }
//        }



    }


}
