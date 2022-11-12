package application;
//my imports
import application.Order;

public class User {
	public int id;
	public int type;
	public String email;
	public Order order;
	
	
	User(){
		id = -1;
		type = -1;
		email = "";
		order = new Order();
	}
	User(int newId, int newType, String newEmail){
		id = newId;
		type = newType;	//0 customer, 1 processor, 2 chef
		email = newEmail;
		order = new Order();
	}
}
