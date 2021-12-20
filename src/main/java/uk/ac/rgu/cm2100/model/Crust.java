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
public enum Crust {
    
    THIN,
    THICK,
    STUFFED;
    
    public String toString(){
        return name().toLowerCase();
    }
}
