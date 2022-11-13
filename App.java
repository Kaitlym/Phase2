package application;


import java.util.Date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
	
	public static String getDate(int addMinutes) {
		
		/*
		Date date = new java.util.Date(); 
		addMinutes*=60000;
		date = new Date(date + addMinutes);
	    Date newDate = new Date(date + (addMinutes * 60000));
		*/
		String dateString = null;
		//dateString = date.toString();
		
		return dateString;
		
		
	}

    //drop downs
    private ComboBox<String> typeBox;
    private ComboBox<String> toppingBox;

    private ComboBox<String> pickTimeBox;

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


    @Override
    public void start(Stage primaryStage) {

        Alert confirm = new Alert(AlertType.NONE);

        EventHandler<ActionEvent> order = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                // set alert type
                confirm.setAlertType(AlertType.CONFIRMATION);

                confirm.setContentText("Pizza order has been placed! Look for where your pizza is at on the right!");
 
                // show the dialog
                confirm.show();
            }
            
        };

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
        toppingLabel.setPadding(new Insets(10, 10, 10, 10));
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
        



        //sets up combo boxes
   
        typeBox = new ComboBox<String>();
        typeBox.getItems().addAll("Pepperoni", "Cheese", "Veggie");
        typeBox.setValue("Select");

        toppingBox = new ComboBox<String>();
        toppingBox.getItems().addAll("Mushroom","Onions" ,"Olives" , "Extra Cheese");
        toppingBox.setValue("Select");

        pickTimeBox = new ComboBox<String>();
        //pickTimeBox.getItems().addAll(getDate());
      //pickTimeBox.getItems().addAll("09/23/2022     12:00", "09/23/2022     12:30");
        pickTimeBox.setValue("Select");

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
        botVbox.setPadding(new Insets(90, 10 , 20, 10));

        VBox orderStatusVBox = new VBox();
        orderStatusVBox.getChildren().addAll(statusLabel, statusLabel2);


        asuVBox.getChildren().addAll(asuIDLabel, asuIDBox);
        emailVbox.getChildren().addAll(emailLabel, emailBox);
        typeVBox.getChildren().addAll(typeLabel, typeBox);
        toppingVbox.getChildren().addAll(toppingLabel, toppingBox);
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
