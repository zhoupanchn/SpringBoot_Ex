package demo;

import java.math.BigDecimal;

/**
 * Created by zhoupanchn on 2019/7/30.
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        /*BigDecimal b1       = new BigDecimal("49.14");
        BigDecimal b2       = new BigDecimal("37.44");
        Integer    i        = 96;
        BigDecimal decimal1 = b1.multiply(new BigDecimal(i.toString())).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal decimal2 = b2.multiply(new BigDecimal(i.toString())).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal decimal  = decimal1.add(decimal2).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(decimal);*/
        long l=30 * 24 * 60 * 60L;
        System.out.println(l);
    }
}
