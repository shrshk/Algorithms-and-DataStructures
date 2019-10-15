package datastructures.bestpractices;

public class Auction {
	int price;
	String description;

	Auction(int price, String description) {
		this.price = price;
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Auction [price=" + this.getPrice() + ", description=" + this.getDescription() + "]";
	}
}
