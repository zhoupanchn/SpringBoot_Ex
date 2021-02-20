import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Tests {
    public static void main(String[] args) {

        /*LocalTime now = LocalTime.of(0, 0, 3);
        System.out.println(LocalTime.now());
        System.out.println("本次获取的配额信息失败，渠道：，账户名：接口名类型：" + "；\n" + "1234567890");


        String[] str = null;
        String   s   = Arrays.toString(str);
        System.out.println(s);
        List<String> regionList = JSONObject.toJavaObject(JSONArray.parseArray(null), List.class);
        for (String se : regionList) {
            System.out.println("+++"+se);
        }*/
        /*List<String> lists = new ArrayList<>();
        lists.add("123");
        lists.add("234");
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            for (String list:lists){
                System.out.println("list:"+list);
            }
            lists.add(e.getMessage());
        }
        lists.add("000");
        lists.add("456");
        lists.add("345");
        for (String list : lists) {
            if (list.equals("000")) {
                continue;
            }
            System.out.println(list);
        }*/
       /* User user = new User();
        user.setUsername("xiaoxaio");
        user.setEmail("12345");
        //user.setState(User.State.Bad);
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            user.setAddress(e.getMessage());
        } finally {
            if (user.getAddress() != null) {
                System.out.println(user.getUsername() + ":" + user.getEmail() + ":" + user.getAddress());
                System.out.println(user.getState()==null);
            } else {
                System.out.println(user.getState()==null);
                System.out.println(user.getUsername() + ":" + user.getEmail() + ":" + user.getAddress());
            }
        }*/
        /*String[] strings = new String[]{"123", "Cno", "Bon", "Zho"};
        Arrays.sort(strings);
        for (String str : strings) {
            System.out.println(str);
        }*/
        List<Object> list = new LinkedList<>();
        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj1.compareTo(obj2);
                    }
                });
        map.put("serverUrl", "Hello");
        map.put("token", "2");
        map.put("tplId", "3");
        map.put("userType", "4");
        map.put("sync", "5");
        map.put("tamp", "6");
        Iterator<String> values = map.values().iterator();
        while (values.hasNext()) {
            String next = values.next();
            System.out.println(next);
            list.add(next);
        }
        Object[] obj = list.toArray();
        System.out.println(Arrays.toString(obj));
        /*Set<String>      keySet = map.keySet();
        Iterator<String> iter   = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key+"："+map.get(key));
            list.add(map.get(key));
        }
        for (Object l:list){
            System.out.println(l);
        }*/

        String[]           string     = {"1", "2"};
        String[]           strings    = {"Hello", "World", "Beijing"};
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("halgh");
        linkedList.add("Hello");
        linkedList.add("World");
        linkedList.add("Beijing");
        Object[] objects = linkedList.toArray();
        String   join    = StringUtils.join(string, "_") + StringUtils.join(strings, "_");
        System.out.println(join);

        String s = DigestUtils.shaHex(join);
        System.out.println(s.toUpperCase());
        System.out.println(Arrays.toString(objects));
    }
}
