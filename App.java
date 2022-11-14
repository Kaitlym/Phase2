package application;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class Main extends Application {
  
    //drop downs
    private ComboBox<String> typeBox;
    private ComboBox<String> pickTimeBox;

    private CheckBox mushroomBox;
    private CheckBox onionsBox;
    private CheckBox olivesBox;
    private CheckBox ecBox;

    //text boxes
    private TextField asuIDBox;
    private TextField emailBox;

    //labels
    private Label typeLabel;
    private Label orderForm;
    private Label toppingLabel;
    private Label pickUpTimeLabel;

    //order button
    private Button orderButton;
    
    private orderInfo orderInfo;

    /*************
     * Takes in int to add minutes to current time
     * this is for the pickupTime ComboBox
     * returns string to add to box 
     * 
     * @param addMinutes 
     * @return
     */
    public static String getDate(int addMinutes) {
		
       
        SimpleDateFormat sdf=new SimpleDateFormat("EEE, MMM d, hh:mm aaa");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, addMinutes);
        int mod = cal.get(Calendar.MINUTE);
        mod = mod % 15;
        
    
        cal.add(Calendar.MINUTE, mod < 8 ? -mod : (15-mod));
        Date date = cal.getTime();
    
		
		return sdf.format(date);
		
		
	}

    public static String getBoxContent(ComboBox<String> n) {

        String i = n.getValue();

        return i;


    }

    public static boolean getToppingContent(CheckBox n) {

        boolean i = n.isSelected();

        return i;


    }
    
    public  application.orderInfo orderInfo(orderInfo n ) {
    	
    	return orderInfo;
    	
    }

    
    public void start(Stage primaryStage) {

        
        /*for onclick pizza button, should add to move to status page */
        Alert confirm = new Alert(AlertType.NONE);

        EventHandler<ActionEvent> order = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e){
            	           
                if(typeBox.getValue() == "Select" || pickTimeBox.getValue() == "Select" ){

                    confirm.setAlertType(AlertType.ERROR);
                    confirm.setContentText("One or more boxes have no selections");
                }

                //should move to next screen
                else{
                
                // set alert type
                orderInfo = new orderInfo(getBoxContent(typeBox),getBoxContent(pickTimeBox),
                		getToppingContent(mushroomBox),getToppingContent(onionsBox),
                		getToppingContent(olivesBox), getToppingContent(ecBox));
                //choose where this info goes 
                confirm.setAlertType(AlertType.CONFIRMATION);
                

                confirm.setContentText("Pizza order has been placed! Look for where your pizza is at on the right!");
                }
                // show the dialog
                confirm.show();
            }
            
        };
        /** end onclick handler */
        
      
        
        



        //sets up labels
        typeLabel = new Label("Type");
        typeLabel.setPadding(new Insets(10, 10, 10, 10));
        typeLabel.setStyle("-fx-font: 14 Verdana; FontWeight.BOLD");

        orderForm =  new Label("Order Form");
        orderForm.setPadding(new Insets(10, 50, 10, 10));
        orderForm.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        
        toppingLabel = new Label("Toppings");
        toppingLabel.setPadding(new Insets(10, 10, 20, 10));
        toppingLabel.setStyle("-fx-font: 14 Verdana;");

        pickUpTimeLabel = new Label("Pickup");
        pickUpTimeLabel.setPadding(new Insets(10, 10, 10, 10));
        pickUpTimeLabel.setStyle("-fx-font: 14 Verdana; FontWeight.BOLD");

        mushroomBox = new CheckBox("Mushroom");
        mushroomBox.setPadding(new Insets(10, 10, 10, 10));
        onionsBox = new CheckBox("Onion");
        onionsBox.setPadding(new Insets(10, 10, 10, 10));
        olivesBox = new CheckBox("Olive");
        olivesBox.setPadding(new Insets(10, 10, 10, 10));
        ecBox = new CheckBox("Extra Cheese");
        ecBox.setPadding(new Insets(10, 10, 10, 10));
     

        //sets up combo boxes
   
        typeBox = new ComboBox<String>();
        typeBox.getItems().addAll("Pepperoni", "Cheese", "Veggie");
        typeBox.setValue("Select");

        pickTimeBox = new ComboBox<String>();
        pickTimeBox.setValue("Select");
     

        for(int i = 0; i < 10; i++){

            if( i == 0){
                pickTimeBox.getItems().addAll(getDate(30));
            }
            else{
                pickTimeBox.getItems().addAll(getDate(i * 15 + 30));
            }
            

        }
       
      
        //sets up orderButton
        Button orderButton = new Button();
        orderButton.setText("Order Pizza");
        orderButton.setOnAction(order);

        

        //each needs a vbox so label will be ontop
        VBox typeVBox = new VBox();
        VBox toppingVbox = new VBox();
        VBox timeVbox = new VBox();


        VBox botVbox = new VBox();
        botVbox.getChildren().addAll(orderButton);
        orderButton.setPrefHeight(50);
        orderButton.setPrefWidth(100);
        botVbox.setPadding(new Insets(40, 10 , 20, 10));


        typeVBox.getChildren().addAll(typeLabel, typeBox);
        toppingVbox.getChildren().addAll(toppingLabel, onionsBox, mushroomBox,  olivesBox, ecBox);
        timeVbox.getChildren().addAll(pickUpTimeLabel, pickTimeBox);

        //Vboxes for each column
       
        VBox leftCol = new VBox();
        VBox rightCol = new VBox();

        leftCol.getChildren().addAll(typeVBox, timeVbox);
        rightCol.getChildren().addAll(toppingVbox, botVbox);

      
        
        

        // Construct a scene graph of nodes

        //base scene
        BorderPane root = new BorderPane();
       
        HBox leftBox = new HBox();
        HBox top = new HBox();

        leftBox.getChildren().addAll(leftCol, rightCol);
        top.getChildren().addAll(orderForm);

        //leftCol.setPadding(new Insets(30, 10, 10, 10));
       // rightCol.setPadding(new Insets(30, 10, 10, 10));


        root.setCenter(leftBox);
        root.setTop(top);
        top.setPadding(new Insets(10, 10, 30, 20));
        leftBox.setPadding(new Insets(30, 10, 50, 150));

        top.setStyle("-fx-border-color: black");

    
        orderButton.setId("button1");
        
        // Construct a scene wit, width, and height
        Scene scene = new Scene(root, 700, 500); 
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("styleSheet.css").toExternalForm());
        primaryStage.setScene(scene);    // The stage sets scene
        primaryStage.setTitle("SunDevil Pizza");  
        primaryStage.show();             // Sets to visible
    }

    

    public static void main(String[] args) {
        launch(args);
    }
}
