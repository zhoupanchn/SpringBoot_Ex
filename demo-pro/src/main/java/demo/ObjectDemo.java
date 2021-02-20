package demo;

/**
 * Created by zhoupanchn on 2019/11/6.
 */
public class ObjectDemo {
    public static void main(String[] args) {
        String[] str    = new String[]{"1", "2"};
        String   length = ObjectUtils.length(str);
        System.out.println(length);
    }
}
