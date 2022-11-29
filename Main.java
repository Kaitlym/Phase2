package application;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//font sizes
			final double MAX_FONT_SIZE = 20;
			final double LABEL_SIZE = 15;
			
			//creating scene and containers
			HBox root = new HBox();
			Scene scene = new Scene(root,500,300);
			VBox infoBox = new VBox();
			VBox statusBox = new VBox();
			
			//vertical divider
			Separator line = new Separator();
			line.setOrientation(Orientation.VERTICAL);
			line.setStyle("-fx-background-radius: 1");
			line.setStyle("-fx-background-color: #000000");
			line.setMaxHeight(300);
			
			root.getChildren().addAll(statusBox, line, infoBox);
			
			infoBox.setPadding(new Insets(0, 0, 0, 30));
			statusBox.setPadding(new Insets(0, 100, 0, 50));
			
			//title labels
			Label info = new Label("Information");
			info.setFont(new Font(MAX_FONT_SIZE));
			info.setStyle("-fx-font-weight: bold");
			info.setPadding(new Insets(15, 0, 10, 0));
			
			Label status = new Label("Status");
			status.setFont(new Font(MAX_FONT_SIZE));
			status.setStyle("-fx-font-weight: bold");
			status.setPadding(new Insets(15, 0, 10, 0));
			
			//student info labels
			Label id = new Label();
			id.textProperty().bind(Bindings.format("ASURITE ID: %s", "user id"));
			id.setFont(new Font(LABEL_SIZE));
			id.setPadding(new Insets(10, 0, 5, 0));
			
			Label email = new Label();
			email.textProperty().bind(Bindings.format("EMAIL: %s", "user email"));
			email.setFont(new Font(LABEL_SIZE));
			email.setPadding(new Insets(10, 0, 5, 0));
			
			Label type = new Label();
			type.textProperty().bind(Bindings.format("TYPE: %s", "pizza type"));
			type.setFont(new Font(LABEL_SIZE));
			type.setPadding(new Insets(10, 0, 5, 0));
			
			Label toppings = new Label();
			toppings.textProperty().bind(Bindings.format("TOPPINGS: %s", "toppings"));
			toppings.setFont(new Font(LABEL_SIZE));
			toppings.setPadding(new Insets(10, 0, 5, 0));
			
			Label pickupTime = new Label();
			pickupTime.textProperty().bind(Bindings.format("Pickup Time: %s", "time"));
			pickupTime.setFont(new Font(LABEL_SIZE));
			pickupTime.setPadding(new Insets(10, 0, 5, 0));
			
			//status labels
			Label order = new Label("Order");
			order.setStyle("-fx-background-color:rgba(85, 255, 68,0.7);");
			order.setFont(new Font(LABEL_SIZE));
			order.setPadding(new Insets(10, 0, 5, 0));
			
			Label accepted = new Label("Accepted");
			accepted.setStyle("-fx-background-color:rgba(85, 255, 68,0.7);");
			accepted.setFont(new Font(LABEL_SIZE));
			accepted.setPadding(new Insets(10, 0, 5, 0));
			
			Label readyToCook = new Label("Ready To Cook");
			readyToCook.setStyle("-fx-background-color:rgba(85, 255, 68,0.7);");
			readyToCook.setFont(new Font(LABEL_SIZE));
			readyToCook.setPadding(new Insets(10, 0, 5, 0));
			
			Label cooking = new Label("Cooking");
			cooking.setFont(new Font(LABEL_SIZE));
			cooking.setPadding(new Insets(10, 0, 5, 0));
			
			Label ready = new Label("Ready For Pickup");
			ready.setFont(new Font(LABEL_SIZE));
			ready.setPadding(new Insets(10, 0, 5, 0));
			
			//putting labels in boxes
			infoBox.getChildren().addAll(info, id, email, type, toppings, pickupTime);
			statusBox.getChildren().addAll(status, order, accepted, readyToCook, cooking, ready);
			
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