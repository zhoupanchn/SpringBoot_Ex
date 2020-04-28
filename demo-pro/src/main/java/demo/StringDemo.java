package demo;

import java.io.File;

/**
 * Created by zhoupanchn on 2019/8/14.
 */
public class StringDemo {
    public static void main(String[] args) {
//        String str ="";
//        System.out.println(str.length());
        /*File f =new File("E:\\Projects\\gycmall\\shop-web\\src\\main\\resources\\static\\file\\国内采购订单明细表.xlsx");
        boolean exists = f.exists();
        System.out.println(exists);*/
        String a = "Programming";
        String b = new String("Programming");
        String c = "Program" + "ming";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.intern() == b.intern());
    }
}
