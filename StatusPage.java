package application;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StatusPage {

    // Status -----------------------------------------------------------

    // font sizes
    final double MAX_FONT_SIZE = 20;
    final double LABEL_SIZE = 15;

    int room_height = 1200;
    int room_width = 800;

    HBox box;

    User currentUser;

    Scene scene;

    Label id;
    Label email;
    Label type;
    Label toppings;
    Label pickupTime;
    Label status;

    String toppingString;

    Button backButton;
    Button refreshButton;

    public void setUser(User currentUser) {

        this.currentUser = currentUser;

    }

    EventHandler<ActionEvent> refresh = new EventHandler<ActionEvent>() {

        public void handle(ActionEvent e){

            toppingString = "";
            
        id.textProperty().bind(Bindings.format("ASURITE ID: %s", currentUser.id));
        email.textProperty().bind(Bindings.format("EMAIL: %s", currentUser.email));
        type.textProperty().bind(Bindings.format("TYPE: %s", currentUser.order.getType()));
        pickupTime.textProperty().bind(Bindings.format("Pickup Time: %s", currentUser.order.getTime()));
        status.setText(currentUser.order.getStatus());
            
            if(currentUser.order.hasMushrooms()){
                toppingString += "Mushroom ";
            }
            if(currentUser.order.hasOlives()){
                toppingString += "Olives ";
            }
            if(currentUser.order.hasOnions()){
                toppingString += "Onion ";
            }
            if(currentUser.order.hasExtraCheese()){
                toppingString += "Extra Cheese ";
            }
        toppings.textProperty().bind(Bindings.format("TOPPINGS: %s", toppingString));

        }
    };

    public Scene getScene(Scene previouScene, Stage primaryStage) {

        // creating scene and containers
        HBox rootStatus = new HBox();
        HBox box = new HBox();

        VBox infoBox = new VBox();
        VBox statusBox = new VBox();

        // vertical divider
        Separator line = new Separator();
        line.setOrientation(Orientation.VERTICAL);
        line.setStyle("-fx-background-radius: 1");
        line.setStyle("-fx-background-color: #000000");
        line.setMaxHeight(300);

        rootStatus.getChildren().addAll(statusBox, line, infoBox);

        infoBox.setPadding(new Insets(0, 0, 0, 30));
        statusBox.setPadding(new Insets(0, 100, 0, 50));

        // title labels
        Label info = new Label("Information");
        info.setFont(new Font(MAX_FONT_SIZE));
        info.setStyle("-fx-font-weight: bold");
        info.setPadding(new Insets(15, 0, 10, 0));

        Label statusLabel = new Label("Status");
        statusLabel.setFont(new Font(MAX_FONT_SIZE));
        statusLabel.setStyle("-fx-font-weight: bold");
        statusLabel.setPadding(new Insets(15, 0, 10, 0));

       
      

        // student info labels
        id = new Label();
        id.textProperty().bind(Bindings.format("ASURITE ID: %s", ""));
        id.setFont(new Font(LABEL_SIZE));
        id.setPadding(new Insets(10, 0, 5, 0));

        email = new Label();
        email.textProperty().bind(Bindings.format("EMAIL: %s", ""));
        email.setFont(new Font(LABEL_SIZE));
        email.setPadding(new Insets(10, 0, 5, 0));

        type = new Label();
        type.textProperty().bind(Bindings.format("TYPE: %s", ""));
        type.setFont(new Font(LABEL_SIZE));
        type.setPadding(new Insets(10, 0, 5, 0));

        toppings = new Label();
        toppings.textProperty().bind(Bindings.format("TOPPINGS: %s", ""));
        toppings.setFont(new Font(LABEL_SIZE));
        toppings.setPadding(new Insets(10, 0, 5, 0));

        pickupTime = new Label();
        pickupTime.textProperty().bind(Bindings.format("Pickup Time: %s", ""));
        pickupTime.setFont(new Font(LABEL_SIZE));
        pickupTime.setPadding(new Insets(10, 0, 5, 0));

        status = new Label("");


        // putting labels in boxes
        infoBox.getChildren().addAll(info, id, email, type, toppings, pickupTime);
        statusBox.getChildren().addAll(statusLabel, status);


        // putting vboxes in hboxes
        box.getChildren().addAll(statusBox, infoBox);

        box.setPadding(new Insets(50, 10, 10, 10));
        infoBox.setPadding(new Insets(30, 30, 50, 50));
        statusBox.setPadding(new Insets(30, 30, 50, 50));

        box.setAlignment(Pos.CENTER);

        scene = new Scene(box, room_height, room_width);
        scene.getStylesheets().add(getClass().getResource("styleSheet.css").toExternalForm());

        refreshButton = new Button("Refresh");
        refreshButton.setOnAction(refresh);

        backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(previouScene));
        box.getChildren().addAll(refreshButton, backButton);


        return scene;

    }

}
