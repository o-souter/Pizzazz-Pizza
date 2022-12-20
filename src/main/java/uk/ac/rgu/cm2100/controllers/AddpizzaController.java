/*
 * Addpizzacontroller.java, created by Oliver Souter
 * Component 2 Part 1 - 4/1/2022
 */
package uk.ac.rgu.cm2100.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import uk.ac.rgu.cm2100.MainApp;
import uk.ac.rgu.cm2100.model.IMenuItem;
import uk.ac.rgu.cm2100.model.Pizza;
import uk.ac.rgu.cm2100.model.managers.MenuManager;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class AddpizzaController extends Controller<MenuManager> implements Initializable {
    @FXML
    private ListView listPizzas;
    @FXML
    private Button btnAddToOrder;
    
    Pizza selected = new Pizza();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @Override
    public void setModel(MenuManager model) {
        this.model = model;
        ObservableList<IMenuItem> pizzas = FXCollections.observableArrayList(model.getPizzas());
        listPizzas.setItems(pizzas);
    }
    
    @FXML
    private void onItemClicked() {
       selected = (Pizza)listPizzas.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    private void btnAddToOrderPressed() throws IOException {
        Pizza newPizza = new Pizza();
        newPizza.setName(selected.name());
        newPizza.setCrust(selected.crust());
        model.addPizza(newPizza);
        MainApp.setRoot("/ordermanager", MainApp.orderManager);
    }
    
}
