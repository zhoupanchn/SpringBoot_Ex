package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoupanchn on 2020/3/25.
 */
public class OrderDemo {
    public static void main(String[] args) {
        List<Order> orders    = new ArrayList<>();
        String      orderCode = "orderCode";
        for (int i = 1; i <= 7; i++) {
            Order order = new Order();
            order.setId(i);
            order.setOrderCode(orderCode + i);
            order.setOrderPrice(new BigDecimal(i));
            orders.add(order);
        }

        for (Order o : orders) {
            if (o.getId() == 1) {
                orders.remove(o);
            }
        }
        System.out.println(orders);
        /*for (int j = 0; j < orders.size(); j++) {
            if (orders.get(j).getId() == 5||orders.get(j).getId() == 4) {
                int i = orders.indexOf(orders.get(j));
                System.out.println(i);
                orders.remove(orders.get(j));
            }
        }*/
       /* List<Order> orderList=new ArrayList<>(orders);
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order next = iterator.next();
            if (next.getId() == 5 || next.getId() == 4) {
                int i = orderList.indexOf(next);
                System.out.println(i);
                iterator.remove();
            }
        }
        System.out.println(orders);*/
    }
}
