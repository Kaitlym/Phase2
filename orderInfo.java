package application;

public class orderInfo {
	
	private String pizzaType = null;
	
	private boolean mushrooms = false;
	private boolean olives = false;
	private boolean onions = false;
	private boolean extraCheese = false;
	
	String pickupTime = null;
	
	
	public orderInfo(String pizzaType, String pickupTime, boolean mushrooms, 
						boolean olives, boolean onions, boolean extraCheese) {
	    
		this.pizzaType = pizzaType;
		this.pickupTime = pickupTime;
		this.mushrooms = mushrooms;
		this.olives = olives;
		this.onions = onions;
		this.extraCheese = extraCheese;
		
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

}
