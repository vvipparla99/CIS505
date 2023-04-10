/**
 * The Bag class is subclass for Product
 * @author Venkateswarlu
 *
 */
public class Bag extends Product{

	private String type;
	
	public Bag() {
		this.type="";
	}

	
	public String getType() {
		return type;
	}

	
	public void setType(String type) {
		this.type = type;
	}

	
	public String toString() {
		return "Product code:" + getCode() + "\n"+ "Description:" + getDescription() + "\n"+"Price:$" + getPrice() + "\n"+"Type:" + type;
		
	}
	
}
