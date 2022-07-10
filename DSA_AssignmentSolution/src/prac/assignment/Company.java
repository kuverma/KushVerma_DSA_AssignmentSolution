package prac.assignment;

public class Company {

	private double sharePrice;
	private boolean updatePrice;

	public Company(double sharePrice, boolean updatePrice) {
		super();
		this.sharePrice = sharePrice;
		this.updatePrice = updatePrice;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public boolean isUpdatePrice() {
		return updatePrice;
	}

	public void setUpdatePrice(boolean updatePrice) {
		this.updatePrice = updatePrice;
	}

}
