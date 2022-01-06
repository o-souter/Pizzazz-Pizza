/*
 * Side.java, edited by Oliver Souter 2004076
 * Component 2 Part 1 - 5/1/2022
 */
package uk.ac.rgu.cm2100.model;

/**
 *
 * @author mark
 */
public class Side implements IMenuItem {

    private String name;
    private int price;
    
    public Side(String name, int price){
        this.name = name;
        this.price = price;
    } 
    
    @Override
    public int price() {
        return this.price;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String description() {
        return "Side: " + this.name + " - " + this.price + "p";
    }
        
    @Override
    public String toString(){
        return this.name + " - " + this.price() + "p";
    }

}
