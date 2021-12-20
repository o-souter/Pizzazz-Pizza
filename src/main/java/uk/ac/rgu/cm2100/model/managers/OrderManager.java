/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public OrderManager(){
        this.orders = new ArrayList<>();
    }
    
    public void addOrder(Order order){
        this.orders.add(order);
    }
    
    public List<Order> getOrders(){
        return this.orders;
    }
}
