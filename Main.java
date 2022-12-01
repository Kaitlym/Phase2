package application;

//javafx imports
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {
	public void move(String moved, String[] fromArray, String[] toArray) {
		return;
	}

	// user info
	User currentUser = new User();

	public OrderFormPage orderFormPage;

	public ArrayList<User> userList;
	public ArrayList<OrderInfo> orderList;
	public OrderInfo orderInfo;
	
	Scene sceneAP;


	Label welcomeMessage = new Label("Welcome to Sun Devil Pizza!");
	VBox homePageLayout;
	Button chefViewButton;

	// chef view page
	

	private final int room_height = 400;
	private final int room_width = 700;
	HBox layout = new HBox(100);

	public void statusInfo(User currentUser) {

	}

	// action handle for chef view click, but this will come from the main login
	// page
	void chefViewButtonAction(Scene s) {
		Stage stage = new Stage();

		stage.setScene(s);
		stage.setTitle("Sun Devil Pizza");
		stage.show();
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			// asu user database
			// ---------------------------------------------------------------------------------------------
			userList = new ArrayList<>();

			// customers
			userList.add(new User(1, 0, "acontr56@asu.edu"));
			userList.add(new User(2, 0, "sesolis@asu.edu"));

			// processors
			userList.add(new User(3, 1, "dvgabrie@asu.edu"));
			userList.add(new User(4, 1, "mggamino@asu.edu"));

			// chefs
			userList.add(new User(5, 2, "bgarci83@asu.edu"));
			userList.add(new User(6, 2, "kmmart47@asu.edu"));

			// order data base
			// ---------------------------------------------------------------------------------------------
			orderList = new ArrayList<>();
			orderInfo = new OrderInfo("Cheese", "Wed, Dec 30, 07:45 PM" , false, false, false, false, "Pending");
			userList.get(0).setOrder(orderInfo);
			orderList.add(0, orderInfo);
			orderInfo.setOrderInfo("Pepperoni", "Wed, Dec 30, 09:45 PM" , false, true, false, false, "Pending");
			orderList.add(1, orderInfo);
			userList.get(1).setOrder(orderInfo);
			orderInfo.setOrderInfo("Veggie", "Wed, Dec 30, 10:00 PM" , false, true, false, true, "Pending");
			orderList.add(2, orderInfo);
			userList.get(2).setOrder(orderInfo);
			orderInfo.setOrderInfo("Veggie", "Thu, Dec 31, 11:45 AM" , true, false, false, false, "Pending");
			orderList.add(3, orderInfo);
			userList.get(3).setOrder(orderInfo);
			orderInfo.setOrderInfo("Veggie", "Fri, Jan 1, 11:00 PM" , true, true, true, true, "Pending");
			orderList.add(4, orderInfo);
			userList.get(4).setOrder(orderInfo);
			orderInfo.setOrderInfo("Cheese", "Wed, Jan 30, 01:00 PM" , false, true, false, true, "Pending");
			orderList.add(5, orderInfo);
			userList.get(5).setOrder(orderInfo);

		

			// setup each page
			ChefPage chefPage = new ChefPage();
			orderFormPage = new OrderFormPage();
			
			StatusPage statusPage = new StatusPage();
			statusPage.setUser(currentUser);
			ProcessorPage processorPage = new ProcessorPage();

			// defaults
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

			orderFormPage = new OrderFormPage();
			Button buttonOF = new Button("Order Form");
			buttonOF.setOnAction(e -> {
				orderFormPage.setUser(currentUser);
				primaryStage.setScene(orderFormPage.getScene(sceneAP, primaryStage));
			});

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


			statusPage.setUser(currentUser);
			Button buttonS = new Button("Status");
			buttonS.setOnAction(e -> {
				
			statusPage.setUser(currentUser);
			primaryStage.setScene(statusPage.getScene(sceneAP, primaryStage));
			
			
			});

			Button buttonCV = new Button("Chef View");
			buttonCV.setOnAction(e -> primaryStage.setScene(chefPage.getScene(sceneAP, primaryStage, currentUser)));

			Button buttonPV = new Button("Processor View");
			buttonPV.setOnAction(e -> primaryStage.setScene(processorPage.getScene(userList, orderList, sceneAP, chefPage, primaryStage)));

			// All Pages
			// ---------------------------------------------------------------------------------------------
			VBox layoutAP = new VBox();
			sceneAP = new Scene(layoutAP, room_height, room_width);
			Label labelAP = new Label("All Pages");
			Button buttonAP = new Button("All Pages");
			buttonAP.setOnAction(e -> primaryStage.setScene(sceneAP));

			layoutAP.setAlignment(Pos.CENTER);
			layoutAP.getChildren().addAll(labelAP, buttonL, buttonCS, buttonOF, buttonA, buttonS, buttonCV, buttonPV);

			Button buttonHome = new Button("Home");
			buttonHome.setOnAction(e -> primaryStage.setScene(sceneAP));

			// Login
			// ---------------------------------------------------------------------------------------------
			Label lL_id = new Label("ID:");
			TextField tfL_id = new TextField();
			tfL_id.setMaxWidth(500);
			Label lL_email = new Label("EMAIL:");
			TextField tfL_email = new TextField();
			tfL_email.setMaxWidth(500);
			Button buttonL_s = new Button("SUBMIT");

			buttonL_s.setOnAction(e -> {
				int userType = checkUser(tfL_id.getText(), tfL_email.getText(), userList);

				if (userType == -1) {
					// not authentication
					primaryStage.setScene(sceneNA);
				}
				if (userType == 0) {
					// authentication
					currentUser = new User(Integer.parseInt(tfL_id.getText().trim()), userType, tfL_email.getText());
					primaryStage.setScene(sceneA);
				}
				if (userType == 1) {
					// processor
					primaryStage.setScene(processorPage.getScene(userList, orderList, sceneAP, chefPage, primaryStage));

				}

				if (userType == 2) {
					// chef
					primaryStage.setScene(chefPage.getScene(sceneAP, primaryStage, currentUser));
				}
			});
			Button buttonL_c = new Button("CLEAR");
			buttonL_c.setOnAction(e -> {
				tfL_id.clear();
				tfL_email.clear();
			});
			layoutL.setAlignment(Pos.CENTER);
			layoutL.getChildren().addAll(labelL, lL_id, tfL_id, lL_email, tfL_email, buttonL_s, buttonL_c, buttonCS);

			// Contact Support
			// ---------------------------------------------------------------------------------------------
			Label lCS_id = new Label("ID:");
			TextField tfCS_id = new TextField();
			Label lCS_message = new Label("MESSAGE:");
			TextField tfCS_message = new TextField();
			Button buttonCS_s = new Button("SEND");

			buttonCS_s.setOnAction(e -> {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("ID: " + tfCS_id.getText() + "\n" + "MESSAGE: " + tfCS_message.getText());
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

			// Authentication
			// ---------------------------------------------------------------------------------------------
			// failure auth
			Label lA_title = new Label();
			Label lA_message = new Label();
			Button buttonA_next = new Button();

			lA_title.setText("Thank You!");
			lA_message.setText("Your ASURITE ID has been accepted, your order has been placed.");
			buttonA_next.setText("DONE");
			buttonA_next.setOnAction(e -> {
				orderFormPage.setUser(currentUser);
				primaryStage.setScene(orderFormPage.getScene(sceneAP, primaryStage));
			});
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

			sceneAP.getStylesheets().add(getClass().getResource("styleSheet.css").toExternalForm());
			// title
			primaryStage.setTitle("ASU PIZZA");

			// Stage
			primaryStage.setScene(sceneAP);
			primaryStage.show();

			// Processing View
			// ---------------------------------------------------------------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int checkUser(String loginId, String loginEmail, ArrayList<User> userList) {
		int returnType = -1;

		// look through database
		for (int i = 0; i < userList.size(); i++) {
			// end if null
			if (userList.get(i) == null) {
				break;
			}

			// end if match;
			if (loginId.equals(Integer.toString(userList.get(i).id)) && loginEmail.equals(userList.get(i).email)) {
				returnType = userList.get(i).type;
				break;
			}
		}

		return returnType;
	}

	public static void main(String[] args) {
		launch(args);
	}
}