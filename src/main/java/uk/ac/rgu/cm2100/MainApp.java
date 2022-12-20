/*
* MainApp.java, edited by Oliver Souter
* Component 2 Part 1 - 31/12/2021
*/

package uk.ac.rgu.cm2100;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import uk.ac.rgu.cm2100.controllers.Controller;
import uk.ac.rgu.cm2100.model.Crust;
import uk.ac.rgu.cm2100.model.Drink;
import uk.ac.rgu.cm2100.model.managers.MenuManager;
import uk.ac.rgu.cm2100.model.Model;
import uk.ac.rgu.cm2100.model.Order;
import uk.ac.rgu.cm2100.model.Pizza;
import uk.ac.rgu.cm2100.model.PizzaTopping;
import uk.ac.rgu.cm2100.model.Side;
import uk.ac.rgu.cm2100.model.managers.OrderManager;

/**
 * JavaFX MainApp
 */
public class MainApp extends Application {

    /* These static models can be used across different views while persisting data */
    public static final MenuManager menu = new MenuManager();
    public static final OrderManager orderManager = new OrderManager();
    
    
    /* The scene that is currently displayed */
    private static Scene scene;
    private static Scene orderManagerScene;
    @Override
    public void start(Stage stage) throws IOException {
        //test menu order
        PizzaTopping tomato = new PizzaTopping();
        tomato.setName("Tomato Puree");
        tomato.setPrice(0);
        
        PizzaTopping cheddar = new PizzaTopping();
        cheddar.setName("Cheddar");
        cheddar.setPrice(50);
        
        PizzaTopping pepperoni = new PizzaTopping();
        pepperoni.setName("Pepperoni");
        pepperoni.setPrice(75);
        
        PizzaTopping olives = new PizzaTopping();
        olives.setName("Olives");
        olives.setPrice(25);
        
        PizzaTopping mozzarella = new PizzaTopping();
        mozzarella.setName("Mozzarella");
        mozzarella.setPrice(45);
        
        PizzaTopping redOnion = new PizzaTopping();
        redOnion.setName("Red Onion");
        redOnion.setPrice(20);
        
        PizzaTopping rocket = new PizzaTopping();
        rocket.setName("Rocket");
        rocket.setPrice(20);
        
        Pizza pepperoniPizza = new Pizza();
        pepperoniPizza.setName("Pepperoni");
        
        pepperoniPizza.setCrust(Crust.THICK);
        pepperoniPizza.addToppings(tomato, cheddar, pepperoni, olives);

        Pizza margheritaPizza = new Pizza();
        margheritaPizza.setName("Margherita");
        
        margheritaPizza.setCrust(Crust.THIN);
        margheritaPizza.addToppings(tomato, mozzarella);
        
        Pizza cheesyDelite = new Pizza();
        cheesyDelite.setName("Cheesy Delite");
        
        cheesyDelite.setCrust(Crust.STUFFED);
        cheesyDelite.addToppings(tomato, cheddar, mozzarella);
        
        Pizza redOnionRocket = new Pizza();
        redOnionRocket.setName("Red Onion and Rocket");
        redOnionRocket.setCrust(Crust.THIN);
        redOnionRocket.addToppings(tomato, cheddar, redOnion, rocket);
        
        
        Side chips = new Side("Chips", 150);
        Side onionRings = new Side("Onion Rings", 230);
        Side salad = new Side("Salad", 90);
        Drink beer = new Drink("Beer", 135);
        Drink coke = new Drink("Coca Cola", 110);
        Drink apple = new Drink("Apple Juice", 90);
        Drink iceTea = new Drink("Ice Tea", 130);
        
        
        menu.addTopping(mozzarella);
        menu.addTopping(tomato);
        menu.addTopping(pepperoni);
        menu.addTopping(olives);
        menu.addTopping(cheddar);
        menu.addTopping(redOnion);
        menu.addTopping(rocket);
        menu.addPizza(pepperoniPizza);
        menu.addPizza(margheritaPizza);
        menu.addPizza(cheesyDelite);
        menu.addPizza(redOnionRocket);
        menu.addSide(chips);
        menu.addSide(onionRings);
        menu.addSide(salad);
        menu.addDrink(beer);
        menu.addDrink(coke);
        menu.addDrink(apple);
        
        Order oliversOrder = new Order();
        oliversOrder.addItem(pepperoniPizza);
        oliversOrder.addItem(chips);
        oliversOrder.addItem(coke);
        oliversOrder.setOrderName("Oliver's order");
        
        
        Order lucysOrder = new Order();
        lucysOrder.addItem(margheritaPizza);
        lucysOrder.addItem(redOnionRocket);
        lucysOrder.addItem(iceTea);
        lucysOrder.addItem(chips);
        lucysOrder.setOrderName("Lucy's order");
        orderManager.addOrder(oliversOrder);
        orderManager.addOrder(lucysOrder);
        
        
        stage.setTitle("Pizzazz");
        scene = new Scene(loadFXML("/firstscreen", null), 640, 480);
        //orderManagerScene = new Scene(loadFXML("/ordermanager", null));
        scene.getStylesheets().add("styles/default.css"); //loads a default stylesheet - helps fix some character encoding issues on some platforms...
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Sets the root of the scene using the given fxml file and model
     *
     * @param fxml
     * @param model
     * @throws IOException
     */
    public static void setRoot(String fxml, Model model) throws IOException {
        
        /* quick hack to strip the .fxml extension if provided by mistake */
        if(fxml.endsWith(".fxml")){
            fxml = fxml.split(".")[0];
        }
  
        scene.setRoot(loadFXML(fxml, model));
    }

    /**
     * Loads the given fxml file and sets the given model in the controller
     *
     * @param fxml
     * @param model
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml, Model model) throws IOException {

        /* Create the FXMLLoader and load the given fxml file */
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxml + ".fxml"));

        /* Load the fxml into a parent */
        Parent parent = fxmlLoader.load();

        /* Get the controller and set the model */
        if (model != null) {
            Controller controller = fxmlLoader.getController();
            controller.setModel(model);
        }
        

        /* Return the parent */
        return parent;
    }

    public static void main(String[] args) {
        launch();
    }
    
    
    public static List getMenuPizzas() {
        return menu.getPizzas();
    }
    

}
