/*
 * CreatenewtoppingController.java, created by Oliver Souter 2004076
 * Component 2 Part 1 - 06/1/2022
 */
package uk.ac.rgu.cm2100.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import uk.ac.rgu.cm2100.MainApp;
import uk.ac.rgu.cm2100.model.PizzaTopping;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class CreatenewtoppingController implements Initializable {
    @FXML
    private Button btnAddToMenu;
    @FXML
    private Button btnBackToPizza;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrice;
    
    private PizzaTopping newTopping = new PizzaTopping();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void addToppingToMenu() throws IOException {
        newTopping.setName(txtName.getText());
        newTopping.setPrice(Integer.parseInt(txtPrice.getText()));
        MainApp.menu.addTopping(newTopping);
        MainApp.setRoot("/createpizza", MainApp.menu);
    }
    @FXML
    private void backToPizza() throws IOException {
        MainApp.setRoot("/createpizza", MainApp.menu);
        
    }
}
