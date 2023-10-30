package daily;

public class NoName {

    public int Calc (int n) {
        int cout = 0;

        for (int i = 1; i <= n; i+=2) {
            int sum = 0;
            for (int j = i; j <=n; j+=2) {
                sum += j;
                if(sum == n) {
                    cout++;
                    break;
                }
            }
        }
        return cout;
    }

    private int dfs(int i, int n,int target) {
        if(i > n) {
            return target == 0 ? 1 : 0;
        }
        if(target == 0) return 1;
        return dfs(i+2,n,target-i);


    }

    public static void main(String[] args) {
        NoName no = new NoName();
        System.out.println(no.Calc(17));
    }


    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int absent = 0;
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'A') absent++;
            if(chars[i] == 'L') {
                int num = 0;
                int j = i;
                while(j < chars.length && chars[j] == 'L'){
                    j++;
                    num++;
                }
                if(num >= 3) flag = true;
            }
        }
        return flag && absent < 2;
    }

}
