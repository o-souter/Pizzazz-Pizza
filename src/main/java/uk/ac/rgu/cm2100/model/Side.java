/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        return this.name + "\t" + this.price + "p";
    }
        
    @Override
    public String toString(){
        return this.description();
    }

}
