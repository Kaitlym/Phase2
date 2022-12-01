package application;


import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProcessorPage {

    // public Label title;

    Scene scene;

    ArrayList<RadioButton> orderButtons;
    ArrayList<VBox> buttonBox;
    ArrayList<Label> type;
    ArrayList<Label> toppings;
    ArrayList<Label> pickUpTime;

    BorderPane root;
    VBox column1;
    VBox column2;
    ScrollPane scrollPane;

    ToggleGroup orderGroup;

    String toppingString;

    Button backButton;
    Button editButton;

    public Scene getScene(ArrayList<User> userList, ArrayList<OrderInfo> orderList, Scene previouScene,
                            ChefPage chefStage, Stage primaryStage) {

        orderButtons = new ArrayList<>();
        buttonBox = new ArrayList<>();
        type = new ArrayList<>();
        toppings = new ArrayList<>();
        pickUpTime = new ArrayList<>();

        root = new BorderPane();
        column1 = new VBox(100);
        column2 = new VBox(100);
        scrollPane = new ScrollPane();

        // title = new Label("SunDevil Pizza");

        root.setLeft(scrollPane);
        root.setRight(column2);
        scrollPane.setPrefWidth(700);
        scrollPane.setContent(column1);

        orderGroup = new ToggleGroup();

        toppingString = "";

        for (int i = 0; orderList.size() > i; i++) {

            toppingString = "";

            orderButtons.add(new RadioButton(userList.get(i).email));
            orderButtons.get(i).setToggleGroup(orderGroup);

            type.add(new Label(userList.get(i).order.getType()));
            type.get(i).setPadding(new Insets(5, 10, 10, 40));

            buttonBox.add(new VBox());
            buttonBox.get(i).getChildren().addAll(orderButtons.get(i), type.get(i));

            if (userList.get(i).order.hasMushrooms()) {
                toppingString += "Mushroom ";

            }
            if (userList.get(i).order.hasOlives()) {
                toppingString += "Olives ";
            }
            if (userList.get(i).order.hasOnions()) {
                toppingString += "Onion ";
            }
            if (userList.get(i).order.hasExtraCheese()) {
                toppingString += "Extra Cheese ";
            }

            toppings.add(new Label(toppingString));
            toppings.get(i).setPadding(new Insets(5, 10, 10, 40));

            pickUpTime.add(new Label(userList.get(i).order.getTime()));
            pickUpTime.get(i).setPadding(new Insets(5, 10, 10, 40));

            buttonBox.get(i).getChildren().addAll(toppings.get(i), pickUpTime.get(i));

            column1.getChildren().addAll(buttonBox.get(i));

        }

        orderButtons.get(0).setSelected(true);

        backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(previouScene));

        editButton = new Button("Edit");
        editButton.setOnAction(e -> {

            for (int i = 0; orderButtons.size() > i; i++) {

                if (orderButtons.get(i).isSelected()) {

                    primaryStage.setScene(chefStage.getScene(previouScene, primaryStage, userList.get(i)));

                }
            }
        });

        column2.getChildren().addAll(backButton, editButton);

        scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add(getClass().getResource("styleSheet.css").toExternalForm());

        return scene;

    }
}