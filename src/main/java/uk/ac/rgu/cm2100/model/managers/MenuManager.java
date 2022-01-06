/*
 * Menumanager.java, edited by Oliver Souter 2004076
 * Component 2 Part 1 - 04/1/2022
 */
package uk.ac.rgu.cm2100.model.managers;

import java.util.ArrayList;
import java.util.List;
import uk.ac.rgu.cm2100.model.Crust;
import uk.ac.rgu.cm2100.model.Model;
import uk.ac.rgu.cm2100.model.IMenuItem;
import uk.ac.rgu.cm2100.model.Pizza;
import uk.ac.rgu.cm2100.model.PizzaTopping;

/**
 *
 * @author mark
 */
public class MenuManager extends Model {
    
    private List<IMenuItem> items;
    private List<IMenuItem> pizzas;
    private List<IMenuItem> drinks;
    private List<IMenuItem> sides;
    private List<Crust> crusts;
    
    private List<PizzaTopping> availableToppings;
    
    public MenuManager(){
        this.items = new ArrayList<>();
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.availableToppings = new ArrayList<>();
        this.crusts = new ArrayList<>();
    } 
    
    public void addPizza(Pizza pizza){
        this.items.add(pizza);  
        this.pizzas.add(pizza);
        this.crusts.add(pizza.crust());
        
    }
    public void addDrink (IMenuItem drink) {
        this.items.add(drink);
        this.drinks.add(drink);
    }
    public void addSide (IMenuItem side) {
        this.items.add(side);
        this.sides.add(side);
    }
    public void deleteItem(IMenuItem item) {
        this.items.remove(item);
        if (item.description().contains("Pizza")) {
            this.pizzas.remove(item);
        }
        else if (item.description().contains("Drink")) {
            this.drinks.remove(item);
        }
        else if (item.description().contains("Side")){
            this.sides.remove(item);
        }
        
    }
    public List<IMenuItem> getItems(){
        return this.items;
    }
    public List<IMenuItem> getPizzas() {
        return this.pizzas;
    }
    public List<IMenuItem> getDrinks() {
        return this.drinks;
    }
    public List<IMenuItem> getSides() {
        return this.sides;
    }
    
    
    
    public void addTopping(PizzaTopping topping){
        this.availableToppings.add(topping);
    }
    
    public List<PizzaTopping> getToppings(){
        return this.availableToppings;
    }
    public List<Crust> getCrusts() {
        return this.crusts;
    }
}
