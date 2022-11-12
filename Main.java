package application;

//javafx imports
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
//my imports
import application.User.*;
import application.Order.*;


public class Main extends Application {
   public void move(String moved, String [] fromArray, String [] toArray) {
	   return;
	}
   
   	//user info
	User currentUser=new User();
	@Override
	public void start(Stage primaryStage) {
		try {
			// asu user database ---------------------------------------------------------------------------------------------
			User[] users;
			users = new User[20];
	
			for(int i=0; i<users.length; i++) {
				users[i]=null;
			}
			//customers
			users[0] = new User(1, 0, "acontr56@asu.edu");
			users[1] = new User(2, 0, "sesolis@asu.edu");
			
			//processors
			users[2] = new User(3, 1, "dvgabrie@asu.edu");
			users[3] = new User(4, 1, "mggamino@asu.edu");
			
			//chefs
			users[4] = new User(5, 2, "bgarci83@asu.edu");
			users[5] = new User(6, 2, "kmmart47@asu.edu");

			
			//order data base ---------------------------------------------------------------------------------------------
			Order[] orders;
			orders = new Order[20];
			orders[0] = new Order(3, "Pepperoni", "Mushroom", "09/23/2022     12:00", 0);
			orders[1] = new Order(2, "Pepperoni", "Onions", "09/23/2022     12:30", 1);
			orders[2] = new Order(6, "Cheese", "Olives", "09/23/2022     12:00", 2);
			orders[3] = new Order(1, "Veggie", "Extra Chees", "09/23/2022     12:30", 3);
			
			//defaults
			int room_height = 1200;
			int room_width = 800;
			
			
			
			
			
			
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
			
			VBox layoutNA = new VBox();
			Scene sceneNA = new Scene(layoutNA, room_height, room_width);
			Label labelNA = new Label("Authentication");

			
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
			
			//All Pages ---------------------------------------------------------------------------------------------
			VBox layoutAP = new VBox();
			Scene sceneAP = new Scene(layoutAP, room_height, room_width);
			Label labelAP = new Label("All Pages");
			Button buttonAP = new Button("All Pages");
			buttonAP.setOnAction(e -> primaryStage.setScene(sceneAP));
			
			layoutAP.setAlignment(Pos.CENTER);
			layoutAP.getChildren().addAll(labelAP, buttonL, buttonCS, buttonOF, buttonA, buttonS, buttonCV, buttonPV);

			//Login ---------------------------------------------------------------------------------------------
			Label lL_id = new Label("ID:");
			TextField tfL_id = new TextField();
			Label lL_email = new Label("EMAIL:");
			TextField tfL_email = new TextField();
			Button buttonL_s = new Button("SUBMIT");
			
			buttonL_s.setOnAction(e -> {
				int userType = checkUser(tfL_id.getText(), tfL_email.getText(), users);
				
				if(userType == -1) {
					//not authentication
					primaryStage.setScene(sceneNA);
				}
				if(userType == 0) {
					//authentication
					currentUser = new User(Integer.parseInt(tfL_id.getText().trim()), userType, tfL_email.getText());
					primaryStage.setScene(sceneA);
				}
				if(userType == 1) {
					//processor
					primaryStage.setScene(scenePV);
				}
				
				if(userType == 2) {
					//chef
					primaryStage.setScene(sceneCV);
				}
			});
			Button buttonL_c = new Button("CLEAR");
			buttonL_c.setOnAction(e -> {
				tfL_id.clear();
				tfL_email.clear();
			});
			layoutL.setAlignment(Pos.CENTER);
			layoutL.getChildren().addAll(labelL, lL_id, tfL_id, lL_email, tfL_email, buttonL_s, buttonL_c, buttonCS);
			
			//Contact Support ---------------------------------------------------------------------------------------------
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
			
			//Order Form ---------------------------------------------------------------------------------------------
			layoutOF.setAlignment(Pos.CENTER);
			layoutOF.getChildren().addAll(labelOF);
			
			//Authentication ---------------------------------------------------------------------------------------------
			//failure auth
			Label lA_title = new Label();
			Label lA_message = new Label();
			Button buttonA_next = new Button();
			
			lA_title.setText("Thank You!");
			lA_message.setText("Your ASURITE ID has been accepted, your order has been placed.");
			buttonA_next.setText("DONE");
			buttonA_next.setOnAction(e -> primaryStage.setScene(sceneOF));
			
			// success auth
			Label lNA_title = new Label();
			Label lNA_message = new Label();
			Button buttonNA_next = new Button();
			
			lNA_title.setText("Oosp!");
			lNA_message.setText("Your ASURITE ID has not been accepted, your order has been rejected.");
			buttonNA_next.setText("RETRY");
			buttonNA_next.setOnAction(e -> primaryStage.setScene(sceneL));
		
			
			layoutA.setAlignment(Pos.CENTER);
			layoutA.getChildren().addAll(labelA, lA_title, lA_message, buttonA_next);
	        
			layoutNA.setAlignment(Pos.CENTER);
			layoutNA.getChildren().addAll(labelNA, lNA_title, lNA_message, buttonNA_next);
	        
			
			//Status			-----------------------------------------------------------
			SplitPane spS = new SplitPane(); 
		    
	        Label lS_id = new Label();
	        lS_id.textProperty().bind(Bindings.format("ASURITE ID: %s", currentUser.id));

		    Label lS_email = new Label();
		    lS_email.textProperty().bind(Bindings.format("EMAIL: %s", currentUser.email));
		    
		    Label lS_type = new Label();
		    lS_type.textProperty().bind(Bindings.format("TYPE: %s", currentUser.type));
		    
		    Label lS_topping = new Label();
		    lS_topping.textProperty().bind(Bindings.format("TOPPING: %s", currentUser.order.topping));
		    Label lS_pickUpTime = new Label();
		    lS_pickUpTime.textProperty().bind(Bindings.format("PICK UP TIME: %s", currentUser.order.pickUpTime));
		    
		    
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
			
			
			//Chef View ---------------------------------------------------------------------------------------------
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
			
			
			//Processing View ---------------------------------------------------------------------------------------------
			SplitPane spPV = new SplitPane(); 
			
		    Label lPV_newOrders = new Label("NEW ORDERS");
		    
		    Label lPV_readyToCook = new Label("READY TO COOK");
		    Button bPV_refresh = new Button("REFRESH");
		    
		    //new orders
		    ListView lvPv_newOrders = new ListView();
		    for(int i=0; i<orders.length; i++){
		    	if(orders[i]==null) {
		    		break;
		    	}
		    	if(orders[i].status==1) {
		    		lvPv_newOrders.getItems().add(orders[i].id +","+orders[i].type +", "+orders[i].topping+", "+orders[i].pickUpTime);
		    	}
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
		    for(int i=1; i<orders.length; i++){
		    	if(orders[i]==null) {
		    		break;
		    	}
		    	if(orders[i].status==2) {
		    		lvPv_readyToCook.getItems().add(orders[i].id +","+orders[i].type +", "+orders[i].topping+", "+orders[i].pickUpTime);
		    	}
		    }
	        VBox rightPV = new VBox(lPV_readyToCook, lvPv_readyToCook);
	        rightPV.setMaxHeight(room_height);
	        rightPV.setMaxWidth(room_width);
	        
	        
	        //buttons
	        bPV_add.setOnAction(e -> {
	        	Object selected = lvPv_newOrders.getSelectionModel().getSelectedItem();
	        	if(selected!=null) {
		        	lvPv_readyToCook.getItems().add(selected);
		        	String userIdStr = selected.toString().split(",")[0].trim(); 
		        	int userId = Integer.parseInt(userIdStr);
		        	
				    for(int i=1; i<orders.length; i++){
				    	if(orders[i]==null) {
				    		break;
				    	}
				    	if(orders[i].id==userId) {
				    		orders[i].status++;
				    		break;
				    	}
				    }
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
	
	public int checkUser(String loginId, String loginEmail, User[] users) {
		int returnType = -1;
		
		//look through database
		for(int i=0; i < users.length; i++) {
			//end if null
			if(users[i]==null) {
				break;
			}
			
			//end if match;
			if(loginId.equals(Integer.toString(users[i].id)) && loginEmail.equals(users[i].email)) {
				returnType=users[i].type;
				break;
			}
		}
		
		return returnType; 	
	}
	public static void main(String[] args) {
		launch(args);
	}
}
