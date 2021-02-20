package demo;

/**
 * Created by zhoupanchn on 2019/11/6.
 */
public class ObjectUtils {
    public static String length(Object o) {
        String aClass = o.getClass().getTypeName();
        return aClass;
    }
}
