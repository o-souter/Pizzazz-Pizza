/*
 * OrdermanagerController.java, created by Oliver Souter 2004076
 * Component 2 Part 1 - 31/12/2021
 */
package uk.ac.rgu.cm2100.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import uk.ac.rgu.cm2100.MainApp;
import uk.ac.rgu.cm2100.model.Order;
import uk.ac.rgu.cm2100.model.managers.OrderManager;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class OrdermanagerController extends Controller<OrderManager> implements Initializable {
    @FXML
    private Button btnBackToMenu;
    @FXML
    private ListView listOrders;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private Button btnNewOrder;
    @FXML
    private Label lblOrderDesc;
    
    private List<Order> orders;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @Override
    public void setModel(OrderManager model) {
        this.model = model;
        orders = model.getOrders();
        ObservableList<Order> ordersObservableList = FXCollections.observableArrayList(orders);
        listOrders.setItems(ordersObservableList);
    }
    @FXML
    private void btnNewOrderClicked() throws IOException{
        MainApp.setRoot("/createneworder", MainApp.menu);
    }
    
    @FXML
    private void btnBackClicked() throws IOException {
        MainApp.setRoot("/firstscreen", null);
    }
}
