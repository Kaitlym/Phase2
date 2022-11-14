package application;

import javafx.scene.control.Label;

public class Order {
	public int id;
	public String type;
	public String topping;
	public String pickUpTime;
	public int status;
	
	Order(){
		id=-1;
		type = "";
		topping = "";
		pickUpTime = "";
		status=-1;
	}
	
	
	Order(int newId, String newType, String newTopping, String newDate, int newStatus){
		id = newId;
		type = newType;
		topping = newTopping;
		pickUpTime = newDate;
		status=newStatus;		//0 - ORDER, 1 - ACCEPTED, 2 - READY TO COOK, 3 - COOKING, READY
	}
}