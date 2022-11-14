package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class ContentPane extends HBox {

    ArrayList<orderInfo> orderList;
    Label newOrderLabel, rtcLabel;
    Button refButton, addButton;
    ScrollPane newOrderScroll, rtcScroll;
    VBox leftBox, centerBox, rightBox, scrollPain1, scrollPain2;
    ArrayList<CheckBox> checkBoxList;
    CheckBox check;


    public ContentPane(ArrayList<orderInfo> list) {
        this.orderList = list;
        checkBoxList = new ArrayList<CheckBox>();

        // initializing all labels and buttons
        newOrderLabel = new Label("New Orders");
        rtcLabel = new Label("Ready to Cook!");
        refButton = new Button("refresh");
        addButton = new Button("ADD");

        newOrderScroll = new ScrollPane();
        rtcScroll = new ScrollPane();
        scrollPain1 = new VBox();
        scrollPain2 = new VBox();
        newOrderScroll.setContent(scrollPain1);
        rtcScroll.setContent(scrollPain2);

        leftBox = new VBox();
        centerBox = new VBox();
        rightBox = new VBox();

        // left box
        leftBox.getChildren().add(newOrderLabel);
        leftBox.getChildren().add(refButton);
        leftBox.getChildren().add(newOrderScroll);

        //center box
        centerBox.getChildren().add(addButton);

        //right box
        rightBox.getChildren().add(rtcLabel);
        rightBox.getChildren().add(rtcScroll);

        this.getChildren().add(leftBox);
        this.getChildren().add(centerBox);
        this.getChildren().add(rightBox);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                for(int i = 0; i < checkBoxList.size(); i++) {
                    if(checkBoxList.get(i).isSelected()) {
                        scrollPain2.getChildren().addAll(checkBoxList.get(i));
                    }
                }
            }
        });

    }

    // update new order list scrollbox
    public void updateNewOrderList(orderInfo order) {
        orderList.add(order);
        String orderString = order.getType() + ", ";

        if (order.hasExtraCheese() == true) {
            orderString += "extra cheese, ";
        }
        if (order.hasMushrooms() == true) {
            orderString += "mushrooms, ";
        }
        if (order.hasOlives() == true) {
            orderString += "onions, ";
        }
        if (order.hasOnions() == true) {
            orderString += "onions";
        }

        check = new CheckBox(orderString);
        checkBoxList.add(check);

        scrollPain1.getChildren().addAll(check);
    }

    // ideally will be used by CHEF VIEW
    // CALL EACH TIME STATUS IS UPDATED
    public void updateRTCList(orderInfo order) {
        for(int i = 0; i < orderList.size(); i++) {
            if(orderList.get(i).getStatus() == "complete") {
                orderList.remove(i);
                checkBoxList.remove(i);
                scrollPain2.getChildren().remove(checkBoxList.get(i));
            }
        }
    }

}