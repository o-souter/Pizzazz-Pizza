/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    private List<IMenuItem> items;
    
    public Order(){
        this.items = new ArrayList<>();
    }
    
    public void addItem(IMenuItem item){
        this.items.add(item);
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
        String toReturn = "";
        
        for(IMenuItem item : this.items){
            toReturn += item + "\n";        
        }
        
        toReturn += "Total:\t" + this.total() + "p";
        
        return toReturn;
    }
}
