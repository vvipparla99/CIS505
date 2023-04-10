
/**
 * The Shoe class is subclass for Product
 * @author Venkateswarlu
 *
 */
public class Shoe extends Product{

	private double size;
	
	public Shoe() {
		this.size=0;
	}

	
	public double getSize() {
		return size;
	}

	
	public void setSize(double size) {
		this.size = size;
	}

	
	public String toString() {
		return "Product code:" + getCode() +  "\n"+ "Description:" + getDescription() + "\n"+"Price:$" + getPrice() + "\n"+"Size:" + size;
		
	}
	
	
}
