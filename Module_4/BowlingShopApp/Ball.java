
/**
 * The Ball class is subclass for Product
 * @author Venkateswarlu
 *
 */
public class Ball extends Product {

	
	public String getColor() {
		return color;
	}

	
	public void setColor(String color) {
		this.color = color;
	}

	private String color;
	
	public Ball() {
		this.color="";
	}

	
	public String toString() {
		return "Product code:" + getCode() +  "\n"+ "Description:" + getDescription() + "\n"+"Price:$" + getPrice() + "\n"+"Color:" + color;
		
	}

	
}
