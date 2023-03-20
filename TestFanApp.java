 * 
 * @author venkateswarlu
 *
 */
public class TestFanApp {

	public static void main(String[] args) {
		Fan f1 = new Fan();
		Fan f2= new Fan(2,true,8,"Blue");
		
		System.out.println(f1);
		System.out.println(f2);
	}
}