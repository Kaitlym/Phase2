package application;


import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;

public class ChefPage {

  Label welcomeMessage = new Label("Welcome to Sun Devil Pizza!");
  VBox homePageLayout;
  Button chefViewButton;
  Button backButton;

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

  Scene scene;

  private void setStatusButtonAction(Text t, String status) {
    // orderInfo.set
    t.setText("Status update sent!");
    t.setX(100);
    t.setY(100);
  }

  public Scene getScene(Scene previouScene, Stage primaryStage, User currentCustomer) {

    VBox layoutCV = new VBox();

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
    Label userID = new Label(String.valueOf(currentCustomer.id) + ", " + currentCustomer.email);

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

    extraCheeseTopping.setSelected(currentCustomer.order.hasExtraCheese());
    mushroomTopping.setSelected(currentCustomer.order.hasMushrooms());
    onionTopping.setSelected(currentCustomer.order.hasOnions());
    oliveTopping.setSelected(currentCustomer.order.hasOlives());

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
    setStatusButton.setPrefWidth(150);

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

    if (currentCustomer.order.getStatus() == "Accepted") {

      acceptedOrder.setSelected(true);

    }
    if (currentCustomer.order.getStatus() == "Ready to Cook") {

      readyToCookOrder.setSelected(true);

    }
    if (currentCustomer.order.getStatus() == "Cooking") {

      cookingOrder.setSelected(true);

    }
    if (currentCustomer.order.getStatus() == "Finished") {

      finishedOrder.setSelected(true);

    }

    status1.addColumn(0, acceptedOrder);
    status1.addColumn(1, readyToCookOrder);
    status1.addColumn(2, cookingOrder);
    status1.addColumn(3, finishedOrder);
    status1.addColumn(4, setStatusButton);

    setStatusButton.setOnAction(e -> {

      if (acceptedOrder.isSelected()) {

        currentCustomer.order.SetStatus("Accepted");

      }
      if (readyToCookOrder.isSelected()) {

        currentCustomer.order.SetStatus("Ready to Cook");

      }
      if (cookingOrder.isSelected()) {

        currentCustomer.order.SetStatus("Cooking");

      }
      if (finishedOrder.isSelected()) {

        currentCustomer.order.SetStatus("Finished");

      }

    });

    backButton = new Button("Home");
    backButton.setOnAction(e -> primaryStage.setScene(previouScene));

    // send email update
    Text t = new Text();
    t.setText("");
    // setStatusButton.setOnAction(e -> setStatusButtonAction(t));

    // place everything into the chef view
    Label cvTitle = new Label("Sun Devil Pizza — Chef View");
    layoutCV.setAlignment(Pos.CENTER);
    layoutCV.getChildren().addAll(cvTitle, orderSection, detailsSection, statusSection, t, backButton);

    scene = new Scene(layoutCV, 1200, 800);
    scene.getStylesheets().add(getClass().getResource("styleSheet.css").toExternalForm());

    return scene;

  }
}
