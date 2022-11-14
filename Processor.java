package processor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Scanner;


public class Processor extends Application {
    public ArrayList<orderInfo> orderList;
    public orderInfo order;
    public Label label1;

    @Override
    public void start(Stage primaryStage) throws Exception {
       // for testing purposes, creating new order item and adding it to orderlist arraylist
        order = new orderInfo("cheese", "Oct 13, 2017", true, true, false, false, "ready to cook");
        orderList = new ArrayList<orderInfo>();

        ContentPane gui = new ContentPane(orderList);
        gui.updateNewOrderList(order);

        BorderPane root = new BorderPane();
        label1 = new Label("SunDevil Pizza");
        root.setTop(label1);
        root.setCenter(gui);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Processor Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
