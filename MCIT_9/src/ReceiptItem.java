
public class ReceiptItem {
	
	private String item;
	private String date;
	private double price;
	private int quantity;
	
	public ReceiptItem(String item, String date, double price, int quantity) {
		this.item = item;
		this.date = date;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public String getDate() {
		return date;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	
	public String toString() {
		return item + "," + date + "," + price + "," + quantity;
	}
	
	
	

}
