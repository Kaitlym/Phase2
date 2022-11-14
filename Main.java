package application;

//javafx imports
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.geometry.Insets; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main extends Application {
   public void move(String moved, String [] fromArray, String [] toArray) {
	   return;
	}
   
   	//user info
	User currentUser=new User();
	
	
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
	    
	    
	    
	    //alondra
	    public ArrayList<orderInfo> orderList;
	    public orderInfo order2;
	    public Label label1;

	    
	    //Donna
	    
	    Label welcomeMessage = new Label("Welcome to Sun Devil Pizza!");
		VBox homePageLayout;
		Button chefViewButton;
		
		// chef view page
		HBox orderBox;
		TitledPane orderSection, detailsSection, statusSection;
		CheckBox cheeseTopping, pepperoniTopping, veggieTopping, extraCheeseTopping, 
				baconTopping, mushroomTopping, onionTopping, oliveTopping;
		Button setStatusButton;
		RadioButton acceptedOrder, readyToCookOrder, cookingOrder, finishedOrder;
		ToggleGroup statusGroup;
		
		private final int room_height = 400;
		private final int room_width = 700;
		HBox layout = new HBox(100);
		
		
		private void setStatusButtonAction(Text t) {
			t.setText("Status update sent!");
			t.setX(100);
			t.setY(100);
		}
		
		// action handle for chef view click, but this will come from the main login page
		void chefViewButtonAction(Scene s) {
			Stage stage = new Stage();
			
			stage.setScene(s);
			stage.setTitle("Sun Devil Pizza");
			stage.show();
		}
		
	    //brandon
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

			HBox box = new HBox();
			Scene sceneS = new Scene(box, room_height, room_width);
			
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
		                		getToppingContent(olivesBox), getToppingContent(ecBox), null);
		                //choose where this info goes 
		                confirm.setAlertType(AlertType.CONFIRMATION);
		                

		                confirm.setContentText("Pizza order has been placed!");
		                }
		                // show the dialog
		                confirm.show();
		            }
		        };
		        /** end onclick handler */

		        //sets up labels
		        typeLabel = new Label("Type");
		        typeLabel.setPadding(new Insets(10, 10, 10, 10));

		        orderForm =  new Label("Order Form");
		        orderForm.setPadding(new Insets(10, 50, 10, 10));
		        orderForm.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
		        
		        toppingLabel = new Label("Toppings");
		        toppingLabel.setPadding(new Insets(10, 10, 20, 10));

		        pickUpTimeLabel = new Label("Pickup");
		        pickUpTimeLabel.setPadding(new Insets(10, 10, 10, 10));

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
		        
		        // Construct a sceneOF graph of nodes

		        //base scene
		        BorderPane root = new BorderPane();
		       
		        HBox leftBox = new HBox();
		        HBox top = new HBox();

		        leftBox.getChildren().addAll(leftCol, rightCol);
		        top.getChildren().addAll(orderForm);
		        
		        root.setCenter(leftBox);
		        root.setTop(top);
		        top.setPadding(new Insets(10, 10, 30, 20));
		        leftBox.setPadding(new Insets(30, 10, 50, 150));
		        
		        layoutOF.getChildren().addAll(root);
		    
		        orderButton.setId("button1");
		        
		        // Construct a scene wit, width, and height
		        sceneOF.getStylesheets().clear();
		        sceneOF.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
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
			
			lNA_title.setText("Oops!");
			lNA_message.setText("Your ASURITE ID has not been accepted, your order has been rejected.");
			buttonNA_next.setText("RETRY");
			buttonNA_next.setOnAction(e -> primaryStage.setScene(sceneL));
		
			layoutA.setAlignment(Pos.CENTER);
			layoutA.getChildren().addAll(labelA, lA_title, lA_message, buttonA_next);
	        
			layoutNA.setAlignment(Pos.CENTER);
			layoutNA.getChildren().addAll(labelNA, lNA_title, lNA_message, buttonNA_next);
	        
			
			//Status			-----------------------------------------------------------
			
			//font sizes
			final double MAX_FONT_SIZE = 20;
			final double LABEL_SIZE = 15;
			
			//title labels
			Label info = new Label("Information");
			info.setFont(new Font(MAX_FONT_SIZE));
			info.setTextAlignment(TextAlignment.CENTER);
			Label status = new Label("Status");
			status.setFont(new Font(MAX_FONT_SIZE));
			status.setTextAlignment(TextAlignment.CENTER);
			
			//student info labels
			Label id = new Label();
			id.textProperty().bind(Bindings.format("ASURITE ID: %s", currentUser.id));  
			id.setFont(new Font(LABEL_SIZE));
			
			Label email = new Label();
			email.textProperty().bind(Bindings.format("EMAIL: %s", currentUser.email)); 
			email.setFont(new Font(LABEL_SIZE));
			
			Label type = new Label();
			type.textProperty().bind(Bindings.format("TYPE: %s", currentUser.type)); 
			type.setFont(new Font(LABEL_SIZE));
			
			Label toppings = new Label();
			toppings.textProperty().bind(Bindings.format("TOPPINGS: %s", currentUser.order.topping)); 
			toppings.setFont(new Font(LABEL_SIZE));
			
			Label pickupTime = new Label();
			pickupTime.textProperty().bind(Bindings.format("Pickup Time: %s", currentUser.order.pickUpTime)); 
			pickupTime.setFont(new Font(LABEL_SIZE));
			
			//status labels
			Label order1 = new Label("Order");
			order1.setStyle("-fx-background-color:rgba(85, 255, 68,0.7);");
			order1.setFont(new Font(LABEL_SIZE));
			order1.setTextAlignment(TextAlignment.CENTER);
			Label accepted = new Label("Accepted");
			accepted.setStyle("-fx-background-color:rgba(85, 255, 68,0.7);");
			accepted.setFont(new Font(LABEL_SIZE));
			accepted.setTextAlignment(TextAlignment.CENTER);
			Label readyToCook = new Label("Ready To Cook");
			readyToCook.setStyle("-fx-background-color:rgba(85, 255, 68,0.7);");
			readyToCook.setFont(new Font(LABEL_SIZE));
			readyToCook.setTextAlignment(TextAlignment.CENTER);
			Label cooking = new Label("Cooking");
			cooking.setFont(new Font(LABEL_SIZE));
			cooking.setTextAlignment(TextAlignment.CENTER);
			Label ready = new Label("Ready For Pickup");
			ready.setFont(new Font(LABEL_SIZE));
			ready.setTextAlignment(TextAlignment.CENTER);
			
			//HBox box2 = new HBox();
			VBox infoBox = new VBox();
			VBox statusBox = new VBox();
			
			//putting labels in boxes
			infoBox.getChildren().addAll(info, id, email, type, toppings, pickupTime);
			statusBox.getChildren().addAll(status, order1, accepted, readyToCook, cooking, ready);
			
			//putting vboxes in hboxes
			box.getChildren().addAll(statusBox, infoBox);
			
			box.setPadding(new Insets(50, 10, 10, 10));
			infoBox.setPadding(new Insets(30, 30, 50, 50));
			statusBox.setPadding(new Insets(30, 30, 50, 50));
			
			box.setAlignment(Pos.CENTER);
			
			//Chef View ---------------------------------------------------------------------------------------------	
			
			buttonCV.setOnAction(e -> primaryStage.setScene(sceneCV));
			
			HBox box1 = new HBox();
		    box1.setAlignment(Pos.CENTER);
		    box1.getChildren().add(welcomeMessage);
		    
		    // button to access chef's view (opens in a new window)
		    chefViewButton = new Button("Chef View");
			chefViewButton.setPrefWidth(100);
			
		    // chef view button placement
	 		
			// chef view — title
			Label chefViewTitle = new Label("Sun Devil Pizza — Chef View");
			VBox hbt = new VBox();
			hbt.setAlignment(Pos.CENTER);
			hbt.getChildren().add(chefViewTitle);
			
			// chef view — orders section
			Label userID = new Label("sesolis@asu.edu");
			
			GridPane orders1 = new GridPane();
			orders1.setHgap(10);
			orders1.setVgap(10);
			orders1.setPadding(new Insets(10, 10, 10, 10));
			orders1.addColumn(0, userID);
			
			orderSection = new TitledPane("ORDER", orders1);
			orderSection.setCollapsible(false);
			orderSection.setPrefHeight(60);
			orderSection.setPadding(new Insets(10, 10, 10, 10));
			
			// chef view — pizza details section
			cheeseTopping = new CheckBox("Cheese");
			pepperoniTopping = new CheckBox("Pepperoni");
			veggieTopping = new CheckBox("Veggie");
			extraCheeseTopping = new CheckBox("Extra Cheese");
			baconTopping = new CheckBox("Bacon");
			mushroomTopping = new CheckBox("Mushroom");
			onionTopping = new CheckBox("Onion");
			oliveTopping = new CheckBox("Olive");
			
			cheeseTopping.setSelected(true);
			mushroomTopping.setSelected(true);
			onionTopping.setSelected(true);
			
			GridPane details = new GridPane();
			details.setHgap(200);
			details.setVgap(10);
			details.setPadding(new Insets(10, 10, 10, 10));
			details.addColumn(0, cheeseTopping, pepperoniTopping, veggieTopping);
			details.addColumn(1, extraCheeseTopping, baconTopping, mushroomTopping);
			details.addColumn(2, onionTopping, oliveTopping);
			
			detailsSection = new TitledPane("PIZZA DETAILS", details);
			detailsSection.setPrefHeight(100);
			detailsSection.setCollapsible(false);
			detailsSection.setPadding(new Insets(10, 10, 10, 10));
			
			// chef view — status section
			GridPane status1 = new GridPane();
			status1.setHgap(62);
			status1.setVgap(10);
			status1.setPadding(new Insets(10, 10, 10, 10));
			statusSection = new TitledPane("STATUS", status1);
			statusSection.setPrefHeight(100);
			statusSection.setCollapsible(false);
			statusSection.setPadding(new Insets(10, 10, 10, 10));

			setStatusButton = new Button("SET STATUS");
			setStatusButton.setPrefWidth(100);
			
			// status buttons
			statusGroup = new ToggleGroup();
			acceptedOrder = new RadioButton("Accepted");
			acceptedOrder.setToggleGroup(statusGroup);
			readyToCookOrder = new RadioButton("Ready to Cook");
			readyToCookOrder.setToggleGroup(statusGroup);
			cookingOrder = new RadioButton("Cooking");
			cookingOrder.setToggleGroup(statusGroup);
			finishedOrder = new RadioButton("Finished");
			finishedOrder.setToggleGroup(statusGroup);
			
			acceptedOrder.setSelected(true);
			
			status1.addColumn(0, acceptedOrder);
			status1.addColumn(1, readyToCookOrder);
			status1.addColumn(2, cookingOrder);
			status1.addColumn(3, finishedOrder);
			status1.addColumn(4, setStatusButton);
			
			// send email update
			Text t = new Text();
			t.setText("");
			setStatusButton.setOnAction(e -> setStatusButtonAction(t));
			
			// place everything into the chef view
			Label cvTitle = new Label("Sun Devil Pizza — Chef View");
	 		layoutCV.setAlignment(Pos.CENTER);
	 		layoutCV.getChildren().addAll(cvTitle, orderSection, detailsSection, statusSection, t);
	 		
	 		
			
			//Processing View ---------------------------------------------------------------------------------------------

	 		 order2 = new orderInfo("cheese", "Oct 13, 2017", true, true, false, false, "ready to cook");
	         orderList = new ArrayList<orderInfo>();

	         ContentPane gui = new ContentPane(orderList);
	         gui.updateNewOrderList(order2);

	         BorderPane root2 = new BorderPane();
	         label1 = new Label("SunDevil Pizza");
	         root2.setTop(label1);
	         root2.setCenter(gui);
	         
	         layoutPV.getChildren().addAll(root2);
			
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