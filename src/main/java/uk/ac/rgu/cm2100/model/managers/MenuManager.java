/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.rgu.cm2100.model.managers;

import java.util.ArrayList;
import java.util.List;
import uk.ac.rgu.cm2100.model.Model;
import uk.ac.rgu.cm2100.model.IMenuItem;
import uk.ac.rgu.cm2100.model.PizzaTopping;

/**
 *
 * @author mark
 */
public class MenuManager extends Model {
    
    private List<IMenuItem> items;
    
    private List<PizzaTopping> availableToppings;
    
    public MenuManager(){
        this.items = new ArrayList<>();
        this.availableToppings = new ArrayList<>();
    }
    
    public void addItem(IMenuItem item){
        this.items.add(item);
    }
    
    public List<IMenuItem> getItems(){
        return this.items;
    }
    
    public void addTopping(PizzaTopping topping){
        this.availableToppings.add(topping);
    }
    
    public List<PizzaTopping> getToppings(){
        return this.availableToppings;
    }
}
