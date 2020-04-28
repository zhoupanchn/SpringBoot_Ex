import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zhoupanchn on 2019/3/29.
 */
public class DDDD {
    /*//按每3个一组分割
    private static final Integer MAX_SEND = 3;

    public static void main(String[] args) {
        List<Integer> list  = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int           limit = countStep(list.size());
        //方法一：使用流遍历操作
        List<List<Integer>> mglist = new ArrayList<>();
        Stream.iterate(0, n -> n + 1).limit(limit).forEach(i -> {
            mglist.add(list.stream().skip(i * MAX_SEND).limit(MAX_SEND).collect(Collectors.toList()));
        });

        System.out.println(mglist);

        //方法二：获取分割后的集合
        List<List<Integer>> splitList = Stream.iterate(0, n -> n + 1).limit(limit).parallel().map(a -> list.stream().skip(a * MAX_SEND).limit(MAX_SEND).parallel().collect(Collectors.toList())).collect(Collectors.toList());

        System.out.println(splitList);
    }

    */

    /**
     * 计算切分次数
     *//*
    private static Integer countStep(Integer size) {
        return (size + MAX_SEND - 1) / MAX_SEND;
    }*/
    public static void main(String[] args) {
        List<String> list  = new ArrayList();
        List<String> list1 = new ArrayList();
        list.add("AAA");
        list.add("2");
        list.add("3");
        list.add("AA");
        list.add("BBBB");
        list.add("BB");
        list.add("CCC");
        list.add("CC");
        list.add("KK");
        list.add("GG");
        list.add("AA");
        list.add("BB");
        list.add("CCC");
        list1.add("AA");
        list1.add("AA");
        list1.add("AA");
        /*for (String l : list1) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                list.remove(l);
            }
        }*/
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        //System.out.println(Collections.min(list2));

        /*String       str      = ",A,B,C";
        List<String> strings  = Arrays.asList(str.split(","));
        List<String> strings1 = new ArrayList<>();
        List<String> strings1 = strings.subList(0, strings.size()-1);
        for (String s : strings) {
            strings1.add("AS:" + s);
        }
        String    count   = String.valueOf(list2.stream().distinct().count());
        System.out.println(Integer.valueOf(count));
        Integer integer = list2.get(0);
        integer += 5;
        for (Integer d : list2) {
            System.out.println(d);
        }*/
        //System.out.println(strings.get(0));

        String join = String.join("/", list);
        System.out.println(join);
        /*byte b = (byte) 1;
        System.out.println(b);*/

    }
}
