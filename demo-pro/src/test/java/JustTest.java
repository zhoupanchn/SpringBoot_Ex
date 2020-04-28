public class JustTest {
    public static int getNFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * getNFactorial(n - 1);
    }

    public static void change(String s) {
        s = s + "world";
    }

    public static void main(String[] args) {
        /*System.out.println("第1个月的兔子总数：2");
        System.out.println("第2个月的兔子总数：2");
        int f1 = 2, f2 = 2, f, M = 12;
        for (int i = 3; i <= M; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            System.out.println("第" + i + "个月的兔子总数: " + f2);
        }*/
        /*int nFactorial = getNFactorial(3);
        System.out.println(nFactorial);*/
        String str = "Hello";
        change(str);
        System.out.println(str);
    }
}
