import java.util.Scanner;

public class ChooseClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //总共课程 1-n
        int m = scanner.nextInt(); //总共学院1-m
        int q = scanner.nextInt(); //处理的请求
        int[] info = new int[n]; //学院开设情况
        for (int i = 0; i < n; i++) {
            info[i] = scanner.nextInt();
        }
        int[][] fij = new int[4][n];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                fij[i][j] = scanner.nextInt();
            }
        } //行表示年级，01表示能否选列课程
        int[][] gij = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gij[i][j] = scanner.nextInt();
            }
        } // 代表学院是否能选j课程
        int[][] question = new int[q][3];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 3; j++) {
                question[i][j] = scanner.nextInt();
            }
        } // 学院+年级+待选课程
        for (int i = 0; i < q; i++) {  //处理每个请求
            int school = question[i][0];
            int grade = question[i][1];
            int chooseClass = question[i][2];
            boolean grade_allow = fij[grade - 1][chooseClass - 1] == 1;
            boolean school_allow = gij[school - 1][chooseClass - 1] == 1;
            if (grade_allow && school_allow) {
                System.out.println("Help yourself");
            } else {
                if (info[chooseClass - 1] == school) {
                    System.out.println("Ask for help");
                } else {
                    System.out.println("Impossible");
                }
            }
        }
    }
}

//        5 2 4
//        1 2 2 1 1
//        1 0 0 0 0
//        0 0 1 1 1
//        0 0 0 0 1
//        0 0 1 0 1
//        1 0 0 1 1
//        0 1 0 0 0
//        2 2 3
//        2 3 2
//        2 3 1
//        1 2 4

//            对第一个查询，3号课程不限制2年级学生自行选课，但限制2号学院的学生选课，因此该学生不能自行选课。幸运的是，3号课程是2号学院开设的课程，因此该学生可以找2号学院教务处帮忙代选。
//
//            对第二个查询，2号课程不限制2号学院的学生自行选课，但限制3年级学生选课，因此该学生不能自行选课。同样的，2号课程由2号学院开设，可以找2号学院教务处代选。
//
//            对第三个查询，1号课程限制2号学院和3年级学生自行选课，因此该学生不能自行选课。由于开课学院是1学院，2学院教务科没有添加权限；由于学生学院是2学院，1学院没有查看学生信息的权限，因此该学生被踢皮球。
//
//            对第四给查询，4号课程不限制1号学院和2年级学生自行选课。