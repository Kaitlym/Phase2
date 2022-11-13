package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Main extends Application {
	// first page
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
	
	@Override
	public void start(Stage primaryStage) throws Exception {		
		// welcome message in first page
		HBox box = new HBox();
	    box.setAlignment(Pos.CENTER);
	    box.getChildren().add(welcomeMessage);
	    
	    // chef view layout
	    VBox chefViewLayout = new VBox();
	    Scene chefViewScene = new Scene(chefViewLayout, room_width, room_height);
	    
	    // button to access chef's view (opens in a new window)
	    chefViewButton = new Button("Chef View");
		chefViewButton.setPrefWidth(100);
		chefViewButton.setOnAction(e -> chefViewButtonAction(chefViewScene));
		
	    // chef view button placement
 		GridPane grid = new GridPane();
 		grid.setHgap(10);
 		grid.setVgap(10);
 		grid.setPadding(new Insets(10, 10, 10, 285));
 		grid.addColumn(0, chefViewButton);
 		
 		// home page
		homePageLayout = new VBox(10);
		homePageLayout.setPadding(new Insets(15));
		homePageLayout.getChildren().addAll(box, grid);
 				
		// chef view — title
		Label chefViewTitle = new Label("Sun Devil Pizza — Chef View");
		VBox hbt = new VBox();
		hbt.setAlignment(Pos.CENTER);
		hbt.getChildren().add(chefViewTitle);
		
		// chef view — orders section
		Label userID = new Label("sesolis@asu.edu");
		
		GridPane orders = new GridPane();
		orders.setHgap(10);
		orders.setVgap(10);
		orders.setPadding(new Insets(10, 10, 10, 10));
		orders.addColumn(0, userID);
		
		orderSection = new TitledPane("ORDER", orders);
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
		
		pepperoniTopping.setSelected(true);
		extraCheeseTopping.setSelected(true);
		
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
		GridPane status = new GridPane();
		status.setHgap(62);
		status.setVgap(10);
		status.setPadding(new Insets(10, 10, 10, 10));
		statusSection = new TitledPane("STATUS", status);
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
		
		status.addColumn(0, acceptedOrder);
		status.addColumn(1, readyToCookOrder);
		status.addColumn(2, cookingOrder);
		status.addColumn(3, finishedOrder);
		status.addColumn(4, setStatusButton);
		
		// send email update
		Text t = new Text();
		t.setText("");
		setStatusButton.setOnAction(e -> setStatusButtonAction(t));
		
		// place everything into the chef view
		Label cvTitle = new Label("Sun Devil Pizza — Chef View");
 		chefViewLayout.setAlignment(Pos.CENTER);
 		chefViewLayout.getChildren().addAll(cvTitle, orderSection, detailsSection, statusSection, t);
				
		try {
			Scene scene = new Scene(homePageLayout, room_width, room_height);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Sun Devil Pizza");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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
		
	public static void main(String[] args) {
		launch(args);
	}
}
