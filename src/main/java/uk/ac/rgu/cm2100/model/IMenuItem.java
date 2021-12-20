/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.rgu.cm2100.model;

import java.util.Comparator;

/**
 *
 * @author mark
 */
public interface IMenuItem extends Comparable<IMenuItem> {
    public int price();
    public String name();
    public String description();
    
    @Override
    default int compareTo(IMenuItem o){
        return this.name().compareTo(o.name());
    }
    
    public class PriceComparator implements Comparator<IMenuItem>{

        @Override
        public int compare(IMenuItem o1, IMenuItem o2) {
            return o1.price() - o2.price();
        } 
    }
}
