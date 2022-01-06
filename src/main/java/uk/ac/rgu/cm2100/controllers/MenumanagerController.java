/*
 * MenumanagerController.java, created by Oliver Souter 2004076
 * Component 2 Part 1 - 2/1/2022
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import uk.ac.rgu.cm2100.MainApp;
import uk.ac.rgu.cm2100.model.Drink;
import uk.ac.rgu.cm2100.model.IMenuItem;
import uk.ac.rgu.cm2100.model.Pizza;
import uk.ac.rgu.cm2100.model.PizzaTopping;
import uk.ac.rgu.cm2100.model.Side;
import uk.ac.rgu.cm2100.model.managers.MenuManager;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class MenumanagerController extends Controller<MenuManager> implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnBackToMenu;
    @FXML
    private ListView listMenuItems;
    @FXML
    private ListView listToppings;
    @FXML
    private Button btnCreateItem;
    @FXML
    private Button btnDeleteItem;
    @FXML
    private Button btnCreateTopping;
    @FXML
    private Label lblItemDesc;
    
    private IMenuItem selected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @Override
    public void setModel(MenuManager model) {
        this.model = model;
        ObservableList<IMenuItem> items = FXCollections.observableArrayList(model.getItems());
        ObservableList<PizzaTopping> toppings = FXCollections.observableArrayList(model.getToppings());
        listMenuItems.setItems(items);
        listToppings.setItems(toppings);
    }
    
    @FXML
    public void btnBackClicked() throws IOException {
        MainApp.setRoot("/firstscreen", null);
    }
    
    @FXML
    public void onItemSelect() {
        selected = (IMenuItem)listMenuItems.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lblItemDesc.setText(selected.description());
        }
    }
    
    @FXML
    public void onCreatePizza() throws IOException{
        MainApp.setRoot("/createpizza", MainApp.menu);
    }
    @FXML
    public void onDeleteItem() {
        if (selected != null) {
            model.deleteItem(selected);
            ObservableList<IMenuItem> items = FXCollections.observableArrayList(model.getItems());
            listMenuItems.setItems(items);
        }
    }
    @FXML
    public void onCreateTopping() throws IOException {
        MainApp.setRoot("/createnewtopping", null);
    }
}
