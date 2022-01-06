/*
 * CreatepizzaController.java, created by Oliver Souter 2004076
 * Component 2 Part 1 - 06/1/2022
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
import javafx.scene.control.TextField;
import uk.ac.rgu.cm2100.MainApp;
import static uk.ac.rgu.cm2100.MainApp.menu;
import uk.ac.rgu.cm2100.model.Crust;
import uk.ac.rgu.cm2100.model.Pizza;
import uk.ac.rgu.cm2100.model.PizzaTopping;
import uk.ac.rgu.cm2100.model.managers.MenuManager;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class CreatepizzaController extends Controller<MenuManager> implements Initializable {
    @FXML
    private Button btnCreatePizza;
    @FXML
    private Button btnAddTopping;
    @FXML
    private Button btnAddCrust;
    @FXML
    private Button btnNewTopping;
    @FXML
    private ListView listCrust;
    @FXML
    private ListView listToppings;
    @FXML
    private TextField txtPizzaName;
    
    Crust selectedCrust;
    PizzaTopping selectedTopping;
    Pizza newPizza = new Pizza();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @Override
    public void setModel(MenuManager model) {
        this.model = model;
        ObservableList<PizzaTopping> toppings = FXCollections.observableArrayList(model.getToppings());
        listToppings.setItems(toppings);
        ObservableList<Crust> crusts = FXCollections.observableArrayList(model.getCrusts().subList(0, 3));
        listCrust.setItems(crusts);
    }
    @FXML
    private void onCrustSelect() {
        selectedCrust = (Crust)listCrust.getSelectionModel().getSelectedItem();
    }
    @FXML
    private void onToppingSelect() {
        selectedTopping = (PizzaTopping)listToppings.getSelectionModel().getSelectedItem();
    }
    @FXML
    private void onCreatePizza() throws IOException{
        if (newPizza.crust() != null) {
            newPizza.setName(txtPizzaName.getText());
            menu.addPizza(newPizza);
        }
        MainApp.setRoot("/menumanager", MainApp.menu);  
    }
    @FXML
    private void onAddTopping() {
        newPizza.addToppings(selectedTopping);
    }
    @FXML
    private void onAddCrust() {
        newPizza.setCrust(selectedCrust); 
    }
    @FXML
    public void onCreateTopping() throws IOException {
        MainApp.setRoot("/createnewtopping", null);
    }
}
