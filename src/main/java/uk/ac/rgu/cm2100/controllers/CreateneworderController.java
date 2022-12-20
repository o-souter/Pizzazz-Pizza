/*
 * CreateneworderController.java, created by Oliver Souter
 * Component 2 Part 1 - 6/01/2022
 */
package uk.ac.rgu.cm2100.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import uk.ac.rgu.cm2100.MainApp;
import static uk.ac.rgu.cm2100.MainApp.orderManager;
import uk.ac.rgu.cm2100.model.Drink;
import uk.ac.rgu.cm2100.model.IMenuItem;
import uk.ac.rgu.cm2100.model.Order;
import uk.ac.rgu.cm2100.model.Pizza;
import uk.ac.rgu.cm2100.model.Side;
import uk.ac.rgu.cm2100.model.managers.MenuManager;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class CreateneworderController extends Controller<MenuManager> implements Initializable {
    @FXML
    private ListView listPizzas;
    @FXML
    private ListView listDrinks;
    @FXML
    private ListView listSides;
    @FXML
    private ListView listOrder;
    @FXML
    private TextField inputOrderName;
    
    private IMenuItem selectedPizza;
    private IMenuItem selectedDrink;
    private IMenuItem selectedSide;
    private IMenuItem selectedItem;
    
    Order newOrder = new Order();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @Override
    public void setModel(MenuManager model) {
        this.model = model;
        ObservableList<IMenuItem> pizzas = FXCollections.observableArrayList(model.getPizzas());
        listPizzas.setItems(pizzas);
        
        ObservableList<IMenuItem> drinks = FXCollections.observableArrayList(model.getDrinks());
        listDrinks.setItems(drinks);
        
        ObservableList<IMenuItem> sides = FXCollections.observableArrayList(model.getSides());
        listSides.setItems(sides);
    }
    @FXML
    private void onItemSelectPizza() {
        selectedPizza = (IMenuItem)listPizzas.getSelectionModel().getSelectedItem();
    }
    @FXML
    private void onItemSelectDrink() {
        selectedDrink = (IMenuItem)listDrinks.getSelectionModel().getSelectedItem();
    }
    @FXML
    private void onItemSelectSide() {
        selectedSide = (IMenuItem)listSides.getSelectionModel().getSelectedItem();
    }
    @FXML
    private void onItemSelectOrder() {
        selectedItem = (IMenuItem)listOrder.getSelectionModel().getSelectedItem();
    }
    @FXML
    private void addPizza() {
        newOrder.addItem(selectedPizza);
        ObservableList<IMenuItem> updatedOrder = FXCollections.observableArrayList(newOrder.getItems());
        listOrder.setItems(updatedOrder);
    }
    @FXML
    private void addDrink() {
        newOrder.addItem(selectedDrink);
        ObservableList<IMenuItem> updatedOrder = FXCollections.observableArrayList(newOrder.getItems());
        listOrder.setItems(updatedOrder);
    }
    @FXML
    private void addSide() {
        newOrder.addItem(selectedSide);
        ObservableList<IMenuItem> updatedOrder = FXCollections.observableArrayList(newOrder.getItems());
        listOrder.setItems(updatedOrder);
    }
    @FXML
    private void placeOrder() throws IOException{
        newOrder.setOrderName(inputOrderName.getText());
        orderManager.addOrder(newOrder);
        MainApp.setRoot("/ordermanager", MainApp.orderManager);
    }
}
