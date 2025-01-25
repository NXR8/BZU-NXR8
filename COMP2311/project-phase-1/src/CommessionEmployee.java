
public class CommessionEmployee {
	double itemSold;
	double price;

	public CommessionEmployee(double itemSold, double price) {
		this.itemSold = itemSold;
		this.price = price;
	}

	public CommessionEmployee() {
	}



	public double getItemSold() {
		return itemSold;
	}
	public void setItemSold(double itemSold) {
		this.itemSold = itemSold;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


	public double pay() {
	    double commissionRate;

	    if (itemSold >= 0 && itemSold <= 15000) {
	        commissionRate = 0.015;
	    } else if (itemSold >= 15000 && itemSold <= 20000) {
	        commissionRate = 0.03;
	    } else {
	        commissionRate = 0.05;
	    }

	    return itemSold * price * commissionRate;
	}

	@Override
	public String toString() {
		return "CommessionEmployee [itemSold=" + itemSold + ", price=" + price + "]";
	}



}
