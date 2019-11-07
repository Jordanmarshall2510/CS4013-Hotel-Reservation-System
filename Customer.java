public class Customer /*extends User*/{
	public String name;
	public String address;
	public int cardNumber;
	public int adults;
	public int children;

	public Customer(String name, String address, int cardNumber, int adults, int children){
		this.name = name;
		this.address = address;
		this.cardNumber = cardNumber;
		this.adults = adults;
		this.children = children;
	}

	public String setName (String name){
		this.name = name;
		return name;
	}

	public String getName(){
		return name;
	}

	public String setAddress (String address){
		this.address = address;
		return address;
	}

	public String getAddress(){
		return address;
	}

	public int setCardNumber (int cardNumber){
		this.cardNumber = cardNumber;
		return cardNumber;
	}

	public int getCardNumber(){
		return cardNumber;
	}

	public int setAdults (int adults){
		this.adults = adults;
		return adults;
	}

	public int getAdults(){
		return adults;
	}

	public int setChildren (int children){
		this.children = children;
		return children;
	}

	public int getChildren(){
		return children;
	}
}