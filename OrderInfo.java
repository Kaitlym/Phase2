package application;


public class OrderInfo {
	
	private String pizzaType = null;
	
	private boolean mushrooms = false;
	private boolean olives = false;
	private boolean onions = false;
	private boolean extraCheese = false;
	
	String pickupTime = null;
	private String status = null;
	
	
	public OrderInfo(String pizzaType, String pickupTime, boolean mushrooms, 
						boolean olives, boolean onions, boolean extraCheese, String status) {
	    
		this.pizzaType = pizzaType;
		this.pickupTime = pickupTime;
		this.mushrooms = mushrooms;
		this.olives = olives;
		this.onions = onions;
		this.extraCheese = extraCheese;
		this.status = status;
		
	   }
	
	public String getType() {
		
		return pizzaType;
		
		
	}
	public String getTime() {
		
		return pickupTime;
		
		
	}
	public Boolean hasMushrooms() {
		
		return mushrooms;
		
		
	}
	public Boolean hasOlives() {
			
			return olives;
			
			
	}
	public Boolean hasOnions() {
		
		return onions;
		
		
	}
	public boolean hasExtraCheese() {
		
		return extraCheese;
		
		
	}
	 public String getStatus() {
	        return status;
	    }
	 
	 public void SetStatus(String status) {
	         this.status = status;
	    }
	public void setOrderInfo(String pizzaType, String pickupTime, boolean mushrooms, 
							boolean olives, boolean onions, boolean extraCheese, String status) {


		this.pizzaType = pizzaType;
		this.pickupTime = pickupTime;
		this.mushrooms = mushrooms;
		this.olives = olives;
		this.onions = onions;
		this.extraCheese = extraCheese;
		this.status = status;

	}

}