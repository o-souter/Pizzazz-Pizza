/*
 * FirstscreenController.java, created by Oliver Souter 
 * Component 2 Part 1 - 31/12/2021
 */
package uk.ac.rgu.cm2100.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import uk.ac.rgu.cm2100.MainApp;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class FirstscreenController implements Initializable {
    @FXML
    private Button btnOrderManager;
    @FXML
    private Button btnMenuManager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void btnOrderManagerClicked() throws IOException{
        MainApp.setRoot("/ordermanager", MainApp.orderManager);
    }
    @FXML
    private void btnMenuManagerClicked() throws IOException{
        MainApp.setRoot("/menumanager", MainApp.menu);
    }
}
