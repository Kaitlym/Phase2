package application;

//my imports
//import application.orderInfo;

public class User {
	public int id;
	public int type;
	public String email;
	public OrderInfo order;
	
	
	User(){
		id = 121000000;
		type = -1;
		email = "demo@asu.edu";
		order = new OrderInfo("Pepperoni", "DEMO Wed, Dec 31, 12:45 PM", true,false,false, false , "Cooking");
	}
	User(int newId, int newType, String newEmail){
		id = newId;
		type = newType;	//0 customer, 1 processor, 2 chef
		email = newEmail;
		order = new OrderInfo("", "", false, false, false, false, "");
	}
	
	public void setOrder(OrderInfo n) {
        this.order = n;
   }
}