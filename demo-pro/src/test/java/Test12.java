public class Test12 {
    public static void main(String[] args) {
        AAA a=new BBB();
        ((BBB) a).p();
        a.prin();
        new AAA() {
            @Override
            public void prin() {
                System.out.println("CCC");
            }
        };
    }
}
