/*
 * PizzaTopping.java, edited by Oliver Souter 2004076
 * Component 2 Part 1 - 4/1/2022
 */
package uk.ac.rgu.cm2100.model;

/**
 *
 * @author mark
 */
public class PizzaTopping {
   
    private String name;
    private int price;
    
    public PizzaTopping(){
        this.name = name;
        this.price = price;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    
    public void setPrice(int newPrice) {
        this.price = newPrice;
    }
            
    
    
    public int getPrice(){
        return this.price;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public String getDescription() {
        return this.name + " - " +  this.price;
    }
}
