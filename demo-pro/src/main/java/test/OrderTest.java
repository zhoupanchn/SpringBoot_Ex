package test;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zhoupanchn on 2019/11/13.
 */
public class OrderTest {
    public static void main(String[] args) {
        List<Order> orders    = new ArrayList<>();
        List<Order> orders1   = new ArrayList<>();
        List<Order> orders2   = new ArrayList<>();
        String      orderCode = "orderCode";
        for (int i = 1; i <= 3; i++) {
            Order order = new Order();
            order.setId(i);
            order.setOrderCode(orderCode + i);
            order.setOrderPrice(new BigDecimal(i));
            orders.add(order);
        }
        for (int i = 2; i <= 4; i++) {
            Order order = new Order();
            order.setId(i);
            order.setOrderCode(orderCode + i);
            order.setOrderPrice(new BigDecimal(i));
            orders1.add(order);
        }
        orders2.addAll(orders);
        orders2.addAll(orders1);

        //使用HashSet,无序
        /*Set<Order> userSet = new HashSet<Order>();
        userSet.addAll(orders);
        userSet.addAll(orders1);
        System.out.println(userSet);*/

        for (Order order : orders2) {
            List<Order> collect = orders2.stream().filter(Order -> order.getOrderCode().equals(order.getOrderCode())).collect(Collectors.toList());
        }

        //使用LinkedHashSet，有序
        List<Order> listNew = new ArrayList<Order>(new LinkedHashSet<>(orders2));
        System.out.println(listNew.toString());
        //System.out.println(orders2.toString());
        /*Map<String, List<Order>> orderMap = orders.stream().collect(Collectors.groupingBy(Order::getOrderCode));
        orders.clear();
        orderMap.forEach((key, value) -> {
            BigDecimal decimal = value.stream().map(v -> v.getOrderPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
            value.forEach(v -> v.setOrderPrice(decimal));
            orders.add(value.get(0));
        });
        orders.sort(Comparator.comparing(Order::getOrderPrice).reversed());
        *//*for (Order o : orders) {
            System.out.println(o.getId() + "：" + o.getOrderCode() + "：" + o.getOrderPrice());
        }*//*

        Map<String, BigDecimal> map = orders.stream().collect(Collectors.toMap(Order::getOrderCode, Order::getOrderPrice));
//        map.forEach((key,value)-> System.out.println(key+":"+value));
        for (Map.Entry<String, BigDecimal> m : map.entrySet()) {
            System.out.println(m.getKey() + "：" + m.getValue());
        }*/

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "3");
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + ":" + next.getValue());
        }
    }
}
