package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.geometry.Insets; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane; 
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.stage.Stage;


public class Main extends Application {
   public void move(String moved, String [] fromArray, String [] toArray) {
	   return;
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			//defaults
			int room_height = 1200;
			int room_width = 800;
			
			//user info
			String asuriteId = "test id";
			String email = "test@asu.edu";
			String type = "test type";
			String topping = "test topping";
			String pickUpTime = "test pick up time";
			boolean authenticated = true;
			int status = -1;
			
			//new orders
			String[] newOrders = {"test1", "test2"};
			//ready to cook
			String[] readyToCook = {"test3", "test4", "test5", "test6"};
			//cooking
			String[] cooking = {"test7", "test8"};
			
			VBox layoutAP = new VBox();
			Scene sceneAP = new Scene(layoutAP, room_height, room_width);
			Label labelAP = new Label("All Pages");
			Button buttonAP = new Button("All Pages");
			buttonAP.setOnAction(e -> primaryStage.setScene(sceneAP));
			
			VBox layoutL = new VBox();
			Scene sceneL = new Scene(layoutL, room_height, room_width);
			Label labelL = new Label("Login");
			Button buttonL = new Button("Login");
			buttonL.setOnAction(e -> primaryStage.setScene(sceneL));

			
			VBox layoutCS = new VBox();
			Scene sceneCS = new Scene(layoutCS, room_height, room_width);
			Label labelCS = new Label("Contact Support");
			Button buttonCS = new Button("Contact Support");
			buttonCS.setOnAction(e -> primaryStage.setScene(sceneCS));
			
			VBox layoutOF = new VBox();
			Scene sceneOF = new Scene(layoutOF, room_height, room_width);
			Label labelOF = new Label("Order Form");
			Button buttonOF = new Button("Order Form");
			buttonOF.setOnAction(e -> primaryStage.setScene(sceneOF));
			
			VBox layoutA = new VBox();
			Scene sceneA = new Scene(layoutA, room_height, room_width);
			Label labelA = new Label("Authentication");
			Button buttonA = new Button("Authentication");
			buttonA.setOnAction(e -> primaryStage.setScene(sceneA));
			
			
			VBox layoutS = new VBox();
			Scene sceneS = new Scene(layoutS, room_height, room_width);
			
			Label labelS = new Label("Status");
			Button buttonS = new Button("Status");
			buttonS.setOnAction(e -> primaryStage.setScene(sceneS));
			
			
			VBox layoutCV = new VBox();
			Scene sceneCV = new Scene(layoutCV, room_height, room_width);
			Label labelCV = new Label("Chef View");
			Button buttonCV = new Button("Chef View");
			buttonCV.setOnAction(e -> primaryStage.setScene(sceneCV));
			
			VBox layoutPV = new VBox();
			Scene scenePV = new Scene(layoutPV, room_height, room_width);
			Label labelPV = new Label("Processor View");
			Button buttonPV = new Button("Processor View");
			buttonPV.setOnAction(e -> primaryStage.setScene(scenePV));
			
			//All Pages
			layoutAP.setAlignment(Pos.CENTER);
			layoutAP.getChildren().addAll(labelAP, buttonL, buttonCS, buttonOF, buttonA, buttonS, buttonCV, buttonPV);

			//Login					-----------------------------------------------------------
			Label lL_id = new Label("ID:");
			TextField tfL_id = new TextField();
			Label lL_email = new Label("EMAIL:");
			TextField tfL_email = new TextField();
			Button buttonL_s = new Button("SUBMIT");
			buttonL_s.setOnAction(e -> {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("EMAIL: "+tfL_email.getText()+"\n"+"ASURITE: "+tfL_id.getText());
				alert.show();
				primaryStage.setScene(sceneA);
			});
			Button buttonL_c = new Button("CLEAR");
			buttonL_c.setOnAction(e -> {
				tfL_id.clear();
				tfL_email.clear();
			});
			layoutL.setAlignment(Pos.CENTER);
			layoutL.getChildren().addAll(labelL, lL_id, tfL_id, lL_email, tfL_email, buttonL_s, buttonL_c, buttonCS);
			
			//Contact Support			-----------------------------------------------------------
			Label lCS_id = new Label("ID:");
			TextField tfCS_id = new TextField();
			Label lCS_message = new Label("MESSAGE:");
			TextField tfCS_message = new TextField();
			Button buttonCS_s = new Button("SEND");
			
			buttonCS_s.setOnAction(e -> {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("ID: "+ tfCS_id.getText() + "\n"+"MESSAGE: " + tfCS_message.getText());
				alert.show();
				primaryStage.setScene(sceneL);
			});
			Button buttonOF_c = new Button("CLEAR");
			buttonOF_c.setOnAction(e -> {
				tfCS_id.clear();
				tfCS_message.clear();
			});
			layoutCS.setAlignment(Pos.CENTER);
			layoutCS.getChildren().addAll(labelCS, lCS_id, tfCS_id, lCS_message, tfCS_message, buttonCS_s, buttonOF_c);
			
			//Order Form				-----------------------------------------------------------
			layoutOF.setAlignment(Pos.CENTER);
			layoutOF.getChildren().addAll(labelOF);
			
			//Authentication			-----------------------------------------------------------
			Label lA_title = new Label();
			Label lA_message = new Label();
			Button buttonA_next = new Button();
			
			if(authenticated==true){
				lA_title.setText("Thank You!");
				lA_message.setText("Your ASURITE ID has been accepted, your order has been placed.");
				buttonA_next.setText("DONE");
				buttonA_next.setOnAction(e -> primaryStage.setScene(sceneOF));
			}else{
				lA_title.setText("Oosp!");
				lA_message.setText("Your ASURITE ID has not been accepted, your order has been rejected.");
				buttonA_next.setText("RETRY");
				buttonA_next.setOnAction(e -> primaryStage.setScene(sceneL));
			}
			
			
			layoutA.setAlignment(Pos.CENTER);
			layoutA.getChildren().addAll(labelA, lA_title, lA_message, buttonA_next);
	        
			
			//Status			-----------------------------------------------------------
			SplitPane spS = new SplitPane(); 
		    
	        Label lS_id = new Label();
	        lS_id.textProperty().bind(Bindings.format("ASURITE ID: %s", asuriteId));

		    Label lS_email = new Label();
		    lS_email.textProperty().bind(Bindings.format("EMAIL: %s", email));
		    
		    Label lS_type = new Label();
		    lS_type.textProperty().bind(Bindings.format("TYPE: %s", type));
		    
		    Label lS_topping = new Label();
		    lS_topping.textProperty().bind(Bindings.format("TOPPING: %s", topping));
		    Label lS_pickUpTime = new Label();
		    lS_pickUpTime.textProperty().bind(Bindings.format("PICK UP TIME: %s", pickUpTime));
		    
		    
		    Label lS_order = new Label("ORDER");
		    Label lS_accepted = new Label("ACCEPTED");
		    Label lS_rtc = new Label("READY TO COOK");
		    Label lS_cooking = new Label("COOKING");
		    Label lS_ready = new Label("READY");

		    VBox leftS = new VBox(labelS, lS_order, lS_accepted, lS_rtc, lS_cooking, lS_ready);
		    leftS.setMaxHeight(room_height);
		    leftS.setMaxWidth(room_width);
	        VBox rightS = new VBox(lS_id, lS_email, lS_type, lS_topping, lS_pickUpTime);
	        rightS.setMaxHeight(room_height);
	        rightS.setMaxWidth(room_width);
	        
		    spS.getItems().addAll(leftS, rightS);
		    layoutS.setAlignment(Pos.CENTER);
			layoutS.getChildren().addAll(spS);
			
			
			//Chef View					-----------------------------------------------------------
			layoutCV.setAlignment(Pos.CENTER);
			layoutCV.getChildren().addAll(labelCV);
			SplitPane spCV = new SplitPane(); 
			
			Label lCV_order = new Label("ORDERS");
			Label lCV_typeAndTopping = new Label("TYPE AND TOPPINGS");
			Label lCV_status = new Label("STATUS");
			
			VBox leftCV = new VBox(lCV_order);
			leftCV.setMaxHeight(room_height);
			leftCV.setMaxWidth(room_width);
			
			VBox middleCV = new VBox(lCV_typeAndTopping);
			middleCV.setMaxHeight(room_height);
			middleCV.setMaxWidth(room_width);
			
			VBox rightCV = new VBox(lCV_status);
			rightCV.setMaxHeight(room_height);
			rightCV.setMaxWidth(room_width);

			spCV.setDividerPositions(0.3f, 0.6f, 0.9f);
	        spCV.getItems().addAll(leftCV, middleCV, rightCV);
	        
	        layoutCV.setAlignment(Pos.CENTER);
			layoutCV.getChildren().addAll(spCV);
			//Processing View			-----------------------------------------------------------
			SplitPane spPV = new SplitPane(); 
			
		    Label lPV_newOrders = new Label("NEW ORDERS");
		    
		    Label lPV_readyToCook = new Label("READY TO COOK");
		    Button bPV_refresh = new Button("REFRESH");
		    
		    //new orders
		    ListView lvPv_newOrders = new ListView();
		    for(int i=0; i<newOrders.length; i++){
		    	lvPv_newOrders.getItems().add(newOrders[i]);
		    }
		    
		    VBox leftPV = new VBox(lPV_newOrders, bPV_refresh, lvPv_newOrders);
		    leftPV.setMaxHeight(room_height);
		    leftPV.setMaxWidth(room_width);
		    
		    //stats
		    Button bPV_add = new Button("ADD");
		    VBox middlePV = new VBox(bPV_add);
		    middlePV.setMaxHeight(room_height);
		    middlePV.setMaxWidth(room_width);
		    
		    //ready to cook
		    ListView lvPv_readyToCook = new ListView();
		    for(int i=0; i<readyToCook.length; i++){
		    	lvPv_readyToCook.getItems().add(readyToCook[i]);
		    }
	        VBox rightPV = new VBox(lPV_readyToCook, lvPv_readyToCook);
	        rightPV.setMaxHeight(room_height);
	        rightPV.setMaxWidth(room_width);
	        
	        
	        //buttons
	        bPV_add.setOnAction(e -> {
	        	Object selected = lvPv_newOrders.getSelectionModel().getSelectedItem();
	        	if(selected!=null) {
		        	lvPv_readyToCook.getItems().add(selected);
		        	lvPv_newOrders.getItems().remove(selected);
	        	}
	        });
	        
	        spPV.setDividerPositions(0.3f, 0.6f, 0.9f);
			spPV.getItems().addAll(leftPV, middlePV, rightPV);
			
			layoutPV.setAlignment(Pos.CENTER);
			layoutPV.getChildren().addAll(spPV);
			
			
		    //Title						-----------------------------------------------------------
	        primaryStage.setTitle("ASU PIZZA");
	        
	        //Stage
	        primaryStage.setScene(sceneAP);   
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
