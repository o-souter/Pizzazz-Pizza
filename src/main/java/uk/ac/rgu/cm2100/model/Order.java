/*
 * Order.java, edited by Oliver Souter 2004076
 * Component 2 Part 1 - 4/1/2022
 */
package uk.ac.rgu.cm2100.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import uk.ac.rgu.cm2100.model.IMenuItem.PriceComparator;

/**
 *
 * @author mark
 */
public class Order implements IOrder {
    private String name;
    private List<IMenuItem> items;
    private List<IMenuItem> itemsToAdd;
    
    public Order(){
        this.items = new ArrayList<>();
        this.itemsToAdd = new ArrayList<>();
    }
    
    public void addItem(IMenuItem item){
        this.items.add(item);
    }
    public void addItems(List<IMenuItem> itemsToAdd) {
        for (int i = 0; i <itemsToAdd.size(); i++) {
            this.items.add(itemsToAdd.get(i));
        }
    }
    public List getItems() {
        return this.items;
    }
    
    public void setOrderName(String name) {
        this.name = name;
    }
    public String getOrderName() {
        return this.name;
    }
    
    public void sortByName(){
        Collections.sort(this.items);
    }
    
    public void sortByPrice(){
        this.items.sort(new PriceComparator());
    }
    
    public int total(){
        int total = 0;
        
        for(IMenuItem item : this.items){
            total += item.price();
        }
        
        return total;
    }
    
    public void saveToFile(String name){
        try{
            FileWriter writer = new FileWriter(name + ".txt");
            
            String toWrite = "";
            
            for(IMenuItem item : this.items){
                toWrite += item.getClass().getSimpleName().toUpperCase() + ","
                        + item.name() + "," + item.price() + "\n";
            }
            
            System.out.println(toWrite);
            
            
            writer.write(toWrite);
            writer.close();
        }catch(IOException ex){
            
        }
    }
    
    @Override
    public String toString(){
        String toReturn = this.name + "\n";
        
        for(IMenuItem item : this.items){
            toReturn += item + "\n";        
        }
        
        toReturn += "Total:\t" + this.total() + "p";
        
        return toReturn;
    }
}
