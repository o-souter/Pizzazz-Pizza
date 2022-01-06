/*
 * Order.java, edited by Oliver Souter 2004076
 * Component 2 Part 1 - 5/1/2022
 */
package uk.ac.rgu.cm2100.model.managers;

import java.util.ArrayList;
import java.util.List;
import uk.ac.rgu.cm2100.model.Model;
import uk.ac.rgu.cm2100.model.Order;

/**
 *
 * @author mark
 */
public class OrderManager extends Model {
    
    private List<Order> orders;
    private List<String> orderNames;
    
    public OrderManager(){
        this.orders = new ArrayList<>();
        this.orderNames = new ArrayList<>();
    }
    
    public void addOrder(Order order){
        this.orders.add(order);
        this.orderNames.add(order.getOrderName());
    }
    public List<String> getOrderNames() {
        return this.orderNames;
    }
    public List<Order> getOrders(){
        return this.orders;
    }
}
