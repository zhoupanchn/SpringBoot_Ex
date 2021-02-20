package demo.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by zhoupanchn on 2020/2/25.
 */
public class ListDemo {
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<String>();
        list.add("11");
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");
        list.add("16");
        System.out.println("原始list元素：" + list.toString());
        *//*CopyOnWriteArrayList<String> copyList = new CopyOnWriteArrayList<>(list);
        //通过对象移除等于11的元素
        for (String item : copyList) {
            if ("11".equals(item)) {
                copyList.remove(item);
            }
        }
        System.out.println("通过对象移除后的list元素：" + copyList.toString());*//*

        //通过迭代器移除等于11的元素
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("11".equals(item)) {
                iterator.remove();
            }
        }
        System.out.println("通过迭代器移除后的list元素：" + list.toString());*/
        String str = "1234567";
        System.out.println(reverse(str));
    }

    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
