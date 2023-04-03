

/**
 * 
 * 
 * 
 * @author Venkat
 *
 */
public class Customer {

	private String name;
	
	private String address;
	
	private String city;
	
	private String zipCode;
	
	public Customer() {
		
	}

	public Customer(String name, String address, String city, String zipCode) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getAddress() {
		return address;
	}

	
	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getCity() {
		return city;
	}

	
	public void setCity(String city) {
		this.city = city;
	}

	
	public String getZipCode() {
		return zipCode;
	}

	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	
	@Override
	public String toString() {
		return "Name:" + name +  System.lineSeparator()+ "Address:" + address + System.lineSeparator()+"City:" + city + System.lineSeparator()+"zip:" + zipCode;
	}
	
	
}
