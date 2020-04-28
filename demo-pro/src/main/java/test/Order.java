package test;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by zhoupanchn on 2019/11/13.
 */
/*@Getter
@Setter*/
public class Order {
    private Integer    id;
    private String     orderCode;
    private BigDecimal orderPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderCode=" + orderCode + ",orderPrice=" + orderPrice + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Order order = (Order) obj;
        return this.orderCode.equals(order.getOrderCode()) && (this.id == order.getId());
    }

    @Override
    public int hashCode() {
        String str = this.orderCode + this.id;
        return str.hashCode();
    }

}
