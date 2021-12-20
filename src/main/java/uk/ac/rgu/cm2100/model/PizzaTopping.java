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
public class PizzaTopping {
   
    private String name;
    private int price;
    
    public PizzaTopping(String name, int price){
        this.name = name;
        this.price = price;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getPrice(){
        return this.price;
    }
}
