/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.rgu.cm2100.controllers;

import uk.ac.rgu.cm2100.model.Model;

/**
 * Provides a base class that JavaFX controllers can extend to support a 
 * simple MVC architecture
 * @author mark
 * @param <T> a concrete model type
 */
public abstract class Controller<T extends Model> {
    
    protected T model;
    
    public abstract void setModel(T model);
    
}
