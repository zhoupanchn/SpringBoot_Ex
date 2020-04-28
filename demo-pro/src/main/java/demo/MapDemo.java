package demo;

import java.util.*;

/**
 * Created by zhoupanchn on 2019/9/10.
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map =new HashMap<>();
        map.put("1","1");
        map.put("tj","2");
        map.put("k","r");
        map.put("4","4");
        Set<String>  strings = map.keySet();
        List<String> result  = new ArrayList<>(strings);
        for(String s:result){
            System.out.println(s);
        }
        List<String> valueList=new ArrayList<>(map.values());
        for (String s:valueList){
            System.out.println(s);
        }
    }
}
