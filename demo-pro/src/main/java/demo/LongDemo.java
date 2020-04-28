package demo;

/**
 * Created by zhoupanchn on 2020/3/11.
 */
public class LongDemo {
    public static void main(String[] args) {
        Long l1=new Long(3L);
        Long l2=new Long(2L);
        Integer i1=new Integer(1212);
        Integer i2=new Integer(12);
        System.out.println(i1.compareTo(i2));
        System.out.println(l1.longValue()>l2.longValue());

    }
}
