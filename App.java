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
    private Label statusLabel;
    private Label statusLabel2;
    private Label typeLabel;
    private Label orderForm;
    private Label orderStatus;
    private Label  asuIDLabel;
    private Label emailLabel;
    private Label toppingLabel;
    private Label pickUpTimeLabel;
    //private Label formMsg;
    //private Label orderMsg;

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
                typeBox.setValue("Select");

           
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
        statusLabel = new Label("Order Status");
        statusLabel.setPadding(new Insets(10, 10, 10, 10));
        statusLabel.setStyle("-fx-font: 14 Verdana; FontWeight.BOLD");

        statusLabel2 = new Label("Accepted");
        statusLabel2.setPadding(new Insets(10, 10, 10, 10));
        statusLabel2.setStyle("-fx-font: 14 Verdana; FontWeight.BOLD");


        typeLabel = new Label("Type");
        typeLabel.setPadding(new Insets(10, 10, 10, 10));
        typeLabel.setStyle("-fx-font: 14 Verdana; FontWeight.BOLD");

        orderForm =  new Label("Order Form");
        orderForm.setPadding(new Insets(10, 50, 10, 10));
        orderForm.setFont(Font.font("Verdana", FontWeight.BOLD, 24));

        orderStatus = new Label("Order Staus");
        orderStatus.setPadding(new Insets(10, 10, 10, 250));
        orderStatus.setFont(Font.font("Verdana", FontWeight.BOLD, 24));

        asuIDLabel = new Label("ASURITE ID");
        asuIDLabel.setPadding(new Insets(10, 10, 10, 10));
        asuIDLabel.setStyle("-fx-font: 14 Verdana;");

        emailLabel = new Label("Email");
        emailLabel.setPadding(new Insets(10, 10, 10, 10));
        emailLabel.setStyle("-fx-font: 14 Verdana;");

        toppingLabel = new Label("Toppings");
        toppingLabel.setPadding(new Insets(10, 10, 20, 10));
        toppingLabel.setStyle("-fx-font: 14 Verdana;");

        pickUpTimeLabel = new Label("Pickup");
        pickUpTimeLabel.setPadding(new Insets(10, 10, 10, 10));
        pickUpTimeLabel.setStyle("-fx-font: 14 Verdana; FontWeight.BOLD");


        /*** can organize above labels with style cheat***/
    
        //*****needs to be styled and added with Vbox, and Hbox 
        /* 
        formMsg = new Label("Order Staus");
        formMsg.setPadding(new Insets(10, 10, 10, 10));
        formMsg.setStyle("-fx-font: 14 Verdana;");
        orderMsg = new Label("Order Staus");
        orderMsg.setPadding(new Insets(10, 10, 10, 10));
        orderMsg.setStyle("-fx-font: 14 Verdana;");
        ***/
        


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

        mushroomBox = new CheckBox();
     

        for(int i = 0; i < 10; i++){

            if( i == 0){
                pickTimeBox.getItems().addAll(getDate(30));
            }
            else{
                pickTimeBox.getItems().addAll(getDate(i * 15 + 30));
            }
            

        }
       
      
        

        //sets up text fields
        TextField asuIDBox = new TextField();
        TextField emailBox = new TextField();

        //sets up orderButton
        Button orderButton = new Button();
        orderButton.setText("Order Pizza");
        orderButton.setOnAction(order);

        

        //each needs a vbox so label will be ontop
        VBox asuVBox = new VBox();
        VBox emailVbox = new VBox();
        VBox typeVBox = new VBox();
        VBox toppingVbox = new VBox();
        VBox timeVbox = new VBox();


        VBox botVbox = new VBox();
        botVbox.getChildren().addAll(orderButton);
        orderButton.setPrefHeight(50);
        orderButton.setPrefWidth(100);
        botVbox.setPadding(new Insets(40, 10 , 20, 10));

        VBox orderStatusVBox = new VBox();
        orderStatusVBox.getChildren().addAll(statusLabel, statusLabel2);


        asuVBox.getChildren().addAll(asuIDLabel, asuIDBox);
        emailVbox.getChildren().addAll(emailLabel, emailBox);
        typeVBox.getChildren().addAll(typeLabel, typeBox);
        toppingVbox.getChildren().addAll(toppingLabel, mushroomBox, onionsBox, olivesBox, ecBox);
        timeVbox.getChildren().addAll(pickUpTimeLabel, pickTimeBox);

        //Vboxes for each column
       
        VBox leftCol = new VBox();
        VBox rightCol = new VBox();

        leftCol.getChildren().addAll(asuVBox, typeVBox, timeVbox);
        rightCol.getChildren().addAll(emailVbox, toppingVbox, botVbox);

      
        
        

        // Construct a scene graph of nodes

        //base scene
        BorderPane root = new BorderPane();
       
        HBox rightBox = new HBox();
        HBox leftBox = new HBox();
        HBox top = new HBox();

        rightBox.getChildren().addAll(orderStatusVBox);
        leftBox.getChildren().addAll(leftCol, rightCol);
        top.getChildren().addAll(orderForm, orderStatus);

        orderStatusVBox.setPadding(new Insets(50, 10, 10, 10));
        leftCol.setPadding(new Insets(30, 10, 10, 10));
        rightCol.setPadding(new Insets(30, 10, 10, 10));


        root.setLeft(leftBox);
        root.setRight(rightBox);
        root.setTop(top);
        top.setPadding(new Insets(10, 10, 30, 20));
        rightBox.setPadding(new Insets(30, 10, 10, 10));
        leftBox.setPadding(new Insets(30, 10, 10, 10));

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
