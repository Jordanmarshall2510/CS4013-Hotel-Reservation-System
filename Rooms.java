public class Room{

	private String type;
	private int quantity;
	private boolean available;

	public Room (String aType, int aQuantity, boolean isAvailable){
		this.type = aType;
		this.quantity = aQuantity;
		this.available = isAvailable;
	}

	public String getType(){
		return type;
	}

	public String setType(String aType){
		this.type = aType;
	}

	public int getQuantity(){
		return quantity;
	}

	public int setQuantity(String aQuantity){
		this.quantity = aQuantity;
	}

	public boolean getAvailable(){
		return available;
	}

	public boolean setType(String isAvailable){
		this.available = isAvailable;
	}

}