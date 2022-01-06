/*
 * Pizza.java, edited by Oliver Souter 2004076
 * Component 2 Part 1 - 4/1/2022
 */
package uk.ac.rgu.cm2100.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mark
 */
public class Pizza extends Model implements IMenuItem{

    private String name;
    private Crust crust;
    private List<PizzaTopping> toppings;
    
    private final int BASE_PRICE = 200; //base price for all pizzas before toppings
    
    public Pizza(){
        this.name = name;
        this.crust = crust;
        this.toppings = new ArrayList<>();
    }
    
    public void addToppings(PizzaTopping... toppings){
        this.toppings.addAll(Arrays.asList(toppings));
    }
    
    @Override
    public int price(){
        
        int price = BASE_PRICE;
        
        for(PizzaTopping topping : this.toppings){
            price += topping.getPrice();
        }      
        
        return price;
    }

    @Override
    public String name() {
        return this.name;
    }
    public Crust crust() {
        return this.crust;
    }
    

    @Override
    public String description() {
        String toReturn = "Pizza: " + this.name + "\t" + this.price() + "p\n" + "Crust: " + this.crust + "\nToppings: ";
        
        for(PizzaTopping topping : this.toppings){
            toReturn += topping + ", ";
        }
        
        toReturn = toReturn.substring(0, toReturn.length() - 2);
        return toReturn;
    }
    
    @Override
    public String toString(){
        return this.name + " - " + this.price() + "p";
    }
    
    public void setCrust(Crust newCrust) {
        this.crust = newCrust;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    
}
