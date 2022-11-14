package application;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//font sizes
			final double MAX_FONT_SIZE = 20;
			final double LABEL_SIZE = 15;
			
			//creating scene and gridpane
			//GridPane grid = new GridPane();
			HBox box = new HBox();
			Scene scene = new Scene(box,500,500);
			
			//title labels
			Label info = new Label("Information");
			info.setFont(new Font(MAX_FONT_SIZE));
			info.setTextAlignment(TextAlignment.CENTER);
			Label status = new Label("Status");
			status.setFont(new Font(MAX_FONT_SIZE));
			status.setTextAlignment(TextAlignment.CENTER);
			
			//student info labels
			Label id = new Label();
			id.textProperty().bind(Bindings.format("ASURITE ID: %s", "user id"));  //switch "user id" to currentUser.id
			id.setFont(new Font(LABEL_SIZE));
			
			Label email = new Label();
			email.textProperty().bind(Bindings.format("EMAIL: %s", "user email")); //switch "user email" to currentUser.email
			email.setFont(new Font(LABEL_SIZE));
			
			Label type = new Label();
			type.textProperty().bind(Bindings.format("TYPE: %s", "pizza type")); //switch "pizza type" to currentUser.type
			type.setFont(new Font(LABEL_SIZE));
			
			Label toppings = new Label();
			toppings.textProperty().bind(Bindings.format("TOPPINGS: %s", "toppings")); //switch "toppings" to currentUser.topping
			toppings.setFont(new Font(LABEL_SIZE));
			
			Label pickupTime = new Label();
			pickupTime.textProperty().bind(Bindings.format("Pickup Time: %s", "time")); //switch "time" to currentUser.pickupTime
			pickupTime.setFont(new Font(LABEL_SIZE));
			
			//status labels
			Label order = new Label("Order");
			order.setStyle("-fx-background-color:rgba(85, 255, 68,0.7);");
			order.setFont(new Font(LABEL_SIZE));
			order.setTextAlignment(TextAlignment.CENTER);
			Label accepted = new Label("Accepted");
			accepted.setStyle("-fx-background-color:rgba(85, 255, 68,0.7);");
			accepted.setFont(new Font(LABEL_SIZE));
			accepted.setTextAlignment(TextAlignment.CENTER);
			Label readyToCook = new Label("Ready To Cook");
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
			statusBox.getChildren().addAll(status, order, accepted, readyToCook, cooking, ready);
			
			//putting vboxes in hboxes
			box.getChildren().addAll(statusBox, infoBox);
			
			box.setPadding(new Insets(50, 10, 10, 10));
			infoBox.setPadding(new Insets(30, 30, 50, 50));
			statusBox.setPadding(new Insets(30, 30, 50, 50));
			
			box.setAlignment(Pos.CENTER);
			//infoBox.setAlignment(Pos.CENTER);
			//statusBox.setAlignment(Pos.CENTER);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//setting title
			primaryStage.setTitle("Status");
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}